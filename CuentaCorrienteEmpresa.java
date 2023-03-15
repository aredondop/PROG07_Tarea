/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG07_Core;

/**
 *
 * @author Ángel
 */
public class CuentaCorrienteEmpresa extends CuentaCorriente{
    
    private int maximoDescubiertoPermitido, tipoInteresDescubierto, comisionFijaDescubierto;
    
    public CuentaCorrienteEmpresa( Persona titular, int saldo, String iban, String listaEntidadesAutorizadas, int maximoDescubiertoPermitido, int tipoInteresDescubierto, int comisionFijaDescubierto){
        super( titular, saldo, iban, listaEntidadesAutorizadas); //Trucazo java!
        this.maximoDescubiertoPermitido = maximoDescubiertoPermitido;
        this.tipoInteresDescubierto = tipoInteresDescubierto;
        this.comisionFijaDescubierto = comisionFijaDescubierto;
    }
    
    //Setters y Getters
    public int getMaximoDescubiertoPermitido() {
        return this.maximoDescubiertoPermitido;
    }

    public void setMaximoDescubiertoPermitido(int maximoDescubiertoPermitido) {
        this.maximoDescubiertoPermitido = maximoDescubiertoPermitido;
    }
    
    public int getComisionFijaDescubierto() {
        return this.comisionFijaDescubierto;
    }

    public void setComisionFijaDescubierto(int comisionFijaDescubierto) {
        this.comisionFijaDescubierto = comisionFijaDescubierto;
    }
    
    public int getTipoInteresDescubierto() {
        return this.tipoInteresDescubierto;
    }

    public void setTipoInteresDescubierto(int tipoInteresDescubierto) {
        this.tipoInteresDescubierto = tipoInteresDescubierto;
    }
    
    @Override
    public String devolverInfoString(){
        return "Cuenta Corriente Empresa " + super.devolverInfoString(); //Otro trucazo
    }
    
}
