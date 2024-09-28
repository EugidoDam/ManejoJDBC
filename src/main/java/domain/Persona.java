/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author eugid
 */
public class Persona {

    private int idPersona;
    private String nombre;
    private String apellidos;
    private String email;
    private int edad;

    public Persona() {
    }

    public Persona(int idPersona) {
        if (idPersona < 0) {
            throw new IllegalArgumentException("Se espera que el parámetro introducido sea un entero mayor que cero. ");
        }
        this.idPersona = idPersona;
    }

    public Persona(String nombre, String apellidos, String email, int edad) {
        if (nombre == null || nombre.trim().length() < 1 || apellidos == null
                || apellidos.trim().length() < 1 || email == null || email.trim().length() < 1
                || edad < 0) {
            throw new IllegalArgumentException("Alguno de los argumentos introducidos no son validos. ");
        }
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.edad = edad;
    }

    public Persona(int idPersona, String nombre, String apellidos, String email, int edad) {
        if (idPersona < 0 || nombre == null || nombre.trim().length() < 1 || apellidos == null
                || apellidos.trim().length() < 1 || email == null || email.trim().length() < 1
                || edad < 0) {
            throw new IllegalArgumentException("Alguno de los argumentos introducidos no son validos. ");
        }
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.edad = edad;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public int getEdad() {
        return edad;
    }

    public void setIdPersona(int idPersona) {
        if (idPersona < 0) {
            throw new IllegalArgumentException("Se espera que el id de la persona sea un entero mayor que cero. ");
        }
        this.idPersona = idPersona;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().length() < 1) {
            throw new IllegalArgumentException("Se espera que el nombre sea una cadena de caracteres. ");
        }
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        if (apellidos == null || apellidos.trim().length() < 1) {
            throw new IllegalArgumentException("Se espera que los apellidos sean una cadena de caracteres. ");
        }
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().length() < 1) {
            throw new IllegalArgumentException("Se espera que el email sean una cadena de caracteres. ");
        }
        this.email = email;
    }

    public void setEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("Se espera que la edad sea un entero mayor que cero. ");
        }
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "\n\tNombre: " + nombre + ", \n\tApellidos: " + apellidos + ", \n\tEmail: " + email + ", \n\tEdad: " + edad;
    }
}
