import Controladores.ControladorModificar;
import Modelos.TareaAina;
import Vistas.*;

public class Main {
    public static void main(String[] args) {

        VistaModificar vista = new VistaModificar();
        ControladorModificar controlador = new ControladorModificar(vista);

        
    }
}