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
public class Role implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long IdRole;
	private String Libelle;
	
	@OneToMany(mappedBy="Roles",fetch=FetchType.LAZY)
	private Collection<User>Users;
	public long getIdRole() {
		return IdRole;
	}
	public void setIdRole(long idRole) {
		IdRole = idRole;
	}
	public String getLibelle() {
		return Libelle;
	}
	public void setLibelle(String libelle) {
		Libelle = libelle;
	}
	public Collection<User> getUsers() {
		return Users;
	}
	public void setUsers(Collection<User> users) {
		Users = users;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(String libelle) {
		super();
		Libelle = libelle;
	}
	@Override
	public String toString() {
		return "Role [IdRole=" + IdRole + ", Libelle=" + Libelle + ", Users=" + Users + "]";
	} 

	
}
