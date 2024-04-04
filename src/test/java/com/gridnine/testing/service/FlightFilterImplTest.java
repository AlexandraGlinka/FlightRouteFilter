package com.gridnine.testing.service;

import com.gridnine.testing.FlightFilterImpl;
import com.gridnine.testing.InitFlightData;
import com.gridnine.testing.entity.Flight;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static com.gridnine.testing.InitFlightData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightFilterImplTest {

    private final FlightFilterImpl flightFilter;

    public FlightFilterImplTest() {
        this.flightFilter = new FlightFilterImpl();
    }

    /**
     * Правило исключения 1: Вылет до текущего момента времени.
     */
    @Test
    public void filterBeforeNowTest() {
        List<Flight> filteredFlightsBeforeNow = flightFilter.filterBeforeNow(allFlights);
        List<Flight> expectedFlights = allFlights.stream()
                .filter(flight -> flight != flightDepartingInThePast1 && flight != flightDepartingInThePast2)
                .collect(Collectors.toList());

        assertEquals(expectedFlights, filteredFlightsBeforeNow);
    }

    /**
     * Правило исключения 2: Сегменты с датой прилёта раньше даты вылета.
     */
    @Test
    public void filterArrivalBeforeDepartureTest() {
        List<Flight> filteredFlightsArrivalBeforeDepart = flightFilter.filterArrivalBeforeDeparture(allFlights);
        List<Flight> expectedFlights = allFlights.stream()
                .filter(flight -> flight != flightDepartsBeforeThanArrives1 && flight != flightDepartsBeforeThanArrives2)
                .collect(Collectors.toList());

        assertEquals(expectedFlights, filteredFlightsArrivalBeforeDepart);
    }

    /**
     * Правило исключения 3: Перелеты, где общее время, проведённое на земле, превышает два часа.
     */
    @Test
    public void filterTotalTransferExceedsTwoHoursTest() {
        List<Flight> filteredFlightsTransferExceedsTwoHours = flightFilter.filterTotalTransferExceedsTwoHours(allFlights);
        List<Flight> expectedFlights = allFlights.stream()
                .filter(flight -> flight != flightMoreThanTwoHoursGroundTime && flight != anotherFlightMoreThanTwoHoursGroundTime)
                .collect(Collectors.toList());

        assertEquals(expectedFlights, filteredFlightsTransferExceedsTwoHours);
    }

}
