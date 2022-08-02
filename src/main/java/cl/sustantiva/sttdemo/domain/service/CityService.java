package cl.sustantiva.sttdemo.domain.service;


import cl.sustantiva.sttdemo.domain.dto.CityDTO;
import cl.sustantiva.sttdemo.domain.repository.CityRepositoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private final CityRepositoryDTO repository;

    public CityService(CityRepositoryDTO repository) {
        this.repository = repository;
    }

    public Optional<List<CityDTO>> getByName(String name){
        return repository.getByName(name);
    }

    public List<CityDTO> getByCountry(int countryId){
        return repository.getAll();
    }
    public List<CityDTO> getAll(){
        return repository.getAll();
    }

    public Optional<CityDTO> getCity(int cityId){
        return repository.getOne(cityId);
    }

    public CityDTO save(CityDTO city){
        return repository.save(city);
    }

    public boolean delete(int cityId){
        return repository.getOne(cityId)
                .map(city -> {
                    repository.delete(cityId);
                    return true;
                })
                .orElse(false);
    }
}
