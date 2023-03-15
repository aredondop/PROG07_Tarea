/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG07_Core;

/**
 *
 * @author Ángel
 */
public class CuentaCorrientePersonal extends CuentaCorriente{
    
    private int comisionMantenimiento;
    
    public CuentaCorrientePersonal( Persona titular, int saldo, String iban, String listaEntidadesAutorizadas, int comisionMantenimiento){
        super( titular, saldo, iban, listaEntidadesAutorizadas); //Trucazo java!
        this.comisionMantenimiento = comisionMantenimiento;
    }
    
    //Setters y Getters
    public int getComisionMantenimiento() {
        return this.comisionMantenimiento;
    }

    public void setComisionMantenimiento(int comisionMantenimiento) {
        this.comisionMantenimiento = comisionMantenimiento;
    }
    
    @Override
    public String devolverInfoString(){
        return "Cuenta Corriente Personal " + super.devolverInfoString(); //Otro trucazo
    }
    
}
