package cl.sustantiva.sttdemo.persistence.repository;

import cl.sustantiva.sttdemo.domain.dto.CustomerDTO;
import cl.sustantiva.sttdemo.domain.repository.CustomerRepositoryDTO;
import cl.sustantiva.sttdemo.persistence.crud.CustomerCrudRepository;
import cl.sustantiva.sttdemo.persistence.entity.Customer;
import cl.sustantiva.sttdemo.persistence.mapper.CustomerMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository implements CustomerRepositoryDTO {
    private final CustomerCrudRepository crudRepository;
    private final CustomerMapper mapper;

    public CustomerRepository(CustomerCrudRepository crudRepository, CustomerMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    public List<CustomerDTO> getAll(){
        return mapper.toCustomerDTOs((List<Customer>) crudRepository.findAll());
    }
    public Optional<CustomerDTO> getOne(int customerId){
        return crudRepository.findById(customerId).map(mapper::toCustomerDTO);
    }

    public CustomerDTO save(CustomerDTO customerDTO){
        return mapper.toCustomerDTO(crudRepository.save(mapper.toCustomer(customerDTO)));
    }
    public void delete(int customerId){
        crudRepository.deleteById(customerId);
    }
}
