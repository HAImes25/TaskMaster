package Controladores;

import Modelos.TareaAina;
import Vistas.VistaModificar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorModificar extends JFrame {

    private ArrayList<TareaAina> listaTareas;
    private VistaModificar vista;
    private TareaAina modelo;

    public ControladorModificar(VistaModificar vista){
        this.vista = vista;
        this.modelo = modelo;
        this.listaTareas = new ArrayList<>();



    this.vista.addCancelarListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            vista.setVisible(false);
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

            }
        });



    }
}
