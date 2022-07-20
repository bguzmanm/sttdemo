package cl.sustantiva.sttdemo.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {

    private int estudianteId;
    private String nombre;
    private String apellido;
    private boolean activo;

}
