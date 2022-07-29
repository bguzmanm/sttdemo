package cl.sustantiva.sttdemo.persistence.repository;

import cl.sustantiva.sttdemo.domain.dto.FilmDTO;
import cl.sustantiva.sttdemo.domain.repository.FilmRepositoryDTO;
import cl.sustantiva.sttdemo.persistence.crud.FilmCrudRepository;
import cl.sustantiva.sttdemo.persistence.entity.Film;
import cl.sustantiva.sttdemo.persistence.mapper.FilmMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FilmRepository implements FilmRepositoryDTO {

    private final FilmCrudRepository crudRepository;
    private final FilmMapper mapper;

    public FilmRepository(FilmCrudRepository crudRepository, FilmMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }


    @Override
    public List<FilmDTO> getAll() {
        return mapper.toFilmDTOs((List<Film>) crudRepository.findAll());
    }

    @Override
    public Optional<FilmDTO> getOne(int filmId) {
        return crudRepository.findById(filmId).map(mapper::toFilmDTO);
    }

    @Override
    public FilmDTO save(FilmDTO film) {
        return mapper.toFilmDTO(crudRepository.save(mapper.toFilm(film)));
    }

    @Override
    public void delete(int filmId) {
        crudRepository.deleteById(filmId);

    }
}
