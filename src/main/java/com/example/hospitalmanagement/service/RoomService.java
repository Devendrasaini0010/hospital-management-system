
package com.example.hospitalmanagement.service;

import com.example.hospitalmanagement.entity.Room;
import com.example.hospitalmanagement.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    // Save Room
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    // Get All Rooms
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    // Get Room By ID
    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    // Delete Room
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    // Update Room
    public Room updateRoom(Long id, Room room) {

        Room existingRoom = roomRepository.findById(id).orElse(null);

        if (existingRoom != null) {
            existingRoom.setRoomNumber(room.getRoomNumber());
            existingRoom.setRoomType(room.getRoomType());
            existingRoom.setAvailable(room.isAvailable());

            return roomRepository.save(existingRoom);
        }

        return null;
    }
}