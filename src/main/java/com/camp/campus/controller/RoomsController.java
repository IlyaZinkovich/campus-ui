package com.camp.campus.controller;

import com.camp.campus.dto.RoomDTO;
import com.camp.campus.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class RoomsController {

    @Autowired
    private RoomsService roomsService;

    @RequestMapping(path = "v1/rooms", method = GET)
    public List<RoomDTO> getRooms() {
        return roomsService.findAll();
    }
}
