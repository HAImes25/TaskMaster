package Modelos;

import javax.swing.*;
import java.util.ArrayList;

public class ModeloListaTareas {

    // Atributos
    ArrayList<ModeloTarea> listaTareas = new ArrayList<ModeloTarea>();


    // Constructor
    public ModeloListaTareas(ArrayList<ModeloTarea> listaTareas){
        this.listaTareas = listaTareas;
    }

    // Metodos
    public ArrayList<ModeloTarea> getListaTareasPorEmpezar(ModeloListaTareas listaTareas){
        ArrayList<ModeloTarea> listaTareasPorEmpezar = new ArrayList<ModeloTarea>();
        for (ModeloTarea tarea : listaTareas.listaTareas){
            if (tarea.getEstado() == "Por Empezar"){
                listaTareasPorEmpezar.add(tarea);
            }
        }
        return listaTareasPorEmpezar;
    }

    public ArrayList<ModeloTarea> getListaTareasEnProceso(ModeloListaTareas listaTareas){
        ArrayList<ModeloTarea> listaTareasEnProceso = new ArrayList<ModeloTarea>();
        for (ModeloTarea tarea : listaTareas.listaTareas){
            if (tarea.getEstado() == "En Proceso"){
                listaTareasEnProceso.add(tarea);
            }
        }
        return listaTareasEnProceso;
    }

    public ArrayList<ModeloTarea> getListaTareasCompletada(ModeloListaTareas listaTareas){
        ArrayList<ModeloTarea> listaTareasCompletada = new ArrayList<ModeloTarea>();
        for (ModeloTarea tarea : listaTareas.listaTareas){
            if (tarea.getEstado() == "Completada"){
                listaTareasCompletada.add(tarea);
            }
        }
        return listaTareasCompletada;
    }

    public ArrayList<ModeloTarea> getListaTareasVencida(ModeloListaTareas listaTareas){
        ArrayList<ModeloTarea> listaTareasVencida = new ArrayList<ModeloTarea>();
        for (ModeloTarea tarea : listaTareas.listaTareas){
            if (tarea.getEstado() == "Vencida"){
                listaTareasVencida.add(tarea);
            }
        }
        return listaTareasVencida;
    }


    public void agregarTarea(ModeloTarea tarea, ModeloListaTareas listaTareas){
        listaTareas.listaTareas.add(tarea);
    }



}
