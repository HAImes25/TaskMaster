package Vistas;

import ConexionesBD.ConexionBD;
import Controladores.ControladorModificar;
import Modelos.ModeloListaTareas;
import Modelos.ModeloTareaHector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VistaAdministradorDeTareas extends JFrame{

    // Atributos
    private JPanel panelAdministradorDeTareas;
    private JButton buttonCrearTarea;
    private JScrollPane panelPorEmpezar;
    private JPanel panelIconos;
    private JScrollPane panelEnProceso;
    private JScrollPane panelCompletada;
    private JScrollPane panelVencida;
    private JScrollPane panelPrincipal;
    private JButton botonesButton;
    private JButton sinButton;
    private JButton funcionButton;

    private ArrayList<ModeloTareaHector> listaTareas;
    private ArrayList<ModeloTareaHector> listaTareasPorEmpezar;
    private ArrayList<ModeloTareaHector> listaTareasEnProceso;
    private ArrayList<ModeloTareaHector> listaTareasCompletada;
    private ArrayList<ModeloTareaHector> listaTareasVencida;

    int idusuario = 0;

    // Constructor
    public VistaAdministradorDeTareas(ArrayList<ModeloTareaHector> listaTareas, ArrayList<ModeloTareaHector> listaTareasPorEmpezar,ArrayList<ModeloTareaHector> listaTareasEnProceso, ArrayList<ModeloTareaHector> listaTareasCompletadas, ArrayList<ModeloTareaHector> listaTareasVencidas){

        //Crear Ventana
        setTitle("Administrador de Tareas");
        //setSize(420, 570); // inicial
        setSize(375, 667); // iPhone 8
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(panelAdministradorDeTareas);

        this.listaTareas = listaTareas;
        this.listaTareasPorEmpezar = listaTareasPorEmpezar;
        this.listaTareasEnProceso = listaTareasEnProceso;
        this.listaTareasCompletada = listaTareasCompletadas;
        this.listaTareasVencida = listaTareasVencidas;

    }

    public VistaAdministradorDeTareas(int id){

        //Crear Ventana
        setTitle("Administrador de Tareas");
        //setSize(420, 570); // inicial
        setSize(375, 667); // iPhone 8
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(panelAdministradorDeTareas);
        this.idusuario = id;


    }

    public int getIdusuario(){
        return idusuario;
    }

    // Metodos
    public void rellenarEspacioPorEmpezar() {



        // Crear un JPanel de contenedor de las tareas
        JPanel contenedorTareas = new JPanel();
        contenedorTareas.setLayout(new GridLayout(0, 1));

        // Limpiar el contenedor antes de agregar nuevos elementos
        contenedorTareas.removeAll();

        for (ModeloTareaHector tarea : listaTareasPorEmpezar) {
            JPanel panelTarea = new JPanel();
            panelTarea.setLayout(new GridLayout(2, 2));

            JLabel labelnombre = new JLabel(tarea.getTitulo());
            panelTarea.add(labelnombre);

            JLabel labelDificultad = new JLabel(tarea.getDificultad());
            panelTarea.add(labelDificultad);

            JLabel labelFecha = new JLabel(tarea.getFechaFinal().toString());
            panelTarea.add(labelFecha);

            JButton botonModificar = new JButton("Modificar");
            botonModificar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    VistaModificar vistaModificar = new VistaModificar(tarea);
                    //ControladorModificar controladorModificar = new ControladorModificar(vistaModificar,tarea, VistaAdministradorDeTareas.this, listaTareas);
                    //Eliminar ventana AdminTareas
                }
            });
            panelTarea.add(botonModificar);

            contenedorTareas.add(panelTarea);
        }

        // Agregar el contenedor al JScrollPane
        panelPorEmpezar.setViewportView(contenedorTareas);

        // Actualizar la vista
        revalidate();
        repaint();
    }

    public void rellenarEspacioEnProceso(){

        // Crear un JPanel de contenedor de las tareas
        JPanel contenedorTareas = new JPanel();
        contenedorTareas.setLayout(new GridLayout(0, 1));

        // Limpiar el contenedor antes de agregar nuevos elementos
        contenedorTareas.removeAll();

        for (ModeloTareaHector tarea : listaTareasEnProceso) {
            String status = tarea.getEstado();
                JPanel panelTarea = new JPanel();
                panelTarea.setLayout(new GridLayout(2, 2));

                JLabel labelnombre = new JLabel(tarea.getTitulo());
                panelTarea.add(labelnombre);

                JLabel labelDificultad = new JLabel(tarea.getDificultad());
                panelTarea.add(labelDificultad);

                JLabel labelFecha = new JLabel(tarea.getFechaFinal().toString());
                panelTarea.add(labelFecha);

                JButton boton = new JButton("Modificar");
                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        VistaModificar vistaModificar = new VistaModificar(tarea);
                        //ControladorModificar controladorModificar = new ControladorModificar(vistaModificar, tarea, VistaAdministradorDeTareas.this, listaTareas);
                        //Eliminar ventana AdminTareas
                    }
                });
                panelTarea.add(boton);

                contenedorTareas.add(panelTarea);

        }

        // Agregar el contenedor al JScrollPane
        panelEnProceso.setViewportView(contenedorTareas);

        // Actualizar la vista
        revalidate();
        repaint();
    }

    public void rellenarEspacioCompletada(){
        // Crear un JPanel de contenedor de las tareas
        JPanel contenedorTareas = new JPanel();
        contenedorTareas.setLayout(new GridLayout(0, 1));

        // Limpiar el contenedor antes de agregar nuevos elementos
        contenedorTareas.removeAll();

        for (ModeloTareaHector tarea : listaTareasCompletada) {

            JPanel panelTarea = new JPanel();
            panelTarea.setLayout(new GridLayout(2, 2));

            JLabel labelnombre = new JLabel(tarea.getTitulo());
            panelTarea.add(labelnombre);

            JLabel labelDificultad = new JLabel(tarea.getDificultad());
            panelTarea.add(labelDificultad);

            JLabel labelFecha = new JLabel(tarea.getFechaInici().toString());
            panelTarea.add(labelFecha);

            JButton boton = new JButton("Modificar");
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    VistaModificar vistaModificar = new VistaModificar(tarea);
                    //ControladorModificar controladorModificar = new ControladorModificar(vistaModificar, tarea, VistaAdministradorDeTareas.this, listaTareas);
                    //Eliminar ventana AdminTareas
                }
            });
            panelTarea.add(boton);

            contenedorTareas.add(panelTarea);
        }

        // Agregar el contenedor al JScrollPane
        panelCompletada.setViewportView(contenedorTareas);

        // Actualizar la vista
        revalidate();
        repaint();
    }

    public void rellenarEspacioPorVencida(){
        // Crear un JPanel de contenedor de las tareas
        JPanel contenedorTareas = new JPanel();
        contenedorTareas.setLayout(new GridLayout(0, 1));

        // Limpiar el contenedor antes de agregar nuevos elementos
        contenedorTareas.removeAll();

        for (ModeloTareaHector tarea : listaTareasVencida) {

            JPanel panelTarea = new JPanel();
            panelTarea.setLayout(new GridLayout(2, 2));

            JLabel labelnombre = new JLabel(tarea.getTitulo());
            panelTarea.add(labelnombre);

            JLabel labelDificultad = new JLabel(tarea.getDificultad());
            panelTarea.add(labelDificultad);

            JLabel labelFecha = new JLabel(tarea.getFechaInici().toString());
            panelTarea.add(labelFecha);

            JButton boton = new JButton("Modificar");
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    VistaModificar vistaModificar = new VistaModificar(tarea);
                    //ControladorModificar controladorModificar = new ControladorModificar(vistaModificar, tarea, VistaAdministradorDeTareas.this, listaTareas);
                    //Eliminar ventana AdminTareas

                }
            });
            panelTarea.add(boton);

            contenedorTareas.add(panelTarea);
        }

        // Agregar el contenedor al JScrollPane
        panelVencida.setViewportView(contenedorTareas);

        // Actualizar la vista
        revalidate();
        repaint();
    }

    public void rellenarEspacioSql() {

        //String sqlSelect = "SELECT * FROM `tasques` ";
        String sqlSelect = "SELECT * FROM `tasques` JOIN usuaris_tasques ON tasques.id = usuaris_tasques.tasques_id JOIN usuaris ON usuaris.id = usuaris_tasques.usuaris_id WHERE usuaris.id = ?";



        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stm = conn.prepareStatement(sqlSelect)) {

            stm.setInt(1, idusuario);
            ResultSet rs = stm.executeQuery();           // Ejecutamos la Consulta

            // Crear un JPanel de contenedor de las tareas Por Empezar
            JPanel contenedorTareasPorEmpezar = new JPanel();
            contenedorTareasPorEmpezar.setLayout(new GridLayout(0, 1));
            // Limpiar el contenedor antes de agregar nuevos elementos
            contenedorTareasPorEmpezar.removeAll();

            // Crear un JPanel de contenedor de las tareas En proceso
            JPanel contenedorTareasEnProceso = new JPanel();
            contenedorTareasEnProceso.setLayout(new GridLayout(0, 1));
            // Limpiar el contenedor antes de agregar nuevos elementos
            contenedorTareasEnProceso.removeAll();

            // Crear un JPanel de contenedor de las tareas Completada
            JPanel contenedorTareasCompletada = new JPanel();
            contenedorTareasCompletada.setLayout(new GridLayout(0, 1));
            // Limpiar el contenedor antes de agregar nuevos elementos
            contenedorTareasCompletada.removeAll();

            // Crear un JPanel de contenedor de las tareas Vencida
            JPanel contenedorTareasVencida = new JPanel();
            contenedorTareasVencida.setLayout(new GridLayout(0, 1));
            // Limpiar el contenedor antes de agregar nuevos elementos
            contenedorTareasVencida.removeAll();

            while (rs.next()) {
                ModeloTareaHector tarea = new ModeloTareaHector(rs.getString("titol"), rs.getInt("dificultats_id"), rs.getInt("estats_id"), rs.getString("frecuencia"), rs.getInt("id"));

                JPanel panelTarea = new JPanel();
                panelTarea.setLayout(new GridLayout(2, 2));

                JLabel labelnombre = new JLabel(tarea.getTitulo());
                panelTarea.add(labelnombre);

                JLabel labelDificultad = new JLabel(tarea.getDificultad());
                panelTarea.add(labelDificultad);

                JLabel labelFecha = new JLabel(tarea.getFechaInici().toString());
                panelTarea.add(labelFecha);

                JButton boton = new JButton("Modificar");
                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        VistaModificar vistaModificar = new VistaModificar(tarea);
                        ControladorModificar controladorModificar = new ControladorModificar(vistaModificar, tarea, VistaAdministradorDeTareas.this, listaTareas, idusuario);
                        //Eliminar ventana AdminTareas

                    }
                });
                panelTarea.add(boton);

                if (rs.getInt("estats_id") == 1) {
                    contenedorTareasPorEmpezar.add(panelTarea);
                    panelPorEmpezar.setViewportView(contenedorTareasPorEmpezar);
                } else if (rs.getInt("estats_id") == 2) {
                    contenedorTareasEnProceso.add(panelTarea);
                    panelEnProceso.setViewportView(contenedorTareasEnProceso);
                } else if (rs.getInt("estats_id") == 3) {
                    contenedorTareasCompletada.add(panelTarea);
                    panelCompletada.setViewportView(contenedorTareasCompletada);
                } else {
                    contenedorTareasVencida.add(panelTarea);
                    panelVencida.setViewportView(contenedorTareasVencida);

                }

            }
            revalidate();
            repaint();


        } catch (SQLException l) {

            l.printStackTrace();
            throw new RuntimeException("Error al actualizar alumno a la base de datos");

        }
    }

    // Listeners
    public void buttonCrearTareaAddActionListener(ActionListener listener){
        buttonCrearTarea.addActionListener(listener);
    }


    public ArrayList<ModeloTareaHector> getListaTareas() {
        return listaTareas;
    }

    public ArrayList<ModeloTareaHector> getListaTareasPorEmpezar() {
        return listaTareasPorEmpezar;
    }

    public ArrayList<ModeloTareaHector> getListaTareasEnProceso() {
        return listaTareasEnProceso;
    }

    public ArrayList<ModeloTareaHector> getListaTareasCompletada() {
        return listaTareasCompletada;
    }

    public ArrayList<ModeloTareaHector> getListaTareasVencida() {
        return listaTareasVencida;
    }

    public void agregarImagenVista(JScrollPane panelagregar){
        panelPrincipal.add(panelagregar);

    }
}
