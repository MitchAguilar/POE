/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico.Hilos;

import MotorLogico.PrCo;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class HiloRepaint extends Thread {

    private JFrame c;

    public HiloRepaint(JFrame ProgressCount) {
        this.c = ProgressCount;
    }
    public void run() {
        c.repaint();
        try {
            sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloRepaint.class.getName()).log(Level.SEVERE, null, ex);
        }
        run();
    }
}
