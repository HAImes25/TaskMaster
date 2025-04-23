
import Vistas.*;
import Modelos.*;
import Controladores.*;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {



        //ModeloListaTareas modeloListaTareas = new ModeloListaTareas(new ArrayList<ModeloTareaHector>());
        ArrayList<ModeloTareaHector> listaTareas = new ArrayList<ModeloTareaHector>();
        tareasTest(listaTareas);

        VistaAdministradorDeTareas vistaAdministradorDeTareas = new VistaAdministradorDeTareas(listaTareas);
        vistaAdministradorDeTareas.setVisible(true);

        ControladorAdministradorDeTareas controladorAdministradorDeTareas = new ControladorAdministradorDeTareas(vistaAdministradorDeTareas, listaTareas);

    }
    // Metodo Para crear Tareas para test

    public static void tareasTest(ArrayList<ModeloTareaHector> listaTareas){
        ModeloTareaHector modelotareaTest = new ModeloTareaHector("Limpiar Casa", "Facil", "Por Empezar");
        ModeloTareaHector modelotareaTest1 = new ModeloTareaHector("Estudiar", "Media", "En Proceso");
        ModeloTareaHector modelotareaTest2 = new ModeloTareaHector("Lavar los platos", "Facil", "Completada");
        ModeloTareaHector modelotareaTest3 = new ModeloTareaHector("Tarea Dificil", "Dificil", "Vencida");
        ModeloTareaHector modelotareaTest4 = new ModeloTareaHector("Tarea facil", "Facil", "Por Empezar");

        ModeloTareaHector modelotareaTest5 = new ModeloTareaHector("Tarea facil", "Facil", "En Proceso");
        ModeloTareaHector modelotareaTest6 = new ModeloTareaHector("Tarea Media", "Media", "En Proceso");
        ModeloTareaHector modelotareaTest7 = new ModeloTareaHector("Tarea facil", "Facil", "Por Empezar");
        ModeloTareaHector modelotareaTest8 = new ModeloTareaHector("Tarea facil", "Facil", "Por Empezar");

        listaTareas.add(modelotareaTest);
        listaTareas.add(modelotareaTest1);
        listaTareas.add(modelotareaTest2);
        listaTareas.add(modelotareaTest3);
        listaTareas.add(modelotareaTest4);

        listaTareas.add(modelotareaTest5);
        listaTareas.add(modelotareaTest6);
        listaTareas.add(modelotareaTest7);
        listaTareas.add(modelotareaTest8);
    }






}