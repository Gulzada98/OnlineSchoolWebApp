package org.itstep.webApp.service;

import org.itstep.webApp.entity.Group;
import org.itstep.webApp.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    Role getRole(Long id);

}
