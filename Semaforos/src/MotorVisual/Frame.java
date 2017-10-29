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
    JPanel Cesped, Cesped2, Edific;
    JLabel Arb;
    static Imagen img;

    public void Components() {
        Cesped = new JPanel();
        Cesped.setBounds(0, 398, 450, 300);
        Cesped.setLayout(null);
        img = new Imagen("/Complements/Cesped.PNG", Cesped.getWidth(), Cesped.getHeight());
        Cesped.add(img);

        Cesped2 = new JPanel();
        Cesped2.setBounds(550, 398, 700, 300);
        Cesped2.setLayout(null);
        Imagen img2 = new Imagen("/Complements/Cesped.PNG", Cesped2.getWidth(), Cesped2.getHeight());
        Cesped2.add(img2);

        Arb = new JLabel();
        URL url = this.getClass().getResource("/Complements/Edificios.png");
        Arb.setIcon(new ImageIcon(url));
        Arb.setFocusable(false);
        Arb.setBounds(850, 90, 560, 300);
        Arb.setBorder(null);
        Arb.setOpaque(false);

//            Edific= new JPanel();
//            Edific.setBounds(10,300, 260, 340);
//            Imagen im= new Imagen("/Complements/Edificios.png", Edific.getWidth(), Edific.getHeight());
//            Edific.add(im);
//            Edific.repaint();
    }

    public void Fram() {
        Fram = new JFrame("Semaforos");
        Fram.setSize(1024, 700);
        Fram.setLayout(null);

        Fram.add(Cesped);
        Fram.add(Cesped2);
//        Fram.add(Edific);
        Fram.add(Arb);

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
