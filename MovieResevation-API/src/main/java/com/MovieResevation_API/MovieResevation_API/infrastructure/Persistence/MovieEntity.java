package com.MovieResevation_API.MovieResevation_API.Infrastructre.Persistence;

import com.MovieResevation_API.MovieResevation_API.Core.Enum.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_movies")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Genre genre;
    private Integer durationMinutes;
    private String director;
    private Integer releaseYear;
    private String description;
}
