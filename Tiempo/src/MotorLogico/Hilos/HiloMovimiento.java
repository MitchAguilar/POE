/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico.Hilos;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class HiloMovimiento extends Thread {

    JPanel Pan;

    public HiloMovimiento(JPanel Pan1) {
        this.Pan = Pan1;
    }
    int a = (995 - 330) / 2, b = 20, ac = 330, dc = 430;
    boolean aaa = true;

    public void run() {
        for (int i = 150; i <= 600; i++) {
            Pan.setBounds(i, b, ac, dc);
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloMovimiento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (int i = 600; i >= a; i--) {
            Pan.setBounds(i, b, ac, dc);
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloMovimiento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
