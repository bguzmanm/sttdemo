package cl.sustantiva.sttdemo.domain.service;

import cl.sustantiva.sttdemo.persistence.entity.Customer;
import cl.sustantiva.sttdemo.persistence.repository.CustomerRepository;
import cl.sustantiva.sttdemo.web.controller.CustomerController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    Log logger = LogFactory.getLog(CustomerService.class);

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
