package com.example.ss9.DAO;



import com.example.ss9.model.Seat;

import java.util.List;

public interface SeatDAO {
    List<Seat> getSeatsByScreenRoom(Long screenRoomId);
    List<Long> getBookedSeatsBySchedule(Long scheduleId);
}

