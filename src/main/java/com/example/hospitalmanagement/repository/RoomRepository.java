package com.example.hospitalmanagement.repository;

import com.example.hospitalmanagement.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {

}