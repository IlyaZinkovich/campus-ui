package com.camp.campus.controller;

import com.camp.campus.dto.EventDTO;
import com.camp.campus.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping(path = "v1/events/{profileId}", method = GET)
    public List<EventDTO> getProfileEvents(@PathVariable Long profileId) {
        return eventService.findByStudentId(profileId);
    }

}
