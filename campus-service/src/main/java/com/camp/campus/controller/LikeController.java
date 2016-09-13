package com.camp.campus.controller;

import com.camp.campus.dto.LikeDTO;
import com.camp.campus.dto.StudentDTO;
import com.camp.campus.service.LikeService;
import com.camp.campus.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class LikeController {

    @Autowired
    private LikeService likeService;
    @Autowired
    private StudentService studentService;

    @RequestMapping(path = "v1/likes", method = POST)
    public boolean like(@RequestBody LikeDTO like) {
        return likeService.saveLikeOrRemoveIfExists(like);
    }

    @RequestMapping(path = "v1/likes/students/{studentId}", method = GET)
    public List<StudentDTO> findStudentsWithMutualLike(@PathVariable("studentId") Long studentId) {
        List<Long> studentIds = likeService.findStudentIdsWithMutualLike(studentId);
        return studentService.getStudentsByIds(studentIds);
    }

    @RequestMapping(path = "v1/likes", method = GET)
    public boolean checkIfLikeExists(@RequestParam("from") Long from, @RequestParam("to") Long to,
                           @RequestParam("type") String type) {
        return likeService.checkIfLikeExists(from, to, type);
    }
}
