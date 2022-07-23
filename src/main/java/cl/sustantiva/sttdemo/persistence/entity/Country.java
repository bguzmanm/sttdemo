package cl.sustantiva.sttdemo.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="country")
public class Country {

    @Id
    @Column(name="country_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer countryId;

    private String country;

    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER)
    private List<City> cities;

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
