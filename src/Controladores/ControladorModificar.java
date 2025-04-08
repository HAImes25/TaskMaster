package Controladores;

import Modelos.ModeloTareaHector;
import Modelos.TareaAina;
import Vistas.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorModificar extends JFrame {

    private ArrayList<TareaAina> listaTareas;
    private VistaModificar vista;
    private ModeloTareaHector modelo;

    public ControladorModificar(VistaModificar vistaM, ModeloTareaHector modeloTareaHector) {
        this.vista = vistaM;
        this.modelo = modeloTareaHector;
        this.listaTareas = new ArrayList<>();



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

                //modelo.setTitulo(vista.getTitul());
                //modelo.setDescripcion(vista.getDescripcio());





                // Aquí pots mostrar algun missatge confirmant l'actualització
                System.out.println("Tasca actualitzada");


                //Aqui he de posar que s'apliquin esls canvis a la tarea

                //eliminar este controlador pk sino se crea uno cada vez que le damos a modificar

                }
        });



    }
}
