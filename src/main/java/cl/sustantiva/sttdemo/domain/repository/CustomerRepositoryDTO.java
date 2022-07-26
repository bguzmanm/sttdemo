package cl.sustantiva.sttdemo.domain.repository;

import cl.sustantiva.sttdemo.domain.dto.CustomerDTO;

import java.util.List;
import java.util.Optional;

public interface CustomerRepositoryDTO {
    List<CustomerDTO> getAll();
    Optional<CustomerDTO> getOne(int customerId);
    CustomerDTO save(CustomerDTO customerDTO);
    void delete(int customerId);
}
