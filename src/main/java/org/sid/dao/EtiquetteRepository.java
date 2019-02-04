package org.sid.dao;

import org.sid.entities.Etiquette;
import org.sid.entities.Rack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtiquetteRepository extends JpaRepository<Etiquette, Long>, EtiquetteRepositoryCustom {

}
