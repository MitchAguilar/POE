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
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class HiloMovimiento extends Thread {

    JLabel aux;
    JFrame FrmAux;
    int tiempo;
    Point posInicial, posFinal;
    int estado;

    public HiloMovimiento(JLabel aux, JFrame FrmAux, int tiempo, Point posInicial, Point posFinal, int estado) {
        this.aux = aux;
        this.FrmAux = FrmAux;
        this.tiempo = tiempo;
        this.posInicial = posInicial;
        this.posFinal = posFinal;
        this.estado = estado;
    }

    @Override
    public void run() {

        aux.setVisible(true);
        try {
            switch (estado) {
                //of x1--->x2 
                case 1:
                    for (int i = posInicial.x; i <= posFinal.x; i=i+2) {
                        try {
                            aux.setLocation(i, posFinal.y);
                            FrmAux.repaint();
                            sleep(tiempo);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(HiloMovimiento.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                //of x1--->x2
                case 2:
                    for (int i = posFinal.x; i >= posInicial.x; i--) {
                        try {
                            aux.setLocation(i, posFinal.y);
                            FrmAux.repaint();
                            sleep(tiempo);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(HiloMovimiento.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                // of y1--->y2
                case 3:
                    for (int i = posInicial.y; i <= posFinal.y; i++) {
                        try {
                            aux.setLocation(posFinal.x, i);
                            FrmAux.repaint();
                            sleep(tiempo);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(HiloMovimiento.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                //of y1<---y2
                case 4:
                    for (int i = posFinal.y; i >= posInicial.y; i--) {
                        try {
                            aux.setLocation(posFinal.x, i);
                            FrmAux.repaint();
                            sleep(tiempo);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(HiloMovimiento.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Erro de indice- HiloMovimiento", "Error", JOptionPane.WARNING_MESSAGE);
                    break;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de indice- HiloMovimiento " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        aux.setLocation(posInicial);
        aux.setVisible(true);
    }
}
