package cl.sustantiva.sttdemo.persistence.crud;

import cl.sustantiva.sttdemo.persistence.entity.Store;
import org.springframework.data.repository.CrudRepository;

public interface StoreCrudRepository extends CrudRepository<Store, Integer> {
}
