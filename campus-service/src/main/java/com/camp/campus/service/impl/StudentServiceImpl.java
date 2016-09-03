package com.camp.campus.service.impl;

import com.camp.campus.dto.StudentDTO;
import com.camp.campus.dto.SearchCriteria;
import com.camp.campus.model.Student;
import com.camp.campus.model.Room;
import com.camp.campus.repository.StudentRepository;
import com.camp.campus.repository.implementation.StudentSpecification;
import com.camp.campus.repository.RoomRepository;
import com.camp.campus.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Long createStudent(StudentDTO studentDTO) {
        Student student = new Student.StudentBuilder().firstName(studentDTO.getFirstName()).lastName(studentDTO.getLastName())
                .gender(Student.Gender.valueOf(studentDTO.getGender()))
                .birthDate(studentDTO.getBirthDate())
                .faculty(studentDTO.getFaculty())
                .speciality(studentDTO.getSpeciality())
                .course(studentDTO.getCourse())
                .group(studentDTO.getGroup())
                .imagePath(studentDTO.getImagePath())
                .build();
        Room room = roomRepository.findByRoomNumber(studentDTO.getRoomNumber());
        student.setRoom(room);
        studentRepository.save(student);
        room.getStudents().add(student);
        return student.getId();
    }

    @Override
    public List<StudentDTO> getStudents(SearchCriteria searchCriteria, Integer page, Integer size) {
        List<Student> students;
        if (page != null && size != null) {
            PageRequest request = new PageRequest(page, size, Sort.Direction.ASC, "firstName");
            students = studentRepository.findAll(new StudentSpecification(searchCriteria), request).getContent();
        } else {
            students = studentRepository.findAll(new StudentSpecification(searchCriteria));
        }
        return students.stream().map(this::profileToDto).collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentById(Long studentId) {
        return profileToDto(studentRepository.findOne(studentId));
    }

    private StudentDTO profileToDto(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setGender(student.getGender().name());
        studentDTO.setBirthDate(student.getBirthDate());
        studentDTO.setFaculty(student.getFaculty());
        studentDTO.setSpeciality(student.getSpeciality());
        studentDTO.setCourse(student.getCourse());
        studentDTO.setGroup(student.getGroup());
        studentDTO.setRoomNumber(student.getRoom().getRoomNumber());
        studentDTO.setImagePath(student.getImagePath());
        return studentDTO;
    }
}
