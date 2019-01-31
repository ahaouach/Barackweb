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
//@Table(name="User")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdUser;
	private String Nom;
	private String Prenom;
	private String Fonction;
	private String Login;
	private String PassWord;
	private String DateOperation;
	private boolean Etat = true;

	@ManyToOne
	@JoinColumn(name = "IdRole")
	private Role Roles;

	@OneToMany(mappedBy = "Users", fetch = FetchType.LAZY)
	private Collection<Mouvement> Mouvements;

	public long getIdUser() {
		return IdUser;
	}

	public void setIdUser(long idUser) {
		IdUser = idUser;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getFonction() {
		return Fonction;
	}

	public void setFonction(String fonction) {
		Fonction = fonction;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getPassWord() {
		return PassWord;
	}

	public void setPassWord(String passWord) {
		PassWord = passWord;
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

	public Role getRoles() {
		return Roles;
	}

	public void setRoles(Role roles) {
		Roles = roles;
	}

	public Collection<Mouvement> getMouvements() {
		return Mouvements;
	}

	public void setMouvements(Collection<Mouvement> mouvements) {
		Mouvements = mouvements;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String nom, String prenom, String fonction, String login, String passWord, String dateOperation,
			boolean etat) {
		super();
		Nom = nom;
		Prenom = prenom;
		Fonction = fonction;
		Login = login;
		PassWord = passWord;
		DateOperation = dateOperation;
		Etat = etat;
	}

}
