package cl.sustantiva.sttdemo.persistence.mapper;

import cl.sustantiva.sttdemo.domain.dto.StoreDTO;
import cl.sustantiva.sttdemo.persistence.entity.Store;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StoreMapper {

    @Mappings({
            @Mapping(source = "storeId", target = "storeId"),
            @Mapping(source = "addressId", target = "addressId"),
            @Mapping(source = "managerStaffId", target = "managerStaffId")
    })
    StoreDTO toStoreDTO(Store store);
    List<StoreDTO> toStoresDTOs(List<Store> stores);
    @InheritInverseConfiguration
    Store toStore(StoreDTO storeDTO);
}
