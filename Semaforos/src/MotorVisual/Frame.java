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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class Frame {

    JFrame Fram;
    JPanel Matix;
    JLabel Arb;
    JButton start;

    public void Components() {
        Matix = new JPanel();
        Matix.setBounds(0, 0, 1024, 700);
        Matix.setLayout(null);
        Imagen img = new Imagen("/Complements/Fondo.jpg", Matix.getWidth(), Matix.getHeight());
        Matix.add(img);

        start = new JButton();
        URL url = this.getClass().getResource("/Complements/St.png");
        start.setIcon(new ImageIcon(url));
        start.setBorder(null);
        start.setOpaque(false);
        start.setBounds(1070, 150, 100, 100);
        

    }

    public void Fram() {
        Fram = new JFrame("Semaforos");
        Fram.setSize(1224, 700);
        Fram.setLayout(null);

//        Fram.setUndecorated(true);
        Fram.add(Matix);
        Fram.add(start);
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
