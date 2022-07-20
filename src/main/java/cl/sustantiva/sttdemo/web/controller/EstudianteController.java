package cl.sustantiva.sttdemo.web.controller;

import cl.sustantiva.sttdemo.domain.service.EstudianteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class EstudianteController {

    EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @GetMapping
    public String getEstudiantes(Model model){
        model.addAttribute("students", service.getAll());
        return "students";
    }

}
