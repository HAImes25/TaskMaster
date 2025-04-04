package Vista;

import Controladores.*;
import Modelos.*;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VistaCrearTarea extends JFrame{
    private JTextField titulo;
    private JComboBox dificultad;
    private JComboBox estado;
    private JComboBox frecuencia;
    private JTextField horaRevision;
    private JTextField descrpcion;
    private JLabel dificultadLabel;
    private JLabel calendarioLabel;
    private JLabel estadoLabel;
    private JLabel frecuenciaLabel;
    private JLabel horaRevisionLabel;
    private JLabel descripcionLabel;
    private JPanel Calendario;
    private JButton crearButton;
    private JPanel Frame;
    private javax.swing.JFrame frame;

    public VistaCrearTarea(){
        JFrame frame = new javax.swing.JFrame("Vista Modificar");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(Frame);
        setLocationRelativeTo(null);
        setContentPane(Frame);
        frame.setVisible(true);

        dificultad.addItem(" ");
        dificultad.addItem("Facil");
        dificultad.addItem("Intermedio");
        dificultad.addItem("Dificil");

        estado.addItem(" ");
        estado.addItem("Por empezar");
        estado.addItem("En proceso");
        estado.addItem("Completada");
        estado.addItem("Vencida");

        frecuencia.addItem(" ");
        frecuencia.addItem("Unica");
        frecuencia.addItem("Diaria");
        frecuencia.addItem("Semanal");
        frecuencia.addItem("mensual");
    }

    public void crearButtonListener(ActionListener listener) {
        crearButtonListener(listener);
    }




}
