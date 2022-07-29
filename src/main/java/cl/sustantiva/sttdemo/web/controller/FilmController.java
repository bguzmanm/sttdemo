package cl.sustantiva.sttdemo.web.controller;

import cl.sustantiva.sttdemo.domain.service.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/film")
public class FilmController {

    private final FilmService service;

    public FilmController(FilmService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public String getAllFilms(Model model){

        model.addAttribute("films", service.getAll());
        return "listFilms";
    }
}
