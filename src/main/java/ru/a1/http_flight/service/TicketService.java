package ru.a1.http_flight.service;

import ru.a1.http_flight.dao.TicketDao;
import ru.a1.http_flight.dto.TicketDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class TicketService {


    private static final TicketService INSTANCE = new TicketService();

    private final TicketDao ticketDao = TicketDao.getInstance();

    private TicketService() {
    }

    public List<TicketDto> findAllByFlightId(Long flightId) {
        return ticketDao.findAllByFlightId(flightId).stream()
                .map(ticket -> new TicketDto(
                        ticket.getId(),
                        ticket.getFlightId(),
                        ticket.getSeatNo()
                ))
                .collect(toList());
    }

    public static TicketService getInstance() {
        return INSTANCE;
    }
}
