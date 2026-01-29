package com.MovieResevation_API.MovieResevation_API.Core.UseCase;

import com.MovieResevation_API.MovieResevation_API.Core.Domain.Ticket;

import java.util.UUID;

public interface UpdateTicketUseCase {
    Ticket execute(UUID ticketId, Ticket ticket);
}
