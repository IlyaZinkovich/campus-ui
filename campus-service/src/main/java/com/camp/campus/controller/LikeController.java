package com.camp.campus.controller;

import com.camp.campus.dto.LikeEventDTO;
import com.camp.campus.dto.ProfileDTO;
import com.camp.campus.model.Like;
import com.camp.campus.service.EventService;
import com.camp.campus.service.LikeService;
import com.camp.campus.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class LikeController {

    @Autowired
    private LikeService likeService;
    @Autowired
    private EventService eventService;

    @RequestMapping(path = "v1/like", method = POST)
    public void like(@RequestParam(name = "type") Like.LikeType type, @RequestParam(name = "from") Long from, @RequestParam(name = "to") Long to) {
        Like like = new Like(from, to, type);
        boolean bothLike = likeService.like(like);
        if (bothLike) {
            LikeEventDTO event = new LikeEventDTO(from, to);
            eventService.saveLikeEvent(event);
        }
    }
}
