/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico.Hilos;

import MotorLogico.PrCo;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class HiloReloj extends Thread {

    private PrCo c;

    public HiloReloj(PrCo ProgressCount) {
        this.c = ProgressCount;
    }

    public void run() {
        for (int i = 0; i <= 100; i++) {
            c.UpdateProgres(i);
            try {
                c.repaint();
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, "Hilo: HiloContador, fué estallado; por favor verifique el código","Error",JOptionPane.WARNING_MESSAGE);
            }
        }
        run();
    }
}
