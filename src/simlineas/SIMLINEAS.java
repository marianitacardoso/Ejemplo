
package simlineas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Mariana Cardoso
 */
public class SIMLINEAS {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) throws IOException{
       BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
         
     Object [] colores ={"___","1.DD1","2.DDS"}; 
    Object opcion = JOptionPane.showInputDialog(null,"SELECCIONA UNA OPCION", "Elegir",JOptionPane.QUESTION_MESSAGE,null,colores, colores[0]);

    
      if (opcion.toString().equalsIgnoreCase("1.DD1")){
          Scanner R=new Scanner(System.in);
        R.useLocale(new Locale("es","MX"));
        
        double lambda;
        double miu;
        double L;
        double Lq;
        double W;
        double Wq;
        double Po;
        double P;
        String unidad;
        
        System.out.println(" Dame el valor de lambda (): ");
        lambda=R.nextDouble();
        System.out.println(" Dame el valor de miu (): ");
        miu=R.nextDouble();
        System.out.println(" Dame la unidad de medida (dias, horas,minutos,segundos) : ");
        unidad=R.next();
        
        L=lambda/(miu-lambda);
        Lq=Math.pow(lambda,2)/(miu*(miu-lambda));
        W=1/(miu-lambda);
        Wq=lambda/(miu*(miu-lambda));
        Po=1-(lambda/miu);
        P=lambda/miu;
        
        System.out.println("L:  " + L + " clientes esperando en el sistema.");
        System.out.println("Lq:  " + Lq + " clientes esperando en la cola.");
        System.out.println("W:  " + W + " " + unidad + " de espera en el sistema.");
        System.out.println("Wq:  " + Wq + " " + unidad + " de espera en el sistema.");
        System.out.println("Po:  " + Po +" % de que este desocupado el sistema.");
        System.out.println("P:  " + P + "% de que este ocupado el sistema.");
    }  
      if (opcion.toString().equalsIgnoreCase("2.DDS")){
         int i = 0;
        int[] Cliente = new int[20]; //20 clientes 
        double PROMTOCIO = 0, PROMTESPERA = 0;//promedio
        double[]  TLL = new double[20]; //tiempo de llegada
        double[]  TE = new double[20]; //tiempo de espera
        double[]  TO = new double[20]; //tiempo de ocio _ tiempo anterior y actual
        double[]  TSER = new double[20];//tiempo de servicio
        double[]  TSAL = new double[20];//tiempo de salida
        
        TLL[0] = 0;
        TE[0] = 0;
        TO[0] = 0;
        TSER[0] = (Math.random())*5;
        TSAL[0] = TLL[0] + TE[0] + TSER[0];
        
           System.out.println("        TLL          |          TO         |        TE        |       TSER       |        TSAL    ");
        System.out.println("TLL = " + TLL[0] + "|" + "|" + "|" + "TO = " + TO[0] + "|" + "|" + "|" + "TE = " + TE[0] + "|" + "|" + "|" + "TSER = " + TSER[0] + "|" + "|" + "|" + "TSAL = " + TSAL[0]);
        
        for (i=1;i<20;i++){
            TLL[i] = TLL[i-1] + (Math.random())*10;
            TE[i] = Math.max(TSAL[i-1],TLL[i])-TLL[i];
            TO[i] = Math.max(TSAL[i-1],TLL[i])-TSAL[i-1];
            TSER[i] = (Math.random())*5;
            TSAL[i] = TLL[i] + TE[i] + TSER[i];
            PROMTOCIO = PROMTOCIO + TO[i];
            PROMTESPERA = PROMTESPERA + TE[i];
            
            System.out.println("TLL = " + TLL[i] + "|" + "|" + "|" + "TO = " + TO[i] + "|" + "|" + "|" + "TE = " + TE[i] + "TSER = " + TSER[i] + "|" + "|" + "|" + "TSAL = " + TSAL[i]);
             
        }
        
        System.out.println("==============================================================================================================");
        System.out.println("Promedio de tiempo Ocio = " + PROMTOCIO/20);
        System.out.println("Promedio de tiempo de espera = " + PROMTESPERA/20);
        
      }
   }
}
    



