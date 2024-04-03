package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Factory class to get sample list of flights.
 * Фабрика для получения тестового списка перелетов
 */
class FlightBuilder {
    static List<Flight> createFlights() {
        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
        return Arrays.asList(
                /**
                 * A normal flight with two hour duration
                 * Нормальный полет длительностью 2 ч
                 */
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2)),

                /**
                 * A normal multi segment flight
                 * Нормальный полет с одной пересадкой
                 */
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5)),

                /**
                 * A flight departing in the past
                 * Полет с датой вылета раньше текущего момента
                 */
                createFlight(threeDaysFromNow.minusDays(6), threeDaysFromNow),
                //TODO необходимо исключить из тестового набора

                /**
                 * A flight that departs before it arrives
                 * Полет, в котором дата вылета позже даты прибытия (неверный полет)
                 */
                createFlight(threeDaysFromNow, threeDaysFromNow.minusHours(6)),
                //TODO необходимо исключить из тестового набора

                /**
                 * A flight with more than two hours ground time
                 * Полет с пересадкой более чем 2 часа
                 */
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6)),
                //TODO необходимо исключить из тестового набора

                /**
                 * Another flight with more than two hours ground time
                 * Полет с пересадкой более чем 2 часа (несколько пересадок)
                 */
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4),
                        threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(7)));
                //TODO необходимо исключить из тестового набора полеты, где суммарное время на земле >2
    }

    private static Flight createFlight(final LocalDateTime... dates) {
        if ((dates.length % 2) != 0) {
            throw new IllegalArgumentException(
                    "you must pass an even number of dates");
        }
        List<Segment> segments = new ArrayList<>(dates.length / 2);
        for (int i = 0; i < (dates.length - 1); i += 2) {
            segments.add(new Segment(dates[i], dates[i + 1]));
        }
        return new Flight(segments);
    }
}