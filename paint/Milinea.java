
package paint;

import java.awt.Color;
import java.awt.Graphics;

public class Milinea extends Figura{
    
    public Milinea(){
        super(0,0,0,0,Color.BLACK);
    }
    public Milinea(int x, int y,int x1, int y1, Color color){
        super(x,y,x1,y1,color);
    }
    @Override
    public void dibujar(Graphics g) {
        g.drawLine(super.getCoorX() ,super.getCoorY(), super.getCoorY(), super.getCoorY1());
    }
    
}
