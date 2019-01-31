package org.sid.dao;

import org.sid.entities.Barrique;
import org.sid.entities.Rack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RackRepository extends JpaRepository<Rack, Long>{
	

}
