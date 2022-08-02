package cl.sustantiva.sttdemo.domain.repository;

import cl.sustantiva.sttdemo.domain.dto.CityDTO;

import java.util.List;
import java.util.Optional;

public interface CityRepositoryDTO {
    List<CityDTO> getAll();
    Optional<CityDTO> getOne(int cityId);
    CityDTO save(CityDTO city);
    void delete(int cityId);

    Optional<List<CityDTO>> getByName(String name);
}
