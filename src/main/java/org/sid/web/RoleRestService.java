package org.sid.web;


import java.util.List;

import javax.persistence.Query;

import org.sid.dao.RoleRepository;
import org.sid.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
public class RoleRestService {
	@Autowired
	private RoleRepository roleRepository;
	
	@RequestMapping(value = "/addroles/{id}", method = RequestMethod.POST)
	public Role addRole(Role r) {
		return roleRepository.addRole(r);
		
	}
	@RequestMapping(value = "/modifierrole/{IdRole}/{Libelle}", method = RequestMethod.POST)
	public Role ModifRole(long IdRole, String Libelle) {
		return roleRepository.ModifRole(IdRole, Libelle);
	

	}

	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public List<Role> getRoles() {
		return roleRepository.getRoles();
	
	}

}


