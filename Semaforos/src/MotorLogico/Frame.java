/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico;

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
        Fram.setSize(1200, 600);
        Fram.setLayout(null);

        Fram.setVisible(true);
        Fram.setResizable(false);
        Fram.setLocationRelativeTo(null);
        Fram.setDefaultCloseOperation(3);
        Imagen img = new Imagen("/Complements/Fondo.jpg", Fram.getWidth(), Fram.getHeight());
        Fram.add(img);
        Fram.repaint();
    }

    public Frame() {
        Components();
        Fram();
    }

}
