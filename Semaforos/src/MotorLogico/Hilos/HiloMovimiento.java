/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico.Hilos;

import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Usuario
 */
public class HiloMovimiento extends Thread{
    JLabel aux;
    JFrame FrmAux;
    int tiempo;
    Point posInicial,posFinal;

    public HiloMovimiento(JLabel aux, JFrame FrmAux, int tiempo, Point posInicial, Point posFinal) {
        this.aux = aux;
        this.FrmAux = FrmAux;
        this.tiempo = tiempo;
        this.posInicial = posInicial;
        this.posFinal = posFinal;
    }
    
    public void run(){
        for (int i = posInicial.x; i <posInicial.x ; i++) {
            try {
                aux.setLocation(i, posFinal.y);
                FrmAux.repaint();
                sleep(tiempo);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloMovimiento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
