package Vistas;

import Modelos.ModeloTarea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VistaAdministradorDeTareas extends JFrame{

    // Atributos
    private JPanel panelAdministradorDeTareas;
    private JButton buttonCrearTarea;
    private JPanel panelPorEmpezar;
    private JPanel panelEnProceso;
    private JPanel panelCompletada;
    private JPanel panelVencida;
    private JPanel panelIconos;

    // Constructor
    public VistaAdministradorDeTareas(){

        //Crear Ventana
        setTitle("Administrador de Tareas");
        setSize(400, 330);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(panelAdministradorDeTareas);


    }

    // Metodos
    public void rellenarEspacioPorEmpezar(ArrayList<ModeloTarea> tareaArrayList){
        panelPorEmpezar.setLayout(new GridLayout(tareaArrayList.size(), 1));
        panelPorEmpezar.removeAll();






        for (ModeloTarea tarea : tareaArrayList){
            System.out.println("Estoy dentro del panel Por Empezar");

            JPanel panelTarea = new JPanel();
            panelTarea.setLayout(new GridLayout(2,2));

            JLabel labelnombre = new JLabel(tarea.getNombre());
            panelTarea.add(labelnombre);

            JLabel labelDificultad = new JLabel(tarea.getDificultad());
            panelTarea.add(labelDificultad);

            JLabel labelFecha = new JLabel(tarea.getFecha().toString());
            panelTarea.add(labelFecha);

            JButton boton = new JButton("Modificar");
            panelTarea.add(boton);

            panelPorEmpezar.add(panelTarea);

            //Add ancho y largo por cada elemento al grosor del frame/panel principal por cada tarea añadida

            revalidate();
            repaint();
        }
    }

    public void rellenarEspacioEnProceso(ArrayList<ModeloTarea> tareaArrayList){
        for (ModeloTarea tarea : tareaArrayList){
            System.out.println("Estoy dentro del panel En Proceso");
        }
    }

    public void rellenarEspacioCompletada(ArrayList<ModeloTarea> tareaArrayList){
        for (ModeloTarea tarea : tareaArrayList){
            System.out.println("Estoy dentro del panel Completada");
        }
    }

    public void rellenarEspacioPorVencida(ArrayList<ModeloTarea> tareaArrayList){
        for (ModeloTarea tarea : tareaArrayList){
            System.out.println("Estoy dentro del panel Vencida");
        }
    }

    // Listeners
    public void buttonCrearTareaAddActionListener(ActionListener listener){
        buttonCrearTarea.addActionListener(listener);
    }



}
