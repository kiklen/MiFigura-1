package paint;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;


public class MarcoDibujo extends JFrame{
private final PanelDibujo paned;
private final JButton borrar;
private final JButton desacer;

 private static final String colors[] = {"Azul","Rojo","Verde", "rosa" };
 private static final String figurs[]  = {"linea ","rectangulo", " circulo" };

JComboBox colores, figuras;
JCheckBox relleno;

public MarcoDibujo(){
    //setLayout(new FlowLayout());
    paned = new PanelDibujo();
    
    JPanel principal = new JPanel();
    principal.setLayout (new GridLayout (2, 1, 5, 5));
    JPanel arriba = new JPanel ();
    JPanel abajo = new JPanel ();
    
    borrar = new JButton("borrar");
    desacer = new JButton("desacer");
    colores = new JComboBox(colors);
    figuras = new JComboBox(figurs);
    relleno = new JCheckBox();
    
    Acciones accion = new Acciones();
    colores.addActionListener(accion);
    figuras.addActionListener(accion);
    relleno.addActionListener(accion);
    
    arriba.add(borrar);
    arriba.add(desacer);
    arriba.add(colores);
    arriba.add(figuras);
    arriba.add(relleno);
    
    principal.add(arriba);
    add(principal, BorderLayout.NORTH);
    add(paned);
}
    public class Acciones implements ActionListener{
        @Override

        public void actionPerformed(ActionEvent e) {
            if(e.getSource()== colores){
                switch (colores.getSelectedIndex()){
                    case 0: paned.setColorActual(Color.BLUE);
                        break;
                    case 1: paned.setColorActual(Color.RED);
                        break;
                }
            }
            else if(e.getSource()== figuras){
                paned.setTipoFigura(figuras.getSelectedIndex()+1);
            }else if(relleno.isSelected()){
                paned.setFiguraRellena(true);
            }
        }
        
    }
   
    
    public static void main(String[] args) {
        MarcoDibujo dib= new  MarcoDibujo();
        dib.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dib.setSize(800, 800);
        dib.setVisible(true);
        
        
    }

    
    
    
}
