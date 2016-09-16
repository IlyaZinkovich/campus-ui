package com.camp.campus.relationship.repository;

import com.camp.campus.relationship.model.Like;

import java.util.List;

public interface LikeRepository {

    boolean saveLikeOrRemoveIfExists(Like like);

    List<Long> findStudentIdsWithMutualLike(Long studentId);

    boolean checkIfLikeExists(Like like);
}
