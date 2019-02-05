package org.sid.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.sid.entities.Barrique;
import org.sid.entities.Etiquette;
import org.sid.entities.Rack;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = false)
public class BarriqueRepositoryImpl implements BarriqueRepositoryCustom {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public List<Barrique> AlerteMaturite() {
		final Date date = new Date();
		String Dates = new SimpleDateFormat("dd/MM/yyyy").format(date);
		Query req = em.createNativeQuery("SELECT * FROM Barrique b WHERE CONVERT(b.DateMaturaVin, DATETIME) <= NOW()");
		List<String> a = req.getResultList();
		System.out.println(""+a);
	    
		return req.getResultList();
	}
	
	@Override
	public void addBarrique(Barrique b, long IdEtiquette, long IdRack) {
		Etiquette e = em.find(Etiquette.class, IdEtiquette);
		b.setEtiquettes(e);
		Rack r = em.find(Rack.class, IdRack);
		b.setRacks(r);
		em.persist(b);
		System.out.println("****************************  Barrique numero :" + b.getIdBarique()
				+ " est ajouté avec succés dans l'emplacement " + b.getXLigne() +" "+ b.getYColone() + " " + b.getZEtiquette()
				+ ":) " + "*************************");

		
	}
	
	@Override
	public List<Barrique> getBarriques() {
		Query req = em.createNativeQuery("select * from Barrique b");
		System.out.println(""+req.getResultList());
		return req.getResultList();
	}
	
	@Override
	public List<Barrique> RechercherBarriqueEntrepot(long IdEntrepot) {

		// Entrepot e = em.find(Entrepot.class, IdEntrepot);
		Query req = em.createNativeQuery("select b.IdBarique, b.CodeBarre, b.DateFabricaVin, b.DateMaturaVin, b.DateOperation, "
				+ "b.Etat, b.XLigne, b.YColone, b.ZEtiquette, b.IdRack, b.IdEtiquette "
				+ " from Barrique b INNER JOIN Rack r ON r.IdRack = b.IdRack INNER JOIN Entrepot e ON e.IdEntrepot = r.IdEntrepot WHERE e.IdEntrepot = '"+IdEntrepot+"'" );
		List<String> a = req.getResultList();
		System.out.println("" + a);
		return req.getResultList();

	}
	@Override
	public List<Barrique> RechercherBarrique(long IdBarique) {

		// Entrepot e = em.find(Entrepot.class, IdEntrepot);
		Query req = em.createNativeQuery("select * from Barrique b WHERE b.IdBarique = '"+IdBarique+"'" );
		List<String> a = req.getResultList();
		System.out.println("" + a);
		return req.getResultList();

	}
	
}
