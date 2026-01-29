package com.MovieResevation_API.MovieResevation_API.infrastructure.Presentation;

import com.MovieResevation_API.MovieResevation_API.Core.Domain.Ticket;
import com.MovieResevation_API.MovieResevation_API.Core.UseCase.CreateTicketUseCase;
import com.MovieResevation_API.MovieResevation_API.Core.UseCase.DeleteTicketUseCase;
import com.MovieResevation_API.MovieResevation_API.Core.UseCase.GetAllTicketUseCase;
import com.MovieResevation_API.MovieResevation_API.Core.UseCase.UpdateTicketUseCase;
import com.MovieResevation_API.MovieResevation_API.infrastructure.Mapper.TicketMapper;
import com.MovieResevation_API.MovieResevation_API.infrastructure.Persistence.TicketEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/ticket")
public class TicketController {

    private final TicketMapper ticketMapper;
    private final CreateTicketUseCase createTicketUseCase;
    private final GetAllTicketUseCase getAllTicketUseCase;
    private final UpdateTicketUseCase updateTicketUseCase;
    private final DeleteTicketUseCase deleteTicketUseCase;

    public TicketController(TicketMapper ticketMapper, CreateTicketUseCase createTicketUseCase, GetAllTicketUseCase getAllTicketUseCase, UpdateTicketUseCase updateTicketUseCase, DeleteTicketUseCase deleteTicketUseCase) {
        this.ticketMapper = ticketMapper;
        this.createTicketUseCase = createTicketUseCase;
        this.getAllTicketUseCase = getAllTicketUseCase;
        this.updateTicketUseCase = updateTicketUseCase;
        this.deleteTicketUseCase = deleteTicketUseCase;
    }

    @PostMapping
    public TicketEntity createTicket(@RequestBody TicketEntity ticket) {
        Ticket createdTicket = createTicketUseCase.execute(ticketMapper.toDomain(ticket));
        return ticketMapper.toEntity(createdTicket);
    }

    @GetMapping
    public List<TicketEntity> getAllTickets() {
        List<TicketEntity> tickets = getAllTicketUseCase.execute().stream().map(ticketMapper::toEntity).toList();
        return tickets;
    }

    @PutMapping("/{id}")
    public TicketEntity updateTicket(@PathVariable UUID id, @RequestBody TicketEntity ticket) {
        Ticket updatedTicket = updateTicketUseCase.execute(id, ticketMapper.toDomain(ticket));
        return ticketMapper.toEntity(updatedTicket);
    }

    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable UUID id) {
        deleteTicketUseCase.execute(id);
    }
}
