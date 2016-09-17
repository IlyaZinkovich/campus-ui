package com.camp.campus.controller;

import com.camp.campus.dto.GroupDTO;
import com.camp.campus.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @RequestMapping(path = "v1/groups", method = GET)
    public List<GroupDTO> getGroups(@RequestParam(required = false) Long studentId) {
        return groupService.getStudentGroups(studentId);
    }
}
