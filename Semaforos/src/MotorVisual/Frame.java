/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorVisual;

import MotorLogico.Hilos.Hilo;
import MotorLogico.Hilos.HiloSemaforos;
import MotorLogico.Imagen;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class Frame {

    JFrame Fram;
    JPanel Lona, Lona2;
    JLabel Fuente, car1, car2, car3, car4, car5, car6, car7, car8, car9, car10, car11, car12;
    JLabel[] cars = new JLabel[12];
    JButton start, stop;
    Circulo DeBaAm;
    Circulo DeBaRo, DeBaVe;
    Circulo DeAlAm;
    Circulo DeAlRo, DeAlVe;
    Circulo IzAlAm;
    Circulo IzAlRo, IzAlVe;
    Circulo IzBaAm;
    Circulo IzBaRo, IzBaVe;
    Hilo hl, hl1, hl2, hl3, hl4, hl5, hl6, hl7, hl8, hl9, hl10, hl11;
    boolean ol = true;
    private int Tv, ta;

    public void Init(boolean old) {
        if (old) {
            hl = new Hilo(DeBaAm, Fram);
            hl.start();
            hl1 = new Hilo(DeBaVe, Fram);
            hl1.start();
            hl2 = new Hilo(DeBaRo, Fram);
            hl2.start();

            hl3 = new Hilo(DeAlAm, Fram);
            hl3.start();
            hl4 = new Hilo(DeAlVe, Fram);
            hl4.start();
            hl5 = new Hilo(DeAlRo, Fram);
            hl5.start();

            hl6 = new Hilo(IzAlAm, Fram);
            hl6.start();
            hl7 = new Hilo(IzAlVe, Fram);
            hl7.start();
            hl8 = new Hilo(IzAlRo, Fram);
            hl8.start();

            hl9 = new Hilo(IzBaAm, Fram);
            hl9.start();
            hl10 = new Hilo(IzBaVe, Fram);
            hl10.start();
            hl11 = new Hilo(IzBaRo, Fram);
            hl11.start();
        } else {
            hl.stop();
            hl1.stop();
            hl2.stop();
            hl3.stop();
            hl4.stop();
            hl5.stop();
            hl6.stop();
            hl7.stop();
            hl8.stop();
            hl9.stop();
            hl10.stop();
            hl11.stop();
        }
    }

    public void Components() {
        Lona2 = new JPanel();
        Lona2.setBounds(1070, 550, 100, 100);
        Lona2.setLayout(null);
        Lona2.setOpaque(true);
        Imagen img3 = new Imagen("/Complements/transparente.png", Lona2.getWidth(), Lona2.getHeight());
        Lona2.add(img3);

        Lona = new JPanel();
        Lona.setBounds(1024, 0, 200, 700);
        Lona.setLayout(null);
        Lona.setOpaque(true);
        Imagen img2 = new Imagen("/Complements/Lona2.jpg", Lona.getWidth(), Lona.getHeight());
        Lona.add(img2);
        Lona.setFocusable(true);
        Lona.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
//                System.out.println("prueba: tecla escrita");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getExtendedKeyCode()) {
                    case KeyEvent.VK_UP:
                        DeBaAm.setLocation(DeBaAm.getX(), DeBaAm.getY() - 5);
                        DeAlAm.setLocation(DeAlAm.getX(), DeAlAm.getY() - 5);
                        IzBaAm.setLocation(IzBaAm.getX(), IzBaAm.getY() - 5);
                        IzAlAm.setLocation(IzAlAm.getX(), IzAlAm.getY() - 5);
                        break;
                    case KeyEvent.VK_DOWN:
                        DeBaAm.setLocation(DeBaAm.getX(), DeBaAm.getY() + 5);
                        DeAlAm.setLocation(DeAlAm.getX(), DeAlAm.getY() + 5);
                        IzBaAm.setLocation(IzBaAm.getX(), IzBaAm.getY() + 5);
                        IzAlAm.setLocation(IzAlAm.getX(), IzAlAm.getY() + 5);
                        break;
                    case KeyEvent.VK_LEFT:
                        DeBaAm.setLocation(DeBaAm.getX() - 5, DeBaAm.getY());
                        DeAlAm.setLocation(DeAlAm.getX() - 5, DeAlAm.getY());
                        IzBaAm.setLocation(IzBaAm.getX() - 5, IzBaAm.getY());
                        IzAlAm.setLocation(IzAlAm.getX() - 5, IzAlAm.getY());
                        break;
                    case KeyEvent.VK_RIGHT:
                        DeBaAm.setLocation(DeBaAm.getX() + 5, DeBaAm.getY());
                        DeAlAm.setLocation(DeAlAm.getX() + 5, DeAlAm.getY());
                        IzBaAm.setLocation(IzBaAm.getX() + 5, IzBaAm.getY());
                        IzAlAm.setLocation(IzAlAm.getX() + 5, IzAlAm.getY());
                        break;
                }
                switch (e.getExtendedKeyCode()) {
                    case KeyEvent.VK_UP:
                        DeBaRo.setLocation(DeBaRo.getX(), DeBaRo.getY() - 10);
                        DeAlRo.setLocation(DeAlRo.getX(), DeAlRo.getY() - 10);
                        IzBaRo.setLocation(IzBaRo.getX(), IzBaRo.getY() - 10);
                        IzAlRo.setLocation(IzAlRo.getX(), IzAlRo.getY() - 10);
                        break;
                    case KeyEvent.VK_DOWN:
                        DeBaRo.setLocation(DeBaRo.getX(), DeBaRo.getY() + 10);
                        DeAlRo.setLocation(DeAlRo.getX(), DeAlRo.getY() + 10);
                        IzBaRo.setLocation(IzBaRo.getX(), IzBaRo.getY() + 10);
                        IzAlRo.setLocation(IzAlRo.getX(), IzAlRo.getY() + 10);
                        break;
                    case KeyEvent.VK_LEFT:
                        DeBaRo.setLocation(DeBaRo.getX() - 10, DeBaRo.getY());
                        DeAlRo.setLocation(DeAlRo.getX() - 10, DeAlRo.getY());
                        IzBaRo.setLocation(IzBaRo.getX() - 10, IzBaRo.getY());
                        IzAlRo.setLocation(IzAlRo.getX() - 10, IzAlRo.getY());
                        break;
                    case KeyEvent.VK_RIGHT:
                        DeBaRo.setLocation(DeBaRo.getX() + 10, DeBaRo.getY());
                        DeAlRo.setLocation(DeAlRo.getX() + 10, DeAlRo.getY());
                        IzBaRo.setLocation(IzBaRo.getX() + 10, IzBaRo.getY());
                        IzAlRo.setLocation(IzAlRo.getX() + 10, IzAlRo.getY());
                        break;
                }
                switch (e.getExtendedKeyCode()) {
                    case KeyEvent.VK_UP:
                        DeBaVe.setLocation(DeBaVe.getX(), DeBaVe.getY() - 15);
                        DeAlVe.setLocation(DeAlVe.getX(), DeAlVe.getY() - 15);
                        IzBaVe.setLocation(IzBaVe.getX(), IzBaVe.getY() - 15);
                        IzAlVe.setLocation(IzAlVe.getX(), IzAlVe.getY() - 15);
                        break;
                    case KeyEvent.VK_DOWN:
                        DeBaVe.setLocation(DeBaVe.getX(), DeBaVe.getY() + 15);
                        DeAlVe.setLocation(DeAlVe.getX(), DeAlVe.getY() + 15);
                        IzBaVe.setLocation(IzBaVe.getX(), IzBaVe.getY() + 15);
                        IzAlVe.setLocation(IzAlVe.getX(), IzAlVe.getY() + 15);
                        break;
                    case KeyEvent.VK_LEFT:
                        DeBaVe.setLocation(DeBaVe.getX() - 15, DeBaVe.getY());
                        DeAlVe.setLocation(DeAlVe.getX() - 15, DeAlVe.getY());
                        IzBaVe.setLocation(IzBaVe.getX() - 15, IzBaVe.getY());
                        IzAlVe.setLocation(IzAlVe.getX() - 15, IzAlVe.getY());
                        break;
                    case KeyEvent.VK_RIGHT:
                        DeBaVe.setLocation(DeBaVe.getX() + 15, DeBaVe.getY());
                        DeAlVe.setLocation(DeAlVe.getX() + 15, DeAlVe.getY());
                        IzBaVe.setLocation(IzBaVe.getX() + 15, IzBaVe.getY());
                        IzAlVe.setLocation(IzAlVe.getX() + 15, IzAlVe.getY());
                        break;
                }

                int key = e.getExtendedKeyCode();
                if (key == KeyEvent.VK_0) {
                    //Semaforo Derecha bajo
                    DeBaAm.setBounds(596, 439, 40, 40);

                    DeBaRo.setBounds(581, 439, 40, 40);

                    DeBaVe.setBounds(611, 439, 40, 40);

                    //Semaforo Derecha Alto
                    DeAlAm.setBounds(601, 221, 40, 40);

                    DeAlRo.setBounds(601, 236, 40, 40);

                    DeAlVe.setBounds(601, 206, 40, 40);

                    //Semaforo izquierda Alto
                    IzAlAm.setBounds(336, 221, 40, 40);

                    IzAlRo.setBounds(321, 221, 40, 40);

                    IzAlVe.setBounds(351, 221, 40, 40);

                    //Semafoto izquierda Bajo
                    IzBaAm.setBounds(373, 462, 40, 40);

                    IzBaRo.setBounds(373, 476, 40, 40);

                    IzBaVe.setBounds(373, 448, 40, 40);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
//                System.out.println("prueba: tecla liberada");
            }

        });

        start = new JButton();
        start.setBounds(1070, 150, 100, 100);
        start.setContentAreaFilled(false);
        URL url = this.getClass().getResource("/Complements/St.png");
        start.setIcon(new ImageIcon(url));
        start.setBorder(null);
        start.setOpaque(false);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Init(ol);
                HiloSemaforos hs = new HiloSemaforos(Fram, DeBaAm, DeBaRo, DeBaVe, DeAlAm, DeAlRo, DeAlVe, IzAlAm, IzAlRo, IzAlVe, IzBaAm, IzBaRo, IzBaVe, cars);
                hs.tiempo(Tv, ta);
                hs.start();
                start.setEnabled(false);
            }
        });

        stop = new JButton();
        stop.setBounds(1070, 350, 100, 100);
        stop.setContentAreaFilled(false);
        URL url1 = this.getClass().getResource("/Complements/Stop.png");
        stop.setIcon(new ImageIcon(url1));
        stop.setBorder(null);
        stop.setOpaque(false);
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        //Semaforo Derecha bajo
        DeBaAm = new Circulo();
        DeBaAm.setBounds(596, 439, 40, 40);

        DeBaRo = new Circulo();
        DeBaRo.setBounds(581, 439, 40, 40);

        DeBaVe = new Circulo();
        DeBaVe.setBounds(611, 439, 40, 40);

        //Semaforo Derecha Alto
        DeAlAm = new Circulo();
        DeAlAm.setBounds(601, 221, 40, 40);

        DeAlRo = new Circulo();
        DeAlRo.setBounds(601, 236, 40, 40);

        DeAlVe = new Circulo();
        DeAlVe.setBounds(601, 206, 40, 40);

        //Semaforo izquierda Alto
        IzAlAm = new Circulo();
        IzAlAm.setBounds(336, 221, 40, 40);

        IzAlRo = new Circulo();
        IzAlRo.setBounds(321, 221, 40, 40);

        IzAlVe = new Circulo();
        IzAlVe.setBounds(351, 221, 40, 40);

        //Semafoto izquierda Bajo
        IzBaAm = new Circulo();
        IzBaAm.setBounds(373, 462, 40, 40);

        IzBaRo = new Circulo();
        IzBaRo.setBounds(373, 476, 40, 40);

        IzBaVe = new Circulo();
        IzBaVe.setBounds(373, 448, 40, 40);

        Fuente = new JLabel();
        URL url2 = this.getClass().getResource("/Complements/fuente.gif");
        Fuente.setIcon(new ImageIcon(url2));
        Fuente.setBounds(760, 480, 117, 128);

        //car 1
        car1 = new JLabel();
        car1.setBounds(300, 270, 100, 70);
        ImageIcon a3 = new ImageIcon(getClass().getResource("/Complements/carro1.png"));
        Icon fondocara3 = new ImageIcon(a3.getImage().getScaledInstance(car1.getWidth(), car1.getHeight(), Image.SCALE_DEFAULT));
        car1.setIcon(fondocara3);

        car2 = new JLabel();
        car2.setBounds(200, 270, 80, 70);
        ImageIcon a4 = new ImageIcon(getClass().getResource("/Complements/carro2.png"));
        Icon fondocara4 = new ImageIcon(a4.getImage().getScaledInstance(car2.getWidth(), car2.getHeight(), Image.SCALE_DEFAULT));
        car2.setIcon(fondocara4);

        car3 = new JLabel();
        car3.setBounds(100, 270, 80, 70);
        ImageIcon a5 = new ImageIcon(getClass().getResource("/Complements/carro3.png"));
        Icon fondocara5 = new ImageIcon(a5.getImage().getScaledInstance(car3.getWidth(), car3.getHeight(), Image.SCALE_DEFAULT));
        car3.setIcon(fondocara5);
        //car 2
        car4 = new JLabel();
        car4.setBounds(600, 330, 100, 70);
        ImageIcon a6 = new ImageIcon(getClass().getResource("/Complements/carro1Invert.png"));
        Icon fondocara6 = new ImageIcon(a6.getImage().getScaledInstance(car4.getWidth(), car4.getHeight(), Image.SCALE_DEFAULT));
        car4.setIcon(fondocara6);

        car5 = new JLabel();
        car5.setBounds(700, 330, 80, 70);
        ImageIcon a7 = new ImageIcon(getClass().getResource("/Complements/carro2Invert.png"));
        Icon fondocara7 = new ImageIcon(a7.getImage().getScaledInstance(car5.getWidth(), car5.getHeight(), Image.SCALE_DEFAULT));
        car5.setIcon(fondocara7);

        car6 = new JLabel();
        car6.setBounds(800, 330, 80, 70);
        ImageIcon a8 = new ImageIcon(getClass().getResource("/Complements/carro3Invert.png"));
        Icon fondocara8 = new ImageIcon(a8.getImage().getScaledInstance(car6.getWidth(), car6.getHeight(), Image.SCALE_DEFAULT));
        car6.setIcon(fondocara8);

        //car 3
        car7 = new JLabel();
        car7.setBounds(430, 440, 60, 80);
        ImageIcon a9 = new ImageIcon(getClass().getResource("/Complements/carro1y2y1.png"));
        Icon fondocara9 = new ImageIcon(a9.getImage().getScaledInstance(car7.getWidth(), car7.getHeight(), Image.SCALE_DEFAULT));
        car7.setIcon(fondocara9);

        car8 = new JLabel();
        car8.setBounds(430, 530, 60, 80);
        ImageIcon a10 = new ImageIcon(getClass().getResource("/Complements/carro2y2y1.png"));
        Icon fondocara10 = new ImageIcon(a10.getImage().getScaledInstance(car8.getWidth(), car8.getHeight(), Image.SCALE_DEFAULT));
        car8.setIcon(fondocara10);

        car9 = new JLabel();
        car9.setBounds(430, 620, 60, 80);
        ImageIcon a11 = new ImageIcon(getClass().getResource("/Complements/carro3y2y1.png"));
        Icon fondocara11 = new ImageIcon(a11.getImage().getScaledInstance(car9.getWidth(), car9.getHeight(), Image.SCALE_DEFAULT));
        car9.setIcon(fondocara11);

        //car 4
        car10 = new JLabel();
        car10.setBounds(490, 170, 60, 80);
        ImageIcon a12 = new ImageIcon(getClass().getResource("/Complements/carro1y1y2.png"));
        Icon fondocara12 = new ImageIcon(a12.getImage().getScaledInstance(car10.getWidth(), car10.getHeight(), Image.SCALE_DEFAULT));
        car10.setIcon(fondocara12);

        car11 = new JLabel();
        car11.setBounds(490, 90, 60, 80);
        ImageIcon a13 = new ImageIcon(getClass().getResource("/Complements/carro2y1y2.png"));
        Icon fondocara13 = new ImageIcon(a13.getImage().getScaledInstance(car11.getWidth(), car11.getHeight(), Image.SCALE_DEFAULT));
        car11.setIcon(fondocara13);

        car12 = new JLabel();
        car12.setBounds(500, 0, 60, 80);
        ImageIcon a14 = new ImageIcon(getClass().getResource("/Complements/carro3y1y2.png"));
        Icon fondocara14 = new ImageIcon(a14.getImage().getScaledInstance(car12.getWidth(), car12.getHeight(), Image.SCALE_DEFAULT));
        car12.setIcon(fondocara14);

        cars[0] = car1;
        cars[1] = car2;
        cars[2] = car3;
        cars[3] = car4;
        cars[4] = car5;
        cars[5] = car6;
        cars[6] = car7;
        cars[7] = car8;
        cars[8] = car9;
        cars[9] = car10;
        cars[10] = car11;
        cars[11] = car12;
    }

    public void Fram() {
        Fram = new JFrame("Semaforos");
        Fram.setSize(1224, 700);
        Fram.setLayout(null);

        Fram.setUndecorated(true);
        Fram.getContentPane().setBackground(Color.lightGray);
        //carros

        Fram.add(car1);
        Fram.add(car2);
        Fram.add(car3);
        Fram.add(car4);
        Fram.add(car5);
        Fram.add(car6);
        Fram.add(car7);
        Fram.add(car8);
        Fram.add(car9);
        Fram.add(car10);
        Fram.add(car11);
        Fram.add(car12);
        //components
        Fram.add(start);
        Fram.add(stop);
        Fram.add(Fuente);
        Fram.add(Lona);
        Fram.add(Lona2);

        //Semaforo Derecha bajo
        Fram.add(DeBaAm);
        Fram.add(DeBaRo);
        Fram.add(DeBaVe);
        //Semaforo Derecha Alto
        Fram.add(DeAlAm);
        Fram.add(DeAlRo);
        Fram.add(DeAlVe);
        //Semaforo izquierda Alto
        Fram.add(IzAlAm);
        Fram.add(IzAlRo);
        Fram.add(IzAlVe);
        //Semafoto izquierda Bajo
        Fram.add(IzBaAm);
        Fram.add(IzBaRo);
        Fram.add(IzBaVe);
        Imagen img = new Imagen("/Complements/Fondo.jpg", 1024, Fram.getHeight());
        Fram.add(img);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Complements/Icon.png"));
        Fram.setIconImage(icon);

        Fram.repaint();
        Fram.setVisible(true);
        Fram.setResizable(false);
        Fram.setLocationRelativeTo(null);
        Fram.setDefaultCloseOperation(3);
        Init(ol);
        Fram.setFocusable(true);
        ol = false;
    }

    public Frame(int t, int t1) throws InterruptedException {
        Tv = t;
        ta = t1;
        Components();
        Fram();
    }
}
