package fr.bazarder.form;

import java.util.HashMap;
import java.util.Map;

import fr.bazarder.entity.Mail;
import fr.bazarder.exception.FormValidationException;

public class MailForm {
	
    /* messages erreurs */
    private static final String MSG_ERREUR_EMAIL_INVALIDE   = "Merci de saisir une adresse mail valide.";
    private static final String MSG_ERREUR_MIN          = "doit contenir au moins 3 caractères";
    private static final String MSG_ERREUR_NULL         = "Le champ est vide";
    private static final String MSG_ERREUR_EMAIL_NULL       = "Merci de saisir une adresse mail";

    private static final String REGEX_EMAIL  = "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)";

	private  Map<String, String> mapErreurs;
	
	public MailForm() {
		
	}
	
	public Map<String, String> verificationMail(Mail mail) {
		
		mapErreurs = new HashMap<>();
		
		traiterEmail(mail.getAdresseMail());
		traiterMessage(mail.getMessage());
		traiterTitre(mail.getTitre());
		traiterNom(mail.getNom());

		
		return mapErreurs;
		
	}
	

    /*---------------------------------------------------------------------------------------*/
    /*------------------------------------- TRAITEMENTS -------------------------------------*/
    /*---------------------------------------------------------------------------------------*/
    
	private void traiterEmail( String email) {
        try {
            validationEmail( email );
        } catch ( FormValidationException e ) {
        	mapErreurs.put( "Adresse Mail : ", e.getMessage() );
        }
    }
	
	private void traiterMessage( String message) {
        try {
        	validationChamp( message );
        } catch ( FormValidationException e ) {
        	mapErreurs.put( "Message : ", e.getMessage() );
        }
    }
	
	private void traiterTitre( String titre) {
        try {
        	validationChamp( titre );
        } catch ( FormValidationException e ) {
        	mapErreurs.put( "Titre : ", e.getMessage() );
        }
    }
	
	private void traiterNom( String nom) {
        try {
        	validationChamp( nom );
        } catch ( FormValidationException e ) {
        	mapErreurs.put( "Nom : ", e.getMessage() );
        }
    }
	

    /*---------------------------------------------------------------------------------------*/
    /*------------------------------------- VERIFICATIONS -----------------------------------*/
    /*---------------------------------------------------------------------------------------*/

    private void validationEmail( String email )
            throws FormValidationException {
        if ( email != null ) {
            if ( !email.matches( REGEX_EMAIL ) ) {
                throw new FormValidationException( MSG_ERREUR_EMAIL_INVALIDE );
            }
        } else {
            throw new FormValidationException( MSG_ERREUR_EMAIL_NULL );
        }
    }
    
    private void validationChamp( String champ ) throws FormValidationException {
        if ( champ != null ) {
            if ( champ.length() < 3 ) {
                throw new FormValidationException( MSG_ERREUR_MIN );
            }
        } else {
            throw new FormValidationException( MSG_ERREUR_NULL );
        }
    }
}
