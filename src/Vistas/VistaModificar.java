package Vistas;


import javax.swing.*;
import java.awt.*;
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

    public VistaModificar() {

        setTitle("Ventana Modificar");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(3, 2));

        add(textTitulo);

        add(comboBoxDificultad);

        //calendario

        add(comboBoxEstado);

        add(comboBoxFrecuencia);

        //hora

        add(textFieldDescripcion);

        add(cancelarButton);

        add(aplicarButton);


    }

    public JTextField getTitulo(){
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

