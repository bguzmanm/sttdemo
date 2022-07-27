package cl.sustantiva.sttdemo.persistence.mapper;

import cl.sustantiva.sttdemo.domain.dto.AddressDTO;
import cl.sustantiva.sttdemo.persistence.entity.Address;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import javax.sound.midi.Soundbank;
import java.util.List;

@Mapper(componentModel = "spring", uses = {CityMapper.class})
public interface AddressMapper {

    @Mappings({
            @Mapping(source = "addressId", target = "addressId"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "address2", target = "address2"),
            @Mapping(source = "city", target = "cityDTO"),
            @Mapping(source = "district", target = "district"),
            @Mapping(source = "phone", target = "phone"),
            @Mapping(source = "postalCode", target = "postalCode")
    })
    AddressDTO toAddressDTO(Address address);
    List<AddressDTO> toAddressDTOs(List<Address> addresses);

    @InheritInverseConfiguration
    @Mapping(target = "cityId", ignore = true)
    Address toAddress(AddressDTO addressDTO);
}
