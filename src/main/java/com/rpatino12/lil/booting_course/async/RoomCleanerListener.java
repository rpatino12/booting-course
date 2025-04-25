package com.rpatino12.lil.booting_course.async;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rpatino12.lil.booting_course.service.RoomService;
import com.rpatino12.lil.booting_course.web.model.Room;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RoomCleanerListener {
    private final ObjectMapper mapper;
    private final RoomService roomService;

    public RoomCleanerListener(ObjectMapper mapper, RoomService roomService) {
        this.mapper = mapper;
        this.roomService = roomService;
    }

    public void receiveMessage(String message){
        try {
            AsyncPayload payload = mapper.readValue(message, AsyncPayload.class);
            if ("ROOM".equals(payload.getModel())){
                Room room = roomService.getRoomById(payload.getId());
                log.info("ROOM {}:{} needs to be cleaned", room.getNumber(), room.getName());
            } else {
                log.warn("Unknown model type");
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
