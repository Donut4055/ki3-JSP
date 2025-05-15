package com.example.ss9.DAO;


public interface TicketDAO {
    void bookTicket(Long customerId, Long scheduleId, Long seatId, Double price);
}

