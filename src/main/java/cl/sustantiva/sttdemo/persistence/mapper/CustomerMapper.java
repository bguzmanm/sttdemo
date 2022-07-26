package cl.sustantiva.sttdemo.persistence.mapper;

import cl.sustantiva.sttdemo.domain.dto.CustomerDTO;
import cl.sustantiva.sttdemo.persistence.entity.Customer;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface CustomerMapper {

    @Mappings({
            @Mapping(source = "customerId", target = "customerId"),
            @Mapping(source = "address", target = "addressDTO"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "store", target = "storeDTO"),
            @Mapping(source = "active", target = "active"),
    })
    CustomerDTO toCustomerDTO(Customer customer);
    List<CustomerDTO> toCustomers(List<Customer> customers);
    
    @InheritInverseConfiguration
    Customer toCustomer(CustomerDTO customerDTO);
}
