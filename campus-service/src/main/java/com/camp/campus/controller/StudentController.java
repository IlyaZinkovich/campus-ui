package com.camp.campus.controller;

import com.camp.campus.dto.StudentDTO;
import com.camp.campus.dto.SearchCriteria;
import com.camp.campus.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(path = "v1/students", method = POST)
    public Long createProfile(@RequestBody StudentDTO poll) {
        return studentService.createStudent(poll);
    }

    @RequestMapping(path = "v1/students", method = GET)
    public List<StudentDTO> getProfiles(@RequestParam(required = false) String name,
                                        @RequestParam(required = false) String gender,
                                        @RequestParam(required = false) Integer ageLow,
                                        @RequestParam(required = false) Integer ageHigh,
                                        @RequestParam(required = false) String faculty,
                                        @RequestParam(required = false) String speciality,
                                        @RequestParam(required = false) Integer course,
                                        @RequestParam(required = false) Integer group,
                                        @RequestParam(required = false) Integer page,
                                        @RequestParam(required = false) Integer size) {
        return studentService.getStudents(new SearchCriteria(name, gender, ageLow, ageHigh, faculty, speciality, course, group), page, size);
    }

    @RequestMapping(path = "v1/students/{studentId}", method = GET)
    public StudentDTO getProfileById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }
}
