package Controladores;

import ConexionesBD.ConexionBD;
import Modelos.ModeloTareaHector;
import Vistas.VistaAdministradorDeTareas;
import Vistas.VistaInicioSesion.VistaInicioSesion;
import Vistas.VistaRegistro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorInicioSesion {

    private VistaInicioSesion vistaInicioSesion;

    public ControladorInicioSesion(VistaInicioSesion vistaInicioSesion, ArrayList<ModeloTareaHector> listTareas) {
        this.vistaInicioSesion = vistaInicioSesion;

        vistaInicioSesion.addActionBotonRegistro(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                VistaRegistro vistaRegistro = new VistaRegistro();
                ControladorRegistro controladorRegistro = new ControladorRegistro(vistaRegistro, listTareas);
                vistaInicioSesion.dispose();

            }
        });


        vistaInicioSesion.addActionBotonAceptar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                vistaInicioSesion.mensajeError("");
                String nombre =  vistaInicioSesion.getNombreText();
                String contraseña = vistaInicioSesion.getContraseñaText();

                String sqlNombre = "SELECT * FROM `usuaris` WHERE nickname = ?";
                String sqlCompleto = "SELECT * FROM `usuaris` WHERE nickname = ? AND password = ?";

                StringBuilder resultado = new StringBuilder();

                for (int i = 0; i < contraseña.length(); i++) {
                    char c = contraseña.charAt(i);
                    int ascii = (int) c;
                    resultado.append(ascii);

                    if (i < contraseña.length() - 1) {
                        resultado.append("-");
                    }
                }

                if (vistaInicioSesion.comprobarCampos()){

                    try (Connection conn = ConexionBD.conectar();
                         PreparedStatement stmn = conn.prepareStatement(sqlNombre)) {

                        stmn.setString(1, nombre); // Modificar sql

                        ResultSet rsn = stmn.executeQuery();// Ejecutamos la Consulta

                        if (rsn.next()){
                            try (Connection conn2 = ConexionBD.conectar();
                                 PreparedStatement stmc = conn.prepareStatement(sqlCompleto)) {

                                stmc.setString(1, nombre); // Modificar sql
                                stmc.setString(2, resultado.toString()); // Modificar sql

                                ResultSet rsc = stmc.executeQuery();// Ejecutamos la Consulta

                                if (rsc.next()){

                                    VistaAdministradorDeTareas vistaAdministradorDeTareas = new VistaAdministradorDeTareas(rsc.getInt("id"));
                                    vistaAdministradorDeTareas.setVisible(true);
                                    ControladorAdministradorDeTareas controladorAdministradorDeTareas = new ControladorAdministradorDeTareas(vistaAdministradorDeTareas, listTareas);

                                    vistaInicioSesion.dispose();

                                }else {
                                    vistaInicioSesion.mensajeError("Contraseña incorrecta");
                                }


                            } catch (SQLException l) {

                                l.printStackTrace();
                                throw new RuntimeException("Contraseña no son iguales");

                            }









                        }else{
                            vistaInicioSesion.mensajeError("Usuario inexistente");
                        }


                    } catch (SQLException l) {

                        l.printStackTrace();
                        throw new RuntimeException("Usuario no encontrado");

                    }




                }




            }
        });







    }
}
