package com.camp.campus.repository;

import com.camp.campus.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomsRepository extends JpaRepository<Room, Long> {

    Room findByRoomNumber(String roomNumber);
}
