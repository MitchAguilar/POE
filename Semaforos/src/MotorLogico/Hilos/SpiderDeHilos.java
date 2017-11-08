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

    int TiempoSemaforo, TiempoCarro;
//    ArrayList<HiloMovimiento> Spider = new ArrayList<>();
//    ArrayList<HiloMovimiento> AuxSpider = new ArrayList<>();
    HiloMovimiento hm, hm2, hm3;

    public SpiderDeHilos(int TiempoSemaforo, int TiempoCarro, HiloMovimiento hm, HiloMovimiento hm2, HiloMovimiento hm3) {
        this.TiempoSemaforo = TiempoSemaforo;
        this.TiempoCarro = TiempoCarro;
        this.hm = hm;
        this.hm2 = hm2;
        this.hm3 = hm3;
    }

    @Override
    public void run() {
//        int Al = (int) (Math.random()*(Spider.size()+0));
        while (TiempoSemaforo != 0) {
            try {
                hm.start();
                sleep(TiempoCarro);
                hm2.start();
                sleep(TiempoCarro);
                hm3.start();
                sleep(TiempoCarro);
                TiempoSemaforo--;
            } catch (InterruptedException ex) {
                Logger.getLogger(SpiderDeHilos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
