package cl.sustantiva.sttdemo.domain.service;

import cl.sustantiva.sttdemo.domain.dto.FilmDTO;
import cl.sustantiva.sttdemo.domain.repository.FilmRepositoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    private final FilmRepositoryDTO repositoryDTO;

    public FilmService(FilmRepositoryDTO repositoryDTO) {
        this.repositoryDTO = repositoryDTO;
    }

    public List<FilmDTO> getAll(){
        return repositoryDTO.getAll();
    }
    public Optional<FilmDTO> getOne(int filmId){
        return repositoryDTO.getOne(filmId);
    }
}
