/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorVisual;

import MotorLogico.Meives;
import java.awt.Image;
import java.awt.Toolkit;
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
        fr.setUndecorated(true);

        Meives.Imagen img = new Meives.Imagen("/Complements/Img/1.jpg", fr.getWidth(), fr.getHeight());
        fr.add(img);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Complements/Img/icon.png"));
        fr.setIconImage(icon);
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
