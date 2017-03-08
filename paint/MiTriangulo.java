package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class MiTriangulo extends MiFiguraDelimitada{
    
    int ancho, alto;
    public MiTriangulo(){
        super(0,0,0,0,Color.BLACK,false);
    }
    public MiTriangulo(int x,int y,int x1,int y1,Color color, boolean r){
        super(x,y,x1,y1,color,r);
    }
    @Override
    public void dibujar(Graphics g) {
        g.setColor(getColor());
        
        int[] X = {(getCoorX() + getCoorX1()) /2, getCoorX() , getCoorX1()};
        int[] Y = {getCoorY() , getCoorY1(),getCoorY1()};
        Polygon triangulo = new Polygon (X, Y, 3);
        if(!isRelleno())
            g.drawPolygon(triangulo);
        else
            g.fillPolygon(triangulo);
    }
    
    
}
