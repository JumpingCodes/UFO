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
    private Asteroid asteroid1,asteroid2,asteroid3;
    ArrayList<Asteroid> ArrayList = new ArrayList<Asteroid>();
    

    public Ufospiel(){
        kamera = new GLSchwenkkamera(800,600);  
        kamera.verschiebe(0,200,500);
        licht  = new GLLicht();
        tastatur = new GLTastatur();
        himmel = new GLHimmel("Sterne.jpg");
        m = new GLMaus();
        
        dasUfo = new Ufo();
        
        
        ArrayList.add(new Asteroid(dasUfo));
        ArrayList.add(new Asteroid(dasUfo));
        ArrayList.add(new Asteroid(dasUfo));
        

        fuehreAus();
    }

    public void fuehreAus(){
        while(!tastatur.esc()){
            if (tastatur.links()) dasUfo.bewegeLinks();
            if (tastatur.rechts()) dasUfo.bewegeRechts();
            for (Asteroid x: ArrayList){x.bewegeDich(speed);}
            if (change == AsteroidenPass){ArrayList.add(new Asteroid(dasUfo));change += 15;speed -= 0.2;anas += 1;};
            if (AsteroidenPass % 15 == 0){level++;AsteroidenPass++;}
            System.out.println("Speed: " + speed + " Geschaffte asteroiden: " + AsteroidenPass +" Anzahl der Asteroiden: "+ anas+ " Level: " + level);
            
                Sys.warte();
        }
        Sys.beenden(); 
    }
}
