package fr.bazarder.exception;

public class FormValidationException extends Exception {
	

	private static final long serialVersionUID = 1L;
	
	public FormValidationException() {
		super();
	}

	public FormValidationException( String message ) {
        super( message );
    }

}
