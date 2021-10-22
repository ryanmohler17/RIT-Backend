package com.revature.rit.mail;

import com.sendgrid.SendGrid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    public void testFormatter() {
        EmailFormatter formatter = new EmailFormatter();

    }

    @Test
    public void testSendgridEmailer() {

    }


}
