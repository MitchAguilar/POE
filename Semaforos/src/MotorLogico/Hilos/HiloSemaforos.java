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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
    JLabel car, car2, car3;

    public void tiempo(int Ve, int Am) {
        amarillo = Am * 1000;
        Verde = Ve * 1000;
    }

    public HiloSemaforos(JFrame Fram, Circulo DeBaAm, Circulo DeBaRo, Circulo DeBaVe, Circulo DeAlAm, Circulo DeAlRo, Circulo DeAlVe, Circulo IzAlAm, Circulo IzAlRo, Circulo IzAlVe, Circulo IzBaAm, Circulo IzBaRo, Circulo IzBaVe, JLabel car, JLabel car2, JLabel car3) {
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
        this.car = car;
        this.car2 = car2;
        this.car3 = car3;
    }

    /*
    HiloMovimiento hlm = new HiloMovimiento(car, Fram, 1, new Point(car.getX(), car.getY()), new Point(950, car.getY()));
            hlm.start();
     */
    public void run() {
        try {
            acto1();
            acto2();
            acto3();
            acto4();
            //arranque carro
//            ArrayList<HiloMovimiento> hl= new ArrayList<>();
            HiloMovimiento hm = new HiloMovimiento(car, Fram, 1, new Point(car.getX(), car.getY()), new Point(950, car.getY()), 1);
            HiloMovimiento hm2 = new HiloMovimiento(car2, Fram, 1, new Point(car2.getX(), car2.getY()), new Point(950, car2.getY()), 1);
            HiloMovimiento hm3 = new HiloMovimiento(car3, Fram, 1, new Point(car3.getX(), car3.getY()), new Point(950, car3.getY()), 1);
//            hl.add(hm);
//            hl.add(hm2);
//            hl.add(hm3);
//            
            SpiderDeHilos sph = new SpiderDeHilos(true, 100, hm, hm2, hm3);
            sph.start();
            //end carro
            acto5();
            sph.Estado=false;
            acto6();
            acto7();
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
