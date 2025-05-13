package Modelos;

import java.util.ArrayList;

public class ModeloListaTareas {

    // Atributos
    ArrayList<ModeloTareaHector> listaTareas = new ArrayList<ModeloTareaHector>();
    private String nombre = "";
    private String path = "";

    // Constructor
    public ModeloListaTareas(ArrayList<ModeloTareaHector> listaTareas, String nombre, String path, ArrayList<ModeloListaTareas> listaImagenes){
        this.listaTareas = listaTareas;
        this.nombre = nombre;
        this.path = path;
        agregarImgLista(listaImagenes);
    }

    // Metodos

    public void agregarImgLista(ArrayList<ModeloListaTareas> listaImagenes){
        listaImagenes.add(this);
    }

    public ArrayList<ModeloTareaHector> getListaTareasPorEmpezar(ModeloListaTareas listaTareas){
        ArrayList<ModeloTareaHector> listaTareasPorEmpezar = new ArrayList<ModeloTareaHector>();
        for (ModeloTareaHector tarea : listaTareas.listaTareas){
            if (tarea.getEstado() == "Por Empezar"){
                listaTareasPorEmpezar.add(tarea);
            }
        }
        return listaTareasPorEmpezar;
    }

    public ArrayList<ModeloTareaHector> getListaTareasEnProceso(ModeloListaTareas listaTareas){
        ArrayList<ModeloTareaHector> listaTareasEnProceso = new ArrayList<ModeloTareaHector>();
        for (ModeloTareaHector tarea : listaTareas.listaTareas){
            if (tarea.getEstado() == "En Proceso"){
                listaTareasEnProceso.add(tarea);
            }
        }
        return listaTareasEnProceso;
    }

    public ArrayList<ModeloTareaHector> getListaTareasCompletada(ModeloListaTareas listaTareas){
        ArrayList<ModeloTareaHector> listaTareasCompletada = new ArrayList<ModeloTareaHector>();
        for (ModeloTareaHector tarea : listaTareas.listaTareas){
            if (tarea.getEstado() == "Completada"){
                listaTareasCompletada.add(tarea);
            }
        }
        return listaTareasCompletada;
    }

    public ArrayList<ModeloTareaHector> getListaTareasVencida(ModeloListaTareas listaTareas){
        ArrayList<ModeloTareaHector> listaTareasVencida = new ArrayList<ModeloTareaHector>();
        for (ModeloTareaHector tarea : listaTareas.listaTareas){
            if (tarea.getEstado() == "Vencida"){
                listaTareasVencida.add(tarea);
            }
        }
        return listaTareasVencida;
    }


    public void agregarTarea(ModeloTareaHector tarea, ModeloListaTareas listaTareas){
        listaTareas.listaTareas.add(tarea);
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
