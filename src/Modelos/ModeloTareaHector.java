package Modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ModeloTareaHector {
    String nombre = "";
    String dificultad = "";
    String estado = "";
    LocalDateTime fecha = LocalDateTime.now();

    private static final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public ModeloTareaHector(String nombre, String dificultad, String estado){
        this.nombre = nombre;
        this.dificultad = dificultad;
        this.estado = estado;
        this.fecha = LocalDateTime.now();
    }


    // Get - Set
    public String getNombre() {
        return nombre.trim();
    }

    public String getDificultad() {
        return dificultad.trim();
    }

    public String getEstado() {
        return estado.trim();
    }

    public String getFecha() {
        return fecha.format(formatoFecha);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }


}
