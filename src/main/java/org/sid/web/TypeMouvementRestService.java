package org.sid.web;

import org.sid.dao.BarriqueRepository;
import org.sid.dao.TypeMouvementRepository;
import org.sid.entities.TypeMouvement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
public class TypeMouvementRestService {
	@Autowired
	private TypeMouvementRepository typeMouvementRepository;
	
	@RequestMapping(value = "/addtypemouvement/{tmv}", method = RequestMethod.POST)
	public TypeMouvement addTypeMouvement(@RequestBody TypeMouvement tmv) {
		return typeMouvementRepository.addTypeMouvement(tmv);
	}
}
