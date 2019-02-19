import GLOOP.*;
public class Asteroid{
    private GLKugel kugel;
    private Ufo dasUfo;
    
    private double DistanzX1, DistanzY1, Distanz1;

    public Asteroid(Ufo pUfo){
        kugel = new GLKugel(0,1000,0, 50,"Krater.jpg"); 
        
        dasUfo = pUfo;
        
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
    
    public void bewegeDich(){
        int x = (int)(Math.random()*1500 - 750);
        if(kugel.gibY()<-700){this.kugel.setzePosition(x,1200,0);}
        kugel.verschiebe(0,-0.5,0);   
        kugel.drehe(0.1,0.1,0.1);
            
        DistanzX1 = dasUfo.gibX() - kugel.gibX();
        DistanzY1 = dasUfo.gibY() - kugel.gibY();
        Distanz1 = Math.sqrt(DistanzX1 * DistanzX1 + DistanzY1 * DistanzY1);
            
            if (Distanz1 < 50) {
                dasUfo.explodiere(); }
                
    }

}
