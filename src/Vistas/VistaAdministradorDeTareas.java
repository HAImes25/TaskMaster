package Vistas;

import Controladores.ControladorModificar;
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

    // Constructor
    public VistaAdministradorDeTareas(){

        //Crear Ventana
        setTitle("Administrador de Tareas");
        //setSize(420, 570); // inicial
        setSize(375, 667); // iPhone 8
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(panelAdministradorDeTareas);

    }

    // Metodos
    public void rellenarEspacioPorEmpezar(ArrayList<ModeloTareaHector> tareaArrayList, ActionListener listener) {

        // Crear un JPanel de contenedor de las tareas
        JPanel contenedorTareas = new JPanel();
        contenedorTareas.setLayout(new GridLayout(0, 1));

        // Limpiar el contenedor antes de agregar nuevos elementos
        contenedorTareas.removeAll();

        for (ModeloTareaHector tarea : tareaArrayList) {
            JPanel panelTarea = new JPanel();
            panelTarea.setLayout(new GridLayout(2, 2));

            JLabel labelnombre = new JLabel(tarea.getNombre());
            panelTarea.add(labelnombre);

            JLabel labelDificultad = new JLabel(tarea.getDificultad());
            panelTarea.add(labelDificultad);

            JLabel labelFecha = new JLabel(tarea.getFecha().toString());
            panelTarea.add(labelFecha);

            JButton botonModificar = new JButton("Modificar");
            botonModificar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    VistaModificar vistaModificar = new VistaModificar(tarea);
                    ControladorModificar controladorModificar = new ControladorModificar(vistaModificar);
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

    public void rellenarEspacioEnProceso(ArrayList<ModeloTareaHector> tareaArrayList){

        // Crear un JPanel de contenedor de las tareas
        JPanel contenedorTareas = new JPanel();
        contenedorTareas.setLayout(new GridLayout(0, 1));

        // Limpiar el contenedor antes de agregar nuevos elementos
        contenedorTareas.removeAll();

        for (ModeloTareaHector tarea : tareaArrayList) {

            JPanel panelTarea = new JPanel();
            panelTarea.setLayout(new GridLayout(2, 2));

            JLabel labelnombre = new JLabel(tarea.getNombre());
            panelTarea.add(labelnombre);

            JLabel labelDificultad = new JLabel(tarea.getDificultad());
            panelTarea.add(labelDificultad);

            JLabel labelFecha = new JLabel(tarea.getFecha().toString());
            panelTarea.add(labelFecha);

            JButton boton = new JButton("Modificar");
            panelTarea.add(boton);

            contenedorTareas.add(panelTarea);
        }

        // Agregar el contenedor al JScrollPane
        panelEnProceso.setViewportView(contenedorTareas);

        // Actualizar la vista
        revalidate();
        repaint();
    }

    public void rellenarEspacioCompletada(ArrayList<ModeloTareaHector> tareaArrayList){
        // Crear un JPanel de contenedor de las tareas
        JPanel contenedorTareas = new JPanel();
        contenedorTareas.setLayout(new GridLayout(0, 1));

        // Limpiar el contenedor antes de agregar nuevos elementos
        contenedorTareas.removeAll();

        for (ModeloTareaHector tarea : tareaArrayList) {

            JPanel panelTarea = new JPanel();
            panelTarea.setLayout(new GridLayout(2, 2));

            JLabel labelnombre = new JLabel(tarea.getNombre());
            panelTarea.add(labelnombre);

            JLabel labelDificultad = new JLabel(tarea.getDificultad());
            panelTarea.add(labelDificultad);

            JLabel labelFecha = new JLabel(tarea.getFecha().toString());
            panelTarea.add(labelFecha);

            JButton boton = new JButton("Modificar");
            panelTarea.add(boton);

            contenedorTareas.add(panelTarea);
        }

        // Agregar el contenedor al JScrollPane
        panelCompletada.setViewportView(contenedorTareas);

        // Actualizar la vista
        revalidate();
        repaint();
    }

    public void rellenarEspacioPorVencida(ArrayList<ModeloTareaHector> tareaArrayList){
        // Crear un JPanel de contenedor de las tareas
        JPanel contenedorTareas = new JPanel();
        contenedorTareas.setLayout(new GridLayout(0, 1));

        // Limpiar el contenedor antes de agregar nuevos elementos
        contenedorTareas.removeAll();

        for (ModeloTareaHector tarea : tareaArrayList) {

            JPanel panelTarea = new JPanel();
            panelTarea.setLayout(new GridLayout(2, 2));

            JLabel labelnombre = new JLabel(tarea.getNombre());
            panelTarea.add(labelnombre);

            JLabel labelDificultad = new JLabel(tarea.getDificultad());
            panelTarea.add(labelDificultad);

            JLabel labelFecha = new JLabel(tarea.getFecha().toString());
            panelTarea.add(labelFecha);

            JButton boton = new JButton("Modificar");
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



}
