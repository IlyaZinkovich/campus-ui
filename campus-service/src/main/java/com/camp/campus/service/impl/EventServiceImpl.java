package com.camp.campus.service.impl;

import com.camp.campus.dto.EventDTO;
import com.camp.campus.dto.LikeEventDTO;
import com.camp.campus.model.Event;
import com.camp.campus.model.Student;
import com.camp.campus.repository.EventRepository;
import com.camp.campus.repository.StudentRepository;
import com.camp.campus.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<EventDTO> findByStudentId(Long studentId) {
        return eventRepository.findByStudentId(studentId).stream().map(this::eventToDto).collect(Collectors.toList());
    }

    @Override
    public void saveLikeEvent(LikeEventDTO likeEvent) {
        Student student = studentRepository.findOne(likeEvent.getProfileId());
        Student likeStudent = studentRepository.findOne(likeEvent.getLikeProfileId());
        Event event = getEvent(student, likeStudent);
        eventRepository.save(event);
        event = getEvent(likeStudent, student);
        eventRepository.save(event);
    }

    private Event getEvent(Student student, Student likeStudent) {
        String title = "Like";
        String body = likeStudent.getFirstName() + " " + likeStudent.getLastName() + " likes you";
        return new Event(title, body, student);
    }

    private EventDTO eventToDto(Event event) {
        return new EventDTO(event.getId(), event.getTitle(), event.getBody(), event.getStudent().getId());
    }

}
