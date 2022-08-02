package cl.sustantiva.sttdemo.persistence.repository;

import cl.sustantiva.sttdemo.persistence.crud.CityCrudRepository;
import cl.sustantiva.sttdemo.persistence.entity.City;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CityRepository {

    private final CityCrudRepository crudRepository;

    public CityRepository(CityCrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public List<City> getAll(){
        return (List<City>) crudRepository.findAll();
    }

    public Optional<List<City>> getByCountry(int countryId){
        //return crudRepository.findByCountryIdOrderByCityDesc(countryId);
        return crudRepository.buscarPorIdDelPais(countryId);
    }

    public Optional<City> getCity(int cityId){
        return crudRepository.findById(cityId);
    }

    public Optional<List<City>> getCityByName(String name){
        return crudRepository.filtrandoPorNombre(name);
    }

 }
