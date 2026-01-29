package com.MovieResevation_API.MovieResevation_API.infrastructure.Persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketRepository extends JpaRepository<TicketEntity, UUID> {
}
