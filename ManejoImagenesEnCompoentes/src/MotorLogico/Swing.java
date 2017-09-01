package MotorLogico;

import MotorVisual.Imagen;
import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Mitch
 */
public class Swing {

    JFrame a;
    JPanel b, d, e;
    JButton c, f;
    JLabel g;
    JApplet h;
    Graphics gg;
    private Image imgApp;
    private ImageIcon img2App;

    public void Components() {
        b = new JPanel();
        b.setBounds(50, 50, 300, 200);
        b.setLayout(null);
        b.setFocusCycleRoot(true);
        b.setFocusable(true);
        Imagen img = new Imagen("/Complements/Img1.jpg", b.getWidth(), b.getHeight());
        b.add(img);
        b.repaint();

        g = new JLabel("hola");
        g.setBounds(450, 50, 300, 200);
//        g.setFocusCycleRoot(true);
//        g.setFocusable(true);
        URL url = this.getClass().getResource("/Complements/Img10.gif");
        g.setIcon(new ImageIcon(url));
        g.repaint();

        f = new JButton();
        f.setBounds(250, 350, 150, 150);
        f.setFocusCycleRoot(true);
        f.setFocusable(true);
        f.setBorder(new LineBorder(Color.BLACK));
        URL url3 = this.getClass().getResource("/Complements/Img12.png");
        f.setIcon(new ImageIcon(url3));
        f.repaint();

        c = new JButton();
        c.setBounds(50, 350, 150, 150);
        c.setFocusCycleRoot(true);
        c.setFocusable(true);
        c.setBorder(new LineBorder(Color.BLACK));
        URL url2 = this.getClass().getResource("/Complements/Img11.gif");
        c.setIcon(new ImageIcon(url2));

        h = new JApplet();
        h.setBounds(250, 350, 150, 150);
        img2App=new ImageIcon("/Complements/Img5.png");
        h.setBackground(Color.yellow);
        h.paint(gg);
        
    }
    

    public void Frame() {
        a = new JFrame();
        a.setTitle("Imagenes AWT");
        a.setSize(800, 600);
        a.setLayout(null);

        a.setUndecorated(true);//quitar la barra de menú

        a.add(b);
        a.add(f);
        a.add(c);
        a.add(g);
        a.add(h);
        /*paint img*/
        Imagen img = new Imagen("/Complements/Img6.jpg", a.getWidth(), a.getHeight());
        a.add(img);
        a.repaint();

        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Complements/Img5.png"));
        a.setIconImage(icon);

        a.setVisible(true);
        a.setResizable(false);
        a.setLocationRelativeTo(null);
        a.setDefaultCloseOperation(a.EXIT_ON_CLOSE);
    }

    public Swing() {
        Components();
        Frame();
    }
}
