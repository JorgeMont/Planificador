package planificador;
import java.util.ArrayList;

public class SimulacionCPU {
    private int quantum,raf;
     
   public SimulacionCPU(int q){
      quantum = q;
       
   }
    
   public void CPU(Proceso proceso_x) {
        //for (int j=1; j<=quantum && proceso_x.getRafaga() > 0; j++) {
      
      for (int j=1; j<=quantum && raf>0 ;j++) {
         raf=proceso_x.GetRafaga();
         raf-=1;
         proceso_x.SetRafaga(raf);
         System.out.println("El proceso " + proceso_x.GetId() + " en ejecucion " + proceso_x.GetRafaga()+" mseg");
      }
      if(proceso_x.GetRafaga()<=0){
         //significa que YA termino y aqui se debe de:
      //1) actualizar sus datos de #veces que ya subio
      //2) el tiempo en el que subio por ultima vez,
      //3) etc.. todo lo que necsite para calcular tiempos
   
            //procesosTerminados.add(proceso_x); //aqui no debes de sobre escribir el metodo de la lista
      //4)insertarlo en
             procesosTerminados.Insertar(proceso_x); //aqui adentro del metodo insertar debe de invocar el metodo add del ArrayList
      }
      else {
      //significa que no termino y aqui se debe de:
      //1) actualizar sus datos de #veces que ya subio
      //2) el tiempo en el que subio por ultima vez,
      //3) etc.. todo lo que necsite para calcular tiempos
      // y volver a insertar otra vez a la cola de listos
      }
     
   }
    
    
    
}
