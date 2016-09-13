package com.camp.campus.repository;


import com.camp.campus.dto.LikeDTO;
import com.camp.campus.model.Like;

import java.util.List;

public interface LikeRepository {

    void saveLike(Like like);

    List<Long> findStudentIdsWithMutualLike(Long studentId);

    boolean checkIfLikeExists(Like like);
}
