import Controladores.ControladorModificar;
import Modelos.TareaAina;
import Vistas.VistaModificar;

public class Main {
    public static void main(String[] args) {


        VistaModificar vista = new VistaModificar();
        vista.setVisible(true);
        ControladorModificar controlador = new ControladorModificar(vista );
    }
}