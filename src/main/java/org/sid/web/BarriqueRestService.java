package org.sid.web;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.websocket.server.PathParam;

import org.apache.catalina.User;
import org.sid.dao.BarriqueRepository;
import org.sid.dao.RackRepository;
import org.sid.entities.Barrique;
import org.sid.entities.Entrepot;
import org.sid.entities.Etiquette;
import org.sid.entities.Mouvement;
import org.sid.entities.Rack;
import org.sid.entities.Role;
import org.sid.entities.TypeMouvement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Service
@RestController
public class BarriqueRestService {
	@Autowired
	private BarriqueRepository barriqueRepository;

	@RequestMapping(value = "/barriques", method = RequestMethod.GET)
	public List<Barrique> getBarriques() {
		return barriqueRepository.getBarriques();
	}

	@RequestMapping(value = "/addbarriques/{b}", method = RequestMethod.POST)
	public Barrique save(@RequestBody Barrique b) {
		return barriqueRepository.save(b);
	}

/*	@RequestMapping(value = "/chercherBarriques", method = RequestMethod.GET)
	public Page<Barrique> chercher(@RequestParam(name = "IdBarrique", defaultValue = "") Long IdBarrique,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		return barriqueRepository.chercher(IdBarrique, new PageRequest(page, size));
	}*/
	@RequestMapping(value = "/alerteBarriques", method = RequestMethod.GET)
	public List<Barrique> AlerteMaturite() {
		return barriqueRepository.AlerteMaturite();
	}
	
	@RequestMapping(value = "/rechercherbarriqueEntrepot/{IdEntrepot}", method = RequestMethod.GET)
	public List<Barrique> RechercherEntrepot(@PathVariable Long IdEntrepot) {
		return barriqueRepository.RechercherBarriqueEntrepot(IdEntrepot);
	}
	@RequestMapping(value = "/rechercherbarrique/{IdBarique}", method = RequestMethod.GET)
	public List<Barrique> RechercherBarrique(@PathVariable long IdBarique) {
		return barriqueRepository.RechercherBarrique(IdBarique);
	}

	
	
}