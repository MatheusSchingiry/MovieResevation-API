package com.MovieResevation_API.MovieResevation_API.Core.UseCase;

import com.MovieResevation_API.MovieResevation_API.Core.Domain.Ticket;

import java.util.List;

public interface GetAllTicketUseCase {
    List<Ticket> execute();
}
