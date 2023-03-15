/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG07_Core;

/**
 *
 * @author Ángel
 */
public abstract class CuentaBancaria implements Imprimible {

    private int saldo;
    private String iban;
    private Persona titular;
        
    public CuentaBancaria( Persona titular, int saldo, String iban){
        this.titular = titular;
        this.saldo = saldo;
        this.iban = iban;
    }
    
    //Setters y Getters
    public String getIban(){
        return this.iban;
    }
    
    public void setSaldo( int saldo ){
        this.saldo = saldo;
    }
    
    public int getSaldo(){
        return this.saldo;
    }
    
    public Persona getTitular(){
        return this.titular;
    }
    
    @Override
    public String devolverInfoString(){
        return "iban: "+ this.iban + ", titular: " + this.titular.devolverInfoString() + " saldo " +  this.saldo;
    }
        
    
        
    
}
