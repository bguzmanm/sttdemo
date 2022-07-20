package cl.sustantiva.sttdemo.domain.service;

import cl.sustantiva.sttdemo.persistence.entity.Estudiante;
import cl.sustantiva.sttdemo.web.controller.InicioController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstudianteService {

    Log logger = LogFactory.getLog(InicioController.class);
    public List<Estudiante> getAll(){
        logger.warn("aquí toy!");

        List<Estudiante> lista = new ArrayList<Estudiante>();

        lista.add(new Estudiante(1, "Ciro", "Cortez", true));
        lista.add(new Estudiante(2, "Leandra", "Minerva", true));
        lista.add(new Estudiante(3, "Annan", "Rojas", true));
        lista.add(new Estudiante(4, "José", "Gregorio", true));
        lista.add(new Estudiante(5, "José", "Manuel", true));

        return lista;
    }
}
