package Modelos;

import Vistas.VistaModificar;
import Controladores.ControladorModificar;

public class TareaAina {

        private String titulo;
        private String dificultad;
        private String estado;
        private String frecuencia;
        private String descripcion;

        // Constructor
        public TareaAina(String titulo, String dificultad, String estado, String frecuencia, String descripcion) {
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
            return "Tarea [titulo=" + titulo + ", dificultad=" + dificultad + ", estado=" + estado + ", frecuencia=" + frecuencia + ", descripcion=" + descripcion + "]";
        }
    }


