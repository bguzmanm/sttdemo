package cl.sustantiva.sttdemo.persistence.crud;

import cl.sustantiva.sttdemo.persistence.entity.FilmActor;
import cl.sustantiva.sttdemo.persistence.entity.FilmActorPK;
import org.springframework.data.repository.CrudRepository;

public interface FilmActorCrudRepository extends CrudRepository<FilmActor, FilmActorPK> {
}
