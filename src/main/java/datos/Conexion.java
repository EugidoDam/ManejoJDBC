/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author eugid
 */
public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "MENXureta82";

    private Connection conexion; // Almacena la conexión

    // Constructor que inicializa la conexión
    public Conexion() {
        try {
            this.conexion = getConnection(); // Establece la conexión
            System.out.println("Conexión establecida correctamente.");
        } catch (SQLException ex) {
            System.out.println("La conexión no se puede establecer: " + ex.getMessage());
        }
    }
    
    // Método para obtener la conexión
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
    
    // Métodos para cerrar recursos
    public static void close(ResultSet resultado) throws SQLException {
        if (resultado != null) {
            resultado.close();
        }
    }
    
    public static void close(Statement estado) throws SQLException {
        if (estado != null) {
            estado.close();
        }
    }
    
    public static void close(Connection conexion) throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
    
    // Método para cerrar la conexión al terminar
    public void cerrarConexion() {
        try {
            if (this.conexion != null && !this.conexion.isClosed()) {
                this.conexion.close();
                System.out.println("Conexión cerrada.");
                System.out.println();
            }
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión: " + ex.getMessage());
            System.out.println();
        }
    }
}
