package com.camp.campus.repository;


import java.util.List;

public interface LikeRepository {

    List<Long> findStudentIdsWithMutualLike(Long studentId);

    List<Long> findStudentIdsForMessageLikes(Long messageId);
}
