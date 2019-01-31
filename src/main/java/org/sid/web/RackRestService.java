package org.sid.web;

import java.util.List;

import org.sid.dao.BarriqueRepository;
import org.sid.dao.RackRepository;
import org.sid.entities.Barrique;
import org.sid.entities.Rack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class RackRestService {
	@Autowired
	private RackRepository rackRepository;

	@RequestMapping(value = "/racks", method = RequestMethod.GET)
	public List<Rack> getRack() {
		return rackRepository.findAll();
	}

	@RequestMapping(value = "/racks/{id}", method = RequestMethod.GET)
	public Rack getRack(@PathVariable Long id) {
		return rackRepository.findOne(id);
	}

	@RequestMapping(value = "/racks/{id}", method = RequestMethod.POST)
	public Rack save(@RequestBody Rack b) {
		return rackRepository.save(b);
	}
}
