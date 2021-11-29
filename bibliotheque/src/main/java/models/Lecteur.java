package models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lecteur {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  private String prenom;
  private String nom;
  private LocalDateTime dateNaissance;

  protected Lecteur() {}

  
}