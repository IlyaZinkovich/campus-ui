package com.camp.campus.relationship.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class LikeNode {

    @GraphId
    private Long graphId;

    private Long relationalId;

    private LikeNodeType likeNodeType;

    public enum LikeNodeType {
        STUDENT, MESSAGE
    }

    public LikeNode() {
    }

    public LikeNode(Long relationalId) {
        this.relationalId = relationalId;
    }

    public Long getGraphId() {
        return graphId;
    }

    public void setGraphId(Long graphId) {
        this.graphId = graphId;
    }

    public Long getRelationalId() {
        return relationalId;
    }

    public void setRelationalId(Long relationalId) {
        this.relationalId = relationalId;
    }

    public LikeNodeType getLikeNodeType() {
        return likeNodeType;
    }

    public void setLikeNodeType(LikeNodeType likeNodeType) {
        this.likeNodeType = likeNodeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LikeNode likeNode = (LikeNode) o;

        if (relationalId != null ? !relationalId.equals(likeNode.relationalId) : likeNode.relationalId != null)
            return false;
        return likeNodeType == likeNode.likeNodeType;

    }

    @Override
    public int hashCode() {
        int result = relationalId != null ? relationalId.hashCode() : 0;
        result = 31 * result + (likeNodeType != null ? likeNodeType.hashCode() : 0);
        return result;
    }
}