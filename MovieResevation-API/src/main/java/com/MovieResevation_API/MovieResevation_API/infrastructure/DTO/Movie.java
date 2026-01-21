package com.MovieResevation_API.MovieResevation_API.infrastructure.DTO;

import com.MovieResevation_API.MovieResevation_API.Core.Enum.Genre;

public record Movie(
        Long id,
        String title,
        Genre genre,
        Integer durationMinutes,
        String director,
        Integer releaseYear,
        String description
) {
}
