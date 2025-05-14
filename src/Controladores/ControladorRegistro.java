package Controladores;

import Vistas.VistaRegistro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorRegistro {

    private VistaRegistro vistaRegistro;

    public ControladorRegistro(VistaRegistro vistaRegistro) {
        this.vistaRegistro = vistaRegistro;



        vistaRegistro.setVisible(true);


        vistaRegistro.addActionBotonAceptar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre =  vistaRegistro.getJTextNombre();
                String contraseña = vistaRegistro.getJTextContraseña();
                String contraseñaConfi = vistaRegistro.getJTextConfirmarContraseña();
                String email = vistaRegistro.getJTextEmail();

                String sqlRegistro = "INSERT INTO `usuaris` " +
                        "(`id`, " +
                        "`nickname`, " +
                        "`password`, `email`, " +
                        "`exp`, " +
                        "`nivells_id`) " +
                        "VALUES (NULL, ?, ?, ?, ?, ?);";






            }
        });



    }
}
