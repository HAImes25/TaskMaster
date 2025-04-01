package Vistas;


import Modelos.TareaAina;

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



        String[] oDificultad = { "Fácil", "Medio", "Dificil"};
        for (String o : oDificultad){
            comboBoxDificultad.addItem(o);
        }

        String[] oEstado = { "Por empezar", "En proceso", "Completada", "Vencida"};
        for (String o : oEstado){
            comboBoxEstado.addItem(o);
        }

        String[] oFrecuencia = { "Única", "Diaria", "Semanal", "Mensual"};
        for (String o : oFrecuencia){
            comboBoxFrecuencia.addItem(o);
        }



        //Per a que quan s'obri la finestra ja posi la informació a la part que toca
       //textTitulo.getText(t1.getNombre());







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


