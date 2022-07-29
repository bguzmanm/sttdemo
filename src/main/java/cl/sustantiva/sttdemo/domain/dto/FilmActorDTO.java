package cl.sustantiva.sttdemo.domain.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class FilmActorDTO {
    private ActorDTO actor;
    private FilmDTO film;
    private LocalDate lastUpdate;

}
