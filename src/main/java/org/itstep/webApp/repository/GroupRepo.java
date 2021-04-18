package org.itstep.webApp.repository;

import org.itstep.webApp.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface GroupRepo extends JpaRepository<Group, Long> {
    Group findByGroupName(String name);
}

