package fr.bazarder.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import fr.bazarder.entity.Mail;
import fr.bazarder.exception.FormValidationException;

public class EnvoiEmail {

    private String    username = "testdemoapplication016@gmail.com";
    private String    password = "unNouveauMotDePasse1234";

    private final int PORT     = 587;

    public void envoyer( Mail mail ) throws FormValidationException {

        // etape1 : creation d'une session
        Properties props = new Properties();
        props.put( "mail.smtp.auth", "true" );
        props.put( "mail.smtp.starttls.enable", "true" );
        props.put( "mail.smtp.host", "smtp.gmail.com" );
        props.put( "mail.smtp.port", PORT );

        // Session session = Session.getDefaultInstance( props, null );

        Session session = Session.getInstance( props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication( username, password );
                    }
                } );

        try {
            // etape 2 : creation d'un message

            Message message = new MimeMessage( session );
            message.setFrom( new InternetAddress( mail.getAdresseMail() ) );
            message.setRecipients( Message.RecipientType.TO,
                    InternetAddress.parse( "adel.khelkhal@yahoo.fr" ) ); 
            // mail du destinaire
            message.setSentDate(new Date());
            message.setSubject( mail.getTitre() );

            String messageEnvoi = String.join(
                    System.getProperty( "line.separator" ), "<HTML> <H2>From : " + mail.getAdresseMail() + "</H2> <H2> Sujet : " + mail.getTitre() + 
                    "</H2> <H2> Message : </H2> <p>" +mail.getMessage() + "</p></html>" );
            
            
          

            
            message.setContent( messageEnvoi, "text/html; charset=UTF-8" );

            // etape 3 : envoi du message
            Transport.send( message );

        } catch ( MessagingException e ) {
            throw new FormValidationException(e.getMessage());
        }
    }

}