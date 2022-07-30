package cl.sustantiva.sttdemo.domain.service;

import cl.sustantiva.sttdemo.domain.dto.StaffDTO;
import cl.sustantiva.sttdemo.domain.repository.StaffRepositoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    private final StaffRepositoryDTO repo;

    public StaffService(StaffRepositoryDTO repo) {
        this.repo = repo;
    }

    public List<StaffDTO> getAll(){
        return repo.getAll();
    }
    public Optional<StaffDTO> getOne(int staffId){
        return repo.getOne(staffId);
    }
    public StaffDTO save(StaffDTO staff){
        return repo.save(staff);
    }
    public boolean delete(int staffId){
        return getOne(staffId)
                .map(staffDTO -> {
                    repo.delete(staffId);
                    return true;
                }).orElse(false);
    }



}
