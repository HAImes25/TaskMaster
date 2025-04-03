package Controladores;

import Vista.VistaCrearTarea;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaCrear {
    private  testCont modelo;
    private VistaCrearTarea vista;

    public ventanaCrear(testCont modelo, VistaCrearTarea vista){
            this.modelo = modelo;
            this.vista = vista;

        this.vista.crearButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.(vista.());
                modelo.setPrecio(Double.parseDouble(vista.getPrecio()));
                vista.setResultado("Producto: " + modelo.getNombre() + " | Precio: " + modelo.getPrecio() + "€");
            }
        });
    }

}
