package com.camp.campus.service;

import com.camp.campus.dto.GroupMessageDTO;

import java.util.List;

public interface GroupMessageService {

    List<GroupMessageDTO> getGroupsMessages(List<Long> studentGroupIds);

    List<GroupMessageDTO> getGroupMessages(Long groupId);
}
