
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

        VistaAdministradorDeTareas vistaAdministradorDeTareas = new VistaAdministradorDeTareas(listaTareas, listaTareasPorEmpezar, listaTareasEnProceso, listaTareasCompletadas, listaTareasVencidas);
        vistaAdministradorDeTareas.setVisible(true);



        ControladorAdministradorDeTareas controladorAdministradorDeTareas = new ControladorAdministradorDeTareas(vistaAdministradorDeTareas, listaTareas);

        //VistaRegistro vistaRegistro = new VistaRegistro();
       // ControladorRegistro controladorRegistro = new ControladorRegistro(vistaRegistro);



    }





}