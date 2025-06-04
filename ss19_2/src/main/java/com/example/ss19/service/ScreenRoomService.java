package com.example.ss19.service;


import com.example.ss19.entity.ScreenRoom;

import java.util.List;

public interface ScreenRoomService {
    List<ScreenRoom> findByStatus(Boolean status);
    ScreenRoom findById(Long id);
    void save(ScreenRoom screenRoom);
    void update(ScreenRoom screenRoom);
    void delete(Long id);
    void createSeatsForRoom(ScreenRoom screenRoom);
}
