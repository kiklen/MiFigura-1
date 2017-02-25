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

     private static final String colors[] = {"Azul","Rojo","Verde", "Rosa" };
     private static final String figurs[]  = {"linea ","rectangulo", " circulo" };

    private JComboBox colores, figuras;
    private JCheckBox relleno;
    private Color color;
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
        color = Color.BLACK;

        Acciones accion = new Acciones();
        colores.addItemListener(new ItemListener (){
            @Override
            public void itemStateChanged (ItemEvent ie) {
			
		 if (ie.getStateChange () == ItemEvent.SELECTED)
                    if(colores.getSelectedItem().toString().equals("Negro")){
                           color = Color.BLACK;
                        }else if(colores.getSelectedItem().toString().equals("Verde")){
                           color = Color.green;
                        }else if(colores.getSelectedItem().toString().equals("Rojo")){
                            color = Color.RED;
                        }else if(colores.getSelectedItem().toString().equals("Amarillo")){
                            color = Color.YELLOW;
                        }else if(colores.getSelectedItem().toString().equals("Anaranjado")){
                            color = Color.ORANGE;
                        }else if(colores.getSelectedItem().toString().equals("Rosa")){
                             color = Color.PINK;
                        }else if(colores.getSelectedItem().toString().equals("Azul")){
                             color = Color.BLUE;
                        }
                        paned.setColorActual(color);
	}
        });
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
    
    public class Acciones implements ActionListener{
            @Override

            public void actionPerformed(ActionEvent e) {

                if(e.getSource()== figuras){
                    paned.setTipoFigura(figuras.getSelectedIndex()+1);
                }else if(e.getSource()==colores){

                    if(colores.getSelectedItem().toString().equals("azul")){
                        color= Color.BLUE;
                    }
                    switch (colores.getSelectedItem().toString()){
                        case "azul": color = Color.BLUE;
                            break;
                        case "rojo": color = Color.RED;
                            break;
                        case "verde": paned.setColorActual(Color.green);
                                color= Color.GREEN;
                            break;
                        case "rosa": color = Color.pink;
                    }
                    paned.setColorActual(color);

                }
                else if(e.getSource()== deshacer){
                    paned.borrarUltima();
                }else if(e.getSource()== borrar){
                    paned.borrarTodo();
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
