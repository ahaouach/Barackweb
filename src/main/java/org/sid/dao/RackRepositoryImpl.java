package org.sid.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.sid.entities.Barrique;
import org.sid.entities.Entrepot;
import org.sid.entities.Rack;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = false)
public class RackRepositoryImpl implements RackRepositoryCustom {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Rack> getRacks() {
		Query req = em.createNativeQuery("select * from Rack r");
		return req.getResultList();
	}

	@Override
	public Rack ModifRack(long IdRack, int Numero, String Emplacement, int NbreLigne, int NbreColonne,
			int NbrePronfondeur) {
		Rack r = em.find(Rack.class, IdRack);
		em.createQuery("update rack set Numero = '" + Numero + "' , Emplacement = '" + Emplacement + "' , NbreLigne = '"
				+ NbreLigne + "', NbreColonne = '" + NbreColonne + "' , NbrePronfondeur = '" + NbrePronfondeur
				+ "' where IdRack = '" + IdRack + "'").executeUpdate();
		em.refresh(r);
		return r;
	}

	@Override
	public Rack addRack(Rack r, long IdEntrepot) {
		Entrepot e = em.find(Entrepot.class, IdEntrepot);
		r.setEntrepot(e);
		em.persist(r);

		return r;
	}

	@Override
	public List<Rack> RechercherRack(int Numero) {
		Query req = em.createNativeQuery("SELECT * " + "From Rack r " + "WHERE Numero = '" + Numero + "'");
		List<String> r = req.getResultList();
		System.out.println("" + r);
		return req.getResultList();
	}
}
