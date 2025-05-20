package Modelos;

import java.util.ArrayList;

public class ModeloImagen {

    private String nombre = "";
    private String path = "";

    public ModeloImagen(String nombre, String path, ArrayList<ModeloImagen> listaImagenes) {
        this.nombre = nombre;
        this.path = path;
        agregarImgLista(listaImagenes);

    }

    public void agregarImgLista(ArrayList<ModeloImagen> listaImagenes){
        listaImagenes.add(this);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPath() {
        return path;
    }



}


