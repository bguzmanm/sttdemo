package cl.sustantiva.sttdemo.persistence.crud;

import cl.sustantiva.sttdemo.persistence.entity.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmCrudRepository extends CrudRepository<Film, Integer> {
}
