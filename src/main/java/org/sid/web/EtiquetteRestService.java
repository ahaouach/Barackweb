package org.sid.web;

import java.util.List;

import org.sid.dao.EtiquetteRepository;
import org.sid.dao.RackRepository;
import org.sid.entities.Etiquette;
import org.sid.entities.Rack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EtiquetteRestService {
	
	
		@Autowired
		private EtiquetteRepository etiquetteRepository;

	/*	@RequestMapping(value = "/etiquettes", method = RequestMethod.GET)
		public List<Etiquette> getEtiquettes() {
			return etiquetteRepository.findAll();
		}*/

		@RequestMapping(value = "/etiquettes/{idEtiquette}", method = RequestMethod.GET)
		public Etiquette getEtiquette(@PathVariable Long Etiquette) {
			return etiquetteRepository.findOne(Etiquette);
		}

		@RequestMapping(value = "/etiquettesajouter", method = RequestMethod.POST)
		public Etiquette addEtiquette(@RequestBody Etiquette et) {
			return etiquetteRepository.addEtiquette(et);
		}
		@RequestMapping(value = "/etiquettes/{IdEtiquette,Code}", method = RequestMethod.POST)
		public Etiquette ModifEttiquette(long IdEtiquette, String code) {
			return etiquetteRepository.ModifEttiquette(IdEtiquette, code);
		}
		@RequestMapping(value = "/etiquettes", method = RequestMethod.GET)
		public List<Etiquette> getEtiquettes() {
			return etiquetteRepository.getEtiquettes();
			
		}
	}

