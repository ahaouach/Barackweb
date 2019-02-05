package org.sid.dao;

import org.sid.entities.Barrique;
import org.sid.entities.TypeMouvement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeMouvementRepository extends JpaRepository<TypeMouvement, Long>, TypeMouvementRepositoryCustom{

}
