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
		return et;
	}

	@Override
	public Etiquette ModifEttiquette(long IdEtiquette, String code) {
		Etiquette e = em.find(Etiquette.class, IdEtiquette);
		em.createQuery("update etiquette set Code = '" + code + "' where id_etiquette = '" + IdEtiquette + "'")
				.executeUpdate();
		em.refresh(e);
		return e;

	}

	@Override
	public List<Etiquette> getEtiquettes() {
		Query req = em.createNativeQuery("select * from Etiquette e where e.Etat=1");
		return req.getResultList();
	}

}
