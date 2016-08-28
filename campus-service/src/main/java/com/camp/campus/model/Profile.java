package com.camp.campus.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PROFILES")
public class Profile {

    public enum Gender {
        MALE, FEMALE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROFILE_SEQ")
    @SequenceGenerator(name = "PROFILE_SEQ", sequenceName = "PROFILE_SEQ", allocationSize = 1)
    private Long id;

    private String firstName;

    private String lastName;

    private Gender gender;

    private LocalDate birthDate;

    private String faculty;

    private String speciality;

    private Integer course;

    @Column(name = "GROUP_NUMBER")
    private Integer group;

    private String imagePath;

    @ManyToOne(optional = false)
    private Room room;

    public Profile() {
    }

    public Profile(Long id, String firstName, String lastName, Gender gender, LocalDate birthDate, String faculty, String speciality, Integer course, Integer group, String imagePath) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.faculty = faculty;
        this.speciality = speciality;
        this.course = course;
        this.group = group;
        this.imagePath = imagePath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public static class ProfileBuilder {

        private Long id;
        private String firstName;
        private String lastName;
        private Gender gender;
        private LocalDate birthDate;
        private String faculty;
        private String speciality;
        private Integer course;
        private Integer group;
        private String imagePath;

        public ProfileBuilder() {

        }

        public ProfileBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ProfileBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public ProfileBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ProfileBuilder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public ProfileBuilder birthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public ProfileBuilder faculty(String faculty) {
            this.faculty = faculty;
            return this;
        }

        public ProfileBuilder speciality(String speciality) {
            this.speciality = speciality;
            return this;
        }

        public ProfileBuilder course(Integer course) {
            this.course = course;
            return this;
        }

        public ProfileBuilder group(Integer group) {
            this.group = group;
            return this;
        }

        public ProfileBuilder imagePath(String imagePath) {
            this.imagePath = imagePath;
            return this;
        }

        public Profile build() {
            return new Profile(id, firstName, lastName, gender, birthDate,
                    faculty, speciality, course, group, imagePath);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Profile profile = (Profile) o;

        if (firstName != null ? !firstName.equals(profile.firstName) : profile.firstName != null) return false;
        if (lastName != null ? !lastName.equals(profile.lastName) : profile.lastName != null) return false;
        if (gender != profile.gender) return false;
        if (birthDate != null ? !birthDate.equals(profile.birthDate) : profile.birthDate != null) return false;
        if (faculty != null ? !faculty.equals(profile.faculty) : profile.faculty != null) return false;
        if (speciality != null ? !speciality.equals(profile.speciality) : profile.speciality != null) return false;
        if (course != null ? !course.equals(profile.course) : profile.course != null) return false;
        return group != null ? group.equals(profile.group) : profile.group == null;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (faculty != null ? faculty.hashCode() : 0);
        result = 31 * result + (speciality != null ? speciality.hashCode() : 0);
        result = 31 * result + (course != null ? course.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        return result;
    }
}
