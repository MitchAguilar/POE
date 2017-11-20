/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico.Hilos;

import MotorVisual.Circulo;
import java.awt.Color;
import static java.lang.Thread.sleep;
import javax.swing.JFrame;

/**
 *
 * @author Usuario
 */
public class Hilo extends Thread {

    Circulo db;
    JFrame fr;

    public Hilo(Circulo db, JFrame fr) {
        this.db = db;
        this.fr = fr;
    }

    public int num() {
        return (int) (Math.random() * (254 + 0));
    }

    @Override
    public void run() {
        try {
            db.col = new Color(num(), num(), num());
            fr.repaint();
            sleep(1000);
            db.col = new Color(num(), num(), num());
            fr.repaint();
            sleep(1000);
            db.col = new Color(num(), num(), num());
            fr.repaint();
            sleep(1000);
            run();
        } catch (InterruptedException ex) {
        }

    }
}
