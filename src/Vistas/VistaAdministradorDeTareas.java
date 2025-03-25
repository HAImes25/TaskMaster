package Vistas;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VistaAdministradorDeTareas extends JFrame{

    // Atributos
    private JPanel panelAdministradorDeTareas;
    private JButton buttonCrearTarea;
    private JPanel panelPorEmpezar;
    private JPanel panelEnProceso;
    private JPanel panelCompletada;
    private JPanel panelVencida;
    private JPanel panelIconos;

    // Constructor
    public VistaAdministradorDeTareas(){

        //Crear Ventana
        setTitle("Administrador de Tareas");
        setSize(300, 230);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(panelAdministradorDeTareas);

    }

    // Listeners
    public void buttonCrearTareaAddActionListener(ActionListener listener){
        buttonCrearTarea.addActionListener(listener);
    }



}
