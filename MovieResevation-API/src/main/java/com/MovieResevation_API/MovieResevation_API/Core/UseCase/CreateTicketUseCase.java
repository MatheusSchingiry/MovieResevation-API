package com.MovieResevation_API.MovieResevation_API.Core.UseCase;

import com.MovieResevation_API.MovieResevation_API.Core.Domain.Ticket;

public interface CreateTicketUseCase {
    Ticket execute(Ticket ticket);
}
