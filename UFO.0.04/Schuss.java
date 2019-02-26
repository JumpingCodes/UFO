import GLOOP.*;
import java.util.*;
public class Schuss
{
    public GLKegel lazer; 
    public static boolean SchussAktiv = false;
    public static boolean SchussReady = true;
    private Ufo dasUfo;
    private double DistanzX, DistanzY, Distanz;
    private double X;

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
        X = dasUfo.gibX();

    }

    public void lock(){
        double x = dasUfo.gibX();
        double y = gibY();
        
        lazer.setzePosition(x,-6.123,0);
    }

    public void bewege(){
        lazer.verschiebe(0,0.7,0);
    }

    public double gibX(){
        return lazer.gibX();
    }

    public double gibY(){
        return lazer.gibY();
    }
}
