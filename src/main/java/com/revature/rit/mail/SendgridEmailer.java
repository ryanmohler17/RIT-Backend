package com.revature.rit.mail;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class SendgridEmailer implements GenericEmailer {

    private EmailFormatter formatter;
    private String sendgridApiKey;

    public SendgridEmailer(EmailFormatter formatter, SendGridEmailerConfig config) {
        this.formatter = formatter;
        this.sendgridApiKey = config.getApiKey();
    }

    @Override
    public MailResult sendEmail(RitEmail email) throws IOException {
        InputStream input = getClass().getResourceAsStream(email.getFile());
        if (input == null) {
            throw new RuntimeException("Invalid file!");
        }
        String toSend = formatter.formatEmail(input, email.getVariables());

        Content content = new Content("text/html", toSend);
        Mail mail = new Mail(email.getFromEmail(), email.getSubject(), email.getToEmail(), content);
        if (email.getReplyToEmail() != null) {
            mail.setReplyTo(email.getReplyToEmail());
        }

        SendGrid sendGrid = new SendGrid(sendgridApiKey);
        Request request = new Request();

        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());
        Response response = sendGrid.api(request);

        return new MailResult(response.getStatusCode());
    }

}
