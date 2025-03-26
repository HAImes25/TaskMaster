import Vistas.*;
import Modelos.*;
import Controladores.*;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        VistaAdministradorDeTareas vistaAdministradorDeTareas = new VistaAdministradorDeTareas();
        vistaAdministradorDeTareas.setVisible(true);
        ModeloTarea modelotareaTest = new ModeloTarea("Limpiar Casa", "Facil", "Por Empezar");
        ModeloListaTareas modeloListaTareas = new ModeloListaTareas(new ArrayList<ModeloTarea>());
        modeloListaTareas.agregarTarea(modelotareaTest, modeloListaTareas);
        ControladorAdministradorDeTareas controladorAdministradorDeTareas = new ControladorAdministradorDeTareas(vistaAdministradorDeTareas, modelotareaTest, modeloListaTareas);



    }
}