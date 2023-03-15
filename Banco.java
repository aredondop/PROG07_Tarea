/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG07_Core;

/**
 *
 * @author Ángel
 */
public class Banco {
    
    public static final int maximoCuentas = 100;    //Para setear el máximo
    protected static boolean demo = true;          //Para setear el demo
    private int totalCuentas;
    private final CuentaBancaria[] cuentas;
    
    //Constructor. Nada nuevo
    public Banco(){
        this.totalCuentas = 0;
        this.cuentas = new CuentaBancaria[maximoCuentas];
    }
    
    public int getTotalCuentas(){
        return this.totalCuentas;
    }
    
    //Este es el método que vertebra todo. Sin él, no podemos hacer el resto
    public CuentaBancaria buscarCuenta(String iban){
        for (int i = 0; i < this.totalCuentas; i++) {            
            if(this.cuentas[i].getIban().equals(iban))
                return this.cuentas[i];
        }
        return null;
    }
    
    //Para abrir una cuenta
    public boolean abrirCuenta( CuentaBancaria cuenta){ 
        if( this.totalCuentas == this.maximoCuentas)
            return false; //Si llegamos al tope

        if ( this.buscarCuenta(cuenta.getIban()) == null ) {        
            this.cuentas[this.totalCuentas] = cuenta;
            this.totalCuentas++; //Subimos el contador, que empezó en 0
            return true; 
        }else
            return false; //Si ya lo existe  
    }
    
    //Para listar las cuentas
    public String[] listadoCuentas() {
        String[] listadoCuentas = new String[this.totalCuentas];
        for(int i = 0; i < this.totalCuentas; i++) {
            listadoCuentas[i] = this.cuentas[i].devolverInfoString();
        }
        return listadoCuentas;
    }
    
    //Versión cutre pero funcional, habría que limpiar los nulos
    public String[] listadoCuentasDni( String dni) {
        String[] listadoCuentas = new String[this.totalCuentas];
        for(int i = 0; i < this.totalCuentas; i++) {
            
            if( this.cuentas[i].devolverInfoString().contains(dni))
                listadoCuentas[i] = this.cuentas[i].devolverInfoString();
        }
        return listadoCuentas;
    }
    
    //Para ver la info de una cuenta
    public String informacionCuenta(String iban) {
        CuentaBancaria cuenta = this.buscarCuenta(iban);
        return (cuenta != null)?  cuenta.devolverInfoString() : null;
    }
    
    //Derivada de la anterior
    public int obtenerSaldo(String iban) {
        CuentaBancaria cuenta = this.buscarCuenta(iban);
        return (cuenta != null)?  cuenta.getSaldo() : -1;
    }
    
    //Derivada de listadoCuentas
    public String[] cuentasCliente( String dni){
        String[] listadoCuentas = new String[this.totalCuentas];
        for(int i = 0; i < this.totalCuentas; i++) {
            listadoCuentas[i] = this.cuentas[i].devolverInfoString();
        }
        return listadoCuentas;
    }
    
    //Para ingresar dinero
    public boolean ingresoCuenta( String iban, int cantidad){
        CuentaBancaria cuenta = this.buscarCuenta(iban);       
        if ( cuenta != null ) {        
            cuenta.setSaldo( cuenta.getSaldo() + cantidad );
            return true; 
        }else
            return false;
        
    }
    
    //Para retirar dinero. Derivada de la anterior. Habría que añadir algo específico para empresas
    public boolean retiradaCuenta( String iban, int cantidad){
        CuentaBancaria cuenta = this.buscarCuenta(iban);       
        if ( cuenta != null ) { 
            int saldo = cuenta.getSaldo();
            if( saldo >= cantidad ){
                cuenta.setSaldo( saldo - cantidad);
                return true;
            }else
              return false;  
        }else
            return false;
        
    }
    
    //Para eliminar una cuenta
    public boolean eliminarCuenta( String iban){
        
        for (int i = 0; i < this.totalCuentas; i++) {
            CuentaBancaria cuentaBuscada = this.cuentas[i];
            
            if(cuentaBuscada.getIban().equals(iban)){
                this.cuentas[i] = null;
                
                for (int j = i+1; j < this.totalCuentas; j++) {
                   this.cuentas[i] = this.cuentas[j];
                }
                this.totalCuentas--;
                return true;
            }
        }
        
        return false;
    }
    
   
}
