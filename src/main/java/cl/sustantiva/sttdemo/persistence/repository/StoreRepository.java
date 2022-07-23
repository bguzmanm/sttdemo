package cl.sustantiva.sttdemo.persistence.repository;

import cl.sustantiva.sttdemo.persistence.crud.StoreCrudRepository;
import cl.sustantiva.sttdemo.persistence.entity.Store;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StoreRepository {

    private final StoreCrudRepository crudRepository;

    public StoreRepository(StoreCrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public List<Store> getAll(){
        return (List<Store>) crudRepository.findAll();
    }

    public Optional<Store> getOne(int storeId){
        return crudRepository.findById(storeId);
    }
}
