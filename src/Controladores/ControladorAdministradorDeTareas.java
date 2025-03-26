package Controladores;
import Vistas.VistaAdministradorDeTareas;
import Modelos.ModeloListaTareas;
import Modelos.ModeloTarea;

public class ControladorAdministradorDeTareas {

    // Atributos
    private VistaAdministradorDeTareas vistaAdministradorDeTareas;
    private ModeloTarea tarea;
    private ModeloListaTareas listaTareas;

    // Constructor
    public ControladorAdministradorDeTareas(VistaAdministradorDeTareas vistaAdministradorDeTareas, ModeloTarea tarea, ModeloListaTareas listaTareas) {
        this.vistaAdministradorDeTareas = vistaAdministradorDeTareas;
        this.tarea = tarea;
        this.listaTareas = listaTareas;

    // Rellenar espacios de tareas
        vistaAdministradorDeTareas.rellenarEspacioPorEmpezar(listaTareas.getListaTareasPorEmpezar(listaTareas));




    }
}
