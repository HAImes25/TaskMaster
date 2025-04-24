package Vistas;

import Controladores.ControladorModificar;
import Modelos.ModeloListaTareas;
import Modelos.ModeloTareaHector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JButton botonesButton;
    private JButton sinButton;
    private JButton funcionButton;

    private ArrayList<ModeloTareaHector> listaTareas;
    private ArrayList<ModeloTareaHector> listaTareasPorEmpezar;
    private ArrayList<ModeloTareaHector> listaTareasEnProceso;
    private ArrayList<ModeloTareaHector> listaTareasCompletada;
    private ArrayList<ModeloTareaHector> listaTareasVencida;

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
                    ControladorModificar controladorModificar = new ControladorModificar(vistaModificar,tarea, VistaAdministradorDeTareas.this, listaTareas);
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
                        ControladorModificar controladorModificar = new ControladorModificar(vistaModificar, tarea, VistaAdministradorDeTareas.this, listaTareas);
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
                    ControladorModificar controladorModificar = new ControladorModificar(vistaModificar, tarea, VistaAdministradorDeTareas.this, listaTareas);
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
                    ControladorModificar controladorModificar = new ControladorModificar(vistaModificar, tarea, VistaAdministradorDeTareas.this, listaTareas);
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
}
