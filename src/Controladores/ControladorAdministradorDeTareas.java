package Controladores;
import Modelos.ModeloTareaHector;
import Vistas.VistaAdministradorDeTareas;
import Modelos.ModeloListaTareas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorAdministradorDeTareas {

    // Atributos
    private VistaAdministradorDeTareas vistaAdministradorDeTareas;
    private ModeloListaTareas listaTareas;

    // Constructor
    public ControladorAdministradorDeTareas(VistaAdministradorDeTareas vistaAdministradorDeTareas,  ArrayList<ModeloTareaHector> listTareas) {
        this.vistaAdministradorDeTareas = vistaAdministradorDeTareas;
        this.listaTareas = listaTareas;

        vistaAdministradorDeTareas.buttonCrearTareaAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Aqui iria la conexion a la ventana de crear Tarea
            }
        });

    // Rellenar espacios de tareas
        vistaAdministradorDeTareas.rellenarEspacioPorEmpezar();
//        vistaAdministradorDeTareas.rellenarEspacioEnProceso();
//        vistaAdministradorDeTareas.rellenarEspacioCompletada();
//        vistaAdministradorDeTareas.rellenarEspacioPorVencida();




    }


}
