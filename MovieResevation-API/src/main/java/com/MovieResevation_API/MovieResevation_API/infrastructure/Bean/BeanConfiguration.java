package com.MovieResevation_API.MovieResevation_API.infrastructure.Bean;

import com.MovieResevation_API.MovieResevation_API.Core.Gateway.TicketGateway;
import com.MovieResevation_API.MovieResevation_API.Core.UseCase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateTicketUseCase createTicketUseCaseBean(TicketGateway ticketGateway){
        return new CreateTicketUseCaseImpl(ticketGateway);
    }

    @Bean
    public GetAllTicketUseCase readTicketUseCase(TicketGateway ticketGateway){
        return new GetAllTicketUseCaseImpl(ticketGateway);
    }

    @Bean
    public UpdateTicketUseCase updateTicketUseCase(TicketGateway ticketGateway){
        return new UpdateTicketUseCaseImpl(ticketGateway);
    }

    @Bean
    public DeleteTicketUseCase deleteTicketUseCase(TicketGateway ticketGateway){
        return new DeleteTicketUseCaseImpl(ticketGateway);
    }
}
