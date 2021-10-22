package com.revature.rit.mail;

import com.sendgrid.helpers.mail.objects.Email;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public class RitEmail {

    private final Map<String, Object> variables = new HashMap<>();
    @NonNull
    private String file;
    @NonNull
    private String subject;
    @NonNull
    private Email toEmail;
    @NonNull
    private Email fromEmail;
    @Setter
    private Email replyToEmail;

    public void addVariable(String name, Object var) {
        variables.put(name, var);
    }

}
