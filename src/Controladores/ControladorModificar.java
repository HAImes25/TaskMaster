package Controladores;

import Modelos.ModeloTareaHector;
import Vistas.*;
import ConexionesBD.ConexionBD;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        vista.getComboBoxDificultadCombo().setSelectedItem(modelo.getDificultad());
        vista.getComboBoxFrecuenciaCombo().setSelectedItem(modelo.getFrecuencia());



        this.vista.addCancelarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.getFrame().dispose();
                JOptionPane.showMessageDialog(null, "Modificación cancelada.");

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
                //Hora revisoon  tadavia no lo ponemos
                modelo.setDescripcion(vista.getDescripcion());




//                vistaAdministradorDeTareas.getListaTareasPorEmpezar().clear();
//                vistaAdministradorDeTareas.getListaTareasEnProceso().clear();
//
//                for (int i = 0; i < listaTareas.size(); i++) {
//                    if (listaTareas.get(i).getEstado() == "Por empezar"){
//                        vistaAdministradorDeTareas.getListaTareasPorEmpezar().add(listaTareas.get(i));
//
//                    } else if (listaTareas.get(i).getEstado() == "En proceso") {
//                        vistaAdministradorDeTareas.getListaTareasEnProceso().add(listaTareas.get(i));
//
//                    }else if (listaTareas.get(i).getEstado() == "Completada"){
//                        vistaAdministradorDeTareas.getListaTareasCompletada().add(listaTareas.get(i));
//
//                    } else if (listaTareas.get(i).getEstado() == "Vencida") {
//                        vistaAdministradorDeTareas.getListaTareasVencida().add(listaTareas.get(i));
//                    }
//                }
//                vistaAdministradorDeTareas.getListaTareasCompletada().clear();
//                vistaAdministradorDeTareas.getListaTareasVencida().clear();
//


                vistaAdministradorDeTareas.dispose();


                String sqlUpdate = "UPDATE `tasques` " +
                        "SET `titol` = ?," +
                        " `dificultats_id` = ?," +
                        " `data_inici` = ?," +
                        " `data_limit` = ?," +
                        " `estats_id` = ?," +
                        " `frecuencia` = ?," +
                        " `descripcio` = ?," +
                        " `quantitat_exp` = ?" +
                        " WHERE `tasques`.`id` = ? ;";

                // Ver cual es el id de dificultad para poner en el sql
                int idDificultad = 0;
                if (vista.getComboBoxDificultad().toString() == "Facil"){
                    idDificultad = 1;
                } else if (vista.getComboBoxDificultad().toString() == "Media") {
                    idDificultad = 2;
                }else {
                    idDificultad = 3;
                }
                String dataInici = modelo.getFechaInici();
                String dataLimit = modelo.getFechaInici();

                // Falta acabar que el esatdo del sql sea el correcto

                int idEstats = 0;
                if (vista.getComboBoxEstado().toString() == "Por empezar"){
                    idEstats = 1;
                } else if (vista.getComboBoxEstado().toString() == "En proceso") {
                    idEstats = 2;
                } else if (vista.getComboBoxEstado().toString() == "Completada") {
                    idEstats = 3;
                }else {
                    idEstats = 4;
                }

                int frecuencia = 0;
                if (vista.getComboBoxFrecuencia().toString() == "Única"){
                    frecuencia = 0;
                } else if (vista.getComboBoxFrecuencia().toString() == "Diaria") {
                    frecuencia = 1;
                }else if (vista.getComboBoxFrecuencia().toString() == "Semanal"){
                    frecuencia = 7;
                }else {
                    frecuencia = 30;
                }





                try (Connection conn = ConexionBD.conectar();
                     PreparedStatement stm = conn.prepareStatement(sqlUpdate)){
                    // Hacer otro try para obtener el id de la tasca para poder hacer el update de momento pongo directamente un id


                    stm.setString(1, vista.getTitul()); // Modificar sql
                    stm.setString(2, String.valueOf(idDificultad));
                    stm.setString(3, modelo.getFechaInici());
                    stm.setString(4, modelo.getFechaFinal());
                    stm.setString(5, String.valueOf(idEstats));
                    stm.setString(6, String.valueOf(frecuencia));
                    stm.setString(7, modelo.getDescripcion());
                    stm.setString(8, String.valueOf(idDificultad));    // Esta linea es la XP, como todavia no
                    stm.setString(9, String.valueOf(modelo.getId()));

                    stm.executeUpdate();                // Ejecutamos la Consulta


                } catch (SQLException l) {

                    l.printStackTrace();
                    throw new RuntimeException("Error al actualizar alumno a la base de datos");

                }

                VistaAdministradorDeTareas vistaAdministradorDeTareas1 = new VistaAdministradorDeTareas(listaTareas,vistaAdministradorDeTareas.getListaTareasPorEmpezar(), vistaAdministradorDeTareas.getListaTareasEnProceso(), vistaAdministradorDeTareas.getListaTareasCompletada(), vistaAdministradorDeTareas.getListaTareasVencida());
//                vistaAdministradorDeTareas1.rellenarEspacioPorEmpezar();
//                vistaAdministradorDeTareas1.rellenarEspacioEnProceso();
//                vistaAdministradorDeTareas1.rellenarEspacioCompletada();
//                vistaAdministradorDeTareas1.rellenarEspacioPorVencida();
                vistaAdministradorDeTareas1.rellenarEspacioSql();
                vistaAdministradorDeTareas1.setVisible(true);
                vista.getFrame().dispose();
                vistaAdministradorDeTareas1.repaint();
                vistaAdministradorDeTareas1.revalidate();

                // Aqui va el controlador de Crear



                ControladorModificar.this.dispose();
                }
        });





    }
}
