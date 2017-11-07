/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico.Hilos;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class SpiderDeHilos extends Thread {

    int TiempoSemaforo, TiempoCarro;
    ArrayList<HiloMovimiento> Spider = new ArrayList<>();

    public SpiderDeHilos(int TiempoSemaforo, int TiempoCarro, ArrayList<HiloMovimiento> Araña) {
        this.TiempoSemaforo = TiempoSemaforo;
        this.TiempoCarro = TiempoCarro;
        this.Spider = Araña;
    }

    @Override
    public void run() {
//        int Al = (int) (Math.random()*(Spider.size()+0));
        while (TiempoSemaforo != 0) {
            try {
                Spider.get(0).start();
                sleep(TiempoCarro);
                Spider.get(1).start();
                sleep(TiempoCarro);
                Spider.get(2).start();
                sleep(TiempoCarro);
                TiempoSemaforo--;
            } catch (InterruptedException ex) {
                Logger.getLogger(SpiderDeHilos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
