package org.sid.web;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.Query;

import org.sid.dao.BarriqueRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.Role;
import org.sid.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
public class UserRestService {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/assuser/{u}", method = RequestMethod.POST)
	public User addUser(@RequestBody User u, long IdRole) {
		return userRepository.addUser(u, IdRole);
		
		}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getUsers() {
		return userRepository.getUsers();
		
	}
	
	@RequestMapping(value = "/modifierusers/{IdUser}/{Nom}{Prenom}{Fonction}{Login}{PassWord}", method = RequestMethod.PUT)
	public User ModifUser(@PathVariable long IdUser,@PathVariable String Nom,@PathVariable String Prenom,@PathVariable String Fonction,@PathVariable String Login,@PathVariable String PassWord) {
	return userRepository.ModifUser(IdUser, Nom, Prenom, Fonction, Login, PassWord);
	}
	
	@RequestMapping(value = "/users/IdUser", method = RequestMethod.GET)
	public List<User> RechercherUser(@PathVariable long IdUser) {
		return userRepository.RechercherUser(IdUser);
		
		
	}



}


	
	
