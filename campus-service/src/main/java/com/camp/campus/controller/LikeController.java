package com.camp.campus.controller;

import com.camp.campus.dto.LikeDTO;
import com.camp.campus.dto.StudentDTO;
import com.camp.campus.model.Like;
import com.camp.campus.service.LikeService;
import com.camp.campus.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public void like(@RequestBody LikeDTO like) {
        likeService.saveLike(like);
    }

    @RequestMapping(path = "v1/likes/students/{studentId}", method = GET)
    public List<StudentDTO> findStudentsWithMutualLike(@RequestParam(name = "studentId") Long studentId) {
        List<Long> studentIds = likeService.findStudentIdsWithMutualLike(studentId);
        return studentService.getStudentsByIds(studentIds);
    }
}
