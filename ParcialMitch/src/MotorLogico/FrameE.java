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
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Mitch
 */
public class FrameE extends MouseAdapter implements ActionListener, ChangeListener {

    JFrame a;
    TextArea f, g, n;
    JLabel h, i, j, m, q, r;
    JButton retur;
    JSlider k;
    Hashtable l;
    JRadioButton A1,A2,A3,A4;
    ButtonGroup g1;
    //comletar
    ArrayList<Estudiante> est;
    panel b,c, d, p;
    public void Compoents() {
        //panel incentivos
        b = new panel(Color.gray);
        b.setBounds(10, 10, 290, 300);
        b.setLayout(null);
        b.setBorder(BorderFactory.createTitledBorder("Incentivos"));

        h = new JLabel("Permanencia:");
        h.setBounds(10, 10, 150, 30);
        h.setOpaque(false);
        h.setForeground(Color.BLACK);

        f = new TextArea();
        f.setBounds(10, 40, 130, 200);
        f.setEditable(false);

        i = new JLabel("Excelencia:");
        i.setBounds(150, 10, 150, 30);
        i.setOpaque(false);
        i.setForeground(Color.BLACK);

        g = new TextArea();
        g.setBounds(150, 40, 130, 200);
        g.setEditable(false);

        retur = new JButton("Regresar");
        retur.setBounds(100, 260, 100, 30);
        retur.addActionListener(this);
        retur.setForeground(Color.BLACK);
        retur.setBackground(new Color(255, 255, 165));

        b.add(retur);
        b.add(h);
        b.add(f);
        b.add(i);
        b.add(g);

        b.addMouseListener(this);

        //Estadisticas nivel 1
        c = new panel(Color.GRAY);
        c.setBounds(350, 10, 300, 300);
        c.setLayout(null);
        c.setBorder(BorderFactory.createTitledBorder("Estadisticas"));

        k = new JSlider(JSlider.HORIZONTAL, 0, 9, 0);
        k.setBounds(10, 30, 290, 90);
        k.setMajorTickSpacing(1);
        k.setPaintTicks(true);
        k.setMajorTickSpacing(1);
        k.setPaintLabels(true);
        k.addChangeListener(this);
        k.setOpaque(false);
        k.setForeground(Color.BLACK);
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
        m.setForeground(Color.BLACK);

        n = new TextArea();
        n.setBounds(50, 100, 200, 100);

        q = new JLabel("Total estudiantes del día: ");
        q.setBounds(10, 220, 300, 30);
        q.setForeground(Color.BLACK);

        r = new JLabel("Total Dinero entregado: ");
        r.setBounds(10, 250, 300, 30);
        r.setForeground(Color.BLACK);

        c.add(q);
        c.add(r);
        c.add(n);
        c.add(m);
        c.add(k);
        c.addMouseListener(this);

        //panel estadistical nivel 2
        p = new panel(Color.GRAY);
        p.setBounds(175, 330, 300, 300);
//        p.setBackground(new Color(224,224,224));
        p.setBorder(BorderFactory.createTitledBorder("Estadisticas Especificas"));
        
        
        A1= new JRadioButton("Ing. Sistemas");
        A1.setBounds(10, 10, 100, 30);
        A1.setOpaque(false);
        A1.setForeground(Color.BLACK);
        
        A2=new JRadioButton("Ing. Agroecologica");
        A2.setBounds(140, 10, 100, 30);
        A2.setOpaque(false);
        A2.setForeground(Color.BLACK);
        
        A3= new JRadioButton("Ing. Alimentos");
        A3.setBounds(10, 40, 100, 30);
        A3.setOpaque(false);
        A3.setForeground(Color.BLACK);
        
        A4= new JRadioButton("MVZ");
        A4.setBounds(10, 40, 100, 30);
        A4.setOpaque(false);
        A4.setForeground(Color.BLACK);
        
        g1= new ButtonGroup();
        g1.add(A1);
        g1.add(A2);
        g1.add(A3);
        g1.add(A4);
        
        p.add(A1);
        p.add(A2);
        p.add(A3);
        p.add(A4);
        p.addMouseListener(this);

    }
    Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Complements/banner.jpg"));

    public void FrameV() {
        a = new JFrame("INCENTIVOS Y ESTADISTICAS");
        a.setSize(660, 665);
        a.setLayout(null);

        a.add(b);
        a.add(c);
        a.add(p);
        Imagen uimg = new Imagen("/Complements/img3.jpg", a.getWidth(), a.getHeight());
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
        
//        c.setOpaque(false);
//        p.setOpaque(false);
//        b.setOpaque(false);
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
//        if (e.getSource().equals(b)) {
//            b.setOpaque(false);
//            c.setOpaque(true);
//            p.setOpaque(true);
//        }
//        if (e.getSource().equals(c)) {
//            b.setOpaque(true);
//            c.setOpaque(false);
//            p.setOpaque(true);
//        }
//        if(e.getSource().equals(p)){
//             b.setOpaque(true);
//            c.setOpaque(true);
//            p.setOpaque(false);
//        }
        a.repaint();
    }

    @Override
    public void stateChanged(ChangeEvent e) {

        //pass
        n.setText(null);
        if (e.getSource().equals(k)) {
            int cou=0;
            long cou2=0;
            for (int pp = 0; pp < est.size(); pp++) {
                if (Integer.parseInt((est.get(pp).getIdentificacion().charAt(est.get(pp).getIdentificacion().length() - 1)) + "") == k.getValue()) {
                    n.setText(n.getText() + est.get(pp).getNombre() + "\n");
                    cou++;
                    if(est.get(pp).getNotadefinitiva()>=3&&est.get(pp).getNotadefinitiva()<=4.3){
                        cou2+=400000;
                    }
                    if(est.get(pp).getNotadefinitiva()>=4.3&&est.get(pp).getNotadefinitiva()<=5){
                        cou2+=600000;
                    }
                }
            }
            q.setText("Total estudiantes del día: "+cou);
            r.setText("Total dinero entregado: "+cou2);
        }
    }
}
