package org.itstep.webApp.repository;

import org.itstep.webApp.entity.Group;
import org.itstep.webApp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RoleRepo extends JpaRepository<Role, Long> {

}

