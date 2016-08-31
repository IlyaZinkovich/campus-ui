package com.camp.campus.dto;

public class EventDTO {

    private Long id;

    private String title;

    private String body;

    private Long profileId;

    public EventDTO() {
    }

    public EventDTO(String title, String body, Long profileId) {
        this.title = title;
        this.body = body;
        this.profileId = profileId;
    }

    public EventDTO(Long id, String title, String body, Long profileId) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.profileId = profileId;
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

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventDTO eventDTO = (EventDTO) o;

        if (id != null ? !id.equals(eventDTO.id) : eventDTO.id != null) return false;
        if (title != null ? !title.equals(eventDTO.title) : eventDTO.title != null) return false;
        if (body != null ? !body.equals(eventDTO.body) : eventDTO.body != null) return false;
        return profileId != null ? profileId.equals(eventDTO.profileId) : eventDTO.profileId == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (profileId != null ? profileId.hashCode() : 0);
        return result;
    }
}
