package Controladores;

import Vistas.*;
import Modelos.*;
import Controladores.*;
import ConexionesBD.*;
import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorCrear extends JFrame{

    private ArrayList<ModeloTareaHector> listaTareas;
    private VistaCrear vistaCrear;
    private ModeloTareaHector modeloTarea;
    private VistaAdministradorDeTareas vistaAdministradorDeTareas;
    private int idUsuari = 0;


    public ControladorCrear(ArrayList<ModeloTareaHector> listaTareas, VistaCrear vistaCrear, VistaAdministradorDeTareas vistaAdministradorDeTareas, int idUsuari){
        this.listaTareas = listaTareas;
        this.vistaCrear = vistaCrear;

        this.vistaAdministradorDeTareas = vistaAdministradorDeTareas;

        this.idUsuari = idUsuari;



        this.vistaCrear.addCancelarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaCrear.getFrame().dispose();
                vistaAdministradorDeTareas.setVisible(true);
            }
        });


        this.vistaCrear.addCrearListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("crear");

                vistaAdministradorDeTareas.setVisible(false);
                modeloTarea = new ModeloTareaHector("", "", "", "");

                String fechaSeleccionada = vistaCrear.getFechaSeleccionadaComoString();
                System.out.println("Fecha: " + fechaSeleccionada);


                modeloTarea.setTitulo(vistaCrear.getTitul());
                System.out.println("Titulo");
                modeloTarea.setDificultad(vistaCrear.getComboBoxDificultad());
                System.out.println("dificultad");
                //modeloTarea.getEstado(vistaCrear.getComboBoxEstado());
                modeloTarea.setFrecuencia(vistaCrear.getComboBoxFrecuencia());
                System.out.println("frecuencia");

                listaTareas.add(modeloTarea);



                for (int i = 0; i < listaTareas.size(); i++) {
                    if (listaTareas.get(i).getEstado().equals( "Por empezar")){
                        vistaAdministradorDeTareas.getListaTareasPorEmpezar().add(listaTareas.get(i));

                    } else if (listaTareas.get(i).getEstado().equals("En proceso")) {
                        vistaAdministradorDeTareas.getListaTareasEnProceso().add(listaTareas.get(i));

                    }else if (listaTareas.get(i).getEstado().equals("Completada")){
                        vistaAdministradorDeTareas.getListaTareasCompletada().add(listaTareas.get(i));

                    } else if (listaTareas.get(i).getEstado().equals("Vencida")) {
                        vistaAdministradorDeTareas.getListaTareasVencida().add(listaTareas.get(i));
                    }
                }
                System.out.println("Añadido a lista tareas");


                vistaAdministradorDeTareas.dispose();


                VistaAdministradorDeTareas vistaAdministradorDeTareas1 = new VistaAdministradorDeTareas(listaTareas,vistaAdministradorDeTareas.getListaTareasPorEmpezar(), vistaAdministradorDeTareas.getListaTareasEnProceso(), vistaAdministradorDeTareas.getListaTareasCompletada(), vistaAdministradorDeTareas.getListaTareasVencida());
//                vistaAdministradorDeTareas1.rellenarEspacioPorEmpezar();
//                vistaAdministradorDeTareas1.rellenarEspacioEnProceso();
//                vistaAdministradorDeTareas1.rellenarEspacioCompletada();
//                vistaAdministradorDeTareas1.rellenarEspacioPorVencida();
                vistaAdministradorDeTareas1.rellenarEspacioSql();
                vistaAdministradorDeTareas1.setVisible(true);

                vistaAdministradorDeTareas1.setVisible(true);
                vistaCrear.getFrame().dispose();



                int idDificultad = 0;
                int experiencia = 0;
                String dificultadSeleccionada = vistaCrear.getComboBoxDificultad().toString();

                if (dificultadSeleccionada.equals("Facil")) {
                    System.out.println("la dificultad es Facil");
                    idDificultad = 1;
                    experiencia = 1;
                } else if (dificultadSeleccionada.equals("Media")) {
                    System.out.println("la dificultad es media");
                    idDificultad = 2;
                    experiencia = 2;
                } else {
                    System.out.println("la dificultad es dificil");
                    idDificultad = 3;
                    experiencia = 3;
                }

                String fechaInici = modeloTarea.getFechaInici();
                String fechaFinal = vistaCrear.getFechaSeleccionadaComoString();


                int idEstats = 0;
                if (vistaCrear.getComboBoxEstado().toString().equals("Por empezar")){
                    System.out.println("Por empezar");
                    idEstats = 1;
                } else if (vistaCrear.getComboBoxEstado().toString().equals("En proceso")) {
                    System.out.println("la En proceso");
                    idEstats = 2;
                } else if (vistaCrear.getComboBoxEstado().toString().equals("Completada")) {
                    System.out.println("la Completada");
                    idEstats = 3;
                }else {
                    System.out.println("esta Vencida");
                    idEstats = 4;
                }

                int frecuencia = 0;
                if (vistaCrear.getComboBoxFrecuencia().toString().equals( "Única")){
                    System.out.println("la Frecuencia es Única");
                    frecuencia = 0;
                } else if (vistaCrear.getComboBoxFrecuencia().toString().equals("Diaria")) {
                    System.out.println("la Frecuencia es Diaria");
                    frecuencia = 1;
                }else if (vistaCrear.getComboBoxFrecuencia().toString().equals("Semanal") ){
                    System.out.println("la Frecuencia es Semanal");
                    frecuencia = 7;
                }else {
                    System.out.println("la Frecuencia es Mensual");
                    frecuencia = 30;
                }



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

                String sqlGetId = "SELECT * FROM `tasques` ORDER BY id DESC LIMIT 1";
                String sqlInsertSegundaTabla = "INSERT INTO `usuaris_tasques` (`tasques_id`, `usuaris_id`) VALUES (?, ?)";


                try {
                    PreparedStatement ps = ConexionBD.conectar().prepareStatement(sqlInsert);
                    ps.setString(1, modeloTarea.getTitulo());
                    ps.setInt(2, idDificultad);
                    ps.setString(3, fechaInici);
                    ps.setString(4, fechaFinal);
                    ps.setString(5, String.valueOf(idEstats));
                    ps.setString(6, String.valueOf(frecuencia));
                    ps.setString(7, modeloTarea.getDescripcion());
                    ps.setInt(8, experiencia);

                    ps.executeUpdate();
                    ps.close();


                    try {
                        PreparedStatement stm = ConexionBD.conectar().prepareStatement(sqlGetId);

                        ResultSet rs = stm.executeQuery();

                        if (rs.next()){
                            try {
                                System.out.println("Esooooo es el iddd de la ultima tasque" + rs.getInt("id"));
                                PreparedStatement insert2 = ConexionBD.conectar().prepareStatement(sqlInsertSegundaTabla);
                                insert2.setInt(1, rs.getInt("id"));
                                insert2.setInt(2,idUsuari);
                                insert2.execute();

                            }catch (SQLException e3){
                                e3.printStackTrace();
                            }
                        }




                    }catch (SQLException e2){
                        e2.printStackTrace();

                    }



                    vistaCrear.getFrame().dispose();
                    vistaAdministradorDeTareas.rellenarEspacioSql();
                    vistaAdministradorDeTareas.setVisible(true);


                } catch (SQLException e1) {
                    e1.printStackTrace();
                }



            }
        });
    }
}
