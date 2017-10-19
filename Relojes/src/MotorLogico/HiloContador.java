/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico;

import javafx.concurrent.Task;

/**
 *
 * @author Usuario
 */
public class HiloContador extends Task<Object> {

    int pausa;

    public HiloContador(int pause) {
        this.pausa = pause;
    }

    @Override
    protected Object call() throws Exception {
        double i;
        for (i = 0; i <= 100; i++) {
            Thread.sleep(pausa);
            updateProgress(i, 10);
        }
        return i;
    }
}
