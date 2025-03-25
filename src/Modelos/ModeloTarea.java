package Modelos;

import java.time.LocalDateTime;

public class ModeloTarea {
    String nombre = "";
    String dificultad = "";
    String estado = "";
    LocalDateTime fecha = LocalDateTime.now();

    public ModeloTarea(String nombre, String dificultad, String estado){
        this.nombre = nombre;
        this.dificultad = dificultad;
        this.estado = estado;
        this.fecha = LocalDateTime.now();
    }


    // Get - Set
    public String getNombre() {
        return nombre;
    }

    public String getDificultad() {
        return dificultad;
    }

    public String getEstado() {
        return estado;
    }

    public LocalDateTime getFecha() {
        return fecha;
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
