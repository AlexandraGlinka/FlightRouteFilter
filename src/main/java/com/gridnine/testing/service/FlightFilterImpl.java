package com.gridnine.testing.service;

import com.gridnine.testing.entity.Flight;

import java.util.List;

public class FlightFilterImpl implements FlightFilter {

    @Override
    public List<Flight> filterBeforeNow() {
        return null;
    }

    @Override
    public List<Flight> filterArrivalBeforeDeparture() {
        return null;
    }

    @Override
    public List<Flight> filterSumTransferExceedsTwoHours() {
        return null;
    }
}
