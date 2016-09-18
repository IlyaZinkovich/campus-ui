package com.camp.campus.controller;

import com.camp.campus.dto.GroupMessageDTO;
import com.camp.campus.service.GroupMessageService;
import com.camp.campus.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class GroupMessageController {

    @Autowired
    private GroupMessageService groupMessageService;

    @Autowired
    private GroupService groupService;

    @RequestMapping(path = "v1/groups/messages", method = GET)
    public List<GroupMessageDTO> getGroupsMessages(@RequestParam(required = false) Long studentId) {
        List<Long> studentGroupIds = groupService.getStudentGroupIds(studentId);
        return groupMessageService.getGroupsMessages(studentGroupIds);
    }

    @RequestMapping(path = "v1/groups/{groupId}/messages", method = GET)
    public List<GroupMessageDTO> getGroupMessages(@PathVariable("groupId") Long groupId) {
        return groupMessageService.getGroupMessages(groupId);
    }
}
