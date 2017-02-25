package paint;

import java.awt.Color;
import java.awt.Graphics;

public class MiOvalo extends MiFiguraDelimitada{
    int ancho, alto;
    public MiOvalo(){
        super(0,0,0,0,Color.BLACK,false);
    }
    public MiOvalo(int x,int y,int x1,int y1,Color color, boolean r){
        super(x,y,x1,y1,color,r);
    }
    @Override
    public void dibujar(Graphics g) {
        
        ancho = Math.abs(super.getCoorX1()-super.getCoorX());
        alto = Math.abs(super.getCoorY1()-super.getCoorY());
        if(!isRelleno())
            g.drawOval(super.getCoorX(), super.getCoorY(), ancho, alto);
        else
            g.fillOval(super.getCoorX(), super.getCoorY(), ancho, alto);
    }
    
    
  
        
}
