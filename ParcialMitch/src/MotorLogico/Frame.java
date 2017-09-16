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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame implements ActionListener, ItemListener {

    JFrame a;
    JPanel b, c, d;
    JButton f, g, h;
    JLabel N1, N2, N3;
    JLabel N4, N5, N6, N7;
    JTextField M1, M2, M4;
    JTextField M5, M6, M7, M8;
    JComboBox M3;
    //arreglo de estudiantes
    Estudiante est[];

    private void Num(KeyEvent e) {
        char c = e.getKeyChar();
        if (((c < '0') || (c > '9')||(c=='.')) && (c != KeyEvent.VK_BACK_SPACE)) {
            e.consume();
        }
        
//        if ((((c < '0') || (c > '9')) || c != '\b')) {
//            JOptionPane.showMessageDialog(null, "Lo sentimos, ésto es un campo de numeros, por lo tanto no puede ingresar ningun otro caracter diferente de los numeros enteros ");
//        }
    }
    private void Num2(KeyEvent e) {
        char c = e.getKeyChar();
//        if (((c < '0') || (c > '5')||(c != '.')) && (c != KeyEvent.VK_BACK_SPACE)) {
//            e.consume();
//        }
//       
    }

    public void Compoents() {
        //panel 1
        b = new JPanel();
        b.setBounds(10, 10, 200, 300);
        b.setBackground(Color.lightGray);
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
        c = new JPanel();
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
                Num2(e);
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
                Num2(e);
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
                Num2(e);
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
        Imagen uimg = new Imagen("/Complements/banner.jpg", a.getWidth(), a.getHeight());
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
    int cou = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(f)) {
            est[0]= new Estudiante();
            if (!(M1.getText().isEmpty() || M2.getText().isEmpty())) {
                est[cou][0] = M1.getText();
                est[cou][1] = M2.getText();
                c.setVisible(true);
                System.err.println("ingresó el primero");
            }else{
                M1.setText(null);
                M2.setText(null);
                System.out.println("Error");
            }
            c.setVisible(true);
        }
        if(e.getSource().equals(h)){
            if(M4.getText().isEmpty()||M5.getText().isEmpty()||M6.getText().isEmpty()||M8.getText().isEmpty()){
                M4.setText(null);
                M5.setText(null);
                M6.setText(null);
                M8.setText(null);
            }else{
                double pro=0;
                pro+=Double.parseDouble(M4.getText());
                pro+=Double.parseDouble(M5.getText());
                pro+=Double.parseDouble(M6.getText());
                pro+=Double.parseDouble(M8.getText());
                pro/=4;
                est[cou][3]=pro+"";
                cou++;
                c.setVisible(false);
                M4.setText(null);
                M5.setText(null);
                M6.setText(null);
                M8.setText(null);
                M1.setText(null);
                M2.setText(null);
            }
        }
        if(e.getSource().equals(g)){
            FrameE a = new FrameE(est);
            this.a.dispose();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource().equals(M3)) {
            if(!M3.getSelectedItem().equals("Selecione")){
                est[cou][2]=M3.getSelectedItem()+"";
            }else{
                M3.setSelectedIndex(0);
                System.out.println("Error");
            }
        }
    }
}
