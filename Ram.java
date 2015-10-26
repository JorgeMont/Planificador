package planificador;
import java.util.ArrayList;

public class Ram {
    private static int j;    
    private static int mem,memTotal=1000;
    Proceso imp,masMem;
    ArrayList<Proceso> ram = new ArrayList<Proceso>();
       
   public void Ram(int memTotal){
   this.memTotal=memTotal;
   
   }
      
     
    public ArrayList<Proceso> subir(ArrayList<Proceso> cola2){
        do {
            if(cola2.size() > 0){
                Proceso extraerElem=cola2.get(0);
             mem=extraerElem.memoria;
             if(memTotal>=extraerElem.memoria){
                    cola2.remove(extraerElem);  
                    System.out.println("**************************************************");
                    System.out.println("************Cola de procesos listos***************");
                    System.out.println("**************************************************");
                    for(j=0;j<cola2.size();j++){
                    imp=cola2.get(j);
                    imp.imprimir();
                    }
        
                    ram.add(extraerElem);
                    System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                    System.out.println("=====Cola de procesos listos para la ejecucion-->RAM=====");
                    System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                    for(j=0;j<ram.size();j++){
                    imp=ram.get(j);
                    imp.imprimir();
                    }
                    
                    memTotal=memTotal-extraerElem.memoria;
             }
         
             if(memTotal>=0){
                 
             System.out.println("===========================================");    
             System.out.println("===================MEMORIA================="); 
             System.out.println("===========================================");  
             System.out.println("Subio el proceso"+extraerElem.nombre+" con id: "+extraerElem.id+" y restan "+memTotal+" unidades de memoria");
             System.out.println("===========================================");  
             System.out.println("===========================================");  
             }
            }
             
     
      }
        while(memTotal>=1000 );
      
      return ram;  
        
    }
    
    public Proceso elemRam(){
    masMem=ram.get(0);
   // System.out.println(memTotal);
        memTotal=memTotal+masMem.memoria;
       //System.out.println(memTotal);
    return ram.get(0);
    }
    
    public int GetMemoria(){
    return memTotal;
    
    }   
    
}
