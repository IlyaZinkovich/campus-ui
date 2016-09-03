package com.camp.campus.service;

import com.camp.campus.dto.StudentDTO;
import com.camp.campus.dto.SearchCriteria;

import java.util.List;

public interface StudentService {

    Long createStudent(StudentDTO studentDTO);
    List<StudentDTO> getStudents(SearchCriteria searchCriteria, Integer page, Integer size);
    StudentDTO getStudentById(Long studentId);
}
