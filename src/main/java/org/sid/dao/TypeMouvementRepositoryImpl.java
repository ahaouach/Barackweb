package org.sid.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.sid.entities.TypeMouvement;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = false)
public class TypeMouvementRepositoryImpl implements TypeMouvementRepositoryCustom {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public TypeMouvement addTypeMouvement(TypeMouvement tmv) {
		em.persist(tmv);
		System.out.println("****************************  TypeMouvement de libelle :" + tmv.getLibelle()
				+ " est ajouté avec succés !! :) *************************");

		return tmv;
	}
	
}
