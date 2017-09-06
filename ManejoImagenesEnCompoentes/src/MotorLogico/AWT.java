package MotorLogico;
import MotorVisual.Imagen;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Mitch
 */
public class AWT {

    Frame a;
    Panel b,d,e,f;
    Button c;

    public void Components() {
        b = new Panel();
        b.setBounds(50, 50, 300, 200);
        b.setLayout(null);
        b.setFocusCycleRoot(true);
        b.setFocusable(true);
        Imagen img = new Imagen("/Complements/Img1.jpg", b.getWidth(), b.getHeight());
        b.add(img);
        b.repaint();
        
        d = new Panel();
        d.setBounds(450, 50, 300, 200);
        d.setLayout(null);
        d.setFocusCycleRoot(true);
        d.setFocusable(true);
        Imagen img2 = new Imagen("/Complements/Img7.jpg", b.getWidth(), b.getHeight());
        d.add(img2);
        d.repaint();
        
        e = new Panel();
        e.setBounds(50, 350, 300, 200);
        e.setLayout(null);
        e.setFocusCycleRoot(true);
        e.setFocusable(true);
        Imagen img3 = new Imagen("/Complements/Img9.jpg", b.getWidth(), b.getHeight());
        e.add(img3);
        e.repaint();
        
        f = new Panel();
        f.setBounds(450, 350, 300, 200);
        f.setLayout(null);
        f.setFocusCycleRoot(true);
        f.setFocusable(true);
        Imagen img4 = new Imagen("/Complements/Img8.jpg", b.getWidth(), b.getHeight());
        f.add(img4);
        f.repaint();
       
    }

    public void Frame() {
        a = new Frame();
        a.setTitle("Imagenes AWT");
        a.setSize(800, 600);
        a.setLayout(null);
        
//        a.setUndecorated(true);//quitar la barra de menú
        
        a.add(b);
        a.add(d);
        a.add(e);
        a.add(f);
        /*paint img*/
        Imagen img = new Imagen("/Complements/Img6.jpg", a.getWidth(), a.getHeight());
        a.add(img);
        a.repaint();
        
        //pintar el icono
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Complements/Img5.png"));
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
