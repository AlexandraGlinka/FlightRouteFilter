package com.gridnine.testing.service;

import com.gridnine.testing.entity.Flight;

import java.util.List;

public interface FlightFilter {
    List<Flight> filterBeforeNow(List<Flight> flights);
    //Сегменты с датой прилёта раньше даты вылета.
    List<Flight> filterArrivalBeforeDeparture();
    //Перелеты, где общее время, проведённое на земле, превышает два часа
    // (время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним).
    List<Flight> filterSumTransferExceedsTwoHours();
}
