package com.camp.campus.relationship.dto;

public class LikeDTO {

    private Long from;
    private Long to;
    private String type;

    public LikeDTO() {
    }

    public LikeDTO(Long from, Long to, String type) {
        this.from = from;
        this.to = to;
        this.type = type;
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
