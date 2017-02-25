
package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelDibujo extends JPanel{
    private Figura figuras [];
    private int cuentaFiguras, tipoFigura;
    private Figura figuraActual;
    private Color colorActual;
    private boolean figuraRellena;
    private JLabel etiquetaEstado;
    private Raton rat;
    
    public PanelDibujo(){
        figuras = new Figura[100];
        etiquetaEstado = new JLabel();
        cuentaFiguras = 0;
        tipoFigura = 1;
        figuraActual = null;
        colorActual = Color.BLACK;
        setBackground(Color.white);
        rat= new Raton();
        addMouseListener(rat);
        addMouseMotionListener(rat);
        setSize(500,500);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(figuraActual != null ){
            figuraActual.dibujar(g);
            for (int i = 0; figuras[i]!= null && i < figuras.length; i++) {
                figuras[i].dibujar(g);
                
            }
          
            
        }
            
    }

    public void setFiguraActual(Figura figuraActual) {
        this.figuraActual = figuraActual;
    }

    public void setColorActual(Color colorActual) {
        this.colorActual = colorActual;
    }
    
    public void setTipoFigura(int i){
        tipoFigura = i;
    }

    public void setFiguraRellena(boolean figuraRellena) {
        this.figuraRellena = figuraRellena;
    }
    
    public void borrarUltima(){
        if(cuentaFiguras >0){
            cuentaFiguras --;
        figuraActual= null;
        }
        repaint();
    }
    public void borrarTodo(){
        cuentaFiguras = 0;
    }
    
    private class Raton extends MouseAdapter implements MouseMotionListener{
        @Override
        public void mousePressed(MouseEvent m){
            
            if(tipoFigura == 1){
                figuraActual = new Milinea();
                figuraActual.setColor(colorActual);
                figuraActual.setCoorX(m.getX());
                figuraActual.setCoorY(m.getY());
            }else if(tipoFigura == 2){
                figuraActual = new MiRectangulo();
                figuraActual.setColor(colorActual);
                
                figuraActual.setCoorX(m.getX());
                figuraActual.setCoorY(m.getY());
            }else{
                figuraActual = new MiOvalo();
                figuraActual.setColor(colorActual);
                figuraActual.setCoorX(m.getX());
                figuraActual.setCoorY(m.getY());
            }
            figuraActual.setCoorX(m.getX());
            figuraActual.setCoorY(m.getY());
            figuraActual.setColor(colorActual);
            
        }
        @Override
        public void mouseReleased(MouseEvent m){
            figuraActual.setCoorX1(m.getX());
            figuraActual.setCoorY1(m.getY());
            figuras[cuentaFiguras] = figuraActual;
            cuentaFiguras++;
            figuraActual = null;
            repaint();
        }
        @Override
        public void mouseMoved(MouseEvent m){
            etiquetaEstado.setText(""+m.getX()+", "+m.getY());
        }
        @Override 
        public void mouseDragged(MouseEvent m){
            figuraActual.setCoorX1(m.getX());
            figuraActual.setCoorY1(m.getY());
            etiquetaEstado.setText(""+m.getX()+", "+m.getY());
            repaint();
        }
    }
}
