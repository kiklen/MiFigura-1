

package paint;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;

public abstract class Figura extends JPanel{
    private int size = 10;
    private int coorX, coorY, coorX1, coorY1;
    private Color color;
    public Figura (){
        coorX = 0;
        coorY = 0;
        coorX1 = 0;
        coorY1 = 0;
        color = Color.BLACK;
    }
    public Figura(int x, int y,int x1, int y1, Color color){
        coorX = x;
        coorY = y;
        coorX1 = x1;
        coorY1 = y1;
        this.color = color;
    }
    public abstract void  dibujar(Graphics g);

    public void setCoorX1(int coorX1) {
        this.coorX1 = coorX1;
    }

    public void setCoorY1(int coorY1) {
        this.coorY1 = coorY1;
    }
    
    public void setCoorX(int coorX) {
        this.coorX = coorX;
    }

    public void setCoorY(int coorY) {
        this.coorY = coorY;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getCoorX1() {
        return coorX1;
    }

    public int getCoorY1() {
        return coorY1;
    }
    
    public int getCoorX() {
        return coorX;
    }

    public int getCoorY() {
        return coorY;
    }

    public Color getColor() {
        return color;
    }
    
}
