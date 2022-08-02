package cl.sustantiva.sttdemo.domain.service;

import cl.sustantiva.sttdemo.persistence.entity.City;
import cl.sustantiva.sttdemo.persistence.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/***
 *
 */
@Service
public class CityService {

    private final CityRepository repository;

    public CityService(CityRepository repository) {
        this.repository = repository;
    }

    public Optional<List<City>> getByCountry(int countryId){
        return repository.getByCountry(countryId);
    }
    public List<City> getAll(){
        return repository.getAll();
    }

    public Optional<List<City>> getByName(String name){
        return repository.getCityByName(name);
    }

}
