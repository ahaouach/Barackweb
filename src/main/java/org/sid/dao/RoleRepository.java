package org.sid.dao;

import org.sid.entities.Barrique;
import org.sid.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>, RoleRepositoryCustom {

}
