package com.camp.campus.relationship.service;

import com.camp.campus.relationship.dto.LikeDTO;

import java.util.List;

public interface LikeService {

    boolean saveLikeOrRemoveIfExists(LikeDTO like);

    List<Long> findStudentIdsWithMutualLike(Long studentId);

    boolean checkIfLikeExists(LikeDTO likeDTO);

    List<Long> findStudentIdsForMessageLikes(Long messageId);
}
