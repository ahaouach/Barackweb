package org.sid.dao;

import org.sid.entities.Entrepot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepotRepository extends JpaRepository<Entrepot, Long>, EntrepotRepositoryCustom{

}
