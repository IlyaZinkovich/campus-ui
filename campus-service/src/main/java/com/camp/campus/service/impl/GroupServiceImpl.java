package com.camp.campus.service.impl;

import com.camp.campus.dto.GroupDTO;
import com.camp.campus.model.CampusGroup;
import com.camp.campus.repository.GroupRepository;
import com.camp.campus.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<Long> getStudentGroupIds(Long studentId) {
        return groupRepository.findGroupsByStudentId(studentId)
                .stream().map(CampusGroup::getId).collect(Collectors.toList());
    }

    @Override
    public List<GroupDTO> getGroups(Long studentId, Boolean joined) {
        List<CampusGroup> groups = new ArrayList<>(0);
        if (studentId != null && joined != null) {
            groups = joined ? groupRepository.findGroupsByStudentId(studentId) :
                    groupRepository.findGroupsNotJoinedByStudentWithId(studentId);

        } else {
            groupRepository.findAll();
        }
        return groups.stream().map(this::groupToGroupDto).collect(Collectors.toList());
    }

    private GroupDTO groupToGroupDto(CampusGroup group) {
        return new GroupDTO(group.getId(), group.getName());
    }
}
