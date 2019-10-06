package com.example.roomservices.repository;

import com.example.roomservices.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    Room findByRoomNumber(String roomNumber);
}
