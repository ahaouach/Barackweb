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

		@RequestMapping(value = "/etiquettes", method = RequestMethod.GET)
		public List<Etiquette> getEtiquettes() {
			return etiquetteRepository.findAll();
		}

		@RequestMapping(value = "/etiquettes/{id}", method = RequestMethod.GET)
		public Etiquette getEtiquette(@PathVariable Long id) {
			return etiquetteRepository.findOne(id);
		}

		@RequestMapping(value = "/etiquettes/{id}", method = RequestMethod.POST)
		public Etiquette save(@RequestBody Etiquette e) {
			return etiquetteRepository.save(e);
		}
	}

