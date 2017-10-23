/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorVisual;

import MotorLogico.*;
import MotorLogico.Hilos.HiloCronometro;
import MotorLogico.Hilos.HiloMovimiento;
import MotorLogico.Hilos.HiloRepaint;
import MotorLogico.Hilos.HiloTemporizador;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Hashtable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Usuario
 */
public class FrameV implements ActionListener {

    private JFrame fram;
    private panel Pan1, Pan2, Pan3, panConfig, tiempo;
    private ClassCount c, d, e, c1, d1, e1;
    private JButton btn, btn2, btn3, P1Play, P1Stop, P1Pause, P2Play, P2Stop, P2Pause, P3Play, P3Stop, P3Pause;
    private ClassRel dibujos;
    private boolean bandera = true, bandera2 = true;
    private int time;
    JSlider Time;
    Hashtable has;
    //hilos peligrosos
//    HiloMovimiento Relo;
    HiloCronometro crm;
    HiloTemporizador tmp;

    public void Components() {
        //panel de configuraciones
        panConfig = new panel(Color.white, 0.5f, "Administración");
        panConfig.setLayout(null);
        panConfig.setBounds(10, 10, 120, 350);

        btn = new JButton();
        btn.setBounds(10, 20, 100, 100);
        URL url = this.getClass().getResource("/Complements/Reloj.png");
        btn.setIcon(new ImageIcon(url));
        btn.addActionListener(this);
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);

        btn2 = new JButton();
        btn2.setBounds(10, 130, 100, 100);
        URL url2 = this.getClass().getResource("/Complements/cronometro.png");
        btn2.setIcon(new ImageIcon(url2));
        btn2.addActionListener(this);
        btn2.setOpaque(false);
        btn2.setContentAreaFilled(false);

        btn3 = new JButton();
        btn3.setBounds(10, 240, 100, 100);
        URL url3 = this.getClass().getResource("/Complements/Temporizador.png");
        btn3.setIcon(new ImageIcon(url3));
        btn3.addActionListener(this);
        btn3.setOpaque(false);
        btn3.setContentAreaFilled(false);

        panConfig.add(btn);
        panConfig.add(btn2);
        panConfig.add(btn3);

        //panel del reloj
        Pan1 = new panel(Color.WHITE, 0.5f, "Reloj");
        Pan1.setLayout(null);
        Pan1.setVisible(false);

        P1Play = new JButton();
        P1Play.setBounds(10, 345, 60, 60);
        URL url4 = this.getClass().getResource("/Complements/play.png");
        P1Play.setIcon(new ImageIcon(url4));
        P1Play.addActionListener(this);
        P1Play.setOpaque(false);
        P1Play.setContentAreaFilled(false);
        P1Play.setBorder(null);

        P1Pause = new JButton();
        P1Pause.setBounds(140, 345, 60, 60);
        URL url5 = this.getClass().getResource("/Complements/Pause.png");
        P1Pause.setIcon(new ImageIcon(url5));
        P1Pause.addActionListener(this);
        P1Pause.setOpaque(false);
        P1Pause.setContentAreaFilled(false);
        P1Pause.setBorder(null);

        P1Stop = new JButton();
        P1Stop.setBounds(260, 345, 60, 60);
        URL url6 = this.getClass().getResource("/Complements/Stop.png");
        P1Stop.setIcon(new ImageIcon(url6));
        P1Stop.addActionListener(this);
        P1Stop.setOpaque(false);
        P1Stop.setContentAreaFilled(false);
        P1Stop.setBorder(null);

        Pan1.add(P1Play);
        Pan1.add(P1Pause);
        Pan1.add(P1Stop);

        //panel cronometro
        c = new ClassCount(72);
        c.setLayout(null);
        c.setBounds(15, 60, 100, 100);

        d = new ClassCount(6);
        d.setLayout(null);
        d.setBounds(115, 60, 100, 100);

        e = new ClassCount(100);
        e.setLayout(null);
        e.setBounds(215, 60, 100, 100);

        Pan2 = new panel(Color.WHITE, 0.5f, "Cronometro");
        Pan2.setLayout(null);
        Pan2.setVisible(false);

        Pan2.add(c);
        Pan2.add(d);
        Pan2.add(e);

        Time = new JSlider(JSlider.HORIZONTAL, 0, 3, 0);
        Time.setBounds(50, 30, 220, 50);
        Time.setMajorTickSpacing(1);
        Time.setPaintTicks(true);
        Time.setMajorTickSpacing(1);
        Time.setPaintLabels(true);
        Time.setOpaque(false);
        Time.setForeground(Color.white);
        Time.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                time = Time.getValue() + 1;
            }
        });

        has = new Hashtable();
        JLabel p1 = new JLabel("2");
        p1.setForeground(Color.ORANGE);
        JLabel p2 = new JLabel("3");
        p2.setForeground(Color.ORANGE);
        JLabel p3 = new JLabel("5");
        p3.setForeground(Color.ORANGE);
        JLabel p4 = new JLabel("0");
        p4.setForeground(Color.ORANGE);

        has.put(new Integer(0), p4);
        has.put(new Integer(1), p1);
        has.put(new Integer(2), p2);
        has.put(new Integer(3), p3);
        Time.setLabelTable(has);

        tiempo = new panel(Color.BLACK, 0.6f, "Tiempo");
        tiempo.setBounds(15, 200, 300, 100);
        tiempo.add(Time);
        tiempo.setLayout(null);

        Pan2.add(tiempo);

        P2Play = new JButton();
        P2Play.setBounds(10, 345, 60, 60);
        URL url7 = this.getClass().getResource("/Complements/play.png");
        P2Play.setIcon(new ImageIcon(url7));
        P2Play.addActionListener(this);
        P2Play.setOpaque(false);
        P2Play.setContentAreaFilled(false);
        P2Play.setBorder(null);
        P2Play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Time.getValue() != 0) {
                    Time.setEnabled(false);
                    if (bandera) {
                        URL url7 = this.getClass().getResource("/Complements/Resume.png");
                        P2Play.setIcon(new ImageIcon(url7));
                        crm.Temp(time++);
                        crm.start();
                    } else {
                        crm.resume();
                        URL url7 = this.getClass().getResource("/Complements/Resume.png");
                        P2Play.setIcon(new ImageIcon(url7));
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor elija un tiempo", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        P2Pause = new JButton();
        P2Pause.setBounds(140, 345, 60, 60);
        URL url8 = this.getClass().getResource("/Complements/Pause.png");
        P2Pause.setIcon(new ImageIcon(url8));
        P2Pause.addActionListener(this);
        P2Pause.setOpaque(false);
        P2Pause.setContentAreaFilled(false);
        P2Pause.setBorder(null);
        P2Pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crm.suspend();
                bandera = false;
                URL url7 = this.getClass().getResource("/Complements/Resume.png");
                P2Play.setIcon(new ImageIcon(url7));
            }
        });

        P2Stop = new JButton();
        P2Stop.setBounds(260, 345, 60, 60);
        URL url9 = this.getClass().getResource("/Complements/Stop.png");
        P2Stop.setIcon(new ImageIcon(url9));
        P2Stop.addActionListener(this);
        P2Stop.setOpaque(false);
        P2Stop.setContentAreaFilled(false);
        P2Stop.setBorder(null);
        P2Stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
                crm.stop();
                crm = new HiloCronometro(c, d, e);
                bandera = true;
                URL url7 = this.getClass().getResource("/Complements/play.png");
                P2Play.setIcon(new ImageIcon(url7));
                Time.setEnabled(true);
                time = 0;
            }
        });

        Pan2.add(P2Play);
        Pan2.add(P2Pause);
        Pan2.add(P2Stop);

        //panel 3
        Pan3 = new panel(Color.WHITE, 0.5f, "Temporizador");
        Pan3.setLayout(null);
        Pan3.setVisible(false);

        c1 = new ClassCount(72);
        c1.setLayout(null);
        c1.setBounds(15, 60, 100, 100);

        d1 = new ClassCount(6);
        d1.setLayout(null);
        d1.setBounds(115, 60, 100, 100);

        e1 = new ClassCount(100);
        e1.setLayout(null);
        e1.setBounds(215, 60, 100, 100);

        Pan3.add(c1);
        Pan3.add(d1);
        Pan3.add(e1);

        P3Play = new JButton();
        P3Play.setBounds(100, 170, 140, 140);
        URL url10 = this.getClass().getResource("/Complements/PlayG.png");
        P3Play.setIcon(new ImageIcon(url10));
        P3Play.addActionListener(this);
        P3Play.setOpaque(false);
        P3Play.setContentAreaFilled(false);
        P3Play.setBorder(null);
        P3Play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bandera2) {
                    URL url10 = this.getClass().getResource("/Complements/ResumeG.png");
                    P3Play.setIcon(new ImageIcon(url10));
                    tmp.start();
                } else {
                    tmp.resume();
                    URL url10 = this.getClass().getResource("/Complements/ResumeG.png");
                    P3Play.setIcon(new ImageIcon(url10));
                }

            }
        });
        P3Pause = new JButton();
        P3Pause.setBounds(40, 340, 80, 80);
        URL url11 = this.getClass().getResource("/Complements/PauseG.png");
        P3Pause.setIcon(new ImageIcon(url11));
        P3Pause.addActionListener(this);
        P3Pause.setOpaque(false);
        P3Pause.setContentAreaFilled(false);
        P3Pause.setBorder(null);
        P3Pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tmp.suspend();
                bandera2 = false;
                URL url11 = this.getClass().getResource("/Complements/ResumeG.png");
                P3Play.setIcon(new ImageIcon(url11));
            }
        });
        P3Stop = new JButton();
        P3Stop.setBounds(220, 340, 80, 80);
        URL url12 = this.getClass().getResource("/Complements/StopG.png");
        P3Stop.setIcon(new ImageIcon(url12));
        P3Stop.addActionListener(this);
        P3Stop.setOpaque(false);
        P3Stop.setContentAreaFilled(false);
        P3Stop.setBorder(null);
        P3Stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
                tmp.stop();
                tmp = new HiloTemporizador(c1, d1, e1, 5);
                bandera2 = true;
                URL url12 = this.getClass().getResource("/Complements/PlayG.png");
                P3Play.setIcon(new ImageIcon(url12));
            }
        });

        Pan3.add(P3Play);
        Pan3.add(P3Stop);
        Pan3.add(P3Pause);
    }

    int a = (995 - 330) / 2, b = 20, ac = 330, dc = 430;
    boolean aaa = true;

    public void runningPan1() throws InterruptedException {
        dibujos = new ClassRel();
        Pan1.add(dibujos);
        dibujos.setBounds(10, 20, 310, 300);
        dibujos.setVisible(true);
    }

    public void Fram() {
        fram = new JFrame("Tiempo");
        fram.setSize(995, 500);
        fram.setLayout(null);

        fram.add(panConfig);
        fram.add(Pan1);
        fram.add(Pan2);
        fram.add(Pan3);

        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Complements/icon.png"));
        Imagen img = new Imagen("/Complements/1.jpg", fram.getWidth(), fram.getHeight());
        fram.add(img);
        fram.setIconImage(icon);

        fram.setResizable(false);
        fram.setLocationRelativeTo(null);
        fram.setVisible(true);
        fram.setDefaultCloseOperation(3);
    }

    public FrameV() throws InterruptedException {
        Components();
        Fram();
//        HiloImagen hl = new HiloImagen(fram);
//        hl.start();
        HiloRepaint Rp = new HiloRepaint(fram);
        Rp.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btn)) {
            btn.setEnabled(false);
            btn2.setEnabled(true);
            btn3.setEnabled(true);
            Pan2.setVisible(false);
            Pan3.setVisible(false);
            Pan1.setVisible(true);
            HiloMovimiento h = new HiloMovimiento(Pan1);
            h.start();
            try {
                runningPan1();
            } catch (InterruptedException ex) {
            }
            System.out.println("final 1");
        }
        if (e.getSource().equals(btn2)) {
            btn.setEnabled(true);
            btn2.setEnabled(false);
            btn3.setEnabled(true);
            Pan2.setVisible(true);
            Pan3.setVisible(false);
            Pan1.setVisible(false);
            HiloMovimiento h = new HiloMovimiento(Pan2);
            h.start();
            crm = new HiloCronometro(c, d, this.e);
            System.out.println("final 2");
        }
        if (e.getSource().equals(btn3)) {
            btn.setEnabled(true);
            btn2.setEnabled(true);
            btn3.setEnabled(false);
            Pan2.setVisible(false);
            Pan3.setVisible(true);
            Pan1.setVisible(false);
            HiloMovimiento h = new HiloMovimiento(Pan3);
            h.start();
            tmp = new HiloTemporizador(c1, d1, e1, 5);
            System.out.println("final 3");
        }
    }
}
