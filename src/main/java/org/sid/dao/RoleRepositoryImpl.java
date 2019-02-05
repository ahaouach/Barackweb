package org.sid.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.sid.entities.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional(readOnly = false)
public class RoleRepositoryImpl implements RoleRepositoryCustom {
	
	
		@PersistenceContext
		private EntityManager em;
		
		@Override
		public Role addRole(Role r) {
			em.persist(r);
			System.out.println("****************************  Role numero :" + r.getIdRole()
					+ " est ajouté avec succés !! :) *************************");

			return r;
		}
		@Override
		public Role ModifRole(long IdRole, String Libelle) {
			Role r = em.find(Role.class, IdRole);
			em.createQuery("update Role set Libelle = '" + Libelle + "' where IdRole = '" + IdRole + "'").executeUpdate();
			em.refresh(r);
			return r;

		}

		@Override
		public List<Role> getRoles() {
			Query req = em.createNativeQuery("select * from Role r");
			return req.getResultList();
		}

}
