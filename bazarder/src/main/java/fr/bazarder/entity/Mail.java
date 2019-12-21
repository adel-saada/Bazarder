package fr.bazarder.entity;

public class Mail {
	
	private String nom;
	private String adresseMail;
	private String titre;

	private String message;
	
	public Mail() {
		
	}
	
	

	public Mail(String nom, String adresseMail, String titre, String message) {
		super();
		
		this.nom = nom;
		this.adresseMail = adresseMail;
		this.titre = titre;
		this.message = message;
	}



	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresseMail() {
		return adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
