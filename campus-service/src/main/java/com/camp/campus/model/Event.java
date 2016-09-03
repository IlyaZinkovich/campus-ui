package com.camp.campus.model;

import javax.persistence.*;

@Entity
@Table(name = "EVENTS")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVENT_SEQ")
    @SequenceGenerator(name = "EVENT_SEQ", sequenceName = "EVENT_SEQ", allocationSize = 1)
    private Long id;

    private String title;

    private String body;

    @OneToOne(optional = false)
    @JoinColumn(name = "STUDENT_ID")
    private Student student;

    public Event() {
    }

    public Event(String title, String body, Student student) {
        this.title = title;
        this.body = body;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (title != null ? !title.equals(event.title) : event.title != null) return false;
        return student != null ? student.equals(event.student) : event.student == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (student != null ? student.hashCode() : 0);
        return result;
    }
}
