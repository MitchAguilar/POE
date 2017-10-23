/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico.Hilos;

import MotorLogico.ClassCount;
import MotorLogico.Sonido;
import static java.lang.Thread.sleep;

/**
 *
 * @author Usuario
 */
public class HiloTemporizador extends Thread{

    private ClassCount pan1, pan2, pan3;
    private int temp;

    public HiloTemporizador(ClassCount pan1, ClassCount pan2, ClassCount pan3, int temp) {
        this.pan1 = pan1;
        this.pan2 = pan2;
        this.pan3 = pan3;
        this.temp = temp;
    }

    public void run() {
        for (int i = temp; i > 0; i--) {
            pan1.UpdateProgres(i - 1);
            for (int j = 60; j >= 0; j--) {
                pan2.UpdateProgres(j);
                for (int k = 100; k >= 0; k--) {
                    pan3.UpdateProgres(k);
                    try {
                        sleep(10);
                    } catch (InterruptedException ex) {
                    }
                }
            }
            Sonido.MIN.play();
        }
        Sonido.HOR.play();
        System.out.println("Terminó hilo Temporizador");
    }
}
