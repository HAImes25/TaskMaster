package Controladores;

import Vistas.*;
import Modelos.*;
import Controladores.*;
import ConexionesBD.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorCrear extends JFrame{

    private ArrayList<ModeloTareaHector> listaTareas;
    private VistaCrear vistaCrear;
    private ModeloTareaHector modeloTarea;
    private VistaAdministradorDeTareas vistaAdministradorDeTareas;


    public ControladorCrear(ArrayList<ModeloTareaHector> listaTareas, VistaCrear vistaCrear, VistaAdministradorDeTareas vistaAdministradorDeTareas){
        this.listaTareas = listaTareas;
        this.vistaCrear = vistaCrear;

        this.vistaAdministradorDeTareas = vistaAdministradorDeTareas;



        this.vistaCrear.addCancelarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaCrear.getFrame().dispose();
                JOptionPane.showMessageDialog(null, "Creación de tarea cancelada.");
                vistaAdministradorDeTareas.setVisible(true);
            }
        });


        this.vistaCrear.addCrearListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("crear");

                modeloTarea = new ModeloTareaHector("", "", "", "");

                //No funciona el problema esta en alguna cosa del modeloTareaHector
                modeloTarea.setTitulo(vistaCrear.getTitul());
                System.out.println("Titulo");
                modeloTarea.setDificultad(vistaCrear.getComboBoxDificultad());
                System.out.println("dificultad");
                //modeloTarea.getEstado(vistaCrear.getComboBoxEstado());
                modeloTarea.setFrecuencia(vistaCrear.getComboBoxFrecuencia());
                System.out.println("frecuencia");



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
                System.out.println("Añadido a lista tareas");


                vistaAdministradorDeTareas.dispose();


                VistaAdministradorDeTareas vistaAdministradorDeTareas1 = new VistaAdministradorDeTareas(listaTareas,vistaAdministradorDeTareas.getListaTareasPorEmpezar(), vistaAdministradorDeTareas.getListaTareasEnProceso(), vistaAdministradorDeTareas.getListaTareasCompletada(), vistaAdministradorDeTareas.getListaTareasVencida());
                vistaAdministradorDeTareas1.rellenarEspacioPorEmpezar();
                vistaAdministradorDeTareas1.rellenarEspacioEnProceso();
                vistaAdministradorDeTareas1.rellenarEspacioCompletada();
                vistaAdministradorDeTareas1.rellenarEspacioPorVencida();
                vistaAdministradorDeTareas1.setVisible(true);

                vistaCrear.getFrame().dispose();

                String sqlInsert = "INSERT INTO `tasques` " +
                        "(`titol`," +
                        " `dificultats_id`," +
                        " `data_inici`," +
                        " `data_limit`," +
                        " `estats_id`," +
                        " `frecuencia`," +
                        " `descripcio`," +
                        " `quantitat_exp`) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

                int idDificultad = 0;
                String dificultadSeleccionada = vistaCrear.getComboBoxDificultad().toString();

                if (dificultadSeleccionada.equals("Facil")) {
                    System.out.println("la dificultad es Facil");
                    idDificultad = 1;
                } else if (dificultadSeleccionada.equals("Media")) {
                    System.out.println("la dificultad es media");
                    idDificultad = 2;
                } else {
                    System.out.println("la dificultad es dificil");
                    idDificultad = 3;
                }

                String fechaInici = modeloTarea.getFechaInici();
                String fechaFinal = modeloTarea.getFechaFinal();

                try {
                    PreparedStatement ps = ConexionBD.conectar().prepareStatement(sqlInsert);
                    ps.setString(1, modeloTarea.getTitulo());
                    ps.setInt(2, idDificultad);
                    ps.setString(3, fechaInici);
                    ps.setString(4, fechaFinal);
                    ps.setString(5, modeloTarea.getEstado());
                    ps.setString(6, modeloTarea.getFrecuencia());
                    ps.setString(7, modeloTarea.getDescripcion());
                    //ps.setInt(8, modeloTarea.geT);     falta la part de quantitat_exp

                    ps.executeUpdate();
                    ps.close();

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }



            }
        });
    }
}
