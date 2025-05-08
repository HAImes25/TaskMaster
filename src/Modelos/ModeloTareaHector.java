package Modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ModeloTareaHector {
    String titulo = "";
    String dificultad = "";
    String estado = "";
    private String frecuencia;
    LocalDateTime fechaFinal = LocalDateTime.now();
    LocalDateTime fechaInicial = LocalDateTime.now();
    String descripcion = "";

    private static final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SS");

    public ModeloTareaHector(String nombre, String dificultad, String estado, String frecuencia){
        this.titulo = nombre;
        this.dificultad = dificultad;
        this.estado = estado;
        this.frecuencia = frecuencia;
        this.fechaFinal = LocalDateTime.now();

    }


    // Get - Set
    public String getTitulo() {
        return titulo.trim();
    }

    public String getDificultad() {
        return dificultad.trim();
    }

    public String getEstado() {
        return estado.trim();
    }

    public String getFechaFinal() {
        return fechaFinal.format(formatoFecha);
    }

    public String getFechaInici() {
        return fechaInicial.format(formatoFecha);
    }


    public String getDescripcion() {
        return descripcion;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setTitulo(String nombre) {
        this.titulo = nombre;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fechaFinal = fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String imprimemeLaTarea() {
        return "Tarea [Titulo = " + titulo + ", Dificultad = " + dificultad + ", Estado = " + estado + ", Frecuencia = " + frecuencia + ", Descripcion = " + descripcion + ".]";
    }




}
