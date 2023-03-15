/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG07_Core;

/**
 *
 * @author �ngel
 * 
 * Para todos nuestros m�todos est�ticos
 */

//Dependencias para jugar con fechas, reges, contar palabras, etc
import java.time.LocalDate;
import java.util.StringTokenizer;
import java.util.Scanner; 
import java.util.concurrent.ThreadLocalRandom;

public class Auxiliar {
    
    // Se le pasa un DNI y nos devuelve true o false seg�n si coincide o no. Simplificada con regex
    public static boolean validarDNI(String dni){
        return dni.matches("^[0-9]{8}[A-Z&&[^IOU]]");  //Simplificado
        //return dni.matches("^[0-9]{8}[A-Z]{1}$");
    }
    

    
    public static boolean validarNombre( String nombrecompleto){
        
        StringTokenizer total = new StringTokenizer(nombrecompleto); //Sacamos palabras
        
        if(nombrecompleto.length() > 40 || !nombrecompleto.matches( "[a-zA-z]+([ '-][a-zA-Z]+)*" ) || total.countTokens() != 2 ){
            return false;
        }else
            return true;
    }
    
    //Para mostrar el menu principaldonde nos haga falta
    public static int mostrarMenuPrincipal(){
        Scanner input = new Scanner(System.in); 
        final int menuInicio = 1, menuFin = 9;
        int leerMenu;
        boolean menuOk = true;
        
        do{
            if( menuOk == false)
                System.out.println("Debes elegir un elemento que esté en el menu, entre "+ menuInicio + " y " +menuFin);
            
            System.out.println("##############################################");
            System.out.println("#       BANCO TIMADOR LA ESTAMPITA SA        #");
            System.out.println("#              Pulsa un numero               #");
            System.out.println("#   1. Abrir una nueva cuenta                #");
            System.out.println("#   2. Listar todas las cuentas              #");
            System.out.println("#   3. Listar cuentas de un cliente          #");
            System.out.println("#   4. Consultar saldo de una cuenta         #");
            System.out.println("#   5. Obtener datos de una cuenta           #");
            System.out.println("#   6. Realizar un ingreso en cuenta         #");
            System.out.println("#   7. Retirar efecitvo de una cuenta        #");
            System.out.println("#   8. Eliminar una cuenta                   #");
            System.out.println("#   9. Salir                                 #");
            System.out.println("##############################################");
            
            leerMenu = input.nextInt();
            
            menuOk = (leerMenu>=menuInicio && leerMenu <=menuFin);
        }while( !menuOk );
        
        return leerMenu;
        
    }
    
    public static int mostrarSubMenu(){
        Scanner input = new Scanner(System.in); 
        final int menuInicio = 1, menuFin = 3;
        int leerMenu;
        boolean menuOk = true;
        
        do{
            if( menuOk == false)
                System.out.println("Debes elegir un elemento que esté en el menu, entre "+ menuInicio + " y " +menuFin);
            
            System.out.println("##############################################");
            System.out.println("#         Escoge el tipo de cuenta           #");
            System.out.println("#              Pulsa un numero               #");
            System.out.println("#   1. Cuenta Ahorro                         #");
            System.out.println("#   2. Cuenta Corriente Personal             #");
            System.out.println("#   3. Cuenta Corriente Empresa              #");
            System.out.println("##############################################");
            
            leerMenu = input.nextInt();
            
            menuOk = (leerMenu>=menuInicio && leerMenu <=menuFin);
        }while( !menuOk );
        
        return leerMenu;
        
    }
    
    //Para pedir brozas genéricas en string
    public static String pedirRetornarString( String mensaje){
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce el " +  mensaje);
        return input.next();
    }
    //Para pedir brozas genéricas en int
    public static int pedirRetornarInt( String mensaje){
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce el " +  mensaje);
        return input.nextInt();
    }
    
    //Para mostrar el errores donde haga falta
    public static void mostrarError( String mensaje){
         System.out.println("Error "+ mensaje +". Revisa lo que has introducido");
    }
     
    //Para mostrar, because yes
    public static void mostrarCantinela(){
        System.out.println("Mi banco me lo robaron anoche mientras dormia");
        System.out.println("Mi banco me lo robaron estando de romeria");
        System.out.println("Donde estara mi banco");
    }
     
    //Para hacernos cadenas al azar y no andar penando
    
    public static int mostrarMenuRandom(){
        int total;
        Scanner input = new Scanner(System.in);
        
        do{
            System.out.println("Introduce el numero de cuentas que quieras crear aleatoriamente. Minimo 0 y Maximo " + Banco.maximoCuentas);
            total = input.nextInt();
        }while( !Auxiliar.validarMenuRandom(total) );
        
        return total;
    }
    
    public static boolean validarMenuRandom(int valor){
        if( valor >= 0 && valor <= Banco.maximoCuentas){
            return true;
        }else{
            return false;
        }
    }
    
    //Generadores de cosas al azar
    public static Persona generarTitularRandom(){
        Persona titularRandom;
        int nn = (int)(Math.random()*10+0);
        int na = (int)(Math.random()*10+0);
        String dni = "";
        for( int a = 0; a < 3; a++){
            dni += Integer.toString( Auxiliar.generarInt(1) );
        }
        dni += Auxiliar.generarString(1);
        
        String[] nombreR = {"Manolo", "Cristina", "Juan", "Maria", "Antonio", "Rosa", "Luis", "Julia", "Roberto", "Laura"};
        String[] apellidoR = {"Rodriguez", "Gutierrez", "Alvarez", "Garcia", "Andrade", "Montoya", "Villalba", "Jimenez", "Corrales", "Sotomayor"};
        
        return titularRandom = new Persona( nombreR[nn], apellidoR[na], dni );
        
    }
    
    public static String generarIbanRandom(){
        String iban = "";
        for( int a = 0; a < 20; a++){
            iban += Integer.toString( Auxiliar.generarInt(1) );
        }
        return iban;
    }
    
    public static CuentaAhorro generarCuentaAhorroRandom(){
        CuentaAhorro cuenta;
        cuenta = new CuentaAhorro( Auxiliar.generarTitularRandom(), Auxiliar.generarInt(10), Auxiliar.generarIbanRandom(), Auxiliar.generarInt(1));
        return cuenta;
    }
    
    public static CuentaCorrientePersonal generarCuentaCorrientePersonalRandom(){
        CuentaCorrientePersonal cuenta;
        cuenta = new CuentaCorrientePersonal( Auxiliar.generarTitularRandom(), Auxiliar.generarInt(10), Auxiliar.generarIbanRandom(), Auxiliar.generarString(5), Auxiliar.generarInt(1) );
        return cuenta;
    }
            
    public static CuentaCorrienteEmpresa generarCuentaCorrienteEmpresaRandom(){        
        CuentaCorrienteEmpresa cuenta;
        cuenta = new CuentaCorrienteEmpresa( Auxiliar.generarTitularRandom(), Auxiliar.generarInt(10), Auxiliar.generarIbanRandom(), Auxiliar.generarString(5), Auxiliar.generarInt(1), Auxiliar.generarInt(1), Auxiliar.generarInt(1));
        return cuenta;
    }
    
    
    public static String generarString( int longitud){
   
        String cadena = "", banco = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        for (int x = 0; x < longitud; x++) {
            int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
            char caracterAleatorio = banco.charAt(indiceAleatorio);
            cadena += caracterAleatorio;
        }
        return cadena;
    }

     
    public static int generarInt( int longitud){
   
        int cadena = 0;
        String banco = "1234567890";
        
        for (int x = 0; x < longitud; x++) {
            int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
            char caracterAleatorio = banco.charAt(indiceAleatorio);
            cadena += caracterAleatorio;
        }
        return cadena;
    }
     
     public static int numeroAleatorioEnRango(int minimo, int maximo) {
        // nextInt regresa en rango pero con limite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }
}
