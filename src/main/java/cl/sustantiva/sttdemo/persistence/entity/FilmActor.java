package cl.sustantiva.sttdemo.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="film_actor")
public class FilmActor {

    @EmbeddedId
    private FilmActorPK id;
    @Column(name="last_update")
    private LocalDate lastUpdate;

    @ManyToOne
    @JoinColumn(name = "actor_id", insertable = false, updatable = false)
    private Actor actor;

    @ManyToOne
    @JoinColumn(name = "film_id", insertable = false, updatable = false)
    private Film film;

    public FilmActorPK getId() {
        return id;
    }

    public void setId(FilmActorPK id) {
        this.id = id;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }


}
