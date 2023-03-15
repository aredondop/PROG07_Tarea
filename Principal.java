/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG07_Core;

/**
 *
 * @author Ángel
 */

import java.util.Scanner;   //Biblioteca para poder añadir el input
import java.util.Locale;

public class Principal {
    public static void main(String[] args) {
        
        //Definimos toda la broza del lugar   
        Scanner input = new Scanner(System.in); 
        input.useDelimiter("\n");
        input.useLocale(Locale.US);
        boolean salir = false;
        Banco miBanco = new Banco(); 
        
        //La mítica. Va a agregar 100 a mano Rita la cantaora
        if( miBanco.demo == true){ 
            int random = Auxiliar.mostrarMenuRandom();
            if( random > 0){
                for (int i = 0; i < random; i++) {
                    
                    switch( Auxiliar.generarInt(1) ){
                        case 4: case 5: case 6:
                            miBanco.abrirCuenta(Auxiliar.generarCuentaCorrientePersonalRandom());
                        break;
                        case 7: case 8: case 9:
                            miBanco.abrirCuenta(Auxiliar.generarCuentaCorrienteEmpresaRandom());
                        break;
                            
                        default:
                            miBanco.abrirCuenta(Auxiliar.generarCuentaAhorroRandom());      
                        
                    }

                }
            }
        }
        
        while(salir == false){
            
            //Más broza
            String nombreTitular, apellidoTitular, dniTitular;
            String iban, listaEntidadesAutorizadas, buscar;
            int eI = 0, saldo, tipoInteresRemunerado, comisionMantenimiento;
            int maximoDescubiertoPermitido, tipoInteresDescubierto, comisionFijaDescubierto;
            Persona titular;
            CuentaBancaria cuenta = null;
            String[] listadoCuentas;
            
            switch( Auxiliar.mostrarMenuPrincipal() ){ //Vamos mejorando!
                
                case 1:
                    if( miBanco.getTotalCuentas() < Banco.maximoCuentas ) {
                        nombreTitular = Auxiliar.pedirRetornarString("nombre del titular");
                        apellidoTitular = Auxiliar.pedirRetornarString("apellido del titular");
                        dniTitular = Auxiliar.pedirRetornarString("dni del titular");
                        titular = new Persona( nombreTitular, apellidoTitular, dniTitular);
                        
                        //Hasta aquí, todo correcto. Seguimos
                        saldo = Auxiliar.pedirRetornarInt("saldo inicial");
                        do{
                            if(eI > 0)
                                System.out.println("Has introducido un IBAN incorrecto");
                                
                            iban = Auxiliar.pedirRetornarString("IBAN");
                            ++eI;
                        }while( !iban.matches("^[0-9]{20}$")); //Expresión regular, sin más ni más
                        
                        //Vamos a por el tipo de cuenta
                        switch( Auxiliar.mostrarSubMenu() ){
                            case 1:
                                tipoInteresRemunerado = Auxiliar.pedirRetornarInt("Tipo de Interes Remunerado");
                                cuenta = new CuentaAhorro( titular, saldo, iban, tipoInteresRemunerado);
                            break;
                            
                            case 2:
                                listaEntidadesAutorizadas = Auxiliar.pedirRetornarString("contenido de la lista de entidades autorizadas");
                                comisionMantenimiento = Auxiliar.pedirRetornarInt("valor de la comision de mantenimiento");
                                cuenta = new CuentaCorrientePersonal( titular, saldo, iban, listaEntidadesAutorizadas, comisionMantenimiento);
                            break;
                            
                            case 3:
                                listaEntidadesAutorizadas = Auxiliar.pedirRetornarString("contenido de la lista de entidades autorizadas");
                                maximoDescubiertoPermitido = Auxiliar.pedirRetornarInt("valor del maximo descubierto permitido");
                                tipoInteresDescubierto = Auxiliar.pedirRetornarInt("valor del interes por descubierto");
                                comisionFijaDescubierto = Auxiliar.pedirRetornarInt("valor de la comision por descubierto");
                                cuenta = new CuentaCorrienteEmpresa( titular, saldo, iban, listaEntidadesAutorizadas, maximoDescubiertoPermitido, tipoInteresDescubierto, comisionFijaDescubierto );
                            break;        
                        }
                        //Por ultimo, lo creamos
                        if( miBanco.abrirCuenta(cuenta) )
                            System.out.println("Cuenta creada con exito");
                        else
                            System.out.println("Fallo al crear la cuenta");                        
                    }else //Fin del if de control de totales
                        System.out.println("El banco esta lleno. No puedes agregar cuentas.");
                break;
                
                case 2:
                    listadoCuentas = miBanco.listadoCuentas();
                    for (int i = 0; i < listadoCuentas.length; i++) {
                        System.out.println(listadoCuentas[i]);
                    }
                break;
                
                case 3: //Aun no tengo claro como sacarlo
                    //buscar = Auxiliar.pedirRetornarString("DNI");
                    listadoCuentas = miBanco.listadoCuentasDni( Auxiliar.pedirRetornarString("DNI") );
                    for (int i = 0; i < listadoCuentas.length; i++) {
                        System.out.println(listadoCuentas[i]);
                    }
                break;
                
                case 5:
                    buscar = Auxiliar.pedirRetornarString("Iban");
                    if(miBanco.informacionCuenta(buscar) != null )
                        System.out.println( miBanco.informacionCuenta(buscar) );
                    else
                        System.out.println("Cuenta no encontrada");
                break;
                
                case 4:
                    buscar = Auxiliar.pedirRetornarString("Iban");
                    if(miBanco.informacionCuenta(buscar) != null )
                        System.out.println( miBanco.obtenerSaldo(buscar) );
                    else
                        System.out.println("Cuenta no encontrada");
                break;
                
                case 6: //Ingreso
                    buscar = Auxiliar.pedirRetornarString("Iban");
                    if(miBanco.informacionCuenta(buscar) != null ){
                        saldo = Auxiliar.pedirRetornarInt("Saldo");
                        if( miBanco.ingresoCuenta(buscar, saldo) != false)
                            System.out.println("Ingreso realizado");
                        else
                            System.out.println("No se ha podido realizar el ingreso");
                            
                    }else
                        System.out.println("Cuenta no encontrada");
                break;
                
                case 7: //Retirada
                    buscar = Auxiliar.pedirRetornarString("Iban");
                    if(miBanco.informacionCuenta(buscar) != null ){
                        saldo = Auxiliar.pedirRetornarInt("Saldo");
                        if( miBanco.retiradaCuenta(buscar, saldo) != false)
                            System.out.println("Retirada realizada");
                        else
                            System.out.println("No se ha podido realizar la retirada");
                            
                    }else
                        System.out.println("Cuenta no encontrada");
                break;
                
                case 8: //Borrado
                    buscar = Auxiliar.pedirRetornarString("Iban");
                    if(miBanco.informacionCuenta(buscar) != null ){
                        if( miBanco.eliminarCuenta(buscar) != false)
                            System.out.println("Cuenta eliminada con exito");
                        else
                            System.out.println("No se ha podido eliminar la cuenta");
                    }else
                        System.out.println("Cuenta no encontrada");
                break;
                
                case 9:
                    salir = true;
                break;
                
                default: 
                    Auxiliar.mostrarCantinela();
            }
        }
       
    }
}
