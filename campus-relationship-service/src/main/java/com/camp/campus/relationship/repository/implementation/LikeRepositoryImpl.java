package com.camp.campus.relationship.repository.implementation;

import com.camp.campus.relationship.model.Like;
import com.camp.campus.relationship.model.LikeNode;
import com.camp.campus.relationship.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class LikeRepositoryImpl implements LikeRepository {

    @Autowired
    private Neo4jOperations neo4jTemplate;

    @Override
    public boolean saveLikeOrRemoveIfExists(Like like) {
        if (checkIfLikeExists(like)){
            neo4jTemplate.delete(like);
            return false;
        }
        LikeNode from = findLikeNode(like.getFrom());
        if (from != null) like.setFrom(from);
        LikeNode to = findLikeNode(like.getTo());
        if (to != null) like.setTo(to);
        neo4jTemplate.save(like);
        return true;
    }

    @Override
    public List<Long> findStudentIdsWithMutualLike(Long studentId) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("relationalId", studentId);
        parameters.put("likeNodeType", LikeNode.LikeNodeType.STUDENT);
        return ((List<LikeNode>) neo4jTemplate.queryForObjects(LikeNode.class,
                "MATCH (a {likeNodeType: {likeNodeType}, relationalId: {relationalId}})" +
                        "-[:LIKES]->(b {likeNodeType: {likeNodeType}})" +
                        "-[:LIKES]->(a {likeNodeType: {likeNodeType}}) RETURN b",
                parameters)).stream().map(LikeNode::getRelationalId).collect(Collectors.toList());
    }

    @Override
    public boolean checkIfLikeExists(Like like) {
        Iterator<Like> iterator = getLikesIfExist(like).iterator();
        if (iterator.hasNext()){
            like.setRelationshipId(iterator.next().getRelationshipId());
            return true;
        }
        return false;
    }

    @Override
    public List<Long> findStudentIdsForMessageLikes(Long messageId) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("messageId", messageId);
        parameters.put("fromLikeNodeType", LikeNode.LikeNodeType.STUDENT);
        parameters.put("toLikeNodeType", LikeNode.LikeNodeType.MESSAGE);
        return (List<Long>) neo4jTemplate.queryForObjects(Long.class,
                "MATCH (from {likeNodeType: {fromLikeNodeType}})" +
                        "-[likes:LIKES]->(to {likeNodeType: {toLikeNodeType}, relationalId:{messageId}}) " +
                        "RETURN from.relationalId", parameters);
    }

    private Iterable<Like> getLikesIfExist(Like like) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("from", like.getFrom().getRelationalId());
        parameters.put("to", like.getTo().getRelationalId());
        parameters.put("fromLikeNodeType", like.getFrom().getLikeNodeType());
        parameters.put("toLikeNodeType", like.getTo().getLikeNodeType());
        return neo4jTemplate.queryForObjects(Like.class,
                "MATCH (from {likeNodeType: {fromLikeNodeType}, relationalId:{from}})" +
                        "-[likes:LIKES]->(to {likeNodeType: {toLikeNodeType}, relationalId:{to}}) " +
                        "RETURN likes", parameters);
    }

    private LikeNode findLikeNode(LikeNode likeNode) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("relationalId", likeNode.getRelationalId());
        parameters.put("likeNodeType", likeNode.getLikeNodeType());
        return neo4jTemplate.queryForObject(LikeNode.class,
                "MATCH (node {likeNodeType: {likeNodeType}, relationalId:{relationalId}}) RETURN node", parameters);
    }
}
