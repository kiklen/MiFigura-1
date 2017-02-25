package paint;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;


public class MarcoDibujo extends JFrame{
private final PanelDibujo paned;
private final JButton borrar;
private final JButton deshacer;

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
    deshacer = new JButton("deshacer");
    colores = new JComboBox(colors);
    figuras = new JComboBox(figurs);
    relleno = new JCheckBox();
    
    Acciones accion = new Acciones();
    colores.addItemListener(accion);
    figuras.addActionListener(accion);
    relleno.addActionListener(accion);
    deshacer.addActionListener(accion);
    borrar.addActionListener(accion);
    
    arriba.add(borrar);
    arriba.add(deshacer);
    arriba.add(colores);
    arriba.add(figuras);
    arriba.add(relleno);
    
    principal.add(arriba);
    add(principal, BorderLayout.NORTH);
    add(paned);
}
    public class Acciones implements ActionListener, ItemListener{
        @Override

        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource()== figuras){
                paned.setTipoFigura(figuras.getSelectedIndex()+1);
            }else if(relleno.isSelected()){
                paned.setFiguraRellena(true);
            }
            else if(e.getSource()== deshacer){
                paned.borrarUltima();
            }else if(e.getSource()== borrar){
                paned.borrarTodo();
            }
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()== ItemEvent.ITEM_STATE_CHANGED)
                switch (colores.getSelectedIndex()){
                    case 0: paned.setColorActual(Color.BLUE);
                        break;
                    case 1: paned.setColorActual(Color.RED);
                        break;
                    case 2: paned.setColorActual(Color.green);
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
