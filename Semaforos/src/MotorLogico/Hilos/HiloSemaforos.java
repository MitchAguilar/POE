/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico.Hilos;

import MotorVisual.DibujarCirculo;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Usuario
 */
public class HiloSemaforos extends Thread {

    JFrame Fram;

    public HiloSemaforos(JFrame Fram, DibujarCirculo DeBaAm, DibujarCirculo DeBaRo, DibujarCirculo DeBaVe, DibujarCirculo DeAlAm, DibujarCirculo DeAlRo, DibujarCirculo DeAlVe, DibujarCirculo IzAlAm, DibujarCirculo IzAlRo, DibujarCirculo IzAlVe, DibujarCirculo IzBaAm, DibujarCirculo IzBaRo, DibujarCirculo IzBaVe) {
        this.Fram = Fram;
        this.DeBaAm = DeBaAm;
        this.DeBaRo = DeBaRo;
        this.DeBaVe = DeBaVe;
        this.DeAlAm = DeAlAm;
        this.DeAlRo = DeAlRo;
        this.DeAlVe = DeAlVe;
        this.IzAlAm = IzAlAm;
        this.IzAlRo = IzAlRo;
        this.IzAlVe = IzAlVe;
        this.IzBaAm = IzBaAm;
        this.IzBaRo = IzBaRo;
        this.IzBaVe = IzBaVe;
    }
    DibujarCirculo DeBaAm, DeBaRo, DeBaVe;
    DibujarCirculo DeAlAm, DeAlRo, DeAlVe;
    DibujarCirculo IzAlAm, IzAlRo, IzAlVe;
    DibujarCirculo IzBaAm, IzBaRo, IzBaVe;

    public void run() {
        try {
            //Primer Acto
            DeBaAm.col = Color.BLACK;
            DeBaRo.col = Color.BLACK;
            DeBaVe.col = Color.GREEN;

            DeAlAm.col = Color.BLACK;
            DeAlRo.col = Color.RED;
            DeAlVe.col = Color.BLACK;

            IzAlAm.col = Color.BLACK;
            IzAlRo.col = Color.RED;
            IzAlVe.col = Color.BLACK;

            IzBaAm.col = Color.BLACK;
            IzBaRo.col = Color.RED;
            IzBaVe.col = Color.BLACK;
            Fram.repaint();
            sleep(18000);

            //Segundo Acto
            DeBaAm.col = Color.YELLOW;
            DeBaRo.col = Color.BLACK;
            DeBaVe.col = Color.BLACK;

            DeAlAm.col = Color.BLACK;
            DeAlRo.col = Color.RED;
            DeAlVe.col = Color.BLACK;

            IzAlAm.col = Color.BLACK;
            IzAlRo.col = Color.RED;
            IzAlVe.col = Color.BLACK;

            IzBaAm.col = Color.BLACK;
            IzBaRo.col = Color.RED;
            IzBaVe.col = Color.BLACK;
            Fram.repaint();
            sleep(2000);

            //Tercer Acto
            DeBaAm.col = Color.BLACK;
            DeBaRo.col = Color.RED;
            DeBaVe.col = Color.BLACK;

            DeAlAm.col = Color.BLACK;
            DeAlRo.col = Color.BLACK;
            DeAlVe.col = Color.GREEN;

            IzAlAm.col = Color.BLACK;
            IzAlRo.col = Color.RED;
            IzAlVe.col = Color.BLACK;

            IzBaAm.col = Color.BLACK;
            IzBaRo.col = Color.RED;
            IzBaVe.col = Color.BLACK;
            Fram.repaint();
            sleep(18000);

            //Cuarto Acto
            DeBaAm.col = Color.BLACK;
            DeBaRo.col = Color.RED;
            DeBaVe.col = Color.BLACK;

            DeAlAm.col = Color.YELLOW;
            DeAlRo.col = Color.BLACK;
            DeAlVe.col = Color.BLACK;

            IzAlAm.col = Color.BLACK;
            IzAlRo.col = Color.RED;
            IzAlVe.col = Color.BLACK;

            IzBaAm.col = Color.BLACK;
            IzBaRo.col = Color.RED;
            IzBaVe.col = Color.BLACK;
            Fram.repaint();
            sleep(2000);

            //Quinto Acto
            DeBaAm.col = Color.BLACK;
            DeBaRo.col = Color.RED;
            DeBaVe.col = Color.BLACK;

            DeAlAm.col = Color.BLACK;
            DeAlRo.col = Color.RED;
            DeAlVe.col = Color.BLACK;

            IzAlAm.col = Color.BLACK;
            IzAlRo.col = Color.BLACK;
            IzAlVe.col = Color.GREEN;

            IzBaAm.col = Color.BLACK;
            IzBaRo.col = Color.RED;
            IzBaVe.col = Color.BLACK;
            Fram.repaint();
            sleep(18000);

            //Sexto Acto
            DeBaAm.col = Color.BLACK;
            DeBaRo.col = Color.RED;
            DeBaVe.col = Color.BLACK;

            DeAlAm.col = Color.BLACK;
            DeAlRo.col = Color.RED;
            DeAlVe.col = Color.BLACK;

            IzAlAm.col = Color.YELLOW;
            IzAlRo.col = Color.BLACK;
            IzAlVe.col = Color.BLACK;

            IzBaAm.col = Color.BLACK;
            IzBaRo.col = Color.RED;
            IzBaVe.col = Color.BLACK;
            Fram.repaint();
            sleep(2000);
            
            //Septimo Acto
            DeBaAm.col = Color.BLACK;
            DeBaRo.col = Color.RED;
            DeBaVe.col = Color.BLACK;

            DeAlAm.col = Color.BLACK;
            DeAlRo.col = Color.RED;
            DeAlVe.col = Color.BLACK;

            IzAlAm.col = Color.BLACK;
            IzAlRo.col = Color.RED;
            IzAlVe.col = Color.BLACK;

            IzBaAm.col = Color.BLACK;
            IzBaRo.col = Color.BLACK;
            IzBaVe.col = Color.GREEN;
            Fram.repaint();
            sleep(18000);
            
            //Octavo Acto
            DeBaAm.col = Color.BLACK;
            DeBaRo.col = Color.RED;
            DeBaVe.col = Color.BLACK;

            DeAlAm.col = Color.BLACK;
            DeAlRo.col = Color.RED;
            DeAlVe.col = Color.BLACK;

            IzAlAm.col = Color.BLACK;
            IzAlRo.col = Color.RED;
            IzAlVe.col = Color.BLACK;

            IzBaAm.col = Color.YELLOW;
            IzBaRo.col = Color.BLACK;
            IzBaVe.col = Color.BLACK;
            Fram.repaint();
            sleep(2000);
            run();
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloSemaforos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
