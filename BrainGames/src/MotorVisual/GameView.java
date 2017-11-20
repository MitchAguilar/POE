/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorVisual;

import MotorLogico.Meives;
import javax.swing.JFrame;

/**
 *
 * @author mitch
 */
public class GameView {

    JFrame fr;

    public void Comp() {

    }

    public void Frm() {
        fr = new JFrame();
        fr.setSize(800, 500);
        fr.setLayout(null);

        Meives.Imagen img = new Meives.Imagen("/Complements/1.jpg", fr.getWidth(), fr.getHeight());
        fr.add(img);
        fr.repaint();

        fr.setLocationRelativeTo(null);
        fr.setResizable(false);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(3);
    }

    public GameView() {
        Comp();
        Frm();
    }
}
