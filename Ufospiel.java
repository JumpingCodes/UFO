import GLOOP.*;
import java.util.*;
public class Ufospiel{
    private GLKamera kamera;
    private GLLicht licht;
    private GLTastatur tastatur;
    private GLHimmel himmel;
    private GLMaus m;
    int level=0;
    private Ufo dasUfo;
    private Asteroid asteroid1,asteroid2,asteroid3;
    ArrayList<Asteroid> ArrayList = new ArrayList<Asteroid>();
    private double  DistanzX1,  DistanzX2,  DistanzX3,  DistanzY1,  DistanzY2,  DistanzY3,  Distanz1,  Distanz2, Distanz3;

    public Ufospiel(){
        kamera = new GLSchwenkkamera(800,600);  
        kamera.verschiebe(0,200,500);
        licht  = new GLLicht();
        tastatur = new GLTastatur();
        himmel = new GLHimmel("Sterne.jpg");
        m = new GLMaus();
        
        dasUfo = new Ufo();
        
        //asteroid1 = new Asteroid(dasUfo);
        //asteroid2 = new Asteroid(dasUfo);
        //asteroid3 = new Asteroid(dasUfo);
        ArrayList.add(new Asteroid(dasUfo));
        ArrayList.add(new Asteroid(dasUfo));
        ArrayList.add(new Asteroid(dasUfo));
        //String AstList[] = {asteroid1, asteroid2, asteroid3};

        fuehreAus();
    }

    public void fuehreAus(){
        while(!tastatur.esc()){
            if (tastatur.links()) dasUfo.bewegeLinks();
            if (tastatur.rechts()) dasUfo.bewegeRechts();

            System.out.println(dasUfo.gibX());
            
            
            
            for (Asteroid x: ArrayList){x.bewegeDich();}
            
                Sys.warte();
        }
        Sys.beenden(); 
    }
}
