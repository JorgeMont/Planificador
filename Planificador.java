package planificador;
import java.util.Scanner;
import java.io.*;
import java.util.Random; 
import java.util.ArrayList;
import java.util.List;

public class Planificador {
   public static int cantidad;
   public static int quantum;
   public static int opc;//variables propias de la clase

  
    public static void main(String[] args) {
      //VARIABLES LOCALES
      BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
      Scanner in = new Scanner(System.in); //para ingresar los valores
      int rafaga,memoria,llegada, cantidad,opc, prioridad,id;//el quantum debe ser leido desde el usuario
      int i = 0;
      String nombre = "";
      ArrayList<Proceso> cola = new ArrayList<Proceso>();//array list para almacenar los procesos
      ArrayList<Proceso> col,colRam;
      Proceso unProceso, proceso;
      
      //DATOS DE INICIALIZACION DEL SIMULADOR
        
      System.out.println("\n¿Cuantos procesos deseas generar (1-10 maximo)?\n");
      cantidad = in.nextInt(); //lectura desde el teclado
      while (cantidad>10) { //validacion de los datos 
         System.out.println("Valor no valido, ingrese un valor menor a 11");
         cantidad = in.nextInt();
      }
        
      System.out.println("\n¿Quantum (1-50)?\n");
      quantum = in.nextInt(); //el Quantum es el mismo para cada proceso
      while (quantum>50) {
         System.out.println("Valor no valido, ingrese un valor menor a 50");
         quantum = in.nextInt();
      }
                         
      SimulacionCPU cpu=new SimulacionCPU(quantum); //se le manda el quantun al simulador              
      
      
      //1) CREAR Y CAPTURAR PROCESOS                   
      do {
         System.out.println("\n¿Como desea generar los procesos?\n");                 
         System.out.println("\n1)Aleatoriamente\n2)Manualmente\n");
         opc = in.nextInt();
             
         switch(opc)  {  //menu para la seleccion del tipo de ingreso de datos   
            case 1://Crea procesos aleatoriamente
               for (i=1;i<=cantidad;i++) { 
                  proceso = new Proceso();
                  proceso.CapturaProcesoAleatorio(i);
                  cola.add(proceso);
               } 
               break;
            case 2://Crea procesos manualmente
               for (i=1; i<=cantidad ;i++) { 
                  proceso = new Proceso();
                  proceso.CapturaProcesoManual(i);
                  cola.add(proceso);
               }
               break;          
            default:
               System.out.println("Opcion no valida\n Seleccione 1 o 2");
               break;
         }
      } 
      
      while (opc !=1 && opc !=2);
         
       //2) UNA VEZ CREADOS LOS PROCESOS se suben a la lista de LISTOS
      FIFO f=new FIFO(); 
      col=f.acomodarFIFO(cola);//se acomdan los procesos en orden de llegada en la cola2
   
//=== aqui inicia un ciclo para estar subiendo procesos a la cpu hasta que la cola de listos y la RAM este vacia======
   
      //3) se suben a la lista de LISTOS-EJECUCION
   
      Ram r=new Ram();
      colRam=r.subir(col);//Se suben los procesos en orden de llegada que quepan en la memoria
      unProceso=r.elemRam(); //mr regresa el primer proceso que se alojo en la RAM y se libera espacio en la RAM
      //4)sube proceso a la CPU
      cpu.CPU(unProceso);//pone ese proceso en la cpu
      colRam.remove(unProceso);//Elimina el proceso de la ram
                 //si hay espacio suficiente se carga el siguiente proceso de la cola 2 a la RAM
                //cuando acabe el proceso en la cpu y su rafaga es mayor a 0, se forma en cola2
               //si el tiempo de llegada del que sigue es mayor a  

//=== aqui termina el ciclo para estar subiendo procesos a la cpu======


   }
    
    }
    
