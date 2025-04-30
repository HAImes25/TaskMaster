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


                //No funciona el problema esta en alguna cosa del modeloTareaHector
                modeloTarea.setTitulo(vistaCrear.getTitul());
                System.out.println("Titulo");
                modeloTarea.setDificultad(vistaCrear.getComboBoxDificultad());
                System.out.println("dificultad");
                //modeloTarea.getEstado(vistaCrear.getComboBoxEstado());
                modeloTarea.setFrecuencia(vistaCrear.getComboBoxFrecuencia());
                System.out.println("frecuencia");



                vistaAdministradorDeTareas.getListaTareasPorEmpezar().clear();
                vistaAdministradorDeTareas.getListaTareasEnProceso().clear();
                vistaAdministradorDeTareas.getListaTareasCompletada().clear();
                vistaAdministradorDeTareas.getListaTareasVencida().clear();


                for (int i = 0; i < listaTareas.size(); i++) {
                    if (listaTareas.get(i).getEstado() == "Por empezar"){
                        vistaAdministradorDeTareas.getListaTareasPorEmpezar().add(listaTareas.get(i));

                    } else if (listaTareas.get(i).getEstado() == "En proceso") {
                        vistaAdministradorDeTareas.getListaTareasEnProceso().add(listaTareas.get(i));

                    }else if (listaTareas.get(i).getEstado() == "Completada"){
                        vistaAdministradorDeTareas.getListaTareasCompletada().add(listaTareas.get(i));

                    } else if (listaTareas.get(i).getEstado() == "Vencida") {
                        vistaAdministradorDeTareas.getListaTareasVencida().add(listaTareas.get(i));
                    }
                }





                //al clicar s'ha de guardar la tarea a la lista tareas




            }
        });
    }
}
