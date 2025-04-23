package com.rpatino12.lil.booting_course.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private UUID id;
    private String number;
    private String name;
    private String info;
}
