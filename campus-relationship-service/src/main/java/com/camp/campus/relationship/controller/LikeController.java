package com.camp.campus.relationship.controller;

import com.camp.campus.relationship.dto.LikeDTO;
import com.camp.campus.relationship.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class LikeController {

    @Autowired
    private LikeService likeService;

    @RequestMapping(path = "v1/likes", method = POST)
    public boolean like(@RequestBody LikeDTO like) {
        return likeService.saveLikeOrRemoveIfExists(like);
    }

    @RequestMapping(path = "v1/likes/students/{studentId}", method = GET)
    public List<Long> findStudentsIdsWithMutualLike(@PathVariable("studentId") Long studentId) {
        return likeService.findStudentIdsWithMutualLike(studentId);
    }

    @RequestMapping(path = "v1/likes", method = GET)
    public boolean checkIfLikeExists(@RequestParam("from") Long from, @RequestParam("to") Long to,
                           @RequestParam("type") String type) {
        return likeService.checkIfLikeExists(from, to, type);
    }
}
