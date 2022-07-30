package cl.sustantiva.sttdemo.persistence.repository;

import cl.sustantiva.sttdemo.domain.dto.StaffDTO;
import cl.sustantiva.sttdemo.domain.repository.StaffRepositoryDTO;
import cl.sustantiva.sttdemo.persistence.crud.StaffCrudRepository;
import cl.sustantiva.sttdemo.persistence.entity.Staff;
import cl.sustantiva.sttdemo.persistence.mapper.StaffMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StaffRepository implements StaffRepositoryDTO {

    private final StaffCrudRepository crudRepository;
    private final StaffMapper mapper;

    public StaffRepository(StaffCrudRepository crudRepository, StaffMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<StaffDTO> getAll() {
        return mapper.toStaffDtos((List<Staff>) crudRepository.findAll());
    }

    @Override
    public Optional<StaffDTO> getOne(int staffId) {
        return crudRepository.findById(staffId)
                .map(mapper::toStaffDto);
    }

    @Override
    public StaffDTO save(StaffDTO staff) {
        return mapper.toStaffDto(crudRepository.save(mapper.toStaff(staff)));
    }

    @Override
    public void delete(int staffId) {
        crudRepository.deleteById(staffId);
    }
}
