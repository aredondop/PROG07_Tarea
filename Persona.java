/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG07_Core;

/**
 *
 * @author Ángel
 */
public class Persona implements Imprimible{
    
    private String nombre, apellidos, dni;
    
    public Persona( String nombre, String apellidos, String dni){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }
    //Getter
    public String getDni(){
        return this.dni;
    }
    
    @Override
    public String devolverInfoString(){
        return "Titular " + this.nombre + " "+ this.apellidos + " dni: "+ this.dni; //Otro trucazo
    }
    
}
