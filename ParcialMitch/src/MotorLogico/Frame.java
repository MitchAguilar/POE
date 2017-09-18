/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico;

import MotorInner.Estudiante;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame implements ActionListener, ItemListener {

    JFrame a;
    panel b, c, d;
    JButton f, g, h;
    JLabel N1, N2, N3;
    JLabel N4, N5, N6, N7;
    JTextField M1, M2, M4;
    JTextField M5, M6, M7, M8;
    JComboBox M3;
    //Array de estudiantes
    int cou = 0;
    ArrayList<Estudiante> est = new ArrayList<>();

    private void Num(KeyEvent e) {
        char c = e.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            e.consume();
        }
        if ((((c < '0') || (c > '9')) && c != '\b')) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, ésto es un campo de numeros, por lo tanto no puede ingresar ningun otro caracter diferente de los numeros enteros ");
        }
    }

    private void Num2(KeyEvent e) {
        char c = e.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != '.') && (c != '\b') && (c != KeyEvent.VK_BACK_SPACE)) {
            e.consume();
        }
        if ((((c < '0') || (c > '9')) && (c != '\b') && (c != '.'))) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, ésto es un campo de numeros, por lo tanto no puede ingresar ningun otro caracter diferente de los numeros enteros ");
        }
        if (M4.getText().contains(".")) {
            if (((c < '0') || (c > '9')) && (c != '\b') && (c != KeyEvent.VK_BACK_SPACE)) {
                e.consume();
            }
        }
    }

    private void Num3(KeyEvent e) {
        char c = e.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != '.') && (c != '\b') && (c != KeyEvent.VK_BACK_SPACE)) {
            e.consume();
        }
        if ((((c < '0') || (c > '9')) && (c != '\b') && (c != '.'))) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, ésto es un campo de numeros, por lo tanto no puede ingresar ningun otro caracter diferente de los numeros enteros ");
        }
        if (M5.getText().contains(".")) {
            if (((c < '0') || (c > '9')) && (c != '\b') && (c != KeyEvent.VK_BACK_SPACE)) {
                e.consume();
            }
        }
    }

    private void Num4(KeyEvent e) {
        char c = e.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != '\b') && (c != '.') && (c != KeyEvent.VK_BACK_SPACE)) {
            e.consume();
        }
        if ((((c < '0') || (c > '9')) && (c != '\b') && (c != '.'))) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, ésto es un campo de numeros, por lo tanto no puede ingresar ningun otro caracter diferente de los numeros enteros ");
        }
        if (M6.getText().contains(".")) {
            if (((c < '0') || (c > '9')) && (c != '\b') && (c != KeyEvent.VK_BACK_SPACE)) {
                e.consume();
            }
        }
    }

    private void Num5(KeyEvent e) {
        char c = e.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != '\b') && (c != '.') && (c != KeyEvent.VK_BACK_SPACE)) {
            e.consume();
        }
        if ((((c < '0') || (c > '9')) && (c != '\b') && (c != '.'))) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, ésto es un campo de numeros, por lo tanto no puede ingresar ningun otro caracter diferente de los numeros enteros ");
        }
        if (M8.getText().contains(".")) {
            if (((c < '0') || (c > '9')) && (c != '\b') && (c != KeyEvent.VK_BACK_SPACE)) {
                e.consume();
            }
        }
    }

    public void Compoents() {
        //panel 1
        b = new panel(Color.WHITE);
        b.setBounds(10, 10, 200, 300);
        b.setLayout(null);

        N1 = new JLabel("Identificación Estudiante:");
        N1.setBounds(10, 10, 200, 30);
        N1.setOpaque(false);

        M1 = new JTextField();
        M1.setBounds(40, 40, 150, 30);
        M1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                Num(e);
            }
        });

        N2 = new JLabel("Nombre Estudiante:");
        N2.setBounds(10, 70, 200, 30);
        N2.setOpaque(false);

        M2 = new JTextField();
        M2.setBounds(40, 100, 150, 30);

        N3 = new JLabel("Programa Academico");
        N3.setBounds(10, 130, 200, 30);
        N3.setOpaque(false);

        M3 = new JComboBox();
        M3.setBounds(40, 160, 150, 30);
        M3.addItem("Seleccione");
        M3.addItem("Ing. Sistemas");
        M3.addItem("Ing. Alimientos");
        M3.addItem("Ing. Agroecologica");
        M3.addItem("MVZ");
        M3.addItemListener(this);

        f = new JButton("Ingresar Nuevo");
        f.setBounds(30, 220, 120, 30);
        f.addActionListener(this);

        g = new JButton("Terminar");
        g.setBounds(30, 265, 120, 30);
        g.setBackground(Color.red);
        g.addActionListener(this);

        b.add(N1);
        b.add(N2);
        b.add(N3);
        b.add(M1);
        b.add(M2);
        b.add(M3);
        b.add(f);
        b.add(g);

        //panel 2
        c = new panel(Color.white);
        c.setBounds(300, 10, 200, 300);
        c.setBackground(Color.lightGray);
        c.setLayout(null);
        c.setVisible(false);

        N4 = new JLabel("Nota 1:");
        N4.setBounds(10, 10, 200, 30);
        N4.setOpaque(false);

        M4 = new JTextField();
        M4.setBounds(40, 40, 150, 30);
        M4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                Num2(e);
            }
        });

        N5 = new JLabel("Nota 2:");
        N5.setBounds(10, 70, 200, 30);
        N5.setOpaque(false);

        M5 = new JTextField();
        M5.setBounds(40, 100, 150, 30);
        M5.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                Num3(e);
            }
        });

        N6 = new JLabel("Nota 3:");
        N6.setBounds(10, 130, 200, 30);
        N6.setOpaque(false);

        M6 = new JTextField();
        M6.setBounds(40, 160, 150, 30);
        M6.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                Num4(e);
            }
        });

        N7 = new JLabel("Nota 4:");
        N7.setBounds(30, 190, 150, 30);
        N7.setOpaque(false);

        M8 = new JTextField();
        M8.setBounds(40, 220, 150, 30);
        M8.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                Num5(e);
            }
        });

        h = new JButton("Igresar");
        h.setBounds(50, 265, 120, 30);
        h.addActionListener(this);

        c.add(N4);
        c.add(N5);
        c.add(N6);
        c.add(N7);
        c.add(M4);
        c.add(M5);
        c.add(M6);
        c.add(M8);
        c.add(h);
    }
    Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Complements/img.jpg"));

    public void FrameV() {
        a = new JFrame("INGRESO DATOS");
        a.setSize(515, 350);
        a.setLayout(null);

        a.add(b);
        a.add(c);
        Imagen uimg = new Imagen("/Complements/img3.jpg", a.getWidth(), a.getHeight());
        a.add(uimg);
        a.setIconImage(icon);
        a.repaint();

        a.setLocationRelativeTo(null);
        a.setResizable(false);
        a.setVisible(true);
        a.setDefaultCloseOperation(3);
    }

    public Frame() {
        Compoents();
        FrameV();
    }
    String[][] tempData = new String[1][4];

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(f)) {
            if (!(M1.getText().isEmpty() || M2.getText().isEmpty())) {
                if (tempData[0][2] == null) {
                    JOptionPane.showMessageDialog(null, "Error- no ha elegido programa academico.");
                } else {
                    tempData[cou][0] = M1.getText();
                    tempData[cou][1] = M2.getText();
                    c.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Uno de los campos no fué llenado");
            }
        }
        if (e.getSource().equals(h)) {

            if (M4.getText().isEmpty() || M5.getText().isEmpty() || M6.getText().isEmpty() || M8.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Uno de los campos no fué llenado");
            } else {
                if (!(Double.parseDouble(M4.getText()) >= 0 && Double.parseDouble(M4.getText()) <= 5)) {
                    JOptionPane.showMessageDialog(null, "Nota 1: Fuera del rango de números permitidos (0-5)");
                } else if (!(Double.parseDouble(M5.getText()) >= 0 && Double.parseDouble(M5.getText()) <= 5)) {
                    JOptionPane.showMessageDialog(null, "Nota 2: Fuera del rango de números permitidos(0-5)");
                } else if (!(Double.parseDouble(M6.getText()) >= 0 && Double.parseDouble(M6.getText()) <= 5)) {
                    JOptionPane.showMessageDialog(null, "Nota 3: Fuera del rango de números permitidos(0-5)");
                } else if (!(Double.parseDouble(M8.getText()) >= 0 && Double.parseDouble(M8.getText()) <= 5)) {
                    JOptionPane.showMessageDialog(null, "Nota 4: Fuera del rango de números permitidos(0-5)");
                } else {
                    double pro = 0;
                    pro += Double.parseDouble(M4.getText());
                    pro += Double.parseDouble(M5.getText());
                    pro += Double.parseDouble(M6.getText());
                    pro += Double.parseDouble(M8.getText());
                    pro /= 4;
                    tempData[0][3] = pro + "";
                    c.setVisible(false);
                    M4.setText(null);
                    M5.setText(null);
                    M6.setText(null);
                    M8.setText(null);
                    M1.setText(null);
                    M2.setText(null);
                    Estudiante ae = new Estudiante(tempData[0][1], tempData[0][0], tempData[0][2], Double.parseDouble(tempData[0][3]));
                    est.add(ae);
                    JOptionPane.showMessageDialog(null, "Estudiante ingresado de forma satisfactoria");
                }
            }

        }
        if (e.getSource().equals(g)) {
            if (est.isEmpty()) {
                System.exit(0);
            } else {
                FrameE aeee = new FrameE(est);
                this.a.dispose();
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource().equals(M3)) {
            if (!M3.getSelectedItem().equals("Seleccione")) {
                tempData[cou][2] = M3.getSelectedItem() + "";
            } else {
                M3.setSelectedIndex(0);
                JOptionPane.showMessageDialog(null, "Uno de los campos no fué llenado o seleeccionado");
            }
        }
    }
}
