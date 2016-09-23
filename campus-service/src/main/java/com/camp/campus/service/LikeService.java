package com.camp.campus.service;

import java.util.List;

public interface LikeService {

    List<Long> findStudentIdsWithMutualLike(Long studentId);
}
