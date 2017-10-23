/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico.Hilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class HiloCronometro extends Thread{

    public HiloCronometro() {
    }

    public void run() {
        try {
            sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloCronometro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
