package com.exceptions;

public class InvalidIdForBibliothqueException extends Exception{
	
	public InvalidIdForBibliothqueException() {
		super("Cet id ne correspond à aucune Bibliotheque.");
	}
	
}
