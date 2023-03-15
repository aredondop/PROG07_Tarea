/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG07_Core;

/**
 *
 * @author Ángel
 */
public abstract class CuentaCorriente extends CuentaBancaria{
    private String listaEntidadesAutorizadas;
    
    public CuentaCorriente( Persona titular, int saldo, String iban, String listaEntidadesAutorizadas){
        super( titular, saldo, iban); //Trucazo java!
        this.listaEntidadesAutorizadas = listaEntidadesAutorizadas;
    }
    
    //Setters y Getters
    public String getListaEntidadesAutorizadas() {
        return listaEntidadesAutorizadas;
    }

    public void setListaEntidadesAutorizadas(String listaEntidadesAutorizadas) {
        this.listaEntidadesAutorizadas = listaEntidadesAutorizadas;
    }
    
    @Override
    public String devolverInfoString(){
        return super.devolverInfoString(); //Otro trucazo
    }
    
}
