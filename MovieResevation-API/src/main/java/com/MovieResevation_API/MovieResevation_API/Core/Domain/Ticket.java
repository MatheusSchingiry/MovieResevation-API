package com.MovieResevation_API.MovieResevation_API.Core.Domain;

import java.time.LocalDateTime;
import java.util.UUID;

public record Ticket(UUID id,
                     String movie,
                     String seatNumber,
                     String userName,
                     LocalDateTime showTime,
                     double price,
                     Integer roomNumber) {
}
