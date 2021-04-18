package org.itstep.webApp.service.impl;

import org.itstep.webApp.entity.Group;
import org.itstep.webApp.repository.GroupRepo;
import org.itstep.webApp.service.GroupService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {
    private final GroupRepo groupRepo;

    public GroupServiceImpl(GroupRepo groupRepo) {
        this.groupRepo = groupRepo;
    }

    @Override
    public void addNewGroup(Group group) {
        Group checkGroup = groupRepo.findByGroupName(group.getGroupName());
        if (checkGroup == null) {
            groupRepo.save(group);
        }
    }

    @Override
    public List<Group> getAllGroups() {
        return groupRepo.findAll();
    }

    @Override
    public Group getGroup(Long id) {
        return groupRepo.getOne(id);
    }

    @Override
    public void updateGroup(Group group) {
        groupRepo.save(group);
    }

    @Override
    public void deleteGroupById(Long id) {
        groupRepo.deleteById(id);
    }
}
