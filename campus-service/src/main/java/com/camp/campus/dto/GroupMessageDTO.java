package com.camp.campus.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupMessageDTO {

    private Long id;

    private String message;

    private LocalDateTime postTime;

    private GroupDTO group;

    public GroupMessageDTO() {
    }

    public GroupMessageDTO(Long id, String message, LocalDateTime postTime) {
        this.id = id;
        this.message = message;
        this.postTime = postTime;
    }

    public GroupMessageDTO(Long id, String message, GroupDTO group, LocalDateTime postTime) {
        this.id = id;
        this.message = message;
        this.group = group;
        this.postTime = postTime;
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

    public LocalDateTime getPostTime() {
        return postTime;
    }

    public void setPostTime(LocalDateTime postTime) {
        this.postTime = postTime;
    }
}
