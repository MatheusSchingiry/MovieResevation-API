package com.MovieResevation_API.MovieResevation_API.infrastructure.Gateway;

import com.MovieResevation_API.MovieResevation_API.Core.Domain.Ticket;
import com.MovieResevation_API.MovieResevation_API.Core.Gateway.TicketGateway;
import com.MovieResevation_API.MovieResevation_API.infrastructure.Mapper.TicketMapper;
import com.MovieResevation_API.MovieResevation_API.infrastructure.Persistence.TicketEntity;
import com.MovieResevation_API.MovieResevation_API.infrastructure.Persistence.TicketRepository;
import com.MovieResevation_API.MovieResevation_API.infrastructure.Producer.TicketProducer;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Component
public class TicketRepositoryGateway implements TicketGateway {

    private final TicketRepository ticketRepository;
    private final TicketProducer ticketProducer;
    private final TicketMapper ticketMapper;

    public TicketRepositoryGateway(TicketRepository ticketRepository, TicketProducer ticketProducer, TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketProducer = ticketProducer;
        this.ticketMapper = ticketMapper;
    }

    @Override
    @Transactional
    public Ticket createTicket(Ticket ticket) {
        TicketEntity savedEntity = ticketRepository.save(ticketMapper.toEntity(ticket));
        ticketProducer.sendTicket(savedEntity);
        return ticketMapper.toDomain(savedEntity);
    }

    @Override
    public List<Ticket> getAllTicket() {
        List<Ticket> tickets = ticketRepository.findAll()
                .stream()
                .map(ticketMapper::toDomain)
                .toList();
        return tickets;
    }

    @Override
    public Ticket updateTicket(UUID ticketId, Ticket ticket) {
        TicketEntity existingEntity = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        existingEntity.setMovie(ticket.movie());
        existingEntity.setSeatNumber(ticket.seatNumber());
        existingEntity.setUserName(ticket.userName());
        existingEntity.setShowTime(ticket.showTime());
        existingEntity.setPrice(ticket.price());
        existingEntity.setRoomNumber(ticket.roomNumber());

        TicketEntity updatedEntity = ticketRepository.save(existingEntity);
        return ticketMapper.toDomain(updatedEntity);
    }

    @Override
    public void deleteTicket(UUID id) {
        ticketRepository.deleteById(id);
    }
}
