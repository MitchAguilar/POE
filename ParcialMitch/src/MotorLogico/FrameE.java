/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico;

import MotorInner.Estudiante;
import java.awt.Color;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author estudiante
 */
public class FrameE extends MouseAdapter implements ActionListener {

    JFrame a;
    JPanel b, c, d;
    TextArea f, g;
    JLabel h, i, j;
    JButton retur;

    //comletar
    ArrayList<Estudiante> est;

    public void Compoents() {
        //panel incentivos
        b = new JPanel();
        b.setBounds(10, 10, 290, 300);
        b.setBackground(Color.LIGHT_GRAY);
        b.setLayout(null);

        h = new JLabel("Permanencia:");
        h.setBounds(10, 10, 150, 30);
        h.setOpaque(false);

        f = new TextArea();
        f.setBounds(10, 40, 130, 200);
        f.setEditable(false);

        i = new JLabel("Excelencia:");
        i.setBounds(150, 10, 150, 30);
        i.setOpaque(false);

        g = new TextArea();
        g.setBounds(150, 40, 130, 200);
        g.setEditable(false);

        retur = new JButton("Regresar");
        retur.setBounds(100, 260, 100, 30);
        retur.addActionListener(this);
        retur.setBackground(Color.red);

        b.add(retur);
        b.add(h);
        b.add(f);
        b.add(i);
        b.add(g);
        
        b.addMouseListener(this);

        //Estadisticas
        c = new JPanel();
        c.setBounds(350, 10, 300, 300);
        c.setBackground(Color.LIGHT_GRAY);
        c.setLayout(null);
        
        c.addMouseListener(this);

    }
    Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Complements/img.jpg"));

    public void FrameV() {
        a = new JFrame("INCENTIVOS Y ESTADISTICAS");
        a.setSize(660, 360);
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

    public FrameE() {
        Compoents();
        FrameV();
    }

    public FrameE(ArrayList<Estudiante> est) {
        this.est = est;
        Compoents();
        FrameV();
        datos();
    }

    public void datos() {
        int cou = 0;
        String estu = "";
        for (int k = 0; k < est.size(); k++) {

            double pro = est.get(k).getNotadefinitiva();
            if (pro >= 3 && pro <= 4.3) {
                f.setText(f.getText() + est.get(k).getNombre());
            } else if (pro >= 4.3 && pro <= 5.0) {
                g.setText(g.getText() + est.get(k).getNombre());
                f.setText(f.getText() + est.get(k).getNombre());
            } else {
                cou++;
                estu += "\n" + est.get(k).getNombre();
            }
        }
        JOptionPane.showMessageDialog(null, "Las Estadisticas son:\n " + cou + " estudiantes no cumplen con los requerimentos\n" + estu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(retur)) {
            Frame a = new Frame();
            this.a.dispose();
        }
    }

    public void mouseEntered(java.awt.event.MouseEvent e) {
        if(e.getSource().equals(b)){
            f.setVisible(true);
            g.setVisible(true);
            b.setOpaque(true);
            h.setText("Permanencia");
            i.setText("Exelencia");
            retur.setVisible(true);
            c.setOpaque(false);
        }
        if(e.getSource().equals(c)){f.setVisible(false);
            g.setVisible(false);
            b.setOpaque(false);
            h.setText(null);
            i.setText(null);
            retur.setVisible(false);
            c.setOpaque(true);
        }
        a.repaint();
    }
}
