package cl.sustantiva.sttdemo.web.controller;

import cl.sustantiva.sttdemo.domain.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/city")
public class CityController {

    private final CityService service;

    public CityController(CityService service) {
        this.service = service;
    }


    @GetMapping("/all/country/{id}")
    public String getAll(@PathVariable("id") int countryId, Model model){
        model.addAttribute("cities", service.getByCountry(countryId));
        return "listCities";
    }
    @GetMapping("/all")
    public String getAll(Model model){
        model.addAttribute("cities", service.getAll());
        return "listCities";
    }

}
