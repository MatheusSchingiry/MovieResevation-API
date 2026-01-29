package com.MovieResevation_API.MovieResevation_API.Core.UseCase;

import com.MovieResevation_API.MovieResevation_API.Core.Domain.Ticket;
import com.MovieResevation_API.MovieResevation_API.Core.Gateway.TicketGateway;

import java.util.List;

public class GetAllTicketUseCaseImpl implements GetAllTicketUseCase {

    private final TicketGateway ticketGateway;

    public GetAllTicketUseCaseImpl(TicketGateway ticketGateway) {
        this.ticketGateway = ticketGateway;
    }

    @Override
    public List<Ticket> execute() {
        return ticketGateway.getAllTicket();
    }
}
