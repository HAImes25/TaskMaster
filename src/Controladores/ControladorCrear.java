package Controladores;

import Vistas.*;
import Modelos.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCrear {

    private ModeloListaTareas listaTareas;
    private VistaCrear vistaCrear;
    private ModeloTareaHector modeloTarea;
    private VistaAdministradorDeTareas vistaAdministradorDeTareas;


    public ControladorCrear(ModeloListaTareas listaTareas, VistaCrear vistaCrear, ModeloTareaHector modeloTarea, VistaAdministradorDeTareas vistaAdministradorDeTareas){
        this.listaTareas = listaTareas;
        this.vistaCrear = vistaCrear;
        this.modeloTarea = modeloTarea;
        this.vistaAdministradorDeTareas = vistaAdministradorDeTareas;



        this.vistaCrear.addCancelarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cancelando....");
                JOptionPane.showMessageDialog(null, "Creación de tarea cancelada.");
                vistaAdministradorDeTareas.setVisible(true);
                vistaCrear.setVisible(false);
            }
        });
    }
}
