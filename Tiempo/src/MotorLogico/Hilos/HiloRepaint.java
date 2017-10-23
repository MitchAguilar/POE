/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico.Hilos;

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
            sleep(100);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Lo siento, reventaste el proceso de pila de la JVM,\n por tanto no es posible recuperar tu aplicación."
                    + " \n te recomendamos reiniciar." + ex.getCause(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        run();
    }
}
