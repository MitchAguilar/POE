/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico.Hilos;

/**
 *
 * @author Usuario
 */
import javax.swing.JFrame;

public class moverAutomaticamenteVentana {

    public moverAutomaticamenteVentana(JFrame ventana, int desdeX, int hastaX, int desdeY, int hastaY, int demora) {
        System.out.println(" desdeX " + desdeX + " hastaX " + hastaX + " desdeY " + desdeY + " hastaY " + hastaY);
        ventana.show();
        while ((desdeX != hastaX) || (desdeY != hastaY)) {
//Movimiento vertical 
            if (desdeY != hastaY) {
                try {
                    Thread.sleep(demora / 2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (desdeY < hastaY) {
                    desdeY++;
                } else if (desdeY != hastaY) {
                    desdeY--;
                }
                ventana.setLocation(desdeX, desdeY);
            }
//Movimiento horizontal 
            if (desdeX != hastaX) {
                try {
                    Thread.sleep(demora / 2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (desdeX < hastaX) {
                    desdeX++;
                } else if (desdeX != hastaX) {
                    desdeX--;
                }
                ventana.setLocation(desdeX, desdeY);
            }
        }
    }

}
