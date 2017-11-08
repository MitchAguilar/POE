/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico.Hilos;

import java.awt.Point;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class SpiderDeHilos extends Thread {

    public boolean Estado;
    int TiempoCarro;
    HiloMovimiento hm, hm2, hm3;

    public SpiderDeHilos(boolean Estado, int TiempoCarro, HiloMovimiento hm, HiloMovimiento hm2, HiloMovimiento hm3) {
        this.Estado = Estado;
        this.TiempoCarro = TiempoCarro;
        this.hm = hm;
        this.hm2 = hm2;
        this.hm3 = hm3;
    }

    @Override
    public void run() {
        try {
            if (Estado) {
                hm.start();
            }
            sleep(TiempoCarro);
            if (Estado) {
                hm2.start();
            }
            sleep(TiempoCarro);
            if (Estado) {
                hm3.start();
            }
            sleep(TiempoCarro);
            sleep(2000);//tiempo hilos
            hm = new HiloMovimiento(hm.aux, hm.FrmAux, hm.tiempo, hm.posInicial, hm.posFinal, hm.estado);
            hm2 = new HiloMovimiento(hm2.aux, hm2.FrmAux, hm2.tiempo, hm2.posInicial, hm2.posFinal, hm2.estado);
            hm3 = new HiloMovimiento(hm3.aux, hm3.FrmAux, hm3.tiempo, hm3.posInicial, hm3.posFinal, hm3.estado);
            System.err.println("pase");
        } catch (InterruptedException ex) {
            Logger.getLogger(SpiderDeHilos.class.getName()).log(Level.SEVERE, null, ex);
        }
        run();
    }
}
