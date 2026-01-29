package com.MovieResevation_API.MovieResevation_API.infrastructure.Persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_tickets")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String movie;

    @Column(nullable = false)
    private String seatNumber;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private LocalDateTime showTime;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private Integer roomNumber;
}
