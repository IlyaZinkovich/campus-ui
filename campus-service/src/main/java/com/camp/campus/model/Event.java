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
    @JoinColumn(name = "PROFILE_ID")
    private Profile profile;

    public Event() {
    }

    public Event(String title, String body, Profile profile) {
        this.title = title;
        this.body = body;
        this.profile = profile;
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (title != null ? !title.equals(event.title) : event.title != null) return false;
        return profile != null ? profile.equals(event.profile) : event.profile == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (profile != null ? profile.hashCode() : 0);
        return result;
    }
}
