package cl.sustantiva.sttdemo.persistence.repository;

import cl.sustantiva.sttdemo.domain.dto.ActorDTO;
import cl.sustantiva.sttdemo.domain.repository.ActorRepositoryDTO;
import cl.sustantiva.sttdemo.persistence.crud.ActorCrudRepository;
import cl.sustantiva.sttdemo.persistence.entity.Actor;
import cl.sustantiva.sttdemo.persistence.mapper.ActorMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ActorRepository implements ActorRepositoryDTO {

    private final ActorCrudRepository crudRepository;
    private final ActorMapper mapper;

    public ActorRepository(ActorCrudRepository crudRepository, ActorMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ActorDTO> getAll() {
        return mapper.toActorDTOs((List<Actor>) crudRepository.findAll());
    }

    @Override
    public Optional<ActorDTO> getOne(int actorId) {
        return crudRepository.findById(actorId).map(mapper::toActorDTO);
    }

    @Override
    public ActorDTO save(ActorDTO actor) {
        return mapper.toActorDTO(crudRepository.save(mapper.toActor(actor)));
    }

    @Override
    public void delete(int actorId) {
        crudRepository.deleteById(actorId);
    }
}
