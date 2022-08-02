package cl.sustantiva.sttdemo.persistence.repository;

import cl.sustantiva.sttdemo.domain.dto.CityDTO;
import cl.sustantiva.sttdemo.domain.repository.CityRepositoryDTO;
import cl.sustantiva.sttdemo.persistence.crud.CityCrudRepository;
import cl.sustantiva.sttdemo.persistence.entity.City;
import cl.sustantiva.sttdemo.persistence.mapper.CityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CityRepository implements CityRepositoryDTO {

    private final CityCrudRepository crudRepository;
    private final CityMapper mapper;

    public CityRepository(CityCrudRepository crudRepository, CityMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }


    public List<CityDTO> getAll(){
        return mapper.toCityDTOs ((List<City>) crudRepository.findAll());
    }

    public Optional<List<CityDTO>> getByCountry(int countryId){
        //return crudRepository.findByCountryIdOrderByCityDesc(countryId);
        return crudRepository.buscarPorIdDelPais(countryId)
                .map(mapper::toCityDTOs);
    }

    public Optional<CityDTO> getOne(int cityId){
        return crudRepository.findById(cityId)
                .map(mapper::toCityDTO);
    }

    public Optional<List<CityDTO>> getCityByName(String name){
        return crudRepository.filtrandoPorNombre(name)
                .map(mapper::toCityDTOs);
    }
    public CityDTO save(CityDTO city){
        return mapper.toCityDTO(crudRepository.save(mapper.toCity(city)));
    }
    public void delete(int cityId){
        crudRepository.deleteById(cityId);
    }

    @Override
    public Optional<List<CityDTO>> getByName(String name) {
        return crudRepository.filtrandoPorNombre(name)
                .map(mapper::toCityDTOs);
    }

}
