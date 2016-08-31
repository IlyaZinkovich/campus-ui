package com.camp.campus.service.impl;

import com.camp.campus.model.Like;
import com.camp.campus.repository.LikeRepository;
import com.camp.campus.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Override
    public boolean like(Like like) {
        boolean likeExists = likeRepository.isLikeExists(like);
        if (likeExists) return false;
        likeRepository.saveLike(like);
        Like reversedLike = new Like(like.getTo(), like.getFrom(), like.getLikeType());
        return likeRepository.isLikeExists(reversedLike);
    }
}
