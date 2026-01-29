package com.MovieResevation_API.MovieResevation_API.Core.UseCase;

import com.MovieResevation_API.MovieResevation_API.Core.Gateway.TicketGateway;

import java.util.UUID;

public class DeleteTicketUseCaseImpl implements DeleteTicketUseCase {

    private final TicketGateway ticketGateway;

    public DeleteTicketUseCaseImpl(TicketGateway ticketGateway) {
        this.ticketGateway = ticketGateway;
    }

    @Override
    public void execute(UUID ticketId) {
        ticketGateway.deleteTicket(ticketId);
    }
}
