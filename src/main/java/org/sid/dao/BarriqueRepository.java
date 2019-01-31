package org.sid.dao;

import java.util.List;

import javax.management.relation.Role;
import javax.websocket.server.PathParam;

import org.apache.catalina.User;
import org.sid.entities.Barrique;
import org.sid.entities.Entrepot;
import org.sid.entities.Etiquette;
import org.sid.entities.Mouvement;
import org.sid.entities.Rack;
import org.sid.entities.TypeMouvement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface BarriqueRepository extends JpaRepository<Barrique, Long>, BarriqueRepositoryCustom {
	
	@Query("select b from Barrique b where b.IdBarique like :x")
public Page<Barrique> chercher(@Param("x")Long IdBarrique, Pageable pageable);
	


}
