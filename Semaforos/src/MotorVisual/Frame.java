/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorVisual;

import MotorLogico.Imagen;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Usuario
 */
public class Frame {

    JFrame Fram;

    public void Components() {

    }

    public void Fram() {
        Fram = new JFrame("Semaforos");
//        Fram.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        Fram.setSize(1024, 700);
        Fram.setLayout(null);

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
