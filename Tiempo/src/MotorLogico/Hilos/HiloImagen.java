/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico.Hilos;

import MotorLogico.Imagen;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Usuario
 */
public class HiloImagen extends Thread {

    private JFrame fr;
    private Imagen img;

    public HiloImagen(JFrame fr) {
        this.fr = fr;
    }
    int num = 0;

    public void run() {
        System.out.println("aso "+num);
        try {
            switch (num) {
                case 0:
                    img = new Imagen("/Complements/1.jpg", fr.getWidth(), fr.getHeight());
                    fr.add(img);
                    sleep(5000);
                    
                    break;
                case 1:
                    img= new Imagen("/Complements/2.jpg", fr.getWidth(), fr.getHeight());
                    fr.add(img);
                    sleep(5000);
                    break;
                case 2:
                    img= new Imagen("/Complements/3.jpg", fr.getWidth(), fr.getHeight());
                    fr.add(img);
                    sleep(5000);
                    break;
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
        num++;
        if (num > 2) {
            num = 0;
        }
        run();
    }
}
