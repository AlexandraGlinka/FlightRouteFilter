package com.gridnine.testing.service;

import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.entity.Segment;

import java.time.Duration;
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
    public List<Flight> filterSumTransferExceedsTwoHours(List<Flight> flights) {
        List<Flight> filteredFlightsTransferExceedsTwoHours = flights.stream()
                .filter(flight -> calculateSumTransferExceedsTwoHours(flight) <= 2)
                .collect(Collectors.toList());
        return filteredFlightsTransferExceedsTwoHours;
    }

    private static long calculateSumTransferExceedsTwoHours(Flight flight) {
        List<Segment> segments = flight.getSegments();
        long totalTransferTime = 0;
        for (int i = 1; i < segments.size(); i++) {
            LocalDateTime currentArrival = segments.get(i-1).getArrivalDate();
            LocalDateTime nextDeparture = segments.get(i).getDepartureDate();
            totalTransferTime += Duration.between(currentArrival, nextDeparture).toHours();
        }
        return totalTransferTime;
    }
}
