package com.example.ss16.service;

import com.example.ss16.model.BusTrip;

import java.util.List;

public interface BusTripService {
    void addBusTrip(BusTrip trip);
    List<BusTrip> findAll();
    BusTrip findById(Integer id);
    void updateBusTrip(BusTrip trip);
    void deleteBusTrip(Integer id);
}

