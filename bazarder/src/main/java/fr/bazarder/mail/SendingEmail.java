package fr.bazarder.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import fr.bazarder.entity.Mail;

@Service
public class SendingEmail {

	@Autowired
    private JavaMailSender javaMailSender;
	
	public void sendEmail(Mail mail) throws MessagingException {
		
	    MimeMessage message=javaMailSender.createMimeMessage();
	    MimeMessageHelper helper;
	    helper=new MimeMessageHelper(message,true);
	    helper.setTo(mail.getAdresseMail());
	    helper.setSubject(mail.getTitre());
	    helper.setText(mail.getMessage());
	    javaMailSender.send(message);


    }
	
}
