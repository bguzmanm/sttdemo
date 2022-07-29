package cl.sustantiva.sttdemo.domain.repository;

import cl.sustantiva.sttdemo.domain.dto.ActorDTO;

import java.util.List;
import java.util.Optional;

public interface ActorRepositoryDTO {
    List<ActorDTO> getAll();
    Optional<ActorDTO> getOne(int actorId);
    ActorDTO save(ActorDTO actor);
    void delete(int actorId);
}
