
import Vistas.*;
import Modelos.*;
import Controladores.*;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {


        VistaAdministradorDeTareas vistaAdministradorDeTareas = new VistaAdministradorDeTareas();
        vistaAdministradorDeTareas.setVisible(true);
        ModeloListaTareas modeloListaTareas = new ModeloListaTareas(new ArrayList<ModeloTareaHector>());
        tareasTest(modeloListaTareas);
        ControladorAdministradorDeTareas controladorAdministradorDeTareas = new ControladorAdministradorDeTareas(vistaAdministradorDeTareas, modeloListaTareas);

    }
    // Metodo Para crear Tareas para test

    public static void tareasTest(ModeloListaTareas listaTareas){
        ModeloTareaHector modelotareaTest = new ModeloTareaHector("Limpiar Casa", "Facil", "Por Empezar");
        ModeloTareaHector modelotareaTest1 = new ModeloTareaHector("Estudiar", "Media", "En Proceso");
        ModeloTareaHector modelotareaTest2 = new ModeloTareaHector("Lavar los platos", "Facil", "Completada");
        ModeloTareaHector modelotareaTest3 = new ModeloTareaHector("Tarea Dificil", "Dificil", "Vencida");
        ModeloTareaHector modelotareaTest4 = new ModeloTareaHector("Tarea facil", "Facil", "Por Empezar");

        ModeloTareaHector modelotareaTest5 = new ModeloTareaHector("Tarea facil", "Facil", "En Proceso");
        ModeloTareaHector modelotareaTest6 = new ModeloTareaHector("Tarea Media", "Media", "En Proceso");
        ModeloTareaHector modelotareaTest7 = new ModeloTareaHector("Tarea facil", "Facil", "Por Empezar");
        ModeloTareaHector modelotareaTest8 = new ModeloTareaHector("Tarea facil", "Facil", "Por Empezar");

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