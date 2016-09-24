package com.camp.campus.relationship.service.implementation;

import com.camp.campus.relationship.dto.LikeDTO;
import com.camp.campus.relationship.model.Like;
import com.camp.campus.relationship.model.LikeNode;
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
    public boolean saveLikeOrRemoveIfExists(LikeDTO likeDTO) {
        Like like = likeDtoToLike(likeDTO);
        return likeRepository.saveLikeOrRemoveIfExists(like);
    }
    @Override
    public List<Long> findStudentIdsWithMutualLike(Long studentId) {
        return likeRepository.findStudentIdsWithMutualLike(studentId);
    }

    @Override
    public boolean checkIfLikeExists(LikeDTO likeDTO) {
        return likeRepository.checkIfLikeExists(likeDtoToLike(likeDTO));
    }

    private Like likeDtoToLike(LikeDTO likeDTO) {
        Like like = new Like(likeDTO.getFrom(), likeDTO.getTo());
        like.getFrom().setLikeNodeType(LikeNode.LikeNodeType.STUDENT);
        if (LikeDTO.LikeType.STUDENT_TO_STUDENT.equals(likeDTO.getType())) {
            like.getTo().setLikeNodeType(LikeNode.LikeNodeType.STUDENT);
        } else if (LikeDTO.LikeType.STUDENT_TO_MESSAGE.equals(likeDTO.getType())) {
            like.getTo().setLikeNodeType(LikeNode.LikeNodeType.MESSAGE);
        }
        return like;
    }
}
