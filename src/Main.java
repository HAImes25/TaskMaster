import Vistas.*;
import Modelos.*;
import Controladores.*;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        VistaAdministradorDeTareas vistaAdministradorDeTareas = new VistaAdministradorDeTareas();
        vistaAdministradorDeTareas.setVisible(true);
        ModeloListaTareas modeloListaTareas = new ModeloListaTareas(new ArrayList<ModeloTarea>());
        tareasTest(modeloListaTareas);
        ControladorAdministradorDeTareas controladorAdministradorDeTareas = new ControladorAdministradorDeTareas(vistaAdministradorDeTareas, modeloListaTareas);




    }
    // Metodo Para crear Tareas para test

    public static void tareasTest(ModeloListaTareas listaTareas){
        ModeloTarea modelotareaTest = new ModeloTarea("Limpiar Casa", "Facil", "Por Empezar");
        ModeloTarea modelotareaTest1 = new ModeloTarea("Estudiar", "Media", "En Proceso");
        ModeloTarea modelotareaTest2 = new ModeloTarea("Lavar los platos", "Facil", "Completada");
        ModeloTarea modelotareaTest3 = new ModeloTarea("Tarea Dificil", "Dificil", "Vencida");
        ModeloTarea modelotareaTest4 = new ModeloTarea("Tarea facil", "facil", "Por Empezar");

        ModeloTarea modelotareaTest5 = new ModeloTarea("Tarea facil", "facil", "Por Empezar");
        ModeloTarea modelotareaTest6 = new ModeloTarea("Tarea facil", "facil", "Por Empezar");
        ModeloTarea modelotareaTest7 = new ModeloTarea("Tarea facil", "facil", "Por Empezar");
        ModeloTarea modelotareaTest8 = new ModeloTarea("Tarea facil", "facil", "Por Empezar");

        listaTareas.agregarTarea(modelotareaTest, listaTareas);
        listaTareas.agregarTarea(modelotareaTest1, listaTareas);
        listaTareas.agregarTarea(modelotareaTest2, listaTareas);
        listaTareas.agregarTarea(modelotareaTest3, listaTareas);
        listaTareas.agregarTarea(modelotareaTest4, listaTareas);

        listaTareas.agregarTarea(modelotareaTest5, listaTareas);
        listaTareas.agregarTarea(modelotareaTest6, listaTareas);
        listaTareas.agregarTarea(modelotareaTest7, listaTareas);
        listaTareas.agregarTarea(modelotareaTest8, listaTareas);
    }






}