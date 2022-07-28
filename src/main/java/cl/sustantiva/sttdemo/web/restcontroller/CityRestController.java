package cl.sustantiva.sttdemo.web.restcontroller;

import cl.sustantiva.sttdemo.domain.service.CityService;
import cl.sustantiva.sttdemo.persistence.entity.City;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityRestController {

    private final CityService service;

    public CityRestController(CityService service) {
        this.service = service;
    }


    @GetMapping("/{name}")
    public List<City> getCityByName(@PathVariable("name") String name){
        return service.getByName(name);
    }
}
