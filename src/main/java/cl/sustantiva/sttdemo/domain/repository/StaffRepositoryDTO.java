package cl.sustantiva.sttdemo.domain.repository;

import cl.sustantiva.sttdemo.domain.dto.StaffDTO;

import java.util.List;
import java.util.Optional;

public interface StaffRepositoryDTO {
    List<StaffDTO> getAll();
    Optional<StaffDTO> getOne(int staffId);
    StaffDTO save(StaffDTO staff);
    void delete(int staffId);
}
