package com.example.roomservices.controller;

import com.example.roomservices.entity.Room;
import com.example.roomservices.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("rooms")
public class RoomController {

    private RoomRepository roomRepository;

    @GetMapping
    public List<Room> findAllRooms(@RequestParam(required = false) String roomNumber) {
        if (StringUtils.isNoneEmpty(roomNumber)) {
            return Collections.singletonList(roomRepository.findByRoomNumber(roomNumber));
        }
        return (List<Room>) roomRepository.findAll();
    }
}
