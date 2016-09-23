package com.camp.campus.service.impl;

import com.camp.campus.repository.LikeRepository;
import com.camp.campus.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Override
    public List<Long> findStudentIdsWithMutualLike(Long studentId) {
        return likeRepository.findStudentIdsWithMutualLike(studentId);
    }
}
