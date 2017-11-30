/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico;

import MotorVisual.SierpinskiCarpet;
import MotorVisual.InitialView;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class trigger extends Thread {

    public void run() {
        try {
            SierpinskiCarpet spr = new SierpinskiCarpet();
            spr.main();
            sleep(4700);
            spr.Exit();
            InitialView mn = new InitialView();
        } catch (InterruptedException ex) {
            Logger.getLogger(trigger.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
