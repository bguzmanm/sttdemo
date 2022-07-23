package cl.sustantiva.sttdemo.persistence.crud;

import cl.sustantiva.sttdemo.persistence.entity.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityCrudRepository extends CrudRepository<City, Integer> {
    List<City> findByCountryId(int countryId);
    List<City> findByCountryIdOrderByCityDesc(int countryId);

}
