import GLOOP.*;
import java.util.*;
public class Ufospiel{
    private GLKamera kamera;
    private GLLicht licht;
    private GLTastatur tastatur;
    private GLHimmel himmel;
    private GLMaus m;
    int change=5;
    double speed = -0.5;
    public static int AsteroidenPass=0;
    
    int level=0;
    int anas=3;
    private Ufo dasUfo;
    private Schuss derSchuss;
    
    ArrayList<Asteroid> ArrayList = new ArrayList<Asteroid>();
    

    public Ufospiel(){
        kamera = new GLSchwenkkamera(800,600);  
        kamera.verschiebe(0,200,500);
        licht  = new GLLicht();
        tastatur = new GLTastatur();
        himmel = new GLHimmel("Sterne.jpg");
        m = new GLMaus();
        
        dasUfo = new Ufo();
        derSchuss = new Schuss(dasUfo);
        
        ArrayList.add(new Asteroid(dasUfo,derSchuss));
        ArrayList.add(new Asteroid(dasUfo,derSchuss));
        ArrayList.add(new Asteroid(dasUfo,derSchuss));
        

        fuehreAus();
    }

    public void fuehreAus(){
        while(!tastatur.esc()){
            if (tastatur.links()) dasUfo.bewegeLinks();
            
            if (tastatur.rechts()) dasUfo.bewegeRechts();
            
            if (tastatur.oben() && !derSchuss.SchussAktiv && derSchuss.SchussReady ){derSchuss.los();};
            
            if (derSchuss.SchussReady){derSchuss.lock();};
            
            if (derSchuss.SchussAktiv){derSchuss.bewege();};
            
            for (Asteroid x: ArrayList){x.bewegeDich(speed);}
            
            if (change == AsteroidenPass){ArrayList.add(new Asteroid(dasUfo,derSchuss));change += 15;speed -= 0.2;anas += 1;};
            
            if (AsteroidenPass % 15 == 0){level++;AsteroidenPass++;}
            
            System.out.println("Speed: " + speed + " Geschaffte asteroiden: " + AsteroidenPass +" Anzahl der Asteroiden: "+ anas+ " Level: " + level);
            
                Sys.warte();
        }
        Sys.beenden(); 
    }
}
