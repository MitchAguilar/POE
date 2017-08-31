package MotorLogico;

import MotorVisual.Imagen;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Mitch
 */
public class AWT {

    Frame a;
    Panel b;
    Button c;

    public void Components() {
        b = new Panel();
        b.setBounds(50, 50, 300, 200);
        b.setLayout(null);
        Imagen img = new Imagen("/Complements/Img2.jpg", b.getWidth(), b.getHeight());
        b.add(img);
        b.repaint();
        
        c= new  Button("Iniciar");
//        c.setIcon(new ImageIcon("Imagenes/miImagen.gif"));
    }

    public void Frame() {
        a = new Frame();
        a.setTitle("Imagenes AWT");
        a.setSize(800, 600);
        a.setLayout(null);

        a.add(b);
        /*paint img*/
        Imagen img = new Imagen("/Complements/Img1.jpg", a.getWidth(), a.getHeight());
        a.add(img);
        a.repaint();

        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Complements/Img3.jpg"));
        a.setIconImage(icon);

        a.setVisible(true);
        a.setResizable(false);
        a.setLocationRelativeTo(null);
        a.addWindowListener(new WindowAdapter() {//oara cerrar la ventana y el proceso
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        }
        );
    }

    public AWT() {
        Components();
        Frame();
    }
}
