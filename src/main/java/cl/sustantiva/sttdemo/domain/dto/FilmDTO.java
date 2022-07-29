package cl.sustantiva.sttdemo.domain.dto;

import lombok.Data;
import java.util.List;

@Data
public class FilmDTO {
    private Integer filmId;
    private String title;
    private String description;
    private Integer releaseYear;
    private Integer languageId;
    private Integer originalLanguageId;
    private Integer rentalDuration;
    private Double rentalRate;
    private Integer length;
    private Double replacementCost;
    private String rating;
    private String specialFeatures;
    private List<FilmActorDTO> actors;
}
