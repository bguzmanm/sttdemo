package cl.sustantiva.sttdemo.persistence.mapper;

import cl.sustantiva.sttdemo.domain.dto.FilmActorDTO;
import cl.sustantiva.sttdemo.persistence.entity.FilmActor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {FilmMapper.class, ActorMapper.class})
public interface FilmActorMapper {

    @Mappings({
            @Mapping(source = "lastUpdate", target = "lastUpdate"),
            @Mapping(source = "actor", target = "actor"),
            @Mapping(source = "film", target = "film"),
    })
    FilmActorDTO toFilmActorDTO(FilmActor filmActor);
    List<FilmActorDTO> toFilmActorDTOs(List<FilmActor> filmActors);

    @InheritInverseConfiguration
    FilmActor toFilmActor(FilmActorDTO filmActorDTO);
}
