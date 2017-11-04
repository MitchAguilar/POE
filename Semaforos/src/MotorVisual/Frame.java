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
import java.awt.event.KeyListener;
import java.net.URL;
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
    JPanel Lona;
    JLabel Fuente;
    JButton start, stop;
    DibujarCirculo DeBaAm, DeBaRo, DeBaVe;
    DibujarCirculo DeAlAm, DeAlRo, DeAlVe;
    DibujarCirculo IzAlAm, IzAlRo, IzAlVe;
    DibujarCirculo IzBaAm, IzBaRo, IzBaVe;
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
        Lona = new JPanel();
        Lona.setBounds(1024, 0, 200, 700);
        Lona.setLayout(null);
        Lona.setOpaque(true);
        Imagen img2 = new Imagen("/Complements/Lona.jpg", Lona.getWidth(), Lona.getHeight());
        Lona.add(img2);
        Lona.setFocusable(true);
        Lona.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
//                System.out.println("prueba: tecla escrita");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'c') {
                    System.out.println("hola");
                }
                switch (e.getExtendedKeyCode()) {
                    case KeyEvent.VK_UP:
                        DeBaAm.setLocation(DeBaAm.getX(), DeBaAm.getY() - 10);
                        DeAlAm.setLocation(DeAlAm.getX(), DeAlAm.getY() - 10);
                        IzBaAm.setLocation(IzBaAm.getX(), IzBaAm.getY() - 10);
                        IzAlAm.setLocation(IzAlAm.getX(), IzAlAm.getY() - 10);
                        break;
                    case KeyEvent.VK_DOWN:
                        DeBaAm.setLocation(DeBaAm.getX(), DeBaAm.getY() + 10);
                        DeAlAm.setLocation(DeAlAm.getX(), DeAlAm.getY() + 10);
                        IzBaAm.setLocation(IzBaAm.getX(), IzBaAm.getY() + 10);
                        IzAlAm.setLocation(IzAlAm.getX(), IzAlAm.getY() + 10);
                        break;
                    case KeyEvent.VK_LEFT:
                        DeBaAm.setLocation(DeBaAm.getX() - 10, DeBaAm.getY());
                        DeAlAm.setLocation(DeAlAm.getX() - 10, DeAlAm.getY());
                        IzBaAm.setLocation(IzBaAm.getX() - 10, IzBaAm.getY());
                        IzAlAm.setLocation(IzAlAm.getX() - 10, IzAlAm.getY());
                        break;
                    case KeyEvent.VK_RIGHT:
                        DeBaAm.setLocation(DeBaAm.getX() + 10, DeBaAm.getY());
                        DeAlAm.setLocation(DeAlAm.getX() + 10, DeAlAm.getY());
                        IzBaAm.setLocation(IzBaAm.getX() + 10, IzBaAm.getY());
                        IzAlAm.setLocation(IzAlAm.getX() + 10, IzAlAm.getY());
                        break;

                }
                System.out.println("entré");
//                Fram.repaint();
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
                HiloSemaforos hs = new HiloSemaforos(Fram, DeBaAm, DeBaRo, DeBaVe, DeAlAm, DeAlRo, DeAlVe, IzAlAm, IzAlRo, IzAlVe, IzBaAm, IzBaRo, IzBaVe);
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
        DeBaAm = new DibujarCirculo();
        DeBaAm.setBounds(596, 439, 40, 40);

        DeBaRo = new DibujarCirculo();
        DeBaRo.setBounds(581, 439, 40, 40);

        DeBaVe = new DibujarCirculo();
        DeBaVe.setBounds(611, 439, 40, 40);

        //Semaforo Derecha Alto
        DeAlAm = new DibujarCirculo();
        DeAlAm.setBounds(601, 221, 40, 40);

        DeAlRo = new DibujarCirculo();
        DeAlRo.setBounds(601, 236, 40, 40);

        DeAlVe = new DibujarCirculo();
        DeAlVe.setBounds(601, 206, 40, 40);

        //Semaforo izquierda Alto
        IzAlAm = new DibujarCirculo();
        IzAlAm.setBounds(336, 221, 40, 40);

        IzAlRo = new DibujarCirculo();
        IzAlRo.setBounds(321, 221, 40, 40);

        IzAlVe = new DibujarCirculo();
        IzAlVe.setBounds(351, 221, 40, 40);

        //Semafoto izquierda Bajo
        IzBaAm = new DibujarCirculo();
        IzBaAm.setBounds(373, 476, 40, 40);

        IzBaRo = new DibujarCirculo();
        IzBaRo.setBounds(373, 448, 40, 40);

        IzBaVe = new DibujarCirculo();
        IzBaVe.setBounds(373, 462, 40, 40);

        Fuente = new JLabel();
        URL url2 = this.getClass().getResource("/Complements/fuente.gif");
        Fuente.setIcon(new ImageIcon(url2));
        Fuente.setBounds(760, 480, 117, 128);
    }

    public void Fram() {
        Fram = new JFrame("Semaforos");
        Fram.setSize(1224, 700);
        Fram.setLayout(null);

        Fram.setUndecorated(true);
        Fram.getContentPane().setBackground(Color.lightGray);

        Fram.add(start);
        Fram.add(stop);
        Fram.add(Fuente);
        Fram.add(Lona);

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
//        Lona.add(img);
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

    public Frame(int t, int t1) {
        Tv = t;
        ta = t1;
        Components();
        Fram();
    }
}
