package org.sid.web;

import java.util.List;

import org.sid.dao.EntrepotRepository;
import org.sid.entities.Entrepot;
import org.sid.entities.Rack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntrepotRestService {
	
	@Autowired
	public EntrepotRepository entrepotRepository;
	
	
	@RequestMapping(value = "/entrepots", method = RequestMethod.GET)
	public List<Entrepot> getEntrepots() {
		return entrepotRepository.findAll();
	}
	@RequestMapping(value = "/entrepots/{id}", method = RequestMethod.GET)
	public Entrepot getEntrepot(@PathVariable Long id) {
		return entrepotRepository.findOne(id);
	}

	@RequestMapping(value = "/entrepots/{id}", method = RequestMethod.POST)
	public Entrepot save(@RequestBody Entrepot e) {
		return entrepotRepository.save(e);
	}

}
