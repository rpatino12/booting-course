package com.rpatino12.lil.booting_course.service;

import com.rpatino12.lil.booting_course.data.entity.RoomEntity;
import com.rpatino12.lil.booting_course.data.repository.RoomRepository;
import com.rpatino12.lil.booting_course.web.model.Room;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms(){
        List<RoomEntity> roomEntities = roomRepository.findAll();
        List<Room> rooms = new ArrayList<>(roomEntities.size());
        roomEntities.forEach(e -> rooms.add(entityToRoom(e)));
        return rooms;
    }

    public Room getRoomById(UUID id){
        Optional<RoomEntity> entity = roomRepository.findById(id);
        if (entity.isEmpty()){
            return null;
        } else {
            return entityToRoom(entity.get());
        }
    }

    public Room addRoom(Room room){
        RoomEntity entity = roomToEntity(room);
        entity = roomRepository.save(entity);
        return entityToRoom(entity);
    }

    public Room updateRoom(UUID id, Room newRoom){
        Room room = getRoomById(id);
        if (room != null) {
            RoomEntity entity = roomToEntity(newRoom);
            entity = roomRepository.save(entity);
            return entityToRoom(entity);
        } else {
            return null;
        }
    }

    public void deleteRoom(UUID id){
        this.roomRepository.deleteById(id);
    }

    private Room entityToRoom(RoomEntity entity){
        return new Room(entity.getRoomId(), entity.getNumber(), entity.getName(), entity.getBedInfo());
    }

    private RoomEntity roomToEntity(Room room){
        RoomEntity entity = new RoomEntity();
        entity.setRoomId(room.getId());
        entity.setNumber(room.getNumber());
        entity.setName(room.getName());
        entity.setBedInfo(room.getInfo());
        return entity;
    }
}
