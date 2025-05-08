package Controladores;
import Modelos.ModeloTareaHector;
import Vistas.VistaAdministradorDeTareas;
import Modelos.ModeloListaTareas;
import Vistas.VistaCrear;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorAdministradorDeTareas {

    // Atributos
    private VistaAdministradorDeTareas vistaAdministradorDeTareas;
    private ModeloListaTareas listaTareas;
    //private VistaCrear vistaCrear;

    // Constructor
    public ControladorAdministradorDeTareas(VistaAdministradorDeTareas vistaAdministradorDeTareas,  ArrayList<ModeloTareaHector> listTareas) {
        this.vistaAdministradorDeTareas = vistaAdministradorDeTareas;
        this.listaTareas = listaTareas;
        //this.vistaCrear = vistaCrear;

        vistaAdministradorDeTareas.buttonCrearTareaAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                VistaCrear vistaCrear = new VistaCrear();
                vistaAdministradorDeTareas.setVisible(false);
                ModeloTareaHector tarea = new ModeloTareaHector("", "", "", "");
                ControladorCrear controladorCrear = new ControladorCrear(listTareas, vistaCrear, vistaAdministradorDeTareas);

            }
        });

    // Rellenar espacios de tareas
        vistaAdministradorDeTareas.rellenarEspacioPorEmpezar();
        vistaAdministradorDeTareas.rellenarEspacioEnProceso();
        vistaAdministradorDeTareas.rellenarEspacioCompletada();
        vistaAdministradorDeTareas.rellenarEspacioPorVencida();




    }


}
