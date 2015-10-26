package planificador;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random; 
import java.io.*;
import java.util.Scanner;

public class Proceso {
   public String nombre;
   public int rafaga;
   public int tiempo;
   public int memoria;
   public int llegada;
   public int id;
   public int prioridad;
   private float tejecucion;
   private float tespera=0; 
   private float trespuesta;
   //CONSTRUCTORES
   
// public Proceso(String nombre,int rafaga,int memoria,int llegada, int id, int prioridad, int quantum){
   public Proceso(String nombre,int rafaga,int memoria,int llegada, int id, int prioridad){
      this.nombre = nombre;
      this.rafaga = rafaga;
      this.memoria = memoria;
      this.llegada = llegada;
      this.id = id;
      this.prioridad = prioridad;
    
    
}
   public Proceso() {
   
   }
   //=======================Captura de procesos===========
   
   //METODO DE CAPTURA ALEATORIO
   public void CapturaProcesoAleatorio(int i){
      id = i;
      rafaga = randomInteger(1,100);//llama la funcion para generar numeros random
      llegada = randomInteger(1,10);
      nombre = getSaltString();//llama a la funcion para generar cadenas random
      memoria = randomInteger(1,1000);
      prioridad = randomInteger(1,10);
   }
   
   
   
   //METODO DE CAPTURA MANUAL
   public void CapturaProcesoManual(int i){
      BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
      Scanner in = new Scanner(System.in); //para ingresar los valores
   
   
      System.out.println("\n¿Id del proceso"+ i +"(1-10 maximo)?\n"); 
      id = in.nextInt();
      while (id>10) { //validacion
         System.out.println("Valor no valido, ingrese un valor menor a 11");
         id = in.nextInt();
      }
      System.out.println("\n¿Nombre del proceso"+ i + "(dos caracteres maximo)?\n");
      try{
         nombre = lee.readLine();
      }
      catch(IOException e){
         e.printStackTrace();
      }
      System.out.println("\n¿Tamaño de proceso" + i +"en memoria (1-1000)?\n");
      memoria = in.nextInt();
      while (memoria>1001) {
         System.out.println("Valor no valido, ingrese un valor menor a 1001");
         memoria = in.nextInt();
      }
      System.out.println("\n¿Tiempo de rafaga del proceso" + i + " (1-100 maximo)?\n"); 
      rafaga = in.nextInt();
      while (rafaga>101) {
         System.out.println("Valor no valido, ingrese un valor menor a 101");
         rafaga = in.nextInt();
      }
      System.out.println("\n¿Prioridad del proceso"+ i +"(1-10 maximo)?\n");
      prioridad = in.nextInt();
      while (prioridad>10) {
         System.out.println("Valor no valido, ingrese un valor menor a 11");
         prioridad = in.nextInt();
      }
      System.out.println("\n¿Tiempo de llegada del proceso"+ i +"(0-10 maximo)?\n");
      llegada = in.nextInt();
      while (llegada>10) {
         System.out.println("Valor no valido, ingrese un valor menor a 11");
         llegada = in.nextInt();
      }
   
   }
//================================   
   public void imprimir() {
      System.out.println("Id del Proceso:" + id);
      System.out.println("Nombre del proceso:"+nombre);
      System.out.println("Espacio en memoria del Proceso;" + memoria);
      System.out.println("Tiempo de rafaga del Proceso:" + rafaga);
      System.out.println("Prioridad del Proceso:" + prioridad);
      System.out.println("Tiempo de llegada del Proceso:" + llegada);
      System.out.println("----------------------------------------------------");
   }
         
   public int GetRafaga(){
      return rafaga;
   }
         
   public int GetId(){
      return id;
   }
         
   public void SetRafaga(int rafaga){
      this.rafaga=rafaga;
   }
   
   public float GetTEjecucion() {
		return tejecucion;
	}

   public void SetTEjecucion(float tejecucion) {
		this.tejecucion = tejecucion;
	}

   public float GetTespera() {
		return tespera;
	}

   public void SetTespera(float tespera) {
		this.tespera = tespera;
	}

    public float GetTRespuesta() {
		return trespuesta;
	}

    public void SetTRespuesta(float trespuesta) {
		this.trespuesta = trespuesta;
	}
	          
   public static int randomInteger(int min, int max) {//funcion para generar numeros random
   
      Random rand = new Random();
       // nextInt excludes the top value so we have to add 1 to include the top value
      int randomNum = rand.nextInt((max - min) + 1) + min;
   
      return randomNum;
   }
   
   public static String getSaltString() {//funcion para generar cadenas random
      String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
      StringBuilder salt = new StringBuilder();
      Random rnd = new Random();
      while (salt.length() < 10) {
         int index = (int) (rnd.nextFloat() * SALTCHARS.length());
         salt.append(SALTCHARS.charAt(index));
      }
      String saltStr = salt.toString();
      return saltStr;
   
   }
}
