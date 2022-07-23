package cl.sustantiva.sttdemo.persistence.crud;

import cl.sustantiva.sttdemo.persistence.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressCrudRepository extends CrudRepository<Address, Integer> {
}
