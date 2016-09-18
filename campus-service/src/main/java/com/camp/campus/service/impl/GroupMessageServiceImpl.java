package com.camp.campus.service.impl;

import com.camp.campus.dto.GroupDTO;
import com.camp.campus.dto.GroupMessageDTO;
import com.camp.campus.model.CampusGroup;
import com.camp.campus.model.GroupMessage;
import com.camp.campus.repository.GroupMessageRepository;
import com.camp.campus.service.GroupMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GroupMessageServiceImpl implements GroupMessageService {

    @Autowired
    private GroupMessageRepository groupMessageRepository;

    @Override
    public List<GroupMessageDTO> getGroupsMessages(List<Long> groupIds) {
        return groupMessageRepository.getGroupsMessages(groupIds)
                .stream().map(this::groupMessageToDto).collect(Collectors.toList());
    }

    private GroupMessageDTO groupMessageToDto(GroupMessage groupMessage) {
        return new GroupMessageDTO(groupMessage.getId(), groupMessage.getMessage(),
                groupToDto(groupMessage.getGroup()));
    }

    private GroupDTO groupToDto(CampusGroup group) {
        return new GroupDTO(group.getId(), group.getName());
    }
}
