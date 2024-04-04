package com.gridnine.testing;

import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.testingData.FlightBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilter unfilteredFlights = new FlightFilterImpl();

        System.out.println("Правило исключения 1: Вылет до текущего момента времени.");
        unfilteredFlights.filterBeforeNow(flights).forEach(System.out::println);
        System.out.println(separator());

        System.out.println("Правило исключения 2: Сегменты с датой прилёта раньше даты вылета.");
        unfilteredFlights.filterArrivalBeforeDeparture(flights).forEach(System.out::println);
        System.out.println(separator());

        System.out.println("Правило исключения 3: Перелеты, где общее время, проведённое на земле, превышает два часа.");
        unfilteredFlights.filterTotalTransferExceedsTwoHours(flights).forEach(System.out::println);
        System.out.println(separator());
    }

    private static String separator() {
        return "---------------------";
    }
}