package paint;

import java.awt.Color;
import java.awt.Graphics;

public class MiRectangulo extends MiFiguraDelimitada{
    
    public MiRectangulo(){
        super(0,0,0,0,Color.BLACK,false);
    }
    public MiRectangulo(int x, int y,int x1, int y1, Color color, boolean r){
        super(x,y,x1,y1,color,r);
    }
    
    @Override
    public void dibujar(Graphics g) {
        g.setColor(getColor());
        int ancho, alto;
        ancho = Math.abs(super.getCoorX1()-super.getCoorX());
        alto = Math.abs(super.getCoorY1()-super.getCoorY());
        if(!isRelleno())
            g.drawRect(super.getCoorX(), super.getCoorY(), ancho, alto);
        else
            g.fillRect(super.getCoorX(), super.getCoorY(), ancho, alto);
    }
}
