package org.itstep.webApp.service.impl;

import org.itstep.webApp.entity.Role;
import org.itstep.webApp.repository.RoleRepo;
import org.itstep.webApp.service.RoleService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepo roleRepo;

    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepo.findAll();
    }

    @Override
    public Role getRole(Long id) {
        return roleRepo.getOne(id);
    }
}
