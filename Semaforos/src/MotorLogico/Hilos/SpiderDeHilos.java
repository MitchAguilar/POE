/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico.Hilos;

import java.util.ArrayList;

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
        int Al = (int) (Math.random()*(Spider.size()+0));
        while (TiempoSemaforo!=0) {
            Spider.get(Al).start();
            TiempoSemaforo--;
        }
    }
}
