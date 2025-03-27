package Vista;

import org.jdatepicker.impl.*;
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Properties;

public class VistaCrearTarea extends JFrame{
    private JTextField titulo;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JTextField horaRevision;
    private JTextField descrpcion;
    private JLabel tituloLabel;
    private JLabel dificultadLabel;
    private JLabel calendarioLabel;
    private JLabel estadoLabel;
    private JLabel frecuenciaLabel;
    private JLabel horaRevisionLabel;
    private JLabel descripcionLabel;
    private JPanel Calendario;
    private JButton crearButton;
    private JPanel Frame;
    frame = new javax.swing.JFrame("Vista Modificar");frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);frame.getContentPane().add(PanelModificar);frame.pack();frame.setLocationRelativeTo(null);frame.setVisible(true);
    public VistaCrearTarea(){
        setTitle("Date Picker");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(Frame);
        setLayout(new GridLayout(18,2));


    }




}
