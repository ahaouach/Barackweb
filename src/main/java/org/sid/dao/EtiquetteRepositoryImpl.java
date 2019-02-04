package org.sid.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.sid.entities.Etiquette;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = false)
public class EtiquetteRepositoryImpl implements EtiquetteRepositoryCustom {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Etiquette addEtiquette(Etiquette et) {
		em.persist(et);
		System.out.println("****************************  " + "Etiquette numero :" + et.getIdEtiquette()
				+ " est ajouté avec succés !! :) " + "*************************");

		return et;
	}
	@Override
	public void ModifEttiquette(long IdEtiquette, String code) {
		Etiquette e = em.find(Etiquette.class, IdEtiquette);
		em.createQuery("update Etiquette set Code = '" + code + "' where IdEtiquette = '" + IdEtiquette + "'")
				.executeUpdate();
		em.refresh(e);
	

	}

	@Override
	public List<Etiquette> getEtiquettes() {
		Query req = em.createQuery("select e from Etiquette e where Etat = 1");
		return req.getResultList();
	}

}
