package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Etiquette implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long IdEtiquette;
	private String Code;
	private String DateOperation;
	private boolean Etat = true;
	
	@OneToMany(mappedBy="Etiquettes",fetch=FetchType.LAZY)
	private Collection<Barrique> Barriques;
	
	public long getIdEtiquette() {
		return IdEtiquette;
	}
	public void setIdEtiquette(long idEtiquette) {
		IdEtiquette = idEtiquette;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getDateOperation() {
		return DateOperation;
	}
	public void setDateOperation(String dateOperation) {
		DateOperation = dateOperation;
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
	public Etiquette() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Etiquette(String code, String dateOperation, boolean etat) {
		super();
		Code = code;
		DateOperation = dateOperation;
		Etat = etat;
	}
	@Override
	public String toString() {
		return "Etiquette [IdEtiquette=" + IdEtiquette + ", Code=" + Code + ", DateOperation=" + DateOperation
				+ ", Etat=" + Etat + ", Barriques=" + Barriques + "]";
	}

	
}

