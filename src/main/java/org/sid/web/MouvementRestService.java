package org.sid.web;

import java.util.List;

import org.sid.dao.BarriqueRepository;
import org.sid.dao.MouvementRepository;
import org.sid.entities.Mouvement;
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
public class MouvementRestService {

	@Autowired
	private MouvementRepository mouvementRepository;
	
	@RequestMapping(value = "/addMouvements/{IdBarique}", method = RequestMethod.POST)
	public Mouvement addMouvement(@RequestBody Mouvement mv, @RequestParam long IdBarique,@RequestParam long IdTypeMouvement,@RequestParam long IdUser) {
return mouvementRepository.addMouvement(mv, IdBarique, IdTypeMouvement, IdUser);

	}
	@RequestMapping(value = "/mouvementsDates-{Libelle}-{DateDebut}-{DateFin}", method = RequestMethod.GET)
	public List<Mouvement> MouvementsDates(@PathVariable String Libelle,@PathVariable String DateDebut,@PathVariable String DateFin) {
		return mouvementRepository.MouvementsDates(Libelle, DateDebut, DateFin);
	}
	
}