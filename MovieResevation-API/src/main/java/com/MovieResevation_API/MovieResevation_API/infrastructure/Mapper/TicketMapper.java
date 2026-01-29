package com.MovieResevation_API.MovieResevation_API.infrastructure.Mapper;

import com.MovieResevation_API.MovieResevation_API.Core.Domain.Ticket;
import com.MovieResevation_API.MovieResevation_API.infrastructure.Persistence.TicketEntity;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

    public Ticket toDomain(TicketEntity entity){
        return new Ticket(
                entity.getId(),
                entity.getMovie(),
                entity.getSeatNumber(),
                entity.getUserName(),
                entity.getShowTime(),
                entity.getPrice(),
                entity.getRoomNumber()
        );
    }

    public TicketEntity toEntity(Ticket ticket){
        return new TicketEntity(
                ticket.id(),
                ticket.movie(),
                ticket.seatNumber(),
                ticket.userName(),
                ticket.showTime(),
                ticket.price(),
                ticket.roomNumber()
        );
    }
}
