package com.MovieResevation_API.MovieResevation_API.infrastructure.Producer;

import com.MovieResevation_API.MovieResevation_API.infrastructure.Persistence.TicketEntity;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class TicketProducer {

    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public TicketProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendTicket(TicketEntity ticket) {
        amqpTemplate.convertAndSend("ticket_queue", objectMapper.writeValueAsString(ticket));
    }
}
