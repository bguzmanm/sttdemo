package cl.sustantiva.sttdemo.domain.repository;

import cl.sustantiva.sttdemo.domain.dto.FilmDTO;

import java.util.List;
import java.util.Optional;

public interface FilmRepositoryDTO {
    List<FilmDTO> getAll();
    Optional<FilmDTO> getOne(int filmId);
    FilmDTO save(FilmDTO film);
    void delete(int filmId);
}
