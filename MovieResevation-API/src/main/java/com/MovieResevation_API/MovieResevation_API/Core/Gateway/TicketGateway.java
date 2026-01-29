package com.MovieResevation_API.MovieResevation_API.Core.Gateway;

import com.MovieResevation_API.MovieResevation_API.Core.Domain.Ticket;
import com.google.zxing.WriterException;

import java.util.List;
import java.util.UUID;

public interface TicketGateway {
    Ticket createTicket(Ticket ticket);
    List<Ticket> getAllTicket();
    Ticket updateTicket(UUID ticketId, Ticket ticket);
    void deleteTicket(UUID id);
}
