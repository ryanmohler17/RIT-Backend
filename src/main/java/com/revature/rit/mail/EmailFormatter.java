package com.revature.rit.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmailFormatter {

    Pattern pattern = Pattern.compile("\\{\\s?(?<var>\\w*)\\s?}");

    public String formatEmail(InputStream htmlFile, Map<String, Object> variables) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(htmlFile));
        String line;
        StringBuilder fileBuilder = new StringBuilder();
        boolean first = true;
        while ((line = reader.readLine()) != null) {
            if (!first) {
                fileBuilder.append('\n');
            } else {
                first = false;
            }
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                String var = matcher.group("var");
                Object item = variables.get(var);
                line = matcher.replaceFirst(String.valueOf(item));
                matcher = pattern.matcher(line);
            }
            fileBuilder.append(line);
        }
        return fileBuilder.toString();
    }

}
