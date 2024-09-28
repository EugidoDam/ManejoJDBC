/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import domain.Persona;
import java.util.*;
import java.sql.*;

/**
 *
 * @author eugid
 */
public class PersonaDAO {

    private static final String SQL_SELECT = "SELECT Id_persona, Nombre, Apellidos, Email,  Edad FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona (nombre, apellidos, email, edad) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellidos = ?, email = ?, edad = ? WHERE Id_persona = ?";
    ;
    private static final String SQL_DELETE = "DELETE FROM persona WHERE Id_persona = ?";

    public List<Persona> selecconar() throws SQLException {
        Connection conexion = null;
        PreparedStatement situacionEstado = null;
        ResultSet resultado = null;
        Persona unaPersona = null;
        List<Persona> personas = new ArrayList<>();

        try {
            conexion = Conexion.getConnection();
            situacionEstado = conexion.prepareStatement(SQL_SELECT);
            resultado = situacionEstado.executeQuery();
            while (resultado.next()) {
                int idPersona = resultado.getInt("Id_Persona");
                String nombre = resultado.getString("Nombre");
                String apellidos = resultado.getString("Apellidos");
                String email = resultado.getString("Email");
                int edad = resultado.getInt("Edad");
                unaPersona = new Persona(idPersona, nombre, apellidos, email, edad);
                personas.add(unaPersona);

            }
        } catch (SQLException ex) {
            System.out.println("Conexión no realizado. " + ex.getMessage());
            System.out.println();
        } finally {
            Conexion.close(conexion);
            Conexion.close(resultado);
            Conexion.close(situacionEstado);
        }

        return personas;
    }

    public int insertar(Persona unaPersona) throws SQLException {
        if(unaPersona == null){
            throw new IllegalArgumentException("La persona facilitada no tiene datos. ");
        }
        Connection conexion = null;
        PreparedStatement situacionEstado = null;
        int registros = 0;

        try {
            conexion = Conexion.getConnection();
            situacionEstado = conexion.prepareStatement(SQL_INSERT);
            situacionEstado.setString(1, unaPersona.getNombre());
            situacionEstado.setString(2, unaPersona.getApellidos());
            situacionEstado.setString(3, unaPersona.getEmail());
            situacionEstado.setInt(4, unaPersona.getEdad());
            registros = situacionEstado.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("No se ha insertado el nuevo registro. " + ex.getMessage());
            System.out.println();
        } finally {
            try {
                Conexion.close(conexion);
                Conexion.close(situacionEstado);

            } catch (SQLException ex) {
                System.out.println("No se ha podido cerrar la conexión. " + ex.getMessage());
                System.out.println();
            }
        }

        return registros;
    }

    public void actualizar(String nombre, String apellidos, String email, int edad, int idPersona) throws SQLException {
         if (idPersona < 0 || nombre == null || nombre.trim().length() < 1 || apellidos == null
                || apellidos.trim().length() < 1 || email == null || email.trim().length() < 1
                || edad < 0) {
            throw new IllegalArgumentException("Alguno de los argumentos introducidos están vacios. ");
        }
        Connection conexion = null;
        PreparedStatement situacionEstado = null;

        try {
            conexion = Conexion.getConnection();
            situacionEstado = conexion.prepareStatement(SQL_UPDATE);
            situacionEstado.setString(1, nombre);
            situacionEstado.setString(2, apellidos);
            situacionEstado.setString(3, email);
            situacionEstado.setInt(4, edad);
            situacionEstado.setInt(5, idPersona);
            int registroactualizado = situacionEstado.executeUpdate();
            if (registroactualizado > 0) {
                System.out.println("El registro ha sido actualizado correctamente. ");
                System.out.println();
            } else {
                System.out.println("No se ha podido realizar la actualización del registro");
                System.out.println();
            }
        } catch (SQLException ex) {
            System.out.println("Actualizacion no realizada. " + ex.getMessage());
            System.out.println();
        } finally {
            Conexion.close(situacionEstado);
            Conexion.close(conexion);
        }
    }

    public void eliminar(int idPersona) throws SQLException {
        if(idPersona < 0){
            throw new IllegalArgumentException("El ID debe de ser un numero mayor que cero. ");
        }
        Connection conexion = null;
        PreparedStatement situacionEstado = null;

        try {
            conexion = Conexion.getConnection();
            situacionEstado = conexion.prepareStatement(SQL_DELETE);
            situacionEstado.setInt(1, idPersona);
            int registrosEliminados = situacionEstado.executeUpdate();
            if (registrosEliminados > 0) {
                System.out.println("Persona eliminada con éxito.");
                System.out.println();
            } else {
                System.out.println("No se encontró la persona con el ID proporcionado.");
                System.out.println();
            }
        } catch (SQLException ex) {
            throw new IllegalStateException("No se ha eliminado el registro que se esperaba eliminar" + ex.getMessage());
        } finally {
            Conexion.close(situacionEstado);
            Conexion.close(conexion);
        }
    }
}
