package ConexionesBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/task_master";
    private static final String USUARIO = "root";
    private static final String CONSTRASEÑA = "";

    // Metodo para conectarte
    public static Connection conectar(){
        try {
            // Intento de conexion, sino envia el mensaje de error
            System.out.println("Conexion correcta");
            return DriverManager.getConnection(URL, USUARIO, CONSTRASEÑA);
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException("Error al conectar con la base de datos");
        }
    }

}
