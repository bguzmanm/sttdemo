package cl.sustantiva.sttdemo.domain.service;

import cl.sustantiva.sttdemo.persistence.entity.Customer;
import cl.sustantiva.sttdemo.persistence.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository repository;
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getAll(){
        return repository.getAll();
    }

    public Optional<Customer> getOne(int customerId){
        return repository.getOne(customerId);
    }

    public Customer save(Customer customer){
        return repository.save(customer);
    }
    public void delete(int customerId){
        repository.delete(customerId);
    }
}
