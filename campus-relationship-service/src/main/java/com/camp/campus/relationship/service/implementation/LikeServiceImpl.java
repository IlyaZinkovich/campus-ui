package com.camp.campus.relationship.service.implementation;

import com.camp.campus.relationship.dto.LikeDTO;
import com.camp.campus.relationship.model.Like;
import com.camp.campus.relationship.repository.LikeRepository;
import com.camp.campus.relationship.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Override
    public boolean saveLikeOrRemoveIfExists(LikeDTO like) {
        return likeRepository.saveLikeOrRemoveIfExists(new Like(like.getFrom(), like.getTo(), Like.LikeType.valueOf(like.getType())));
    }

    @Override
    public List<Long> findStudentIdsWithMutualLike(Long studentId) {
        return likeRepository.findStudentIdsWithMutualLike(studentId);
    }

    @Override
    public boolean checkIfLikeExists(Long from, Long to, String type) {
        return likeRepository.checkIfLikeExists(new Like(from, to, Like.LikeType.valueOf(type)));
    }
}
