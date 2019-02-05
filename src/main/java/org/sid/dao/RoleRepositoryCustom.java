package org.sid.dao;

import java.util.List;

import org.sid.entities.Role;

public interface RoleRepositoryCustom {

	public Role addRole(Role r);

	public Role ModifRole(long IdRole, String Libelle);

	public List<Role> getRoles();

}
