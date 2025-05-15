package Controladores;
import Modelos.ModeloTareaHector;
import Vistas.VistaAdministradorDeTareas;
import Modelos.ModeloListaTareas;
import Vistas.VistaCrear;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorAdministradorDeTareas {

    // Atributos
    private VistaAdministradorDeTareas vistaAdministradorDeTareas;
    private ModeloListaTareas listaTareas;
    //private VistaCrear vistaCrear;

    // Constructor
    public ControladorAdministradorDeTareas(VistaAdministradorDeTareas vistaAdministradorDeTareas,  ArrayList<ModeloTareaHector> listTareas, ArrayList<ModeloListaTareas> listaImagenes) {
        this.vistaAdministradorDeTareas = vistaAdministradorDeTareas;
        this.listaTareas = listaTareas;
        //this.vistaCrear = vistaCrear;

        vistaAdministradorDeTareas.buttonCrearTareaAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                VistaCrear vistaCrear = new VistaCrear();
                vistaAdministradorDeTareas.setVisible(false);
                ModeloTareaHector tarea = new ModeloTareaHector("", "", "", "");
                ControladorCrear controladorCrear = new ControladorCrear(listTareas, vistaCrear, vistaAdministradorDeTareas);

            }
        });

        for (ModeloListaTareas imgModelo : listaImagenes){
            JScrollPane Pane = new JScrollPane();
            Pane.setLayout(new BoxLayout(Pane, BoxLayout.Y_AXIS));
            Pane.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));

            JLabel labelFoto = new JLabel(new ImageIcon("src/IMG/" +imgModelo.getPath()));
            Pane.add(labelFoto);

            vistaAdministradorDeTareas.agregarImagenVista(Pane);
        }

    // Rellenar espacios de tareas
//        vistaAdministradorDeTareas.rellenarEspacioPorEmpezar();
//        vistaAdministradorDeTareas.rellenarEspacioEnProceso();
//        vistaAdministradorDeTareas.rellenarEspacioCompletada();
//        vistaAdministradorDeTareas.rellenarEspacioPorVencida();
        vistaAdministradorDeTareas.rellenarEspacioSql();




    }


}
