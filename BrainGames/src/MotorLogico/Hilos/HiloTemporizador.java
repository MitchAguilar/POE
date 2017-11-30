/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico.Hilos;

import Core.EasyCore;
import MotorLogico.ClassCount;
import MotorLogico.Sound;
import MotorVisual.GameOver;
import MotorVisual.GameViewOneLevel;
import MotorVisual.InitialView;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Usuario
 */
public class HiloTemporizador extends Thread {

    private ClassCount pan2;
    private GameViewOneLevel fr;

    private EasyCore eas;

    public HiloTemporizador(ClassCount pan2, GameViewOneLevel fr, EasyCore ls) {
        this.pan2 = pan2;
        this.fr = fr;
        eas = ls;
    }

    HiloEasyLevel hle;

    public void run() {
        hle = new HiloEasyLevel(eas, fr);
        hle.start();
        Sound.epic.play();
        for (int j = 60; j >= 0; j--) {
            pan2.UpdateProgres(j);
            fr.Rapa();
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloTemporizador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Sound.MIN.play();
        GameOver gm= new GameOver();
        fr.dis();
        Sound.epic.stop();
        try {
            sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloTemporizador.class.getName()).log(Level.SEVERE, null, ex);
        }
        gm.Disp();
        InitialView in= new InitialView();
        
        hle.stop();
        Sound.epic.stop();
    }

    public void Str() {
        Sound.poi.play();
//            sleep(2000);
        fr.restart();
        hle.Str();

    }
}
