package com.example.ss9.service;


import com.example.ss9.DAO.ScreenRoomDAO;
import com.example.ss9.model.ScreenRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenRoomServiceImpl implements ScreenRoomService {

    @Autowired
    private ScreenRoomDAO screenRoomDAO;

    @Override
    public List<ScreenRoom> getAllScreenRooms() {
        return screenRoomDAO.getAllScreenRooms();
    }
}
