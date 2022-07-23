package cl.sustantiva.sttdemo.persistence.repository;

import cl.sustantiva.sttdemo.persistence.crud.AddressCrudRepository;
import cl.sustantiva.sttdemo.persistence.entity.Address;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AddressRepository {

    private final AddressCrudRepository crudRepository;

    public AddressRepository(AddressCrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public List<Address> getAll(){
        return (List<Address>) crudRepository.findAll();
    }

    public Optional<Address> getOne(int addressId){
        return crudRepository.findById(addressId);
    }

}
