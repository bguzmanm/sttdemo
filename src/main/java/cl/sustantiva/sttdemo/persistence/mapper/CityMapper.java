package cl.sustantiva.sttdemo.persistence.mapper;

import cl.sustantiva.sttdemo.domain.dto.CityDTO;
import cl.sustantiva.sttdemo.persistence.entity.City;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CountryMapper.class})
public interface CityMapper {
    @Mappings({
            @Mapping(source = "cityId", target = "cityId"),
            @Mapping(source = "city", target = "city"),
            @Mapping(source = "countryId", target = "countryId"),
            @Mapping(source = "country", target = "countryDTO"),
    })
    CityDTO toCityDTO(City city);
    List<CityDTO> toCityDTOs(List<City> cities);

    @InheritInverseConfiguration
    @Mapping(target = "countryId", ignore = true)
    City toCity(CityDTO cityDTO);
}
