package Vistas;

import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class VistaCrear extends JFrame {
    private JButton cancelarButton;
    private JButton crearTareaButton;
    private JPanel panelCrear;
    private JTextField textFieldTitulo;
    private JTextField textFieldDescripcion;
    private JComboBox comboBoxDificultad;
    private JComboBox comboBoxEstado;
    private JComboBox comboBoxFrecuencia;
    private JPanel JPanelCalendar;
    private javax.swing.JFrame frame;
    private com.toedter.calendar.JCalendar calendarComponent;


    public VistaCrear(){

        frame = new javax.swing.JFrame("Crear Tarea");
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panelCrear);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);






        String[] oDificultad = { "Facil", "Media", "Dificil"};
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



    }
    public JPanel getPanel(){
        return panelCrear;
    }

    public String getTitul(){
        return textFieldTitulo.getText().trim();
    }

    public String getDescripcion(){
        return textFieldDescripcion.getText().trim();
    }

    public String getComboBoxDificultad() {
        return comboBoxDificultad.getSelectedItem().toString();
    }

    public String getComboBoxEstado() {
        return comboBoxEstado.getSelectedItem().toString();
    }

    public String getComboBoxFrecuencia() {
        return comboBoxFrecuencia.getSelectedItem().toString();
    }

    public JFrame getFrame() {
        return frame;
    }

    public void addCancelarListener(ActionListener listener) {
        cancelarButton.addActionListener(listener);
    }

    public void addCrearListener(ActionListener listener){
         crearTareaButton.addActionListener(listener);
    }


    private void createUIComponents() {
        calendarComponent = new JCalendar();
        JPanelCalendar = new JPanel();
        JPanelCalendar.add(calendarComponent);
    }

    public java.util.Date getFechaSeleccionada() {
        return calendarComponent.getDate();
    }

    public String getFechaSeleccionadaComoString() {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(calendarComponent.getDate());
    }


}


