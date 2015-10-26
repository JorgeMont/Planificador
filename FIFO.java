package planificador;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class FIFO {
  private static int i,j,tam,temp;    
  private static int pos = 0;
  
     ArrayList<Proceso> cola2 = new ArrayList<Proceso>();
        Proceso temo,imp;
        Proceso nuevo = new Proceso();
     
    public ArrayList<Proceso> acomodarFIFO(ArrayList<Proceso> cola){
    
    tam = cola.size();
        
        do {
            temo=cola.get(0);
            temp=temo.llegada;
        
            for (i=0; i<tam;i++ ) {
                temo = cola.get(i);

                if (temp >= temo.llegada) {
                    temp = temo.llegada;
                    pos = i;
                    nuevo = temo;
                }
            }

             cola.remove(pos);
           

             cola2.add(nuevo);
            //imprimir cola de procesos listos 
            System.out.println("************************************************");
            System.out.println("***********Cola de procesos listos**************");
            System.out.println("************************************************");
             for(j=0;j<cola2.size();j++){
                 imp=cola2.get(j);
                 imp.imprimir();
             }
             tam = cola.size();
             pos = 0;
      }
        while(cola.size()>0);
        return (cola2);
        }
    
    
}
