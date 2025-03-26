package Controladores;

import Modelos.Tarea;
import Vistas.VistaModificar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorModificar {

    private ArrayList<Tarea> listaTareas;
    private VistaModificar vista;
    private Tarea modelo;

    public ControladorModificar(VistaModificar vista, Tarea modelo){
        this.vista = vista;
        this.modelo = modelo;
        this.listaTareas = new ArrayList<>();



    this.vista.addCancelarListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Aqui he de posar que torni a la finestra principal al clicar el boto de cancelar
        }
    });

    this.vista.addAplicarListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Aqui he de posar que s'apliquin esls canvis a la tarea

        }
    });

    }







}
