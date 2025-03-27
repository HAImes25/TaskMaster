package Controladores;
import Vistas.VistaAdministradorDeTareas;
import Modelos.ModeloListaTareas;
import Modelos.ModeloTarea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAdministradorDeTareas {

    // Atributos
    private VistaAdministradorDeTareas vistaAdministradorDeTareas;
    private ModeloListaTareas listaTareas;

    // Constructor
    public ControladorAdministradorDeTareas(VistaAdministradorDeTareas vistaAdministradorDeTareas, ModeloListaTareas listaTareas) {
        this.vistaAdministradorDeTareas = vistaAdministradorDeTareas;
        this.listaTareas = listaTareas;

        vistaAdministradorDeTareas.buttonCrearTareaAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    // Rellenar espacios de tareas
        vistaAdministradorDeTareas.rellenarEspacioPorEmpezar(listaTareas.getListaTareasPorEmpezar(listaTareas));
        vistaAdministradorDeTareas.rellenarEspacioEnProceso(listaTareas.getListaTareasEnProceso(listaTareas));
        vistaAdministradorDeTareas.rellenarEspacioCompletada(listaTareas.getListaTareasCompletada(listaTareas));
        vistaAdministradorDeTareas.rellenarEspacioPorVencida(listaTareas.getListaTareasVencida(listaTareas));





    }
}
