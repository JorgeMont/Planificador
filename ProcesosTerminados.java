package planificador;
import java.util.ArrayList;

public class ProcesosTerminados {
     private int quantum;
    
    static void Insertar(Proceso proceso_x) {
        int tiempo=0, tvuelta;
	float tejecucion=0;
	float tespera=0;       
        boolean bande = true;
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //adicionarlo al ArrayList
    
while(bande){   
            for(int j=0; j<quantum; j++){
                            tiempo++;
                            
                            if(proceso_x.GetRafaga() > 0)
                            {

                                    System.out.println("Proceso: "+proceso_x.GetId()+" en ejecuccion... le restan: "+proceso_x.GetRafaga()+" ms");
                                    proceso_x.SetRafaga((proceso_x.GetRafaga()-1));
                                    try
                                    {
                                            Thread.sleep(1000);
                                    }
                                    catch(Exception e){ }

                            }
                            if(proceso_x.GetRafaga()==0)
                            {
                                    proceso_x.SetTespera(proceso_x.GetTespera()-j);
                                    tvuelta=tiempo-j-1;
//                                    tejecucion=tejecucion+tiempo;
                                    tespera=tespera+(tvuelta-proceso_x.GetTespera());

                                    break;
                            }
                            proceso_x.SetTespera(proceso_x.GetTespera()+1);

                    }
                    if(proceso_x.GetRafaga() > 0)
                    {

                            colaProcesos.add(proceso_x);
                    }
   }  
    
   
}
}

    
   

