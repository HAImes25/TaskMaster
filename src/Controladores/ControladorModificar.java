package Controladores;

import Modelos.ModeloListaTareas;
import Modelos.ModeloTareaHector;
import Modelos.TareaAina;
import Vistas.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorModificar extends JFrame {

    private ArrayList<ModeloTareaHector> listaTareas;
    private VistaModificar vista;
    private ModeloTareaHector modelo;
    private VistaAdministradorDeTareas vistaAdministradorDeTareas;


    public ControladorModificar(VistaModificar vistaM, ModeloTareaHector modeloTareaHector, VistaAdministradorDeTareas vistaAdministradorDeTareas, ArrayList<ModeloTareaHector> listaTareas) {
        this.vista = vistaM;
        this.modelo = modeloTareaHector;
        this.vistaAdministradorDeTareas = vistaAdministradorDeTareas;
        this.listaTareas = listaTareas;


        // Combobox Predeterminado


        vista.getComboBoxEstadoCombo().setSelectedItem(modelo.getEstado());



        this.vista.addCancelarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cancelando....");
                vista.getFrame().dispose();

            //VentanaPrincipal.setVisible(true);
                //((JFrame)SwingUtilities.getWindowAncestor(panelModificar)).dispose();
                //});
                // Tornar a Finestra principal

            }
        });

        this.vista.addAplicarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                modelo.setTitulo(vista.getTitul());    // Titulo
                modelo.setDificultad(vista.getComboBoxDificultad());   // Dificultad
                //Calendario tadavia no lo ponemos
                modelo.setEstado(vista.getComboBoxEstado());   // Estado
                System.out.println(vista.getComboBoxEstado() + " Este es el estado ");
                modelo.setFrecuencia(vista.getComboBoxFrecuencia());  //Frecuencia
                //Hota revisoon  tadavia no lo ponemos
                modelo.setDescripcion(vista.getDescripcion());



                // Aquí pots mostrar algun missatge confirmant l'actualització
                System.out.println("Tasca actualitzada");


                System.out.println(modelo.getTitulo());
                System.out.println(vista.getComboBoxDificultad());
                System.out.println(vista.getComboBoxEstado());
                System.out.println(vista.getComboBoxFrecuencia());
                System.out.println(modelo.getDescripcion());

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



                vistaAdministradorDeTareas.dispose();


                VistaAdministradorDeTareas vistaAdministradorDeTareas1 = new VistaAdministradorDeTareas(listaTareas,vistaAdministradorDeTareas.getListaTareasPorEmpezar(), vistaAdministradorDeTareas.getListaTareasEnProceso(), vistaAdministradorDeTareas.getListaTareasCompletada(), vistaAdministradorDeTareas.getListaTareasVencida());
                vistaAdministradorDeTareas1.rellenarEspacioPorEmpezar();
                vistaAdministradorDeTareas1.rellenarEspacioEnProceso();
                vistaAdministradorDeTareas1.rellenarEspacioCompletada();
                vistaAdministradorDeTareas1.rellenarEspacioPorVencida();
                vistaAdministradorDeTareas1.setVisible(true);








                //eliminar este controlador pk sino se crea uno cada vez que le damos a modificar


                }
        });





    }
}
