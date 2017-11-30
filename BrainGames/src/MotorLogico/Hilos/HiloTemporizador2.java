/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico.Hilos;

import Core.EasyCore;
import Core.MediumCore;
import MotorLogico.ClassCount;
import MotorLogico.Sound;
import MotorVisual.GameOver;
import MotorVisual.GameViewTwoLevel;
import MotorVisual.InitialView;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class HiloTemporizador2 extends Thread {

    private ClassCount pan2;
    private GameViewTwoLevel fr;

    private MediumCore eas;

    public HiloTemporizador2(ClassCount pan2, GameViewTwoLevel fr, MediumCore ls) {
        this.pan2 = pan2;
        this.fr = fr;
        eas = ls;
    }

    HiloEasyLevel2 hle;

    public void run() {
        hle = new HiloEasyLevel2(eas, fr);
        hle.start();
        Sound.paw.play();
        for (int j = 30; j >= 0; j--) {
            pan2.UpdateProgres(j);
            fr.Rapa();
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloTemporizador2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Sound.MIN.play();
        GameOver gm= new GameOver();
        fr.dis();
        Sound.paw.stop();
        try {
            sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloTemporizador2.class.getName()).log(Level.SEVERE, null, ex);
        }
        gm.Disp();
        InitialView in= new InitialView();
        
        hle.stop();
        Sound.epic.stop();
    }

    public void Str() {
//        Sound.paw.play();
        fr.restart();
        hle.Str();

    }
}
