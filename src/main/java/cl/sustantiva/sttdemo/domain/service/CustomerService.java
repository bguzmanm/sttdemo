package cl.sustantiva.sttdemo.domain.service;

import cl.sustantiva.sttdemo.domain.dto.CustomerDTO;
import cl.sustantiva.sttdemo.persistence.repository.CustomerRepository;
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

    public List<CustomerDTO> getAll(){
        return repository.getAll();
    }

    public Optional<CustomerDTO> getOne(int customerId){
        return repository.getOne(customerId);
    }

    public CustomerDTO save(CustomerDTO customer){
        return repository.save(customer);
    }
    public boolean delete(int customerId){
        return getOne(customerId)
                .map(customer -> {
                    repository.delete(customerId);
                    return true;
                }).orElse(false);
    }
}
