package com.gridnine.testing;

import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.entity.Segment;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Создаем тестовый набор данных
 * normalFlightsWithTwoHourDuration нормальный полет длительностью 2ч
 * normalMultiSegmentFlights нормальный полет с одной пересадкой
 * flightsDepartingInThePast полет с вылетом в прошлом
 * flightsDepartsBeforeThanArrives полеты с временем вылета до времени прибытия
 * flightsMoreThanTwoHoursGroundTime полет с пересадкой более чем 2 часа
 * allFlights все полеты
 */
public class InitFlightData {
    private static final LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
    public static final Flight normalFlightWithTwoHourDuration1 = new Flight(List.of(
            new Segment(threeDaysFromNow.plusHours(2), threeDaysFromNow.plusHours(4))));
    public static final Flight normalFlightWithTwoHourDuration2 = new Flight(List.of(
            new Segment(threeDaysFromNow.plusDays(2), threeDaysFromNow.plusDays(4).plusHours(2))));
    public static final Flight normalMultiSegmentFlight = new Flight(List.of(
            new Segment(threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4)),
            new Segment(threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(7))));
    public static final Flight flightDepartingInThePast1 = new Flight(List.of(
            new Segment(threeDaysFromNow.minusDays(6), threeDaysFromNow.minusDays(6).plusHours(3))));
    public static final Flight flightDepartingInThePast2 = new Flight(List.of(
            new Segment(threeDaysFromNow.minusDays(4), threeDaysFromNow.plusHours(2))));
    public static final Flight flightDepartsBeforeThanArrives1 = new Flight(List.of(
            new Segment(threeDaysFromNow, threeDaysFromNow.minusHours(2))));
    public static final Flight flightDepartsBeforeThanArrives2 = new Flight(List.of(
            new Segment(threeDaysFromNow.plusHours(2), threeDaysFromNow.minusHours(6))));
    public static final Flight flightMoreThanTwoHoursGroundTime = new Flight(List.of(
            new Segment(threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4)),
            new Segment(threeDaysFromNow.plusHours(7), threeDaysFromNow.plusHours(12))));
    public static final Flight anotherFlightMoreThanTwoHoursGroundTime = new Flight(List.of(
            new Segment(threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4)),
            new Segment(threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6)),
            new Segment(threeDaysFromNow.plusHours(10), threeDaysFromNow.plusHours(12))));

    public static final List<Flight> allFlights = Arrays.asList(
            normalFlightWithTwoHourDuration1, normalFlightWithTwoHourDuration2,
            normalMultiSegmentFlight,
            flightDepartingInThePast1, flightDepartingInThePast2,
            flightDepartsBeforeThanArrives1, flightDepartsBeforeThanArrives2,
            flightMoreThanTwoHoursGroundTime,
            anotherFlightMoreThanTwoHoursGroundTime);
}
