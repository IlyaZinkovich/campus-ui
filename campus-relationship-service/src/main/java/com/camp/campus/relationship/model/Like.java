package com.camp.campus.relationship.model;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "LIKES")
public class Like {

    public enum LikeType {
        STUDENT, ROOM
    }

    @GraphId
    private Long relationshipId;
    @StartNode
    private LikeNode from;
    @EndNode
    private LikeNode to;
    @Property
    private LikeType likeType;

    public Like() {
    }

    public Like(Long from, Long to, LikeType likeType) {
        this.from = new LikeNode(from);
        this.to = new LikeNode(to);
        this.likeType = likeType;
    }

    public LikeNode getFrom() {
        return from;
    }

    public void setFrom(LikeNode from) {
        this.from = from;
    }

    public LikeNode getTo() {
        return to;
    }

    public void setTo(LikeNode to) {
        this.to = to;
    }

    public LikeType getLikeType() {
        return likeType;
    }

    public void setLikeType(LikeType likeType) {
        this.likeType = likeType;
    }

    public Long getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(Long relationshipId) {
        this.relationshipId = relationshipId;
    }
}
