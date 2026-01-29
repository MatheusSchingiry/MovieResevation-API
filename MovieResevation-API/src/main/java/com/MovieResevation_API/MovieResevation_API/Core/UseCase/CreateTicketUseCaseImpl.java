package com.MovieResevation_API.MovieResevation_API.Core.UseCase;

import com.MovieResevation_API.MovieResevation_API.Core.Domain.Ticket;
import com.MovieResevation_API.MovieResevation_API.Core.Gateway.TicketGateway;

public class CreateTicketUseCaseImpl implements CreateTicketUseCase {

    private final TicketGateway ticketGateway;

    public CreateTicketUseCaseImpl(TicketGateway ticketGateway) {
        this.ticketGateway = ticketGateway;
    }

    @Override
    public Ticket execute(Ticket ticker) {
        return ticketGateway.createTicket(ticker);
    }
}
