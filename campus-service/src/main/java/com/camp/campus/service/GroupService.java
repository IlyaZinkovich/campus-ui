package com.camp.campus.service;

import com.camp.campus.dto.GroupDTO;

import java.util.List;

public interface GroupService {

    List<Long> getStudentGroupIds(Long studentId);

    List<GroupDTO> getGroups(Long studentId, Boolean joined);
}
