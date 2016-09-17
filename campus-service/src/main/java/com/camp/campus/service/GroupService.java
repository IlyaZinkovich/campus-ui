package com.camp.campus.service;

import com.camp.campus.dto.GroupDTO;

import java.util.List;

public interface GroupService {

    List<Long> getStudentGroupIds(Long studentId);

    List<GroupDTO> getStudentGroups(Long studentId);
}
