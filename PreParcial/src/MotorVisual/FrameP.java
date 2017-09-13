/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorVisual;

import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;

/**
 *
 * @author estudiante
 */
public class FrameP extends MouseAdapter implements ActionListener {

    JFrame a;
    JPanel b, d, h;
    JLabel Pi;
    TextArea c;
    JLabel f, FM, FM1, FM2, FM3;
    JRadioButton g1, g2, g3, g4;
    ButtonGroup gN;
    JButton Im1, Im2, Im3, Im4,Nval;

    public void Tablas() {
        String pintar = "";
        int ma = (int) (Math.random() * 10) + 10;
        System.out.println(ma);
        for (int i = 1; i <= 10; i++) {
            pintar += i + " * " + ma + " = " + (i * ma) + "\n";
        }
        c.setText(pintar);
    }

    public void Components() {
        //panel unio
        b = new JPanel();
        b.setBounds(10, 10, 200, 200);
        b.setBackground(Color.red);
        b.setLayout(null);
        b.addMouseListener(this);

        c = new TextArea();
        c.setBounds(10, 10, 100, 180);
        Tablas();
        c.setEditable(false);
        b.add(c);
        
        Nval= new JButton("New");
        Nval.setBounds(130, 80, 70, 30);
        Nval.setOpaque(false);
        Nval.addActionListener(this);
        b.add(Nval);

        //panel 2
        d = new JPanel();
        d.setBounds(250, 10, 200, 200);
        d.setLayout(null);
        d.setBackground(Color.lightGray);
        d.addMouseListener(this);

        f = new JLabel("Escoja su color.");
        f.setBounds(10, 5, 150, 20);

        g1 = new JRadioButton("Verde");
        g1.setBounds(10, 50, 80, 20);
        g1.addActionListener(this);

        g2 = new JRadioButton("Rojo");
        g2.setBounds(100, 50, 80, 20);
        g2.addActionListener(this);

        g3 = new JRadioButton("Gris");
        g3.setBounds(10, 90, 80, 20);
        g3.addActionListener(this);

        g4 = new JRadioButton("Cyan");
        g4.setBounds(100, 90, 80, 20);
        g4.addActionListener(this);

        gN = new ButtonGroup();
        gN.add(g1);
        gN.add(g2);
        gN.add(g3);
        gN.add(g4);

        FM = new JLabel("Hola Mundo");
        FM.setOpaque(false);
        FM.setForeground(Color.BLACK);
        FM.setBounds(70, 150, 70, 20);

        d.add(FM);

        d.add(f);
        d.add(g1);
        d.add(g2);
        d.add(g3);
        d.add(g4);
        d.repaint();

        //panel 3
        h = new JPanel();
        h.setBounds(100, 250, 300, 300);
        h.setBackground(Color.darkGray);
        h.setLayout(null);
        h.addMouseListener(this);

        Im1 = new JButton("leer");
        Im1.setBounds(10, 10, 50, 50);
        Im1.addActionListener(this);
        URL url2 = this.getClass().getResource("/Complement/Img4.jpg");
        Im1.setIcon(new ImageIcon(url2));

        Im2 = new JButton("ver tv");
        Im2.setBounds(90, 10, 50, 50);
        Im2.addActionListener(this);
        URL url3 = this.getClass().getResource("/Complement/Img3.jpg");
        Im2.setIcon(new ImageIcon(url3));

        Im3 = new JButton("Deportes");
        Im3.setBounds(170, 10, 50, 50);
        Im3.addActionListener(this);
        URL url4 = this.getClass().getResource("/Complement/Img2.png");
        Im3.setIcon(new ImageIcon(url4));

        Im4 = new JButton("bailar");
        Im4.setBounds(240, 10, 50, 50);
        Im4.addActionListener(this);
        URL url5 = this.getClass().getResource("/Complement/Img1.jpg");
        Im4.setIcon(new ImageIcon(url5));

        h.add(Im1);
        h.add(Im2);
        h.add(Im3);
        h.add(Im4);

        Pi = new JLabel();
        Pi.setBounds(50, 80, 70, 70);

        FM1 = new JLabel();
        FM1.setBounds(150, 80, 70, 70);

        FM2 = new JLabel();
        FM2.setBounds(50, 170, 70, 70);

        FM3 = new JLabel();
        FM3.setBounds(150, 170, 70, 70);

        h.add(Pi);
        h.add(FM1);
        h.add(FM2);
        h.add(FM3);

    }

    public void Frame() {
        a = new JFrame("Ventana Principal");
        a.setSize(480, 600);
        a.setLayout(null);
        a.setBackground(Color.GRAY);

        a.add(b);
        a.add(d);
        a.add(h);
        Imagen FON = new Imagen("/Complement/FONDO.jpg", 480, 600);
        a.add(FON);

//        a.pack();
        a.repaint();
        b.setEnabled(false);
        d.setEnabled(false);
        h.setEnabled(false);

        a.setVisible(true);
        a.setResizable(false);
        a.setLocationRelativeTo(null);
        a.setDefaultCloseOperation(a.EXIT_ON_CLOSE);
    }

    public FrameP() {
        Components();
        Frame();
    }
    boolean A1 = false;
    boolean A2 = false;
    boolean A3 = false;
    boolean A4 = false;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(g1)) {
            FM.setForeground(Color.GREEN);
        } else if (e.getSource().equals(g2)) {
            FM.setForeground(Color.RED);
        } else if (e.getSource().equals(g3)) {
            FM.setForeground(Color.GRAY);
        } else if (e.getSource().equals(g4)) {
            FM.setForeground(Color.CYAN);
        }
        FM.repaint();
        if(e.getSource().equals(Nval)){
            Tablas();
        }
        if (e.getSource().equals(Im1)) {

            if (A1) {
                Pi.setIcon(null);
                A1 = false;
            } else {
                URL url = this.getClass().getResource("/Complement/book.jpg");
                Pi.setIcon(new ImageIcon(url));
                A1 = true;
            }
        } else if (e.getSource().equals(Im2)) {

            if (A2) {
                FM1.setIcon(null);
                A2 = false;
            } else {
                A2 = true;
                URL url = this.getClass().getResource("/Complement/Img3.jpg");
                FM1.setIcon(new ImageIcon(url));
            }
        } else if (e.getSource().equals(Im3)) {

            if (A3) {
                FM2.setIcon(null);
                A3 = false;
            } else {
                A3 = true;
                URL url = this.getClass().getResource("/Complement/deporte.gif");
                FM2.setIcon(new ImageIcon(url));
            }
        } else if (e.getSource().equals(Im4)) {

            if (A4) {
                FM3.setIcon(null);
                A4 = false;
            } else {
                A4 = true;
                URL url = this.getClass().getResource("/Complement/bailar.jpg");
                FM3.setIcon(new ImageIcon(url));
            }
        }
        a.repaint();
    }

    public void mouseEntered(java.awt.event.MouseEvent evento) {
        if (evento.getSource() == b) {
            b.setOpaque(true);
            d.setOpaque(false);
            h.setOpaque(false);
            System.out.println("a");
            a.repaint();
        } else if (evento.getSource() == d) {
            d.setOpaque(true);
            b.setOpaque(false);
            h.setOpaque(false);
            System.out.println("b");
            a.repaint();
        } else if (evento.getSource() == h) {
            h.setOpaque(true);
            b.setOpaque(false);
            d.setOpaque(false);
            System.out.println("c");
            a.repaint();
        }
    }
}
