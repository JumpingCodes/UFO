import GLOOP.*;
public class Asteroid{
    private GLKugel kugel;
    private Ufo dasUfo;
    private Schuss derSchuss;
    
    private double DistanzX, DistanzY, Distanz;

    public Asteroid(Ufo pUfo, Schuss pSchuss){
        kugel = new GLKugel(0,1000,0, 50,"Krater.jpg"); 
        
        dasUfo = pUfo;
        derSchuss = pSchuss;
        
        int x = (int)(Math.random()*1000 - 500);
        int y = (int)(Math.random()*500 + 500);
        
        kugel.setzePosition(x,y,0);
        kugel.setzeSkalierung(1,Math.random()+0.3,Math.random()+0.3);
    }
    
    public double gibX(){
        return kugel.gibX();
    }

    public double gibY(){
        return kugel.gibY();
    }
    public boolean checkDistanz(){
        DistanzX = dasUfo.gibX() - kugel.gibX();
        DistanzY = dasUfo.gibY() - kugel.gibY();
        Distanz = Math.sqrt(DistanzX * DistanzX + DistanzY * DistanzY);
        if (Distanz < 50) {
                return true; }
        return false;
    }
    public void explodiere(){
        ArrayList.remove(this);
    }
    public boolean checkDistanzLazer(){
        DistanzX = kugel.gibX() - derSchuss.lazer.gibX();
        DistanzY = kugel.gibY() - derSchuss.lazer.gibY();
        Distanz = Math.sqrt(DistanzX * DistanzX + DistanzY * DistanzY);
        if (Distanz < 50) {
                return true; }
        return false;
    }
    public void bewegeDich(double s){
        int x = (int)(Math.random()*1500 - 750);
        if(kugel.gibY()<-700){this.kugel.setzePosition(x,1200,0);Ufospiel.AsteroidenPass++;System.out.println(Ufospiel.AsteroidenPass);}
        if (checkDistanzLazer()){this.explodiere();};
        kugel.verschiebe(0,s,0);   
        kugel.drehe(0.1,0.1,0.1);
        if (checkDistanz()) {dasUfo.explodiere(); }                
    }

}
