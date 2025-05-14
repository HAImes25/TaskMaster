package Vistas;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VistaRegistro extends JFrame{
    private JPanel panelRegistro;
    private JLabel LabelTitulo;
    private JTextField textFieldNombre;
    private JTextField textFieldContraseña;
    private JButton confirmarButton;
    private JButton inicoDeSesionButton;
    private JTextField textFieldConfirmarContraseña;
    private JTextField textFieldEmail;
    private JLabel labelConfirmarConstraseña;
    private JLabel labelEmail;
    private JLabel IMG;

    public VistaRegistro(){
        setTitle("Administrador de Tareas");
        //setSize(420, 570); // inicial
        setSize(375, 667); // iPhone 8
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(panelRegistro);

    }

    public String getJTextNombre(){
        return textFieldNombre.getText().trim();
    }

    public String getJTextContraseña(){
        return textFieldContraseña.getText().trim();
    }

    public String getJTextConfirmarContraseña(){
        return textFieldConfirmarContraseña.getText().trim();
    }

    public String getJTextEmail(){
        return textFieldEmail.getText().trim();
    }


    public void addActionBotonAceptar(ActionListener listener){
        confirmarButton.addActionListener(listener);
    }




}


