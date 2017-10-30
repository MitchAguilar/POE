/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorVisual;

import MotorLogico.Imagen;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
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
    JPanel Matix;
    JLabel Arb;
    JButton start;
    DibujarCirculo DeBaAm,DeBaRo,DeBaVe;

    public void Components() {
        Matix = new JPanel();
        Matix.setBounds(0, 0, 1024, 700);
        Matix.setLayout(null);
//        Imagen img = new Imagen("/Complements/Fondo.jpg", Matix.getWidth(), Matix.getHeight());
//        Matix.add(img);
        Matix.setOpaque(true);

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
                Hilo hl = new Hilo(DeBaAm, Fram);
                hl.start();
                Hilo hl1 = new Hilo(DeBaVe, Fram);
                hl1.start();
                Hilo hl2 = new Hilo(DeBaRo, Fram);
                hl2.start();
            }
        });

        DeBaAm = new DibujarCirculo();
        DeBaAm.setBounds(596, 439, 40, 40);
        
        DeBaRo= new DibujarCirculo();
        DeBaRo.setBounds(581, 439, 40, 40);

        DeBaVe= new DibujarCirculo();
        DeBaVe.setBounds(611, 439, 40, 40);

    }

    public void Fram() {
        Fram = new JFrame("Semaforos");
        Fram.setSize(1224, 700);
        Fram.setLayout(null);

//        Fram.setUndecorated(true);
//        Fram.add(Matix);
        Fram.add(start);
        Fram.add(DeBaAm);
        Fram.add(DeBaRo);
        Fram.add(DeBaVe);
        Imagen img = new Imagen("/Complements/Fondo.jpg", Matix.getWidth(), Matix.getHeight());
        Matix.add(img);
        Fram.add(img);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Complements/Icon.png"));
        Fram.setIconImage(icon);

        Fram.repaint();
        Fram.setVisible(true);
        Fram.setResizable(false);
        Fram.setLocationRelativeTo(null);
        Fram.setDefaultCloseOperation(3);

    }

    public Frame() {
        Components();
        Fram();
    }

    public static class Hilo extends Thread {

        DibujarCirculo db;
        JFrame fr;

        public Hilo(DibujarCirculo db, JFrame fr) {
            this.db = db;
            this.fr = fr;
        }
        public int num(){
            return (int) (Math.random()*(254+0));
        }

        public void run() {
            try {
                db.col = new Color(num(),num(),num());
                fr.repaint();
                sleep(1000);
                System.out.println("1");
                db.col = new Color(num(),num(),num());
                fr.repaint();
                sleep(1000);
                System.out.println("2");
                db.col = new Color(num(),num(),num());
                fr.repaint();
                sleep(1000);
                System.out.println("3");
                run();
            } catch (InterruptedException ex) {
            }

        }
    }

}
