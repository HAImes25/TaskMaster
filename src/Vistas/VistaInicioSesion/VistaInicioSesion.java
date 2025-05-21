package Vistas.VistaInicioSesion;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VistaInicioSesion extends JFrame{
    private JTextField textFieldUsuario;
    private JPasswordField textFieldContraseña;
    private JButton registroButton;
    private JButton aceptarButton;
    private JPanel panelInicioSesion;
    private JLabel labelError;

    public VistaInicioSesion(){
        setTitle("Inicio Sesion");
        //setSize(420, 570); // inicial
        setSize(375, 667); // iPhone 8
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(panelInicioSesion);

    }

    public String getNombreText(){
        return textFieldUsuario.getText().trim();
    }

    public String getContraseñaText(){
        return textFieldContraseña.getText().trim();
    }

    public void limpiarVista(){
        textFieldUsuario.setText("");
        textFieldContraseña.setText("");
    }

    public void mensajeError(String mensaje){
        labelError.setText(mensaje);
    }

    public void addActionBotonAceptar(ActionListener listener){
        aceptarButton.addActionListener(listener);
    }

    public void addActionBotonRegistro(ActionListener listener){
        registroButton.addActionListener(listener);
    }

    public Boolean comprobarCampos(){
        if (!getNombreText().isEmpty() || !getContraseñaText().isEmpty()){
            return true;
        }
        return false;
    }







}
