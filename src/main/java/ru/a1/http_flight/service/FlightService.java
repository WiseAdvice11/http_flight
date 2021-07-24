package ru.a1.http_flight.service;


import ru.a1.http_flight.dao.FlightDao;
import ru.a1.http_flight.dto.FlightDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class FlightService {


   private FlightService() {
    }

    private static final FlightService INSTANCE = new FlightService();
    private  final FlightDao flightDao= FlightDao.getInstance();

    public List<FlightDto> flightAll (){

        return flightDao.findAll().stream()
                .map(flight -> FlightDto.builder()
                        .id(flight.getId())
                        .description(
                                """
                                            %s - %s - %s
                                        """.formatted(flight.getDepartureAirportCode(), flight.getArrivalAirportCode(), flight.getStatus()))
                        .build())
                .collect(toList());
    }

    public static FlightService getInstance() {
        return INSTANCE;
    }
}
