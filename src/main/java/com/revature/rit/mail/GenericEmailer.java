package com.revature.rit.mail;

import java.io.IOException;
import java.net.URISyntaxException;

public interface GenericEmailer {

    MailResult sendEmail(RitEmail email) throws IOException;

}
