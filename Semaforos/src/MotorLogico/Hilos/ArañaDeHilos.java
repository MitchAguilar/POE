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
public class ArañaDeHilos extends Thread{
    int TiempoSemaforo, TiempoCarro;
    ArrayList<HiloMovimiento> Araña;

    public ArañaDeHilos(int TiempoSemaforo, int TiempoCarro, ArrayList<HiloMovimiento> Araña) {
        this.TiempoSemaforo = TiempoSemaforo;
        this.TiempoCarro = TiempoCarro;
        this.Araña = Araña;
    }
    
    @Override
    public void run(){
        
    }
}
