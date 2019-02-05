package org.sid.web;

import java.util.List;

import org.sid.dao.EntrepotRepository;
import org.sid.entities.Barrique;
import org.sid.entities.Entrepot;
import org.sid.entities.Rack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Service
@RestController
public class EntrepotRestService {
	
	@Autowired
	public EntrepotRepository entrepotRepository;
	
	
	@RequestMapping(value = "/entrepots", method = RequestMethod.GET)
	public List<Entrepot> getEntrepots() {
		return entrepotRepository.getEntrepots();
	}
	@RequestMapping(value = "/rechercherEntrepot/{IdEntrepot}", method = RequestMethod.GET)
	public List<Entrepot> RechercherEntrepot(@PathVariable Long IdEntrepot) {
		return entrepotRepository.RechercherEntrepot(IdEntrepot);
	}

	/*@RequestMapping(value = "/entrepots/{id}", method = RequestMethod.POST)
	public Entrepot save(@RequestBody Entrepot e) {
		return entrepotRepository.save(e);
	}*/
	@RequestMapping(value = "/entrepotsEnStock", method = RequestMethod.GET)
	public List<Entrepot> save() {
		return entrepotRepository.getEntrepotsEtat();

}
	
	@RequestMapping(value = "/entrepots/{id}", method = RequestMethod.POST)
	public Entrepot addEntrepot(@RequestBody Entrepot e) {
		return entrepotRepository.addEntrepot(e);
	}
	
	@RequestMapping(value = "/entrepots/{IdEntrepot}", method = RequestMethod.POST)
	public Entrepot ModifEntrepot(@RequestParam long IdEntrepot, @RequestParam String ReferenceEntrepot,@RequestParam float Superficie) {
		
		return entrepotRepository.ModifEntrepot(IdEntrepot, ReferenceEntrepot, Superficie);
	}
}
