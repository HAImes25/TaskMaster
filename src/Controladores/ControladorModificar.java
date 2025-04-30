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
                System.out.println("Cancelando....");
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
                System.out.println(vista.getComboBoxEstado() + " Este es el estado ");
                modelo.setFrecuencia(vista.getComboBoxFrecuencia());  //Frecuencia
                //Hota revisoon  tadavia no lo ponemos
                modelo.setDescripcion(vista.getDescripcion());


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

                vista.getFrame().dispose();


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
                    System.out.println("la dificultad es Facil");
                    idDificultad = 1;
                } else if (vista.getComboBoxDificultad().toString() == "Media") {
                    System.out.println("la dificultad es media");
                    idDificultad = 2;
                }else {
                    System.out.println("la dificultad es dificil");
                    idDificultad = 3;
                }
                String dataInici = modelo.getFechaInici();
                String dataLimit = modelo.getFechaInici();

                // Falta acabar que el esatdo del sql sea el correcto 

//                int idEstats = 0;
//                if (vista.getComboBoxEstado().toString() == "Por empezar"){
//                    System.out.println("Por empezar");
//                    idEstats = 1;
//                } else if (vista.getComboBoxEstado().toString() == "En proceso") {
//                    System.out.println("la dificultad es media");
//                    idEstats = 2;
//                }else {
//                    System.out.println("la dificultad es dificil");
//                    idEstats = 3;
//                }






//                try (Connection conn = ConexionBD.conectar();
//                     PreparedStatement stm = conn.prepareStatement(sqlUpdate)){
//
//                    stm.setString(1, vista.getTitul()); // Modificar sql
//                    stm.setString(2, vista.getTitul());
//
//                    // Hacer otro try para obtener el id de la tasca para poder hacer el update
//
//
//
//                    stm.executeUpdate();                // Ejecutamos la Consulta
//
//                } catch (SQLException l) {
//
//                    l.printStackTrace();
//                    throw new RuntimeException("Error al ingresar alumno a la base de datos");
//
//                }






                ControladorModificar.this.dispose();
                }
        });





    }
}
