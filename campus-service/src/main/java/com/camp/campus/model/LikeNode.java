package com.camp.campus.model;

import org.neo4j.ogm.annotation.GraphId;

public class LikeNode {

    @GraphId
    private Long graphId;

    private Long relationalId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LikeNode likeNode = (LikeNode) o;

        return relationalId != null ? relationalId.equals(likeNode.relationalId) : likeNode.relationalId == null;

    }

    @Override
    public int hashCode() {
        return relationalId != null ? relationalId.hashCode() : 0;
    }
}