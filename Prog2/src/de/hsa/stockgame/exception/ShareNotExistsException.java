package de.hsa.stockgame.exception;

public class ShareNotExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ShareNotExistsException() {
		super();
	}
	
	public ShareNotExistsException(String s) {
		super(s);
	}

}
