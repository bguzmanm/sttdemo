package cl.sustantiva.sttdemo.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FilmActorPK implements Serializable {

    @Column(name="actor_id")
    private Integer actorId;
    @Column(name="film_id")
    private Integer filmId;

    public FilmActorPK() {
    }

    public FilmActorPK(Integer actorId, Integer filmId) {
        this.actorId = actorId;
        this.filmId = filmId;
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }
}
