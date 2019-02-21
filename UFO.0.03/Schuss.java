import GLOOP.*;
import java.util.*;
public class Schuss
{
    public GLKegel lazer; 
    public boolean SchussAktiv = false;
    public boolean SchussReady = true;
    private Ufo dasUfo;
    private double DistanzX, DistanzY, Distanz;
    
    public Schuss(Ufo pUfo){
        lazer = new GLKegel(60,-10,0,15,70);
        lazer.skaliere(0.2,1,1);
        lazer.drehe(90,90,0, 0,0,0);
        lazer.setzeFarbe(1,0,0);
        dasUfo = pUfo;
    }
    public void los(){
        SchussAktiv = true;
        SchussReady = false;
        
    }
    public void lock(){
        double x = dasUfo.gibX();
        double y = gibY();
        this.lazer.setzePosition(x,y,0);
    }
    public boolean checkDistanz(Object x){
        DistanzX = dasUfo.gibX() - lazer.gibX();
        DistanzY = dasUfo.gibY() - lazer.gibY();
        Distanz = Math.sqrt(DistanzX * DistanzX + DistanzY * DistanzY);
        if (Distanz < 50) {
                return true; }
        return false;
    }
    public double gibX(){
        return lazer.gibX();
    }

    public double gibY(){
        return lazer.gibY();
    }
}
