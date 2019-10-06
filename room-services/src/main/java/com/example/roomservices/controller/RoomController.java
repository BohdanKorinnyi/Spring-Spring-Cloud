package com.example.roomservices.controller;

import com.example.roomservices.entity.Room;
import com.example.roomservices.repository.RoomRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("rooms")
@Api(tags = {"rooms"})
@SwaggerDefinition(tags = {@Tag(name = "rooms", description = "Data service operations on rooms")})
public class RoomController {

    private RoomRepository roomRepository;

    @GetMapping
    @ApiOperation(value = "Get All Rooms", notes = "Gets all rooms in the system", nickname = "getRooms")
    public List<Room> findAllRooms(@RequestParam(required = false) String roomNumber) {
        if (StringUtils.isNoneEmpty(roomNumber)) {
            return Collections.singletonList(roomRepository.findByRoomNumber(roomNumber));
        }
        return (List<Room>) roomRepository.findAll();
    }
}
