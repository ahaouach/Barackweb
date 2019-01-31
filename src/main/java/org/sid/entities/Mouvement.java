package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity


public class Mouvement implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	  private long  IdMouvement;
	  private String DateOperation;
	  private String Observation;
	  private boolean Etat=true ; 
	 
	  @ManyToOne
	  @JoinColumn(name="IdBarrique")
	  private Barrique Barriques;
	  
	  @ManyToOne
	  @JoinColumn(name="IdUser")
	  private User Users;
	 
	  @ManyToOne
	  @JoinColumn(name="IdTypeMouvement")
	  private TypeMouvement TypeMouvements;
	  
	  
	  public long getIdMouvement() {
		return IdMouvement;
	}
	public void setIdMouvement(long idMouvement) {
		IdMouvement = idMouvement;
	}
	public String getDateOperation() {
		return DateOperation;
	}
	public void setDateOperation(String dateOperation) {
		DateOperation = dateOperation;
	}
	public String getObservation() {
		return Observation;
	}
	public void setObservation(String observation) {
		Observation = observation;
	}
	public boolean isEtat() {
		return Etat;
	}
	public void setEtat(boolean etat) {
		Etat = etat;
	}
	
	public Barrique getBarriques() {
		return Barriques;
	}
	public void setBarriques(Barrique barriques) {
		Barriques = barriques;
	}
	
	public User getUsers() {
		return Users;
	}
	public void setUsers(User u) {
		Users = u;
	}
	
	public TypeMouvement getTypemouvements() {
		return TypeMouvements;
	}
	public void setTypemouvements(TypeMouvement typemouvements) {
		TypeMouvements = typemouvements;
	}
	public Mouvement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mouvement(String dateOperation, String observation, boolean etat) {
		super();
		DateOperation = dateOperation;
		Observation = observation;
		Etat = etat;
	}	  
}
