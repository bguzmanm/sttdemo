package cl.sustantiva.sttdemo.persistence.mapper;

import cl.sustantiva.sttdemo.domain.dto.CountryDTO;
import cl.sustantiva.sttdemo.persistence.entity.Country;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    @Mappings({
            @Mapping(source = "countryId", target = "countryId"),
            @Mapping(source = "country", target = "country")
    })
    CountryDTO toCountryDTO(Country country);
    List<CountryDTO> toCountryDTOs(List<Country> countries);

    @InheritInverseConfiguration
    Country toCountry(CountryDTO countryDTO);
}
