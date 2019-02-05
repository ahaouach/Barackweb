package org.sid.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.sid.entities.Barrique;
import org.sid.entities.Mouvement;
import org.sid.entities.TypeMouvement;
import org.sid.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional(readOnly = false)
public class MouvementRepositoryImpl implements MouvementRepositoryCustom {

	
		@PersistenceContext
		private EntityManager em;
		
		@Override
		public Mouvement addMouvement(Mouvement mv, long IdBarique, long IdTypeMouvement, long IdUser) {
			Barrique b = em.find(Barrique.class, IdBarique);
			mv.setBarriques(b);
			TypeMouvement tmv = em.find(TypeMouvement.class, IdTypeMouvement);
			mv.setTypemouvements(tmv);
			User u = em.find(User.class, IdUser);
			mv.setUsers(u);
			em.persist(mv);
			System.out.println("****************************  Mouvement numero :" + mv.getIdMouvement()
					+ " est ajouté avec succés !! :) *************************");

			return mv;
		}
		
		@Override
		public List<Mouvement> MouvementsDates(String Libelle, String DateDebut, String DateFin) {
			Query req = em.createNativeQuery("SELECT IdMouvement FROM Mouvement m"
					+ " INNER JOIN TypeMouvement tp "
					+ "ON tp.IdTypeMouvement = m.IdTypeMouvement"
					+ " WHERE tp.Libelle = '"+Libelle+"'  AND CONVERT(m.DateOperation, DATETIME) BETWEEN"
					+ " CONVERT('"+DateDebut+"', DATETIME)  AND CONVERT('"+DateFin+"', DATETIME)");
			System.out.println("voila "+req.getResultList());
			return req.getResultList();
		}


}
