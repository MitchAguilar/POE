/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorVisual;

import MotorLogico.Imagen;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class Frame {

    JFrame Fram;
    JPanel Cesped, Cesped2;
    JLabel Arb;
    static Imagen img ;
    public void Components() {
        Cesped = new JPanel();
        Cesped.setBounds(0, 0, 450, 300);
        Cesped.setLayout(null);
        img= new Imagen("/Complements/Cesped.PNG", Cesped.getWidth(), Cesped.getHeight());
        Cesped.add(img);

        Cesped2 = new JPanel();
        Cesped2.setBounds(550, 0, 700, 300);
        Cesped2.setLayout(null);
        Imagen img2 = new Imagen("/Complements/Cesped.PNG", Cesped2.getWidth(), Cesped2.getHeight());
        Cesped2.add(img2);

        Arb = new JLabel();
        URL url = this.getClass().getResource("/Complements/Arbol.gif");
        Arb.setIcon(new ImageIcon(url));
        Arb.setFocusable(false);
        Arb.setBounds(10, 50, 560, 300);
        Arb.setBorder(null);
        Arb.setOpaque(false);
        Cesped.add(Arb);
    }

    public void Fram() {
        Fram = new JFrame("Semaforos");
//        Fram.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        Fram.setSize(1024, 700);
        Fram.setLayout(null);

        Fram.add(Cesped);
        Fram.add(Cesped2);

        Imagen img = new Imagen("/Complements/Fondo.jpg", Fram.getWidth(), Fram.getHeight());
        Fram.add(img);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Complements/Icon.png"));
        Fram.setIconImage(icon);

        Fram.repaint();
        Fram.setVisible(true);
        Fram.setResizable(false);
        Fram.setLocationRelativeTo(null);
        Fram.setDefaultCloseOperation(3);
    }

    public Frame() {
        Components();
        Fram();
    }
}
