/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico;

import MotorVisual.progrest;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class HiloContador extends Thread{

    private PrCo c;

    public HiloContador(PrCo ProgressCount) {
        this.c = ProgressCount;
    }

    public void run() {
        for (int i = 0; i <= 100; i++) {
            c.UpdateProgres(i);
            try {
                c.repaint();
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(progrest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
