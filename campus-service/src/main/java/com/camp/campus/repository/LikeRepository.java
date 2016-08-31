package com.camp.campus.repository;


import com.camp.campus.model.Like;

public interface LikeRepository {

    boolean isLikeExists(Like like);
    void saveLike(Like like);
}
