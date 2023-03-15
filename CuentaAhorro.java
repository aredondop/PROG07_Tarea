/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG07_Core;

/**
 *
 * @author Ángel
 */
public class CuentaAhorro extends CuentaBancaria{
    
    private int tipoInteresRemuneracion; //Atributo distintivo
    
    //Constructores y toda la broza
    public CuentaAhorro( Persona titular, int saldo, String iban){
        super( titular, saldo, iban); //Trucazo java!
        this.tipoInteresRemuneracion = 0;
    }
    
    public CuentaAhorro( Persona titular, int saldo, String iban, int tipoInteresRemuneracion){
        super( titular, saldo, iban); //Trucazo java!
        this.tipoInteresRemuneracion = tipoInteresRemuneracion;
    }
    
    //Setters y Getters
    public int GetInteres(){
        return this.tipoInteresRemuneracion;
    }
    
    public void SetInteres( int tipoInteresRemuneracion ){
        this.tipoInteresRemuneracion = tipoInteresRemuneracion;
    }
    
    @Override
    public String devolverInfoString(){
        return "Cuenta de Ahorro " + super.devolverInfoString(); //Otro trucazo
    }
    
}
