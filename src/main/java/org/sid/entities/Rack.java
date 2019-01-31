package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity

public class Rack implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long IdRack;
	private int Numero;
	private String Emplacement;
	private int NbreLigne;
	private int NbreColonne;
	private int NbrePronfondeur;
	private String DateOperation;
	
	
	@ManyToOne()
	@JoinColumn(name="IdEntrepot")
	private Entrepot Entrepot;
	
	private boolean Etat= true ; 
	
	@OneToMany(mappedBy="Racks",fetch=FetchType.LAZY)
	private Collection<Barrique> Barriques;
	
	
	public Rack(int numero, String emplacement, int nbreLigne, int nbreColonne, int nbrePronfondeur,
			String dateOperation) {
		super();
		Numero = numero;
		Emplacement = emplacement;
		NbreLigne = nbreLigne;
		NbreColonne = nbreColonne;
		NbrePronfondeur = nbrePronfondeur;
		DateOperation = dateOperation;
		
		
	}
	
	
	
	public long getIdRack() {
		return IdRack;
	}
	public void setIdRack(long idRack) {
		IdRack = idRack;
	}
	public int getNumero() {
		return Numero;
	}
	public void setNumero(int numero) {
		Numero = numero;
	}
	public String getEmplacement() {
		return Emplacement;
	}
	public void setEmplacement(String emplacement) {
		Emplacement = emplacement;
	}
	public int getNbreLigne() {
		return NbreLigne;
	}
	public void setNbreLigne(int nbreLigne) {
		NbreLigne = nbreLigne;
	}
	public int getNbreColonne() {
		return NbreColonne;
	}
	public void setNbreColonne(int nbreColonne) {
		NbreColonne = nbreColonne;
	}
	public int getNbrePronfondeur() {
		return NbrePronfondeur;
	}
	public void setNbrePronfondeur(int nbrePronfondeur) {
		NbrePronfondeur = nbrePronfondeur;
	}
	public String getDateOperation() {
		return DateOperation;
	}
	public void setDateOperation(String dateOperation) {
		DateOperation = dateOperation;
	}
	
	public Entrepot getEntrepot() {
		return Entrepot;
	}
	public void setEntrepot(Entrepot entrepot) {
		Entrepot = entrepot;
	}
	public boolean isEtat() {
		return Etat;
	}
	public void setEtat(boolean etat) {
		Etat = etat;
	}
	public Collection<Barrique> getBarriques() {
		return Barriques;
	}
	public void setBarriques(Collection<Barrique> barriques) {
		Barriques = barriques;
	}
	public Rack() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
