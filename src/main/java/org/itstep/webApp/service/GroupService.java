package org.itstep.webApp.service;

import org.itstep.webApp.entity.Group;

import java.util.List;
import java.util.Optional;

public interface GroupService {

    void addNewGroup(Group group);

    List<Group> getAllGroups();

    Group getGroup(Long id);

    void updateGroup(Group group);

    void deleteGroupById(Long id);
}
