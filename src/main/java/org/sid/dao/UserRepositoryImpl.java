package org.sid.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.sid.entities.Role;
import org.sid.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = false)
public class UserRepositoryImpl implements UserRepositoryCustom {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User addUser(User u, long IdRole) {
		Role r = em.find(Role.class, IdRole);
		u.setRoles(r);
		MessageDigest digester = null;
	        try {
	            digester = MessageDigest.getInstance("MD5");
	        }
	        catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        if (u.getPassWord() == null || u.getPassWord().length() == 0) {
	            throw new IllegalArgumentException("String to encript cannot be null or zero length");
	        }
	        digester.update(u.getPassWord().getBytes());
	        byte[] hash = digester.digest();
	        StringBuffer hexString = new StringBuffer();
	        for (int i = 0; i < hash.length; i++) {
	            if ((0xff & hash[i]) < 0x10) {
	                hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
	            }
	            else {
	                hexString.append(Integer.toHexString(0xFF & hash[i]));
	            }
	        }
	        u.setPassWord(hexString.toString()); 
		em.persist(u);
		System.out.println("****************************  User numero :" + u.getIdUser()
				+ " est ajouté avec succés !! :) *************************");
		return u;
		}
	@Override
	public List<User> getUsers() {
		Query req = em.createQuery("select u from User u where Etat = 1");
		return req.getResultList();
	}
	
	@Override
	public User ModifUser(long IdUser, String Nom, String Prenom, String Fonction, String Login, String PassWord) {
		User u = em.find(User.class, IdUser);
		/*em.createQuery("update User set Nom = '" + Nom + "' , Prenom = '" + Prenom + "' , Fonction = '" + Fonction
				+ "', Login = '" + Login + "' , PassWord = '" + PassWord + "' where IdUser = '" + IdUser + "'")
				.executeUpdate();*/
		u.setNom(Nom);
		u.setPrenom(Prenom);
		u.setFonction(Fonction);
		u.setLogin(Login);
		MessageDigest digester = null;
        try {
            digester = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (u.getPassWord() == null || u.getPassWord().length() == 0) {
            throw new IllegalArgumentException("String to encript cannot be null or zero length");
        }
        digester.update(u.getPassWord().getBytes());
        byte[] hash = digester.digest();
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            if ((0xff & hash[i]) < 0x10) {
                hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
            }
            else {
                hexString.append(Integer.toHexString(0xFF & hash[i]));
            }
        }
        u.setPassWord(hexString.toString()); 
		return u;
	}
	@Override
	public List<User> RechercherUser(long IdUser) {
		Query req = em.createNativeQuery("SELECT u.Nom " + "From User u " + "WHERE IdUser = '" + IdUser + "'");
		List<String> r = req.getResultList();
		System.out.println("" + r.toString());
		return req.getResultList();
	}



}
