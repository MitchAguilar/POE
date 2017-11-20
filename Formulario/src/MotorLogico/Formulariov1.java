package MotorLogico;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Formulariov1 {

    private JFrame a;
    private JPanel b, Pn;
    private JScrollPane c;
    private JComboBox p, q, r, s, a6;
    private JCheckBox t, u, v, w, x, y, z, a1, a2, a3, a4, a5;
    private Meives.labelM d, f;
    private Meives.textfieldM g, h, i, j, k, l, m, n, o;

    private void Components() {
        d = new Meives.labelM("Formulario de inscripción.", new Color(102, 15, 130));
        d.setBounds(30, 5, 500, 50);

        f = new Meives.labelM("<html><body><h5>Para continuar tu inscripción  completa el siguiente formulario,<br/> Recibirás un email con la entrada al evento.<h5></body></html>", Color.GRAY);
        f.tam = 5;
        f.setBounds(30, 40, 400, 50);

        b = new JPanel();
        b.setPreferredSize(new Dimension(500, 1000));
        b.setBounds(29, 50, 200, 1000);

        g = new Meives.textfieldM("", Color.BLUE);
        g.setBounds(200, 100, 200, 30);

        h = new Meives.textfieldM("",Color.BLUE);
        h.setBounds(200, 140, 200, 30);

        i = new Meives.textfieldM("",Color.BLUE);
        i.setBounds(200, 180, 200, 30);

        j = new Meives.textfieldM("",Color.BLUE);
        j.setBounds(200, 220, 200, 30);

        p = new JComboBox();
        p.addItem("Seleccionar...");
        p.addItem("C.C");
        p.addItem("C.E");
        p.addItem("T.I");
        p.addItem("Pasaporte");
        p.addItem("N/A");
        p.setBounds(200, 260, 200, 30);

        k = new Meives.textfieldM("",Color.BLUE);
        k.setBounds(200, 300, 200, 30);

        l = new Meives.textfieldM("",Color.BLUE);
        l.setBounds(200, 340, 200, 30);

        m = new Meives.textfieldM("",Color.BLUE);
        m.setBounds(200, 380, 200, 30);

        q = new JComboBox();
        q.addItem("Seleccionar...");
        q.addItem("CC");
        q.setBounds(200, 420, 200, 30);

        r = new JComboBox();
        r.addItem("Seleccionar...");
        r.addItem("C.C");
        r.setBounds(200, 460, 200, 30);

        s = new JComboBox();
        s.addItem("Seleccionar...");
        s.addItem("N/A");
        s.setBounds(200, 500, 200, 30);

        n = new Meives.textfieldM("",Color.BLUE);
        n.setBounds(200, 540, 200, 30);

        Pn = new JPanel();
        Pn.setBounds(200, 580, 200, 360);
        Pn.setBackground(Color.DARK_GRAY);

        a6 = new JComboBox();
        a6.setBounds(200, 950, 200, 30);
        a6.addItem("CC");

        o = new Meives.textfieldM("",Color.BLUE);
//        o.setBounds(200, 580, 200, 30);

        c = new JScrollPane(b, 22, 31);
        b.setLayout(null);
        b.add(d);
        b.add(g);
        b.add(h);
        b.add(i);
        b.add(j);
        b.add(k);
        b.add(l);
        b.add(m);
        b.add(n);
        b.add(o);
        b.add(p);
        b.add(q);
        b.add(r);
        b.add(s);
        b.add(Pn);
        b.add(a6);
        b.add(f);
    }

    private void Frame() {
        a = new JFrame("Colombia 4.0");
        a.setSize(500, 500);
//        a.setLayout(null);

        a.getContentPane().add(c);

        a.setResizable(false);
        a.setLocationRelativeTo(null);
        a.setVisible(true);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Formulariov1() {
        Components();
        Frame();
    }
}
