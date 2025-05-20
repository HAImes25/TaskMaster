package Controladores;

import ConexionesBD.ConexionBD;
import Modelos.ModeloTareaHector;
import Vistas.VistaInicioSesion;
import Vistas.VistaRegistro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorRegistro {

    private VistaRegistro vistaRegistro;

    public ControladorRegistro(VistaRegistro vistaRegistro, ArrayList<ModeloTareaHector> listTareas) {
        this.vistaRegistro = vistaRegistro;



        vistaRegistro.setVisible(true);


        vistaRegistro.addActionBotonAceptar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaRegistro.mesajeError("");
                String nombre =  vistaRegistro.getJTextNombre();
                String contraseña = vistaRegistro.getJTextContraseña();
                String contraseñaConfi = vistaRegistro.getJTextConfirmarContraseña();
                String email = vistaRegistro.getJTextEmail();

                String sqlRegistro = "INSERT INTO `usuaris` " +
                        "(`id`, " +
                        "`nickname`, " +
                        "`password`, " +
                        "`email`, " +
                        "`exp`, " +
                        "`nivells_id`," +
                        "`rol`) " +
                        "VALUES (NULL, ?, ?, ?, ?, ?, ?);";

                String sqlComprobarUsuario = "SELECT * FROM `usuaris` WHERE nickname = ? ";

                StringBuilder resultado = new StringBuilder();

                for (int i = 0; i < contraseña.length(); i++) {
                    char c = contraseña.charAt(i);
                    int ascii = (int) c;
                    resultado.append(ascii);

                    if (i < contraseña.length() - 1) {
                        resultado.append("-");
                    }
                }

                if (vistaRegistro.comprobarCampos(contraseña, contraseñaConfi)) {

                    try (Connection conn = ConexionBD.conectar();
                         PreparedStatement stm = conn.prepareStatement(sqlComprobarUsuario)) {
                        stm.setString(1, nombre); // Modificar sql
                        ResultSet rs = stm.executeQuery();// Ejecutamos la Consulta

                        if (rs.next()){
                            vistaRegistro.mesajeError("El usuario ya existe");
                        }else {

                            try (Connection conne = ConexionBD.conectar();
                                 PreparedStatement stmC = conn.prepareStatement(sqlRegistro)) {
                                // Hacer otro try para obtener el id de la tasca para poder hacer el update de momento pongo directamente un id


                                stmC.setString(1, nombre); // Modificar sql
                                stmC.setString(2, resultado.toString()); // Modificar sql
                                stmC.setString(3, email); // Modificar sql
                                stmC.setInt(4, 0); // Modificar sql
                                stmC.setInt(5, 1); // Modificar sql
                                stmC.setString(6, "user"); // Modificar sql


                                stmC.executeUpdate();                // Ejecutamos la Consulta

                                vistaRegistro.limpiarVista();
                                vistaRegistro.mesajeError("Usuario creado");



                            } catch (SQLException l) {

                                l.printStackTrace();
                                throw new RuntimeException("Error al registrar usuario");

                            }

                        }

                    } catch (SQLException l) {
                        l.printStackTrace();
                        throw new RuntimeException("Usuario ya existe ");

                    }

                }
            }
        });

        vistaRegistro.addActionBotonInicioSesion(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                VistaInicioSesion vistaInicioSesion = new VistaInicioSesion();
                vistaInicioSesion.setVisible(true);
                ControladorInicioSesion controladorInicioSesion = new ControladorInicioSesion(vistaInicioSesion, listTareas);
                vistaRegistro.dispose();

            }
        });



    }
}
