/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.*;
import domain.Persona;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author eugid
 */
public class TestManejoPersonas {

    public static void main(String[] args) throws SQLException {
        System.setProperty("file.encoding", "UTF-8");
        PersonaDAO personaDAO = new PersonaDAO();
        
        System.out.println("Estado incial de la base de datos....\n");
        List<Persona> personas = personaDAO.selecconar();
        listarPersonas(personas);
        
        System.out.println("Insertando nuevo registro....\n");
        Persona personaNueva = new Persona("Carlos", "Perez", "carlosperez@gmail.com", 54);
        personaDAO.insertar(personaNueva);
        personas = personaDAO.selecconar();
        listarPersonas(personas);

        System.out.println("Actualizando registro....\n");
        personaDAO.actualizar("Eugenio", "Gimeno Dolz", "eugido@hotmail.com", 43, 2);
        personas = personaDAO.selecconar();
        listarPersonas(personas);

        personaDAO.eliminar(2);
        System.out.println("Estado final de la base de datos....\n");
        personas = personaDAO.selecconar();
        listarPersonas(personas);
    }

    private static void listarPersonas(List<Persona> personas) {
        if (personas == null || personas.isEmpty()){
            throw new IllegalArgumentException("La lista proporcionada está vacia.");
        }
        int contador = 0;
        for (Persona unaPersona : personas) {
            contador++;
            System.out.println("La " + contador + "º " + "persona es: " + unaPersona.toString());
            System.out.println("");
        }
    }
}
