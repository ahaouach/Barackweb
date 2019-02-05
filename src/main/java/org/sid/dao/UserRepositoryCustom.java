package org.sid.dao;

import java.util.List;

import org.sid.entities.User;

public interface UserRepositoryCustom {

	public User addUser(User u, long IdRole);

	public List<User> RechercherUser(long IdUser);

	public User ModifUser(long IdUser, String Nom, String Prenom, String Fonction, String Login, String PassWord);

	public List<User> getUsers();

}
