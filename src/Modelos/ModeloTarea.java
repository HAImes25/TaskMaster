package Modelos;

import java.time.format.DateTimeFormatter;

public class ModeloTarea {
    private String titulo;
    private  String usuario;
    private String dificultad;
    private String estado;
    private String frecuencia;
    private DateTimeFormatter fechaInicio;
    private DateTimeFormatter fechaLimite;
    private String descripcion;
    private double experiencia;

    //Acabar constructor  y hacer metodos getters y setters.
    public ModeloTarea(String titulo, String dificultad, String estado, String frecuencia, String descripcion) {
        this.titulo = titulo;
        this.dificultad = dificultad;
        this.estado = estado;
        this.frecuencia = frecuencia;
        this.descripcion = descripcion;
    }

    // Métodos getter y setter
    public String getTitulo() {

        return titulo;
    }

    public void setTitulo(String titulo) {

        this.titulo = titulo;
    }

    public String getDificultad() {

        return dificultad;
    }

    public void setDificultad(String dificultad) {

        this.dificultad = dificultad;
    }

    public String getEstado() {

        return estado;
    }

    public void setEstado(String estado) {

        this.estado = estado;
    }

    public String getFrecuencia() {

        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {

        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Tarea [Titulo = " + titulo + ", Dificultad = " + dificultad + ", Estado = " +
                estado + ", Frecuencia = " + frecuencia + ", Descripcion = " + descripcion + ".]";
    }
}



