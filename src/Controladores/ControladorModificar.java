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

    private ModeloListaTareas listaTareas;
    private VistaModificar vista;
    private ModeloTareaHector modelo;
    private VistaAdministradorDeTareas vistaAdministradorDeTareas;


    public ControladorModificar(VistaModificar vistaM, ModeloTareaHector modeloTareaHector, VistaAdministradorDeTareas vistaAdministradorDeTareas, ModeloListaTareas listaTareas) {
        this.vista = vistaM;
        this.modelo = modeloTareaHector;
        this.vistaAdministradorDeTareas = vistaAdministradorDeTareas;
        this.listaTareas = listaTareas;



        this.vista.addCancelarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cancelando....");
                //JOptionPane.showMessageDialog(null, "Modificación cancelada.");
                //Cerrar/eliminar VentanaModificar
                //Crear ventana AdminTareas Actualizada


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

                vistaAdministradorDeTareas.dispose();

                VistaAdministradorDeTareas vistaAdministradorDeTareas1 = new VistaAdministradorDeTareas();
                vistaAdministradorDeTareas1.setVisible(true);

//
//                vistaAdministradorDeTareas.rellenarEspacioPorEmpezar(listaTareas.getListaTareasPorEmpezar(listaTareas));
//                vistaAdministradorDeTareas.rellenarEspacioEnProceso(listaTareas.getListaTareasEnProceso(listaTareas));
//                vistaAdministradorDeTareas.rellenarEspacioCompletada(listaTareas.getListaTareasCompletada(listaTareas));
//                vistaAdministradorDeTareas.rellenarEspacioPorVencida(listaTareas.getListaTareasVencida(listaTareas));






                //eliminar este controlador pk sino se crea uno cada vez que le damos a modificar


                }
        });



    }
}
