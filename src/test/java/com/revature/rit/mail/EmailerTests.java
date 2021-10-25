package com.revature.rit.mail;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Email;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EmailerTests {

    @Autowired
    private SendgridEmailer emailer;
    private SendGrid sendGrid;
    private EmailFormatter formatter;

    @BeforeEach
    public void initSendgrid() {
        sendGrid = Mockito.mock(SendGrid.class);
        emailer.setSendGrid(sendGrid);
        formatter = Mockito.mock(EmailFormatter.class);
        emailer.setFormatter(formatter);
    }

    @Test
    public void testFormatter() throws IOException {
        EmailFormatter formatter = new EmailFormatter();
        String testString = "Test { stuff } {otherStuff}\n{ stuff } { stuff }";
        String stuff = "things";
        String otherStuff = "more things";

        String expected = "Test " + stuff + " " + otherStuff + "\n" + stuff + " " + stuff;

        ByteArrayInputStream in = new ByteArrayInputStream(testString.getBytes(StandardCharsets.UTF_8));
        Map<String, Object> vars = new HashMap<>();
        vars.put("stuff", stuff);
        vars.put("otherStuff", otherStuff);

        String out = formatter.formatEmail(in, vars);
        assertEquals(expected, out);
    }

    @Test
    public void testSendgridEmailer() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Email to = new Email("user@example.com", "User");
        Email from = new Email("system@example.com");
        Email reply = new Email("admin@example.com", "Admin");

        RitEmail email = new RitEmail("/email/email.txt", "Testing emailing", to, from);
        email.setReplyToEmail(reply);

        email.addVariable("test", "stuff");

        int statusCode = 202;

        Mockito.when(formatter.formatEmail(Mockito.any(), Mockito.anyMap())).then(invocationOnMock -> {
            assertEquals("stuff", ((Map<String, Object>) invocationOnMock.getArgument(1)).get("test"));
            return "Hello world!";
        });

        Mockito.when(sendGrid.api(Mockito.any())).then(invocationOnMock -> {
            Request request = invocationOnMock.getArgument(0);

            Mail mail = objectMapper.readValue(request.getBody(), Mail.class);

            assertEquals(from, mail.getFrom());
            assertEquals(to, mail.getPersonalization().get(0).getTos().get(0));
            assertEquals(reply, mail.getReplyto());

            Response response = new Response();
            response.setStatusCode(statusCode);
            return response;
        });

        MailResult result = emailer.sendEmail(email);
        assertEquals(statusCode, result.getStatus());
    }


}
