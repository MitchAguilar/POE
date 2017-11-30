/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorVisual;

import Core.EasyCore;
import Core.MediumCore;
import MotorLogico.ClassCount;
import MotorLogico.Hilos.HiloTemporizador;
import MotorLogico.Hilos.HiloTemporizador2;
import MotorLogico.Hilos.moverAutomaticamenteVentana;
import MotorLogico.Meives;
import MotorLogico.Parpadeo;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

/**
 *
 * @author mitch
 */
public class GameViewTwoLevel implements MouseMotionListener, MouseListener {

    JFrame fr;
    Meives.PanelM pan, config;
    ClassCount segundos;
    JButton init, exit;
    public JLabel info, puntos, point, num1, num2, num3, num4, num5;
    JLabel Lnum1, Lnum2, Lnum3, Lnum4, Lnum5;
    Cursor c;
    JPanel Pnume, Sign, Snun, Igu, Res;
    public int bansera1, bandera2;

    public void setBansera1(int bansera1) {
        this.bansera1 = bansera1;
    }

    public void setBandera2(int bandera2) {
        this.bandera2 = bandera2;
    }
    HiloTemporizador2 ht;

    public void Comp() {
        pan = new Meives.PanelM(Color.WHITE, 0.34f, 50, 50, 400, 400);
        config = new Meives.PanelM(Color.GRAY, 0.54f, 500, 50, 150, 400);

        init = new JButton();
        init.setDoubleBuffered(true);
        init.setOpaque(false);
        init.setBorder(null);
        init.setBounds(10, 120, 130, 70);
        Color c = UIManager.getLookAndFeel().getDefaults().getColor("Panel.background");
        init.setBackground(new Color(c.getRed(), c.getGreen(), c.getBlue()));
        ImageIcon a2 = new ImageIcon(getClass().getResource("/Complements/Img/Play.png"));
        Icon fnd = new ImageIcon(a2.getImage().getScaledInstance(init.getWidth(), init.getHeight(), Image.SCALE_DEFAULT));
        init.setIcon(fnd);
        init.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ht = new HiloTemporizador2(segundos, GameViewTwoLevel.this, new MediumCore(num1, num2, num3, num4, num5, Lnum1, Lnum2, Lnum3, Lnum4, Lnum5));
                ht.start();
                init.setEnabled(false);
            }
        });

        exit = new JButton();
        exit.setDoubleBuffered(true);
        exit.setOpaque(false);
        exit.setBorder(null);
        exit.setBounds(640, 10, 50, 50);
        exit.setBackground(new Color(c.getRed(), c.getGreen(), c.getBlue()));
        ImageIcon a3 = new ImageIcon(getClass().getResource("/Complements/Img/exit.png"));
        Icon fnd2 = new ImageIcon(a3.getImage().getScaledInstance(exit.getWidth(), exit.getHeight(), Image.SCALE_DEFAULT));
        exit.setIcon(fnd2);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        segundos = new ClassCount(6, new Color(61, 66, 146));
        segundos.setBounds(40, 10, 70, 70);
        segundos.setDoubleBuffered(true);
        segundos.setLayout(null);

        info = new JLabel("<html><body><center><div style='color:black;'>Puntos<br/> minimos:<br/><b>10</b>"
                + "</div></center></body></html>");
        info.setBounds(20, 200, 150, 100);
        info.setForeground(Color.WHITE);
        info.setFont(new Font("aharoni", Font.BOLD, 25));

        puntos = new JLabel("0");
        puntos.setBounds(10, 290, 150, 100);
        puntos.setForeground(Color.WHITE);
        puntos.setFont(new Font("aharoni", Font.BOLD, 150));

        config.add(init);
        config.add(puntos);
        config.add(info);
        config.add(segundos);

        point = new JLabel("x= 0 || y= 0");
        point.setFont(new Font("aharoni", Font.BOLD, 14));
        point.setBounds(300, 335, 100, 100);
        point.setDoubleBuffered(true);
        pan.add(point);

        Font fn = new Font("aharoni", Font.BOLD, 60);
        //la font

//valores a escoger
        Lnum1 = new JLabel("1");
        Lnum1.setBackground(Color.orange);
        Lnum1.setForeground(Color.WHITE);
        Lnum1.setOpaque(true);
        Lnum1.setBorder(new LineBorder(Color.black));
        Lnum1.setBounds(30, 250, 60, 60);
        Lnum1.setLayout(null);
        Lnum1.addMouseMotionListener(this);
        Lnum1.addMouseListener(this);
        Lnum1.setFont(fn);

        Lnum2 = new JLabel("2");
        Lnum2.setBackground(Color.orange);
        Lnum2.setForeground(Color.WHITE);
        Lnum2.setOpaque(true);
        Lnum2.setBorder(new LineBorder(Color.black));
        Lnum2.setBounds(100, 250, 60, 60);
        Lnum2.setLayout(null);
        Lnum2.setFont(fn);
        Lnum2.addMouseMotionListener(this);
        Lnum2.addMouseListener(this);

        Lnum3 = new JLabel("3");
        Lnum3.setBackground(Color.orange);
        Lnum3.setForeground(Color.WHITE);
        Lnum3.setOpaque(true);
        Lnum3.setBorder(new LineBorder(Color.black));
        Lnum3.setBounds(170, 250, 60, 60);
        Lnum3.setLayout(null);
        Lnum3.setFont(fn);
        Lnum3.addMouseMotionListener(this);
        Lnum3.addMouseListener(this);

        Lnum4 = new JLabel("4");
        Lnum4.setBackground(Color.orange);
        Lnum4.setForeground(Color.WHITE);
        Lnum4.setOpaque(true);
        Lnum4.setBorder(new LineBorder(Color.black));
        Lnum4.setBounds(240, 250, 60, 60);
        Lnum4.setLayout(null);
        Lnum4.setFont(fn);
        Lnum4.addMouseMotionListener(this);
        Lnum4.addMouseListener(this);

        Lnum5 = new JLabel("53");
        Lnum5.setBorder(new LineBorder(Color.black));
        Lnum5.setLayout(null);
        Lnum5.setBackground(Color.orange);
        Lnum5.setForeground(Color.WHITE);
        Lnum5.setOpaque(true);
        Lnum5.setBounds(310, 250, 60, 60);
        Lnum5.setFont(fn);
        Lnum5.addMouseMotionListener(this);
        Lnum5.addMouseListener(this);
        pan.add(Lnum1);
        pan.add(Lnum2);
        pan.add(Lnum3);
        pan.add(Lnum4);
        pan.add(Lnum5);
        // numeros
        Pnume = new JPanel(true);
        Pnume.setBackground(Color.white);
        Pnume.setBorder(new LineBorder(Color.black));
        Pnume.setBounds(30, 60, 60, 60);
        Pnume.setLayout(null);

        Sign = new JPanel(true);
        Sign.setBackground(Color.white);
        Sign.setBorder(new LineBorder(Color.black));
        Sign.setBounds(100, 60, 60, 60);
        Sign.setLayout(null);

        Snun = new JPanel(true);
        Snun.setBackground(Color.white);
        Snun.setBorder(new LineBorder(Color.black));
        Snun.setBounds(170, 60, 60, 60);
        Snun.setLayout(null);

        Igu = new JPanel(true);
        Igu.setBackground(Color.white);
        Igu.setBorder(new LineBorder(Color.black));
        Igu.setBounds(240, 60, 60, 60);
        Igu.setLayout(null);

        Res = new JPanel(true);
        Res.setBackground(Color.white);
        Res.setBorder(new LineBorder(Color.black));
        Res.setBounds(310, 60, 60, 60);
        Res.setLayout(null);

        //numeros
        num1 = new JLabel("19");
        num1.setFont(fn);
        num1.setBounds(5, 5, 50, 50);
        num1.setSize(50, 50);
        num1.addMouseMotionListener(this);
        num1.addMouseListener(this);
        num1.setDoubleBuffered(true);
        Pnume.add(num1);

        num2 = new JLabel("/");
        num2.setFont(fn);
        num2.setBounds(15, 5, 50, 50);
        num2.setSize(50, 50);
        num2.addMouseMotionListener(this);
        num2.addMouseListener(this);
        num2.setDoubleBuffered(true);
        Sign.add(num2);

        num3 = new JLabel("49");
        num3.setFont(fn);
        num3.setBounds(5, 5, 50, 50);
        num3.setSize(50, 50);
        num3.addMouseMotionListener(this);
        num3.addMouseListener(this);
        num3.setDoubleBuffered(true);
        Snun.add(num3);

        num4 = new JLabel("=");
        num4.setFont(fn);
        num4.setBounds(5, 5, 50, 50);
        num4.setSize(50, 50);
        num4.addMouseMotionListener(this);
        num4.addMouseListener(this);
        num4.setDoubleBuffered(true);
        Igu.add(num4);

        num5 = new JLabel("39");
        num5.setFont(fn);
        num5.setBounds(10, 5, 50, 50);
        num5.setSize(50, 50);
        num5.addMouseMotionListener(this);
        num5.addMouseListener(this);
        num5.setDoubleBuffered(true);
        Res.add(num5);

        pan.add(Pnume);
        pan.add(Sign);
        pan.add(Snun);
        pan.add(Igu);
        pan.add(Res);

    }

    public void Rapa() {
        fr.repaint();
    }

    public void dis() {
        fr.dispose();
    }

    public void Frm() {
        fr = new JFrame();
        fr.setSize(700, 500);
        fr.setLayout(null);
        fr.setUndecorated(true);

        fr.add(exit);
        fr.add(pan);
        fr.add(config);

        Meives.Imagen img = new Meives.Imagen("/Complements/Img/two.jpg", fr.getWidth(), fr.getHeight());
        fr.add(img);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Complements/Img/icon.png"));
        fr.setIconImage(icon);
        fr.repaint();

        Toolkit tk = Toolkit.getDefaultToolkit();
        Image iconoMaus = new ImageIcon(getClass().getResource("/Complements/Img/7.png")).getImage(); //Icono
        c = tk.createCustomCursor(iconoMaus, new Point(1, 1), "String");
        fr.setCursor(c);

        fr.setLocationRelativeTo(null);
        fr.setResizable(false);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(3);

        moverAutomaticamenteVentana mv = new moverAutomaticamenteVentana(fr, 1, 500, 10, 100, 10);
        fr.setLocationRelativeTo(null);
    }

    public GameViewTwoLevel() {
        Comp();
        Frm();
    }

    public void para() {
        Parpadeo pr = new Parpadeo(fr.getWidth(), fr.getHeight(), fr);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (e.getSource().equals(Lnum1)) {
            Lnum1.setLocation(Lnum1.getX() + e.getX() - Lnum1.getWidth() / 2, Lnum1.getY() + e.getY() - Lnum1.getHeight() / 2);
            point.setText("x= " + Lnum1.getX() + " || y= " + Lnum1.getY() + "");
        }
        if (e.getSource().equals(Lnum2)) {
            Lnum2.setLocation(Lnum2.getX() + e.getX() - Lnum2.getWidth() / 2, Lnum2.getY() + e.getY() - Lnum2.getHeight() / 2);
            point.setText("x= " + Lnum2.getX() + " || y= " + Lnum2.getY() + "");
        }
        if (e.getSource().equals(Lnum3)) {
            Lnum3.setLocation(Lnum3.getX() + e.getX() - Lnum3.getWidth() / 2, Lnum3.getY() + e.getY() - Lnum3.getHeight() / 2);
            point.setText("x= " + Lnum3.getX() + " || y= " + Lnum3.getY() + "");
        }
        if (e.getSource().equals(Lnum4)) {
            Lnum4.setLocation(Lnum4.getX() + e.getX() - Lnum4.getWidth() / 2, Lnum4.getY() + e.getY() - Lnum4.getHeight() / 2);
            point.setText("x= " + Lnum4.getX() + " || y= " + Lnum4.getY() + "");
        }
        if (e.getSource().equals(Lnum5)) {
            Lnum5.setLocation(Lnum5.getX() + e.getX() - Lnum5.getWidth() / 2, Lnum5.getY() + e.getY() - Lnum5.getHeight() / 2);
            point.setText("x= " + Lnum5.getX() + " || y= " + Lnum4.getY() + "");
        }
        fr.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    public void restart() {
        Lnum5.setLocation(310, 250);
        Lnum4.setLocation(240, 250);
        Lnum2.setLocation(100, 250);
        Lnum3.setLocation(170, 250);
        Lnum1.setLocation(30, 250);
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if (me.getSource().equals(Lnum1)) {
            if (bansera1 == 1) {
                switch (bandera2) {
                    case 1:
                        if ((Lnum1.getX() >= 25 && Lnum1.getX() <= 38) && (Lnum1.getY() >= 50 && Lnum1.getY() <= 75)) {
                            Lnum1.setLocation(30, 60);
                            ht.Str();
                        } else {
                            Lnum1.setLocation(30, 250);
                        }
                        break;
                    case 2:
                        if ((Lnum1.getX() >= 97 && Lnum1.getX() <= 104) && (Lnum1.getY() >= 50 && Lnum1.getY() <= 75)) {
                            Lnum1.setLocation(100, 60);
                            ht.Str();
                        } else {
                            Lnum1.setLocation(30, 250);
                        }
                        break;
                    case 3:
                        if ((Lnum1.getX() >= 165 && Lnum1.getX() <= 175) && (Lnum1.getY() >= 50 && Lnum1.getY() <= 75)) {
                            Lnum1.setLocation(170, 60);
                            ht.Str();
                        } else {
                            Lnum1.setLocation(30, 250);
                        }
                        break;
                    case 4:
                        if ((Lnum1.getX() >= 236 && Lnum1.getX() <= 246) && (Lnum1.getY() >= 50 && Lnum1.getY() <= 75)) {
                            Lnum1.setLocation(240, 60);
                            ht.Str();
                        } else {
                            Lnum1.setLocation(30, 250);
                        }
                        break;
                    case 5:
                        if ((Lnum1.getX() >= 305 && Lnum1.getX() <= 315) && (Lnum1.getY() >= 50 && Lnum1.getY() <= 75)) {
                            Lnum1.setLocation(310, 60);
                            ht.Str();
                        } else {
                            Lnum1.setLocation(30, 250);
                        }
                        break;
                }
            } else {
                Lnum1.setLocation(30, 250);
            }
        }
        if (me.getSource().equals(Lnum2)) {
            if (bansera1 == 2) {
                switch (bandera2) {
                    case 1:
                        if ((Lnum2.getX() >= 25 && Lnum2.getX() <= 38) && (Lnum2.getY() >= 50 && Lnum2.getY() <= 75)) {
                            Lnum2.setLocation(30, 60);
                            ht.Str();
                        } else {
                            Lnum2.setLocation(100, 250);
                        }
                        break;
                    case 2:
                        if ((Lnum2.getX() >= 97 && Lnum2.getX() <= 104) && (Lnum2.getY() >= 50 && Lnum2.getY() <= 75)) {
                            Lnum2.setLocation(100, 60);
                            ht.Str();
                        } else {
                            Lnum2.setLocation(100, 250);
                        }
                        break;
                    case 3:
                        if ((Lnum2.getX() >= 165 && Lnum2.getX() <= 175) && (Lnum2.getY() >= 50 && Lnum2.getY() <= 75)) {
                            Lnum2.setLocation(170, 60);
                            ht.Str();
                        } else {
                            Lnum2.setLocation(100, 250);
                        }
                        break;
                    case 4:
                        if ((Lnum2.getX() >= 236 && Lnum2.getX() <= 246) && (Lnum2.getY() >= 50 && Lnum2.getY() <= 75)) {
                            Lnum2.setLocation(240, 60);
                            ht.Str();
                        } else {
                            Lnum2.setLocation(100, 250);
                        }
                        break;
                    case 5:
                        if ((Lnum2.getX() >= 305 && Lnum2.getX() <= 315) && (Lnum2.getY() >= 50 && Lnum2.getY() <= 75)) {
                            Lnum2.setLocation(310, 60);
                            ht.Str();
                        } else {
                            Lnum2.setLocation(100, 250);
                        }
                        break;
                    default:
                        Lnum2.setLocation(310, 250);
                        break;
                }
            } else {
                Lnum2.setLocation(100, 250);
            }
        }
        if (me.getSource().equals(Lnum3)) {
            if (bansera1 == 3) {
                switch (bandera2) {
                    case 1:
                        if ((Lnum3.getX() >= 25 && Lnum3.getX() <= 38) && (Lnum3.getY() >= 50 && Lnum3.getY() <= 75)) {
                            Lnum3.setLocation(30, 60);
                            ht.Str();
                        } else {
                            Lnum3.setLocation(170, 250);
                        }
                        break;
                    case 2:
                        if ((Lnum3.getX() >= 97 && Lnum3.getX() <= 104) && (Lnum3.getY() >= 50 && Lnum3.getY() <= 75)) {
                            Lnum3.setLocation(100, 60);
                            ht.Str();
                        } else {
                            Lnum3.setLocation(170, 250);
                        }
                        break;
                    case 3:
                        if ((Lnum3.getX() >= 165 && Lnum3.getX() <= 175) && (Lnum3.getY() >= 50 && Lnum3.getY() <= 75)) {
                            Lnum3.setLocation(170, 60);
                            ht.Str();
                        } else {
                            Lnum3.setLocation(170, 250);
                        }
                        break;
                    case 4:
                        if ((Lnum3.getX() >= 236 && Lnum3.getX() <= 246) && (Lnum3.getY() >= 50 && Lnum3.getY() <= 75)) {
                            Lnum2.setLocation(240, 60);
                            ht.Str();
                        } else {
                            Lnum3.setLocation(170, 250);
                        }
                        break;
                    case 5:
                        if ((Lnum3.getX() >= 305 && Lnum3.getX() <= 315) && (Lnum3.getY() >= 50 && Lnum3.getY() <= 75)) {
                            Lnum3.setLocation(310, 60);
                            ht.Str();
                        } else {
                            Lnum3.setLocation(170, 250);
                        }
                        System.out.println("entré");
                        break;
                    default:
                        Lnum3.setLocation(170, 250);
                        break;
                }
            } else {
                Lnum3.setLocation(170, 250);
            }
        }

        if (me.getSource().equals(Lnum4)) {
            if (bansera1 == 4) {
                switch (bandera2) {
                    case 1:
                        if ((Lnum4.getX() >= 25 && Lnum4.getX() <= 38) && (Lnum4.getY() >= 50 && Lnum4.getY() <= 75)) {
                            Lnum4.setLocation(30, 60);
                            ht.Str();
                        } else {
                            Lnum4.setLocation(170, 250);
                        }
                        break;
                    case 2:
                        if ((Lnum4.getX() >= 97 && Lnum4.getX() <= 104) && (Lnum4.getY() >= 50 && Lnum4.getY() <= 75)) {
                            Lnum4.setLocation(100, 60);
                            ht.Str();
                        } else {
                            Lnum4.setLocation(240, 250);
                        }
                        break;
                    case 3:
                        if ((Lnum4.getX() >= 165 && Lnum4.getX() <= 175) && (Lnum4.getY() >= 50 && Lnum4.getY() <= 75)) {
                            Lnum4.setLocation(170, 60);
                            ht.Str();
                        } else {
                            Lnum4.setLocation(240, 250);
                        }
                        break;
                    case 4:
                        if ((Lnum4.getX() >= 236 && Lnum4.getX() <= 246) && (Lnum4.getY() >= 50 && Lnum4.getY() <= 75)) {
                            Lnum4.setLocation(240, 60);
                            ht.Str();
                        } else {
                            Lnum4.setLocation(240, 250);
                        }
                        break;
                    case 5:
                        if ((Lnum4.getX() >= 305 && Lnum4.getX() <= 315) && (Lnum4.getY() >= 50 && Lnum4.getY() <= 75)) {
                            Lnum4.setLocation(310, 60);
                            ht.Str();
                        } else {
                            Lnum4.setLocation(240, 250);
                        }
                        break;
                    default:
                        Lnum4.setLocation(240, 250);
                        break;
                }
            } else {
                Lnum4.setLocation(240, 250);
            }
        }
        if (me.getSource().equals(Lnum5)) {
            if (bansera1 == 5) {
                switch (bandera2) {
                    case 1:
                        if ((Lnum5.getX() >= 25 && Lnum5.getX() <= 38) && (Lnum5.getY() >= 50 && num5.getY() <= 75)) {
                            Lnum5.setLocation(30, 60);
                            ht.Str();
                        } else {
                            Lnum5.setLocation(310, 250);
                        }
                        break;
                    case 2:
                        if ((Lnum5.getX() >= 97 && Lnum5.getX() <= 104) && (Lnum5.getY() >= 50 && Lnum5.getY() <= 75)) {
                            Lnum5.setLocation(100, 60);
                            ht.Str();
                        } else {
                            Lnum5.setLocation(310, 250);
                        }
                        break;
                    case 3:
                        if ((Lnum5.getX() >= 165 && Lnum5.getX() <= 175) && (Lnum5.getY() >= 50 && Lnum5.getY() <= 75)) {
                            Lnum5.setLocation(170, 60);
                            ht.Str();
                        } else {
                            Lnum5.setLocation(310, 250);
                        }
                        break;
                    case 4:
                        if ((Lnum5.getX() >= 236 && Lnum5.getX() <= 246) && (Lnum5.getY() >= 50 && Lnum5.getY() <= 75)) {
                            Lnum4.setLocation(240, 60);
                            ht.Str();
                        } else {
                            Lnum5.setLocation(310, 250);
                        }
                        break;
                    case 5:
                        if ((Lnum5.getX() >= 305 && Lnum5.getX() <= 315) && (Lnum5.getY() >= 50 && Lnum5.getY() <= 75)) {
                            Lnum5.setLocation(310, 60);
                            ht.Str();
                        } else {
                            Lnum5.setLocation(310, 250);
                        }
                        break;
                    default:
                        Lnum5.setLocation(310, 250);
                        break;
                }
            } else {
                Lnum5.setLocation(310, 250);
            }
        }

        fr.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

}
