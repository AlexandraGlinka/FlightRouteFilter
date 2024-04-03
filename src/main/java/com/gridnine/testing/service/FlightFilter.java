package com.gridnine.testing.service;

import com.gridnine.testing.entity.Flight;

import java.util.List;

public interface FlightFilter {
    //Вылет до текущего момента времени.
    List<Flight> filterBeforeNow();
    //Сегменты с датой прилёта раньше даты вылета.
    List<Flight> filterArrivalBeforeDeparture();
    //Перелеты, где общее время, проведённое на земле, превышает два часа
    // (время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним).
    List<Flight> filterSumTransferExceedsTwoHours();
}
