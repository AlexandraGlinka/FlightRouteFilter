package com.gridnine.testing.service;

import com.gridnine.testing.entity.Flight;

import java.util.List;

public interface FlightFilter {
    List<Flight> filterBeforeNow(List<Flight> flights);
    List<Flight> filterArrivalBeforeDeparture(List<Flight> flights);
    List<Flight> filterSumTransferExceedsTwoHours(List<Flight> flights);
}
