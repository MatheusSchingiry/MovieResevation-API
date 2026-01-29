package com.MovieResevation_API.MovieResevation_API.Core.UseCase;

import java.util.UUID;

public interface DeleteTicketUseCase {
    void execute(UUID ticketId);
}
