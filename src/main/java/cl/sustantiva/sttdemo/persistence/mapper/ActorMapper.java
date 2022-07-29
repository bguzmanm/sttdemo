package cl.sustantiva.sttdemo.persistence.mapper;

import cl.sustantiva.sttdemo.domain.dto.ActorDTO;
import cl.sustantiva.sttdemo.persistence.entity.Actor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActorMapper {

    @Mappings({
        @Mapping(source = "actorId", target = "actorId"),
        @Mapping(source = "firstName", target = "firstName"),
        @Mapping(source = "lastName", target = "lastName"),
    })
    ActorDTO toActorDTO(Actor actor);
    List<ActorDTO> toActorDTOs(List<Actor> actors);
    @InheritInverseConfiguration
    Actor toActor(ActorDTO actorDTO);
}
