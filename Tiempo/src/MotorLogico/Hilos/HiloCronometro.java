/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico.Hilos;

import MotorLogico.ClassCount;
import MotorLogico.Sonido;

/**
 *
 * @author Usuario
 */
public class HiloCronometro extends Thread {

    private ClassCount pan1, pan2, pan3;
    private int temp;

    public HiloCronometro(ClassCount pan1, ClassCount pan2, ClassCount pan3) {
        this.pan1 = pan1;
        this.pan2 = pan2;
        this.pan3 = pan3;
    }

    public void Temp(int clock) {
        temp = clock;
    }

    public void run() {
        for (int i = 0; i < temp; i++) {
            pan1.UpdateProgres(i);
            for (int j = 0; j <= 60; j++) {
                pan2.UpdateProgres(j);
                for (int k = 0; k <=100; k++) {
                    pan3.UpdateProgres(k);
                    try {
                        sleep(10);
                    } catch (InterruptedException ex) {
                    }
                }
            }
            Sonido.MIN.play();
        }
        System.out.println("Terminó hilo cronometro");
    }
}
