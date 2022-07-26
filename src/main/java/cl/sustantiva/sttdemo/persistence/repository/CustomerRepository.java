package cl.sustantiva.sttdemo.persistence.repository;

import cl.sustantiva.sttdemo.domain.repository.CustomerRepositoryDTO;
import cl.sustantiva.sttdemo.persistence.crud.CustomerCrudRepository;
import cl.sustantiva.sttdemo.persistence.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository implements CustomerRepositoryDTO {
    private final CustomerCrudRepository crudRepository;

    public CustomerRepository(CustomerCrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }
    public List<Customer> getAll(){
        return (List<Customer>) crudRepository.findAll();
    }
    public Optional<Customer> getOne(int id){
        return crudRepository.findById(id);
    }


    public Customer save(Customer customer){
        return crudRepository.save(customer);
    }
    public void delete(int customerId){
        crudRepository.deleteById(customerId);
    }
}
