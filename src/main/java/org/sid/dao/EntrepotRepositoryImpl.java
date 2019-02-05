package org.sid.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.sid.entities.Barrique;
import org.sid.entities.Entrepot;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = false)
public class EntrepotRepositoryImpl implements EntrepotRepositoryCustom {
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public List<Entrepot> getEntrepots() {
		Query req = em.createNativeQuery("select * from Entrepot b");
		return req.getResultList();
	}
	@Override
	public Entrepot addEntrepot(Entrepot e) {
		em.persist(e);
		return e;
	}
	
	@Override
	public List<Entrepot> getEntrepotsEtat() {

		Query req = em.createNativeQuery("select * from Entrepot e where e.Etat = 1");
		return req.getResultList();
	}
	
	@Override
	public Entrepot ModifEntrepot(long IdEntrepot, String ReferenceEntrepot, float Superficie) {
		Entrepot e = em.find(Entrepot.class, IdEntrepot);
		em.createNativeQuery("update entrepot set ReferenceEntrepot = '" + ReferenceEntrepot + "' , Superficie = '"
				+ Superficie + "' where IdEntrepot = '" + IdEntrepot + "'").executeUpdate();
		em.refresh(e);
		return e;
	}
	@Override
	public List<Entrepot> RechercherEntrepot(long IdEntrepot) {
		Query req = em.createNativeQuery("select * from Entrepot e where IdEntrepot = '" + IdEntrepot + "'");
		System.out.println(""+req.getResultList().toString());
		return req.getResultList();

	}

}
