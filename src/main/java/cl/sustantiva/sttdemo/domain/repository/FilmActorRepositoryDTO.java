package cl.sustantiva.sttdemo.domain.repository;

import cl.sustantiva.sttdemo.domain.dto.FilmActorDTO;

import java.util.List;
import java.util.Optional;

public interface FilmActorRepositoryDTO {
    List<FilmActorDTO> getAll();
    Optional<FilmActorDTO> getOne(int actorId, int filmId);
    FilmActorDTO save(FilmActorDTO filmActor);
    void delete(int actorId, int filmId);
}
