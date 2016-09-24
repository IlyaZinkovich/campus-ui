package com.camp.campus.repository.implementation;

import com.camp.campus.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;

@Repository
public class LikeRepositoryImpl implements LikeRepository {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${relationship-server.url}")
    private String relationshipServerUrl;

    @Override
    public List<Long> findStudentIdsWithMutualLike(Long studentId) {
        Long[] studentIdsArray = restTemplate.getForObject(relationshipServerUrl + "/v1/likes/students/" + studentId, Long[].class);
        return asList(studentIdsArray);
    }

    @Override
    public List<Long> findStudentIdsForMessageLikes(Long messageId) {
        Long[] studentIdsArray = restTemplate.getForObject(relationshipServerUrl + "/v1/likes/students?messageId=" + messageId, Long[].class);
        return asList(studentIdsArray);
    }
}
