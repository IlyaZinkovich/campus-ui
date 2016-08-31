package com.camp.campus.model;

public class Like {

    public enum LikeType {
        PROFILE, ROOM
    }

    private Long from;
    private Long to;
    private LikeType likeType;

    public Like() {
    }

    public Like(Long from, Long to, LikeType likeType) {
        this.from = from;
        this.to = to;
        this.likeType = likeType;
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

    public LikeType getLikeType() {
        return likeType;
    }

    public void setLikeType(LikeType likeType) {
        this.likeType = likeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Like like = (Like) o;

        if (from != null ? !from.equals(like.from) : like.from != null) return false;
        if (to != null ? !to.equals(like.to) : like.to != null) return false;
        return likeType == like.likeType;

    }

    @Override
    public int hashCode() {
        int result = from != null ? from.hashCode() : 0;
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + (likeType != null ? likeType.hashCode() : 0);
        return result;
    }
}
