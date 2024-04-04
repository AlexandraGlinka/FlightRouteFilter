package com.gridnine.testing.service;

import com.gridnine.testing.entity.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FlightFilterImpl implements FlightFilter {

    @Override
    public List<Flight> filterBeforeNow(List<Flight> flights) {
        List<Flight> filteredFlightsBeforeNow = flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate().isAfter(LocalDateTime.now())))
                .collect(Collectors.toList());
        return filteredFlightsBeforeNow;
    }

    @Override
    public List<Flight> filterArrivalBeforeDeparture(List<Flight> flights) {
        List<Flight> filteredFlightsArrivalBeforeDepart = flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate().isBefore(segment.getArrivalDate())))
                .collect(Collectors.toList());
        return filteredFlightsArrivalBeforeDepart;
    }

    @Override
    public List<Flight> filterSumTransferExceedsTwoHours() {
        return null;
    }
}
