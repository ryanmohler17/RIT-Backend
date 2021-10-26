package com.revature.rit.mail;

import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

@Service
public class ImageLoader {

    public String loadBase64ImageFromClasspath(String path) throws IOException {
        InputStream stream = getClass().getResourceAsStream(path);
        if (stream == null) {
            throw new RuntimeException("Invalid File");
        }
        BufferedImage image = ImageIO.read(stream);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(image, "png", out);

        return Base64.getEncoder().encodeToString(out.toByteArray());
    }

}
