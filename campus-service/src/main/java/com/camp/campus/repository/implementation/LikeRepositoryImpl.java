package com.camp.campus.repository.implementation;

import com.camp.campus.model.Like;
import com.camp.campus.model.LikeNode;
import com.camp.campus.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class LikeRepositoryImpl implements LikeRepository {

    @Autowired
    private Neo4jOperations neo4jTemplate;

    @Override
    public void saveLike(Like like) {
        if (checkIfLikeExists(like)) return;
        LikeNode from = findLikeNode(like.getFrom());
        if (from != null) like.setFrom(from);
        LikeNode to = findLikeNode(like.getTo());
        if (to != null) like.setTo(to);
        neo4jTemplate.save(like);
    }

    @Override
    public List<Long> findStudentIdsWithMutualLike(Long studentId) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("relationalId", studentId);
        return ((List<LikeNode>) neo4jTemplate.queryForObjects(LikeNode.class,
                "MATCH (a {relationalId: {relationalId}})-[:LIKES]->(b)-[:LIKES]->(a) RETURN b",
                parameters)).stream().map(LikeNode::getRelationalId).collect(Collectors.toList());
    }

    @Override
    public boolean checkIfLikeExists(Like like) {
        return getLikesIfExist(like).iterator().hasNext();
    }

    private Iterable<Like> getLikesIfExist(Like like) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("from", like.getFrom().getRelationalId());
        parameters.put("to", like.getTo().getRelationalId());
        return neo4jTemplate.queryForObjects(Like.class,
                "MATCH (from {relationalId:{from}})-[likes:LIKES]->(to {relationalId:{to}}) RETURN likes", parameters);
    }

    private LikeNode findLikeNode(LikeNode likeNode) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("relationalId", likeNode.getRelationalId());
        return neo4jTemplate.queryForObject(LikeNode.class, "MATCH (node {relationalId:{relationalId}}) RETURN node", parameters);
    }
}
