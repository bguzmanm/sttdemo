package cl.sustantiva.sttdemo.persistence.mapper;

import cl.sustantiva.sttdemo.domain.dto.FilmDTO;
import cl.sustantiva.sttdemo.persistence.entity.Film;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FilmMapper {
    
    @Mappings({
            @Mapping(source = "filmId", target = "filmId"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "languageId", target = "languageId"),
            @Mapping(source = "originalLanguageId", target = "originalLanguageId"),
            @Mapping(source = "length", target = "length"),
            @Mapping(source = "releaseYear", target = "releaseYear"),
            @Mapping(source = "rentalRate", target = "rentalRate"),
            @Mapping(source = "rentalDuration", target = "rentalDuration"),
            @Mapping(source = "replacementCost", target = "replacementCost"),
            @Mapping(source = "specialFeatures", target = "specialFeatures"),
            @Mapping(source = "title", target = "title"),
            @Mapping(target = "actors", ignore = true),
    })
    FilmDTO toFilmDTO(Film film);
    List<FilmDTO> toFilmDTOs(List<Film> films);

    @InheritInverseConfiguration
    Film toFilm(FilmDTO filmDTO);
}
