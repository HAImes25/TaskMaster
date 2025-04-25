package Controladores;

import Vistas.*;
import Modelos.*;
import Controladores.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorCrear extends JFrame{

    private ArrayList<ModeloTareaHector> listaTareas;
    private VistaCrear vistaCrear;
    private ModeloTareaHector modeloTarea;
    private VistaAdministradorDeTareas vistaAdministradorDeTareas;


    public ControladorCrear(ArrayList<ModeloTareaHector> listaTareas, VistaCrear vistaCrear, VistaAdministradorDeTareas vistaAdministradorDeTareas){
        this.listaTareas = listaTareas;
        this.vistaCrear = vistaCrear;

        this.vistaAdministradorDeTareas = vistaAdministradorDeTareas;



        this.vistaCrear.addCancelarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaCrear.getFrame().dispose();
                JOptionPane.showMessageDialog(null, "Creación de tarea cancelada.");
                vistaAdministradorDeTareas.setVisible(true);
            }
        });


        this.vistaCrear.addCrearListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("crear");

                //al clicar s'ha de guardar la tarea a la lista tareas




            }
        });
    }
}
