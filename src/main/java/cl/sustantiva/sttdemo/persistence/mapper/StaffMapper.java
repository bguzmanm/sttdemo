package cl.sustantiva.sttdemo.persistence.mapper;

import cl.sustantiva.sttdemo.domain.dto.StaffDTO;
import cl.sustantiva.sttdemo.persistence.entity.Staff;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AddressMapper.class, StoreMapper.class})
public interface StaffMapper {

    @Mappings({
            @Mapping(source = "staffId", target = "staffId"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "addressId", target = "addressId"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "storeId", target = "storeId"),
            @Mapping(source = "store", target = "store"),
            @Mapping(source = "active", target = "active"),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "password", target = "password"),
    })
    StaffDTO toStaffDto(Staff staff);
    List<StaffDTO> toStaffDtos(List<Staff> staffList);

    @InheritInverseConfiguration
    Staff toStaff(StaffDTO staffDTO);
}
