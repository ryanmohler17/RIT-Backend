package com.revature.rit.services;

import com.revature.rit.mail.GenericEmailer;
import com.revature.rit.mail.ImageLoader;
import com.revature.rit.mail.RitEmail;
import com.revature.rit.mail.SendGridEmailerConfig;
import com.revature.rit.models.users.User;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserService {

    private ImageLoader imageLoader;
    private GenericEmailer emailer;
    private SendGridEmailerConfig config;

    @Autowired
    public UserService(ImageLoader imageLoader, GenericEmailer emailer, SendGridEmailerConfig config) {
        this.imageLoader = imageLoader;
        this.emailer = emailer;
        emailer.init();
        this.config = config;
    }

    public void createNewUser(User user) throws IOException {

        RitEmail email = new RitEmail("/email/newAccount.html", "Welcome " + user.getUsername(),
                new Email(config.getFromEmail(), "RITS"),
                new Email(user.getEmail(), user.getUsername()));

        email.addVariable("logo", "data:image/png;base64," + imageLoader.loadBase64ImageFromClasspath("/email/assets/RITS2.png"));
        email.addVariable("user", user.getUsername());

        // TODO interface with DAO (Repository)
    }

}
