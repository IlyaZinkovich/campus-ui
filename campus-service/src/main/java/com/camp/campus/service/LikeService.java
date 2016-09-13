package com.camp.campus.service;

import com.camp.campus.dto.LikeDTO;

import java.util.List;

public interface LikeService {

    boolean saveLikeOrRemoveIfExists(LikeDTO like);

    List<Long> findStudentIdsWithMutualLike(Long studentId);

    boolean checkIfLikeExists(Long from, Long to, String type);
}
