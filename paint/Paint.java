package paint;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Paint extends JFrame{
    private int numFiguras;
    private  Figura [] figuras;
    private Figura linea, cuadro, ovalo;
    private Panel panel;
    private int x,x1,y,y1,ovalos, lineas, cuadros;
    private Color color;
    private boolean relleno;
    private Graphics g;
    private JLabel barraDeEstado;
    private String datos;
    
    public Paint(){
        setLayout(new FlowLayout());
        barraDeEstado = new JLabel("lineas "+lineas+", ovalos "+
                ovalos +", cuadros "+cuadros);
        add(barraDeEstado);
        //barraDeEstado = new JLabel(datos);
    }
    
    public void generarCoordenadasAleatorias(){
        x  = (int)(Math.random()*200);
        x1 = x + (int)(Math.random()*150);
        y  = (int)(Math.random()*200);
        y1 = y + (int)(Math.random()*150);
        
        switch((int)((Math.random()*5)+1)){
            case 1: color = Color.black;
                break;
            case 2: color = Color.blue;
                break;
            case 3: color = Color.gray;
                break;
            case 4: color = Color.magenta;
                break;
            case 5: color = Color.red;
        }
        
        if((int)((Math.random()*2)+1)== 1){
            relleno = true;
        }else{
            relleno = false;
        }
            
    }
    
    public void crearAleatorios(){
        int figuraActual;
        numFiguras = numeroDeFiguras();
        figuras= new Figura[numFiguras];
        
        for (int i = 0; i < figuras.length; i++) {
            figuraActual = (int)((Math.random()*3)+1);
            generarCoordenadasAleatorias();
            switch (figuraActual){
                case 1: figuras[i] = new Milinea(x,x1,y,y1, color);
                    lineas++;
                    break;
                case 2: figuras[i] = new MiRectangulo(x,x1,y,y1,color, relleno);
                    cuadros++;
                    break;
                case 3: figuras[i] = new MiOvalo(x,x1,y,y1,color,relleno);
                    ovalos++;
            }
        }
        datos="lineas "+lineas+", ovalos "+
                ovalos +", cuadros "+cuadros;
        barraDeEstado.setText(datos);
    }
    
    public int numeroDeFiguras(){
        int numero= 0;
        try{
        numero = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántas figuras"
                + " quiere generar'","escriba en número"));
        }catch(Exception e){
            numeroDeFiguras();
        }
        return numero;
    }
    
    public Panel iniciarPanel(){
        
        add(barraDeEstado);
        return new Panel();
        
    }
    public Panel armarPanel(){
        panel= iniciarPanel();
        return panel;
    }
    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.setSize(700, 700);
        paint.setVisible(true);
        paint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        paint.crearAleatorios();
        Panel panel = paint.iniciarPanel();
        paint.add(panel);
        panel.repaint();
        paint.repaint();
    }
    
    public class Panel extends JPanel{
    
    
        public Panel(){
            setSize(500,500);
            setBackground(Color.white);
            setVisible(true);
        }
        @Override
        public void paintComponent(Graphics g){
            super.setBounds(0, 200, 400, 400);
            super.setBackground(Color.WHITE);
            super.paintComponent(g);
            
            for (int i = 0; i < figuras.length; i++) {
                figuras[i].dibujar(g);
                repaint();    
            }
        }
    }
}
