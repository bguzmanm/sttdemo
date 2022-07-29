package cl.sustantiva.sttdemo.persistence.repository;

import cl.sustantiva.sttdemo.domain.dto.FilmActorDTO;
import cl.sustantiva.sttdemo.domain.repository.FilmActorRepositoryDTO;
import cl.sustantiva.sttdemo.persistence.crud.FilmActorCrudRepository;
import cl.sustantiva.sttdemo.persistence.entity.FilmActor;
import cl.sustantiva.sttdemo.persistence.entity.FilmActorPK;
import cl.sustantiva.sttdemo.persistence.mapper.FilmActorMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FilmActorRepository implements FilmActorRepositoryDTO {

    private final FilmActorCrudRepository crudRepository;
    private final FilmActorMapper mapper;

    public FilmActorRepository(FilmActorCrudRepository crudRepository, FilmActorMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<FilmActorDTO> getAll() {
        return mapper.toFilmActorDTOs((List<FilmActor>) crudRepository.findAll());
    }

    @Override
    public Optional<FilmActorDTO> getOne(int actorId, int filmId) {
        return crudRepository.findById(new FilmActorPK(actorId, filmId)).map(mapper::toFilmActorDTO);
    }

    @Override
    public FilmActorDTO save(FilmActorDTO filmActor) {
        return mapper.toFilmActorDTO(crudRepository.save(mapper.toFilmActor(filmActor)));
    }

    @Override
    public void delete(int actorId, int filmId) {
        crudRepository.deleteById(new FilmActorPK(actorId, filmId));
    }
}
