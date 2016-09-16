package com.camp.campus.controller;

import com.camp.campus.dto.StudentDTO;
import com.camp.campus.dto.SearchCriteria;
import com.camp.campus.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${relationship-server.url}")
    private String relationshipServerUrl;

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

    @RequestMapping(path = "v1/students/{studentId}/image", method = PUT)
    public void updateStudentImage(@PathVariable Long studentId, @RequestBody String imagePath) {
        studentService.updateStudentImage(studentId, imagePath);
    }

    @RequestMapping(path = "v1/likes/students/{studentId}", method = GET)
    public List<StudentDTO> findStudentsWithMutualLike(@PathVariable("studentId") Long studentId) {
        List objectIds = restTemplate.getForObject(relationshipServerUrl + "/v1/likes/students/" + studentId, List.class);
        List<Long> studentIds = new ArrayList<>(objectIds.size());
        objectIds.forEach(o -> studentIds.add(Long.valueOf((Integer) o)));
        return studentService.getStudentsByIds(studentIds);
    }
}
