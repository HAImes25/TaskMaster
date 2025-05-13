
import Vistas.*;
import Vistas.*;
import Modelos.*;
import Controladores.*;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
//        ArrayList<ModeloListaTareas> listaImagenes = new ArrayList<ModeloListaTareas>();
//        VistaAdministradorDeTareas vistaImagenes = new VistaAdministradorDeTareas();
//        vistaImagenes.setVisible(true);
//        ModeloListaTareas = new ModeloListaTareas("Loro", "loro.jpg", listaImagenes);
//        ModeloImagen modeloImagenGirasol = new ModeloImagen("Girasol", "girasol.png", listaImagenes);
//        ModeloImagen modeloImagenRosa = new ModeloImagen("Rosa", "rosa.png", listaImagenes);




        //ModeloListaTareas modeloListaTareas = new ModeloListaTareas(new ArrayList<ModeloTareaHector>());
        ArrayList<ModeloTareaHector> listaTareas = new ArrayList<ModeloTareaHector>();
        ArrayList<ModeloTareaHector> listaTareasPorEmpezar = new ArrayList<ModeloTareaHector>();
        ArrayList<ModeloTareaHector> listaTareasEnProceso = new ArrayList<ModeloTareaHector>();
        ArrayList<ModeloTareaHector> listaTareasCompletadas = new ArrayList<ModeloTareaHector>();
        ArrayList<ModeloTareaHector> listaTareasVencidas = new ArrayList<ModeloTareaHector>();
        tareasTest(listaTareas, listaTareasPorEmpezar, listaTareasEnProceso, listaTareasCompletadas, listaTareasVencidas);

        VistaAdministradorDeTareas vistaAdministradorDeTareas = new VistaAdministradorDeTareas(listaTareas, listaTareasPorEmpezar, listaTareasEnProceso, listaTareasCompletadas, listaTareasVencidas);
        vistaAdministradorDeTareas.setVisible(true);



        ControladorAdministradorDeTareas controladorAdministradorDeTareas = new ControladorAdministradorDeTareas(vistaAdministradorDeTareas, listaTareas);

    }
    // Metodo Para crear Tareas para test

    public static void tareasTest(ArrayList<ModeloTareaHector> listaTareas, ArrayList<ModeloTareaHector> listaTareasPorEmpezar, ArrayList<ModeloTareaHector> listaTareasEnProceso, ArrayList<ModeloTareaHector> listaTareasCompletada, ArrayList<ModeloTareaHector> listaTareasVencida){
        ModeloTareaHector modelotareaTest = new ModeloTareaHector("Limpiar Casa", "Facil", "Por empezar", "Diaria");
        ModeloTareaHector modelotareaTest1 = new ModeloTareaHector("Estudiar", "Media", "En proceso", "Única");
        ModeloTareaHector modelotareaTest2 = new ModeloTareaHector("Lavar los platos", "Facil", "Completada", "Mensual");
        ModeloTareaHector modelotareaTest3 = new ModeloTareaHector("Tarea Dificil", "Dificil", "Vencida", "Semanal");
        ModeloTareaHector modelotareaTest4 = new ModeloTareaHector("Tarea facil", "Facil", "Por empezar", "Diaria");

        ModeloTareaHector modelotareaTest5 = new ModeloTareaHector("Tarea facil", "Facil", "En proceso", "Única");
        ModeloTareaHector modelotareaTest6 = new ModeloTareaHector("Tarea Media", "Media", "En proceso", "Diaria");
        ModeloTareaHector modelotareaTest7 = new ModeloTareaHector("Tarea facil", "Facil", "Por empezar", "Semanal");
        ModeloTareaHector modelotareaTest8 = new ModeloTareaHector("Tarea facil", "Facil", "Por empezar", "Diaria");

        listaTareas.add(modelotareaTest);
        listaTareasPorEmpezar.add(modelotareaTest);

        listaTareas.add(modelotareaTest1);
        listaTareasEnProceso.add(modelotareaTest1);

        listaTareas.add(modelotareaTest2);
        listaTareasCompletada.add(modelotareaTest2);

        listaTareas.add(modelotareaTest3);
        listaTareasVencida.add(modelotareaTest3);

        listaTareas.add(modelotareaTest4);
        listaTareasPorEmpezar.add(modelotareaTest4);

        listaTareas.add(modelotareaTest5);
        listaTareasEnProceso.add(modelotareaTest5);


        listaTareas.add(modelotareaTest6);
        listaTareasEnProceso.add(modelotareaTest6);

        listaTareas.add(modelotareaTest7);
        listaTareasPorEmpezar.add(modelotareaTest7);

        listaTareas.add(modelotareaTest8);
        listaTareasPorEmpezar.add(modelotareaTest8);

    }






}