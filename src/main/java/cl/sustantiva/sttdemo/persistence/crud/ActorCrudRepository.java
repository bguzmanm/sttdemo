package cl.sustantiva.sttdemo.persistence.crud;


import cl.sustantiva.sttdemo.persistence.entity.Actor;
import org.springframework.data.repository.CrudRepository;

public interface ActorCrudRepository extends CrudRepository<Actor, Integer> {
}
