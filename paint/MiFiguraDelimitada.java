
package paint;

import java.awt.Color;
import java.awt.Graphics;

public abstract class MiFiguraDelimitada extends Figura{

    private boolean relleno;
    public MiFiguraDelimitada(){}   
    public MiFiguraDelimitada(int x, int y, int x1, int y1, Color color,
            boolean r){
        super(x,y,x1,y1,color);
        relleno = r;
    }   

    public boolean isRelleno() {
        return relleno;
    }

    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
    }
    
}
