package com.camp.campus.repository.implementation;

import com.camp.campus.model.Like;
import com.camp.campus.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class LikeRepositoryImpl implements LikeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean isLikeExists(Like like) {
        String query = "select count(*) from Likes where like_from = ? and like_to = ? and like_type = ?";
        Integer counter = jdbcTemplate.queryForObject(
                query, Integer.class, like.getFrom(), like.getTo(), like.getLikeType().ordinal());
        return counter != null && counter > 0;
    }

    @Override
    public void saveLike(Like like) {
        String query = "insert into Likes (like_from, like_to, like_type) values (?, ?, ?)";
        jdbcTemplate.update(query, like.getFrom(), like.getTo(), like.getLikeType().ordinal());
    }
}
