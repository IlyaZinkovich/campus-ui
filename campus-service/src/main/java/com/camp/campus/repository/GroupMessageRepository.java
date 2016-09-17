package com.camp.campus.repository;

import com.camp.campus.model.GroupMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupMessageRepository extends JpaRepository<GroupMessage, Long> {

    @Query("select gm from GroupMessage gm where gm.group.id in :groupIds")
    List<GroupMessage> getGroupsMessages(@Param("groupIds") List<Long> groupIds);
}
