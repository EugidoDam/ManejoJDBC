/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author eugenio
 */
public class TestMySQLJDBC {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            // Carga del driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Conexión a la base de datos
            Connection conexion = DriverManager.getConnection(url, "root", "MENXureta82");

            // Creación de una instrucción SQL
            Statement instruccion = conexion.createStatement();
            String sql = "SELECT Id_persona, Nombre, Apellidos, Email, Edad FROM Persona";

            // Ejecución de la consulta y obtención del resultado
            ResultSet resultado = instruccion.executeQuery(sql);

            // Iterar sobre los resultados
            while (resultado.next()) {
                System.out.println("Id Persona: " + resultado.getInt("Id_persona"));
                System.out.println("Nombre: " + resultado.getString("Nombre"));
                System.out.println("Apellidos: " + resultado.getString("Apellidos"));
                System.out.println("Email: " + resultado.getString("Email"));
                System.out.println("Edad: " + resultado.getInt("Edad"));
            }

            // Faltaba Cerrar recursos
            resultado.close();
            instruccion.close();
            conexion.close();

            //Faltaba try-catch    
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
