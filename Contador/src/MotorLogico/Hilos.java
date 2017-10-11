/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico;

import javax.swing.JLabel;

/**
 *
 * @author Mitch
 */
public class Hilos extends Thread{
    String mensaje;

    public Hilos(String msg) {
        super(msg);
    }

    public void run(JLabel lb) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            lb.setText((i+1)+"");
            sleep(50);
        }
    }

    public void setMensaje(String msj) {
        this.mensaje = msj;
    }
}
