package Vistas;

import Modelos.Tarea;


import javax.swing.*;
import java.awt.event.ActionListener;




public class VistaModificar extends JFrame {
    private JTextField textTitulo;
    private JComboBox comboBoxDificultad;
    private JComboBox comboBoxEstado;
    private JComboBox comboBoxFrecuencia;
    private JTextField textFieldDescripcion;
    private JButton aplicarButton;
    private JButton cancelarButton;
    private JPanel JPanelCalendario;
    private JPanel JPanelHora;
    private JPanel PanelModificar;
    private javax.swing.JFrame frame;

    public VistaModificar() {



        frame = new javax.swing.JFrame("Vista Modificar");
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(PanelModificar);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //Per a que quan s'obri la finestra ja posi la informació a la part que toca
        //textTitulo.getText(t1.getNombre());

        /*setTitle("Ventana Modificar");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setContentPane(new VentanaM(frame).getPanel()
       // );


        setLayout(new GridLayout(3, 2));

        add(textTitulo);
        textTitulo.setVisible(true);

        add(comboBoxDificultad);
        comboBoxDificultad.setVisible(true);

        //calendari

        add(comboBoxEstado);
        comboBoxEstado.setVisible(true);

        add(comboBoxFrecuencia);
        comboBoxFrecuencia.setVisible(true);

        //hora

        add(textFieldDescripcion);
        textFieldDescripcion.setVisible(true);

        add(cancelarButton);
        cancelarButton.setVisible(true);

        add(aplicarButton);
        aplicarButton.setVisible(true);*/


    }

    public JPanel getPanel(){
        return PanelModificar;
    }

    public JTextField getTitul(){
        return textTitulo;
    }

    public JTextField getDescripcion(){
        return textFieldDescripcion;
    }

    public void addCancelarListener(ActionListener listener) {
        cancelarButton.addActionListener(listener);
    }

    public void addAplicarListener(ActionListener listener){
        aplicarButton.addActionListener(listener);
    }



}


