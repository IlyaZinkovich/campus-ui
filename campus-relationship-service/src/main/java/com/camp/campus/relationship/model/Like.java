package com.camp.campus.relationship.model;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "LIKES")
public class Like {

    @GraphId
    private Long relationshipId;
    @StartNode
    private LikeNode from;
    @EndNode
    private LikeNode to;
    @Property
    private String timestamp;

    public Like() {
    }

    public Like(Long from, Long to) {
        this.from = new LikeNode(from);
        this.to = new LikeNode(to);
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

    public Long getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(Long relationshipId) {
        this.relationshipId = relationshipId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
