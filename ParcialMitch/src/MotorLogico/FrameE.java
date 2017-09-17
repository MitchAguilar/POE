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
import java.util.Hashtable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Mitch
 */
public class FrameE extends MouseAdapter implements ActionListener, ChangeListener {

    JFrame a;
    JPanel b, c, d,p;
    TextArea f, g, n;
    JLabel h, i, j, m;
    JButton retur;
    JSlider k;
    Hashtable l;
    //comletar
    ArrayList<Estudiante> est;

    public void Compoents() {
        //panel incentivos
        b = new JPanel();
        b.setBounds(10, 10, 290, 300);
        b.setBackground(new Color(127, 105, 110));
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
        retur.setBackground(new Color(255, 255, 165));

        b.add(retur);
        b.add(h);
        b.add(f);
        b.add(i);
        b.add(g);

        b.addMouseListener(this);

        //Estadisticas nivel 1
        c = new JPanel();
        c.setBounds(350, 10, 300, 300);
        c.setBackground(new Color(127, 105, 110));
        c.setLayout(null);

        k = new JSlider(JSlider.HORIZONTAL, 0, 9, 0);
        k.setBounds(10, 30, 290, 90);
        k.setMajorTickSpacing(1);
        k.setPaintTicks(true);
        k.setMajorTickSpacing(1);
        k.setMinorTickSpacing(1);
        k.setPaintTicks(true);
        k.setPaintLabels(true);
        k.addChangeListener(this);
        k.setOpaque(false);
//Create the label table
        l = new Hashtable();
        l.put(new Integer(0), new JLabel("1"));
        l.put(new Integer(1), new JLabel("2"));
        l.put(new Integer(2), new JLabel("3"));
        l.put(new Integer(3), new JLabel("4"));
        l.put(new Integer(4), new JLabel("5"));
        l.put(new Integer(5), new JLabel("6"));
        l.put(new Integer(6), new JLabel("7"));
        l.put(new Integer(7), new JLabel("8"));
        l.put(new Integer(8), new JLabel("9"));
        l.put(new Integer(9), new JLabel("10"));

        k.setLabelTable(l);

        m = new JLabel("Seleccione el día de atención");
        m.setBounds(30, 10, 280, 30);
        m.setOpaque(false);

        n = new TextArea();
        n.setBounds(50, 100, 200, 100);

        c.add(n);
        c.add(m);
        c.add(k);
        c.addMouseListener(this);
        
        //panel estadistical nivel 2
        
        p= new JPanel();
        p.setBounds(175, 330, 300, 300);
        p.setBackground(Color.red);
        
        
        

    }
    Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Complements/banner.jpg"));

    public void FrameV() {
        a = new JFrame("INCENTIVOS Y ESTADISTICAS");
        a.setSize(660, 665);
        a.setLayout(null);

        a.add(b);
        a.add(c);
        a.add(p);
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
        if (e.getSource().equals(b)) {
            f.setVisible(true);
            g.setVisible(true);
            b.setOpaque(true);
            h.setText("Permanencia");
            i.setText("Exelencia");
            retur.setVisible(true);
            c.setOpaque(false);
        }
        if (e.getSource().equals(c)) {
            f.setVisible(false);
            g.setVisible(false);
            b.setOpaque(false);
            h.setText("Permanencia");
            h.setText(null);
            i.setText(null);
            retur.setVisible(false);
            c.setOpaque(true);
        }
        a.repaint();
    }

    @Override
    public void stateChanged(ChangeEvent e) {

        //pass
        n.setText(null);
        if (e.getSource().equals(k)) {
            for (int p = 0; p < est.size(); p++) {
                if (Integer.parseInt((est.get(p).getIdentificacion().charAt(est.get(p).getIdentificacion().length() - 1)) + "") == k.getValue()) {
                    n.setText(n.getText() + est.get(p).getNombre() + "\n");
                }
            }
        }
    }
}
