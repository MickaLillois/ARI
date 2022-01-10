package com.tools;

public class Tools {

	// Méthode permettant de valider les String pour les requêtes create/update 
	public static boolean isLettersString(String chaine) {
		return chaine.matches("^\\w++(?:[.,_:()\\s'-](?![.\\s-])|\\w++)*$");
	}
	
	public static boolean isNumberString(String chaine) {
		return chaine.matches("[0-9]+");
	}
	
}
