package com.camp.campus.service;

import com.camp.campus.dto.LikeDTO;

import java.util.List;

public interface LikeService {

    void saveLike(LikeDTO like);

    List<Long> findStudentIdsWithMutualLike(Long studentId);
}
