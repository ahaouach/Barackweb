package org.sid.web;

import java.util.List;


import org.sid.dao.BarriqueRepository;
import org.sid.dao.RackRepository;
import org.sid.entities.Barrique;
import org.sid.entities.Rack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@Service
@RestController
public class RackRestService {
	@Autowired
	private RackRepository rackRepository;

	@RequestMapping(value = "/racks", method = RequestMethod.GET)
	public List<Rack> getRacks() {
		return rackRepository.getRacks();
	}

	@RequestMapping(value = "/racksNumero/{Numero}", method = RequestMethod.GET)
	public List<Rack> RechercherRack(@PathVariable int Numero) {
		return rackRepository.RechercherRack(Numero);
	}

	@RequestMapping(value = "/racks/{id}", method = RequestMethod.POST)
	public Rack addRack(@RequestBody Rack r, Long IdEntrepot) {
		return rackRepository.addRack(r, IdEntrepot);
	}
	@RequestMapping(value = "/racks/{IdRack}{Numero}{Emplacement}{NbreLigne}{NbreColonne}{NbrePronfondeur}", method = RequestMethod.POST)
	public Rack ModifRack(long IdRack, int Numero, String Emplacement, int NbreLigne, int NbreColonne,
			int NbrePronfondeur) {
		return rackRepository.ModifRack(IdRack, Numero, Emplacement, NbreLigne, NbreColonne, NbrePronfondeur);
	}
}
