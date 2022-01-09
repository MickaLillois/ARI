package com.exceptions;

public class InvalidStringException extends Exception {
	
	public InvalidStringException() {
		super("Erreur de String gérée : Le format n'est pas valide.");
	}
	
}
