package com.rpatino12.lil.booting_course.web.controller;

import com.rpatino12.lil.booting_course.data.entity.RoomEntity;
import com.rpatino12.lil.booting_course.data.repository.RoomRepository;
import com.rpatino12.lil.booting_course.web.model.Room;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping
    public String getRoomsPage(Model model){
        List<RoomEntity> roomEntities = roomRepository.findAll();
        List<Room> rooms = new ArrayList<>(roomEntities.size());
        roomEntities.forEach(e -> rooms.add(new Room(e.getRoomId(), e.getNumber(), e.getName(), e.getBedInfo())));
        model.addAttribute("rooms", rooms);
        return "rooms";
    }
}
