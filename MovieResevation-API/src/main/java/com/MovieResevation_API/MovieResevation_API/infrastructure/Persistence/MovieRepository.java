package com.MovieResevation_API.MovieResevation_API.infrastructure.Persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
}
