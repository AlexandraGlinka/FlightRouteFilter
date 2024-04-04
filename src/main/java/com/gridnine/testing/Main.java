package com.gridnine.testing;

import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.service.FlightFilter;
import com.gridnine.testing.service.FlightFilterImpl;
import com.gridnine.testing.testingData.FlightBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        System.out.println("Тестовые данные:");
        flights.forEach(System.out::println);
        System.out.println(separator());

        System.out.println("Правило исключения 1: Вылет до текущего момента времени.");
        List<Flight> filteredFlightsBeforeNow = new FlightFilterImpl().filterBeforeNow(flights);
        filteredFlightsBeforeNow.forEach(System.out::println);
        System.out.println(separator());

        System.out.println("Правило исключения 2: Сегменты с датой прилёта раньше даты вылета.");
        List<Flight> filteredFlightsArrivalBeforeDepart = new FlightFilterImpl().filterArrivalBeforeDeparture(flights);
        filteredFlightsArrivalBeforeDepart.forEach(System.out::println);
        System.out.println(separator());

        System.out.println("Правило исключения 3: Перелеты, где общее время, проведённое на земле, превышает два часа.");
        List<Flight> filteredFlightsTransferExceedsTwoHours = new FlightFilterImpl().filterSumTransferExceedsTwoHours(flights);
        filteredFlightsTransferExceedsTwoHours.forEach(System.out::println);
        System.out.println(separator());
    }

    private static String separator() {
        return "---------------------";
    }
}