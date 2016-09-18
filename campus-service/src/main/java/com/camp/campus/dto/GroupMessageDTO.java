package com.camp.campus.dto;

public class GroupMessageDTO {

    private Long id;

    private String message;

    private GroupDTO group;

    public GroupMessageDTO() {
    }

    public GroupMessageDTO(Long id, String message, GroupDTO group) {
        this.id = id;
        this.message = message;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public GroupDTO getGroup() {
        return group;
    }

    public void setGroup(GroupDTO group) {
        this.group = group;
    }
}
