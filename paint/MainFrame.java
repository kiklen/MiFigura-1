package paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class MainFrame extends JFrame implements ActionListener{
    private final JDesktopPane ventana;
    private final MarcoDibujo dibujos [];
    private final JMenuBar barraSuperior;
    private final JMenu archivo;
    private final JMenuItem nuevo;
    private int numeroVentana;
    
    public MainFrame(){
        setTitle("Figuras");
        
        ventana = new JDesktopPane();
        barraSuperior = new JMenuBar();
        archivo = new JMenu("Archivo");
        dibujos = new MarcoDibujo[200];
        nuevo = new JMenuItem("Nuevo");
        barraSuperior.add(archivo);
        
        add(barraSuperior);
        
        archivo.add(nuevo);
        setJMenuBar(barraSuperior);
        add(ventana);
        
        nuevo.addActionListener(this);
                
    }
        
      @Override
            public void actionPerformed(ActionEvent e) {
                   if(numeroVentana <20){
                   dibujos[numeroVentana] = new MarcoDibujo("Dibujo",true,true,true,true);
                   ventana.add(dibujos[numeroVentana]);
                   dibujos[numeroVentana].pack();
                   dibujos[numeroVentana].setVisible(true);
                   numeroVentana++;
                   
                   }else{
                    numeroVentana= 0;
                    dibujos[numeroVentana] = new MarcoDibujo("Dibujo",true,true,true,true);
                    ventana.add(dibujos[numeroVentana]);
                    dibujos[numeroVentana].pack();
                    dibujos[numeroVentana].setVisible(true);
                    numeroVentana++;
                    }
          }
    
      public static void main(String[] args) {
        MainFrame clase = new MainFrame();
        clase.setDefaultCloseOperation(3);
        clase.setSize(800, 800);
        clase.setVisible(true);
    }
}
