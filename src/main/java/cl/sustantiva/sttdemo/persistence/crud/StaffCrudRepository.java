package cl.sustantiva.sttdemo.persistence.crud;

import cl.sustantiva.sttdemo.persistence.entity.Staff;
import org.springframework.data.repository.CrudRepository;

public interface StaffCrudRepository extends CrudRepository<Staff, Integer> {
}
