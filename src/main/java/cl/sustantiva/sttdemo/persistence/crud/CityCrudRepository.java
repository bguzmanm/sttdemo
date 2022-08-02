package cl.sustantiva.sttdemo.persistence.crud;

import cl.sustantiva.sttdemo.persistence.entity.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CityCrudRepository extends CrudRepository<City, Integer> {

    //Utilizando el nombre del método para indicar los filtros que queremos hacer.
    Optional<List<City>> findByCountryId(int countryId);
    Optional<List<City>> findByCountryIdOrderByCityDesc(int countryId);

    //utilizando JPQL
    @Query("select c from City c where c.countryId =:countryId")
    Optional<List<City>> buscarPorIdDelPais(int countryId);

    //utilizando JPQL de otra forma
    Optional<List<City>> filtrandoPorNombre(String nombre);

    //Query nativa (es decir, con SQL)
    @Query(value = "select city_id, city, country_id where city_id>18 and city =:nombre", nativeQuery = true)
    Optional<List<City>> filtrandoConNativeQuery(String nombre);

}
