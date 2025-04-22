package com.rpatino12.lil.booting_course.data.repository;

import com.rpatino12.lil.booting_course.data.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, UUID> {
}
