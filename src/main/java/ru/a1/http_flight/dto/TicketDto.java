package ru.a1.http_flight.dto;

import lombok.Builder;
import lombok.Value;


@Value
@Builder
public class TicketDto {

    Long id;
    Long flightId;
    String seatNo;

    }

