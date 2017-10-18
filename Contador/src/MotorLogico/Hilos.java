/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Mitch
 */
public class Hilos extends Thread {

    String mensaje;
    JLabel lb;

    public Hilos(String msg, JLabel lb) {
        super(msg);
        this.lb = lb;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                lb.setText(i + "");
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setMensaje(String msj) {
        this.mensaje = msj;
    }
}
