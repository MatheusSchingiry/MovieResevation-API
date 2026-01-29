package com.MovieResevation_API.MovieResevation_API.Core.UseCase;

import com.MovieResevation_API.MovieResevation_API.Core.Domain.Ticket;
import com.MovieResevation_API.MovieResevation_API.Core.Gateway.TicketGateway;

import java.util.UUID;

public class UpdateTicketUseCaseImpl implements UpdateTicketUseCase {

    private final TicketGateway ticketGateway;

    public UpdateTicketUseCaseImpl(TicketGateway ticketGateway) {
        this.ticketGateway = ticketGateway;
    }

    @Override
    public Ticket execute(UUID ticketId, Ticket ticket) {
        return ticketGateway.updateTicket(ticketId, ticket);
    }
}
