package org.movie.MovieRecommendationSystem.service;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {
    public static void main(String[] args) {
        // Recipient's email ID
        String to = "rutikpimpale2401@gmail.com";  // Change to the actual recipient's email address

        // Sender's email ID
        String from = "rutikpimpale24@gmail.com";  // Change to your actual email address
        final String username = "rutikpimpale24@gmail.com";  // Your email username
        final String password = BCrypt.pass;  // Your email password (consider using an App Password for Gmail)

        // SMTP server information
        String host = "smtp.gmail.com";
        int port = 587;

        // Set properties for the email session
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        // Get the Session object with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a default MimeMessage object
            MimeMessage message = new MimeMessage(session);

            // Set the from and to address
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set the subject and body text
            message.setSubject("Ping");
            message.setText("Hello, this is an example of sending an email.");

            // Send the message
            Transport.send(message);
            System.out.println("Message sent successfully....");

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
