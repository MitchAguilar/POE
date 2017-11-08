/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico.Hilos;

import MotorLogico.Sonido;
import MotorVisual.Circulo;
import java.awt.Color;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Usuario
 */
public class HiloSemaforos extends Thread {

    JFrame Fram;
    int amarillo = 4000;
    int Verde = 20000;
    int tiempoCarros;
    Circulo DeBaAm;
    Circulo DeBaRo, DeBaVe;
    Circulo DeAlAm;
    Circulo DeAlRo, DeAlVe;
    Circulo IzAlAm;
    Circulo IzAlRo, IzAlVe;
    Circulo IzBaAm;
    Circulo IzBaRo, IzBaVe;
    JLabel[] cars;

    public void tiempo(int Ve, int Am) {
        amarillo = Am * 1000;
        Verde = Ve * 1000;
    }

    public HiloSemaforos(JFrame Fram, Circulo DeBaAm, Circulo DeBaRo, Circulo DeBaVe, Circulo DeAlAm, Circulo DeAlRo, Circulo DeAlVe, Circulo IzAlAm, Circulo IzAlRo, Circulo IzAlVe, Circulo IzBaAm, Circulo IzBaRo, Circulo IzBaVe, JLabel[] cars) {
        this.Fram = Fram;
        this.DeBaAm = DeBaAm;
        this.DeBaRo = DeBaRo;
        this.DeBaVe = DeBaVe;
        this.DeAlAm = DeAlAm;
        this.DeAlRo = DeAlRo;
        this.DeAlVe = DeAlVe;
        this.IzAlAm = IzAlAm;
        this.IzAlRo = IzAlRo;
        this.IzAlVe = IzAlVe;
        this.IzBaAm = IzBaAm;
        this.IzBaRo = IzBaRo;
        this.IzBaVe = IzBaVe;
        this.cars = cars;
    }

    /*
    HiloMovimiento hlm = new HiloMovimiento(car, Fram, 1, new Point(car.getX(), car.getY()), new Point(950, car.getY()));
            hlm.start();
     */
    public void run() {
        try {
            //arranque carro
            HiloMovimiento hm4 = new HiloMovimiento(cars[3], Fram, 1, new Point(cars[3].getX(), cars[3].getY()), new Point(1, cars[3].getY()), 2);
            HiloMovimiento hm5 = new HiloMovimiento(cars[4], Fram, 1, new Point(cars[4].getX(), cars[4].getY()), new Point(1, cars[4].getY()), 2);
            HiloMovimiento hm6 = new HiloMovimiento(cars[5], Fram, 1, new Point(cars[5].getX(), cars[5].getY()), new Point(1, cars[5].getY()), 2);
            SpiderDeHilos sph1 = new SpiderDeHilos(true, 100, hm4, hm5, hm6);
            sph1.start();
            acto1();
            //end carro
            sph1.Estado = false;
            acto2();
            //arranque carro
            HiloMovimiento hm10 = new HiloMovimiento(cars[9], Fram, 1, new Point(cars[9].getX(), cars[9].getY()), new Point(cars[9].getX(), 700), 3);
            HiloMovimiento hm11 = new HiloMovimiento(cars[10], Fram, 1, new Point(cars[10].getX(), cars[10].getY()), new Point(cars[10].getX(), 700), 3);
            HiloMovimiento hm12 = new HiloMovimiento(cars[11], Fram, 1, new Point(cars[11].getX(), cars[11].getY()), new Point(cars[11].getX(), 700), 3);
            SpiderDeHilos sph3 = new SpiderDeHilos(true, 100, hm10, hm11, hm12);
            sph3.start();
            //end carro
            acto3();
            sph3.Estado = false;
            acto4();
            //arranque carro
            HiloMovimiento hm = new HiloMovimiento(cars[0], Fram, 1, new Point(cars[0].getX(), cars[0].getY()), new Point(950, cars[0].getY()), 1);
            HiloMovimiento hm2 = new HiloMovimiento(cars[1], Fram, 1, new Point(cars[1].getX(), cars[1].getY()), new Point(950, cars[1].getY()), 1);
            HiloMovimiento hm3 = new HiloMovimiento(cars[2], Fram, 1, new Point(cars[2].getX(), cars[2].getY()), new Point(950, cars[2].getY()), 1);
            SpiderDeHilos sph = new SpiderDeHilos(true, 100, hm, hm2, hm3);
            sph.start();
            //end carro
            acto5();
            sph.Estado = false;
            acto6();
            //arranque carro
            HiloMovimiento hm7 = new HiloMovimiento(cars[6], Fram, 1, new Point(cars[6].getX(), cars[6].getY()), new Point(cars[6].getX(), 1), 4);
            HiloMovimiento hm8 = new HiloMovimiento(cars[7], Fram, 1, new Point(cars[7].getX(), cars[7].getY()), new Point(cars[7].getX(), 1), 4);
            HiloMovimiento hm9 = new HiloMovimiento(cars[8], Fram, 1, new Point(cars[8].getX(), cars[8].getY()), new Point(cars[8].getX(), 1), 4);
            SpiderDeHilos sph2 = new SpiderDeHilos(true, 100, hm7, hm8, hm9);
            sph2.start();
            //end carro            
            acto7();
            sph2.Estado = false;
            acto8();
            run();
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloSemaforos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void acto1() throws InterruptedException {
        //Primer Acto
        DeBaAm.col = Color.BLACK;
        DeBaRo.col = Color.BLACK;
        DeBaVe.col = Color.GREEN;

        DeAlAm.col = Color.BLACK;
        DeAlRo.col = Color.RED;
        DeAlVe.col = Color.BLACK;

        IzAlAm.col = Color.BLACK;
        IzAlRo.col = Color.RED;
        IzAlVe.col = Color.BLACK;

        IzBaAm.col = Color.BLACK;
        IzBaRo.col = Color.RED;
        IzBaVe.col = Color.BLACK;
        Fram.repaint();
        sleep(Verde);
    }

    public void acto2() throws InterruptedException {
        //Segundo Acto
        Sonido.Camion.play();
        DeBaAm.col = Color.YELLOW;
        DeBaRo.col = Color.BLACK;
        DeBaVe.col = Color.BLACK;

        DeAlAm.col = Color.YELLOW;
        DeAlRo.col = Color.BLACK;
        DeAlVe.col = Color.BLACK;

        IzAlAm.col = Color.BLACK;
        IzAlRo.col = Color.RED;
        IzAlVe.col = Color.BLACK;

        IzBaAm.col = Color.BLACK;
        IzBaRo.col = Color.RED;
        IzBaVe.col = Color.BLACK;
        Fram.repaint();
        sleep(amarillo);
    }

    public void acto3() throws InterruptedException {
        //Tercer Acto
        Sonido.Camion.stop();
        DeBaAm.col = Color.BLACK;
        DeBaRo.col = Color.RED;
        DeBaVe.col = Color.BLACK;

        DeAlAm.col = Color.BLACK;
        DeAlRo.col = Color.BLACK;
        DeAlVe.col = Color.GREEN;

        IzAlAm.col = Color.BLACK;
        IzAlRo.col = Color.RED;
        IzAlVe.col = Color.BLACK;

        IzBaAm.col = Color.BLACK;
        IzBaRo.col = Color.RED;
        IzBaVe.col = Color.BLACK;
        Fram.repaint();
        sleep(Verde);
    }

    public void acto4() throws InterruptedException {
        //Cuarto Acto
        Sonido.Camion.play();
        DeBaAm.col = Color.BLACK;
        DeBaRo.col = Color.RED;
        DeBaVe.col = Color.BLACK;

        DeAlAm.col = Color.YELLOW;
        DeAlRo.col = Color.BLACK;
        DeAlVe.col = Color.BLACK;

        IzAlAm.col = Color.yellow;
        IzAlRo.col = Color.BLACK;
        IzAlVe.col = Color.BLACK;

        IzBaAm.col = Color.BLACK;
        IzBaRo.col = Color.RED;
        IzBaVe.col = Color.BLACK;
        Fram.repaint();
        sleep(amarillo);
    }

    public void acto5() throws InterruptedException {
        //Quinto Acto
        Sonido.Camion.stop();
        DeBaAm.col = Color.BLACK;
        DeBaRo.col = Color.RED;
        DeBaVe.col = Color.BLACK;

        DeAlAm.col = Color.BLACK;
        DeAlRo.col = Color.RED;
        DeAlVe.col = Color.BLACK;

        IzAlAm.col = Color.BLACK;
        IzAlRo.col = Color.BLACK;
        IzAlVe.col = Color.GREEN;

        IzBaAm.col = Color.BLACK;
        IzBaRo.col = Color.RED;
        IzBaVe.col = Color.BLACK;
        Fram.repaint();
        sleep(Verde);
    }

    public void acto6() throws InterruptedException {
        //Sexto Acto
        Sonido.Camion.play();
        DeBaAm.col = Color.BLACK;
        DeBaRo.col = Color.RED;
        DeBaVe.col = Color.BLACK;

        DeAlAm.col = Color.BLACK;
        DeAlRo.col = Color.RED;
        DeAlVe.col = Color.BLACK;

        IzAlAm.col = Color.YELLOW;
        IzAlRo.col = Color.BLACK;
        IzAlVe.col = Color.BLACK;

        IzBaAm.col = Color.yellow;
        IzBaRo.col = Color.BLACK;
        IzBaVe.col = Color.BLACK;
        Fram.repaint();
        sleep(amarillo);
    }

    public void acto7() throws InterruptedException {
        //Septimo Acto
        Sonido.Camion.stop();
        DeBaAm.col = Color.BLACK;
        DeBaRo.col = Color.RED;
        DeBaVe.col = Color.BLACK;

        DeAlAm.col = Color.BLACK;
        DeAlRo.col = Color.RED;
        DeAlVe.col = Color.BLACK;

        IzAlAm.col = Color.BLACK;
        IzAlRo.col = Color.RED;
        IzAlVe.col = Color.BLACK;

        IzBaAm.col = Color.BLACK;
        IzBaRo.col = Color.BLACK;
        IzBaVe.col = Color.GREEN;
        Fram.repaint();
        sleep(Verde);
    }

    public void acto8() throws InterruptedException {
        //Octavo Acto
        Sonido.Camion.play();
        DeBaAm.col = Color.yellow;
        DeBaRo.col = Color.BLACK;
        DeBaVe.col = Color.BLACK;

        DeAlAm.col = Color.BLACK;
        DeAlRo.col = Color.RED;
        DeAlVe.col = Color.BLACK;

        IzAlAm.col = Color.BLACK;
        IzAlRo.col = Color.RED;
        IzAlVe.col = Color.BLACK;

        IzBaAm.col = Color.YELLOW;
        IzBaRo.col = Color.BLACK;
        IzBaVe.col = Color.BLACK;
        Fram.repaint();
        sleep(amarillo);
        Sonido.Camion.stop();
    }
}
