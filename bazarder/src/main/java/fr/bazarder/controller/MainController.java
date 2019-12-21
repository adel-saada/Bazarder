package fr.bazarder.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fr.bazarder.entity.Mail;
import fr.bazarder.exception.FormValidationException;
import fr.bazarder.form.MailForm;
import fr.bazarder.mail.EnvoiEmail; 
 
 
@Controller
public class MainController {
 
 
	@GetMapping(value={"", "/", "/index"})  
	public String home() { 
		return "index";
	}
	 
	@GetMapping("/contact") 
	public String contact(Model model) {
        Mail mail = new Mail();
        model.addAttribute("mail", mail);
		return "contact";
	}
	 
	@PostMapping("/mail") 
	public String envoiMail(Model model,Mail mail) {
		

		Map<String, String> mapErreurs = new MailForm().verificationMail(mail);
		 
		if(! mapErreurs.isEmpty()) { 
			model.addAttribute("mapErreurs", mapErreurs);
			return "contact";
		}
	
		EnvoiEmail envoiEmail = new EnvoiEmail();
		boolean envoi = true;  
		
		try {
			envoiEmail.envoyer(mail);
		} catch (FormValidationException e) {
			//problemeEnvoi = "L'envoi du mail a échoué, merci de retenter l'envoi.";
			envoi = false;
		}
		model.addAttribute("envoi", envoi);
		
				
		return "contact";
	}
}
