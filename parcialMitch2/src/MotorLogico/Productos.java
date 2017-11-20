/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author estudiante
 */
public class Productos implements ActionListener {
    
    Meives.frameM a;
    Meives.PanelM b, h, i;
    Meives.labelM c, e, f, j, k, l, m, n, o, p, n2, n3, o2, o3, p2, p3;
    Meives.textfieldM d, g, pre, cant, pre2, pre3, cant2, cant3;
    JButton btn, btn2, btn3, clear, close;
    JPanel img;
    JRadioButton ltr, grm, und, grm2, grm3, ltr2, ltr3, und2, und3;
    ButtonGroup g1, g2, g3;
    Meives.textareaM text;
    
    public void Add() {
        //panel 1
        b.add(c);
        b.add(g);
        b.add(d);
        b.add(e);
        b.add(btn);
        btn.addActionListener(this);
        b.add(btn2);
        btn2.addActionListener(this);
        b.add(m);
        b.add(img);
        //panel 2
        h.add(n);
        h.add(j);
        h.add(pre);
        h.add(o);
        h.add(grm);
        h.add(ltr);
        h.add(und);
        h.add(p);
        h.add(cant);
        h.add(n2);
        h.add(l);
        h.add(pre2);
        h.add(o2);
        h.add(grm2);
        h.add(ltr2);
        h.add(und2);
        h.add(p2);
        h.add(cant2);
        h.add(n3);
        h.add(k);
        h.add(pre3);
        h.add(o3);
        h.add(grm3);
        h.add(ltr3);
        h.add(und3);
        h.add(p3);
        h.add(btn3);
        h.add(cant3);
        btn3.addActionListener(this);

//        g1.add(ltr);
//        g1.add(grm);
//        g1.add(und);
//        g2.add(ltr2);
//        g2.add(grm2);
//        g2.add(und2);
//        g3.add(ltr3);
//        g3.add(grm3);
//        g3.add(und3);
        //panel 3
        i.add(text);
        i.add(clear);
        i.add(close);
    }
    
    public void Com() {
        //panel 1
        b = new Meives.PanelM(Color.WHITE, 0.5f, 30, 30, 250, 250);
        c = new Meives.labelM("Digite Nombre Del Producto :", new Color(102, 15, 130), 10, 10, 300, 30);
        d = new Meives.textfieldM("", Color.black, 40, 40, 200, 20);
        g = new Meives.textfieldM(Color.black, 40, 90, 200, 20);
        e = new Meives.labelM("Código del producto:", new Color(102, 15, 130), 10, 60, 200, 30);
        m = new Meives.labelM("Imagen:", new Color(102, 15, 130), 10, 150, 200, 30);
        btn2 = new JButton("Url");
        btn2.setBounds(50, 157, 80, 20);
        img = new JPanel();
        img.setBounds(140, 120, 80, 80);
        img.setBackground(Color.GRAY);
        btn = new JButton("Ingresar Producto");
        btn.setBounds(50, 210, 150, 30);
        //panel 2

        h = new Meives.PanelM(Color.white, 0.5f, 310, 30, 250, 250);
        h.setVisible(false);
        j = new Meives.labelM("Establecimiento 1", new Color(102, 15, 130), 10, 10, 150, 20);
        n = new Meives.labelM("Precio:", new Color(102, 15, 130), 10, 30, 150, 20);
        pre = new Meives.textfieldM(0f, Color.black, 50, 30, 70, 20);
        o = new Meives.labelM("Cantidad:", new Color(102, 15, 130), 125, 30, 70, 20);
        cant = new Meives.textfieldM(0, Color.BLACK, 180, 30, 30, 20);
        p = new Meives.labelM("U Medida:", new Color(102, 15, 130), 10, 55, 70, 20);
        grm = new JRadioButton("Gramos");
        grm.setBounds(55, 55, 70, 20);
        grm.setOpaque(false);
        ltr = new JRadioButton("Litros");
        ltr.setBounds(130, 55, 60, 20);
        ltr.setOpaque(false);
        und = new JRadioButton("Uni");
        und.setBounds(190, 55, 50, 20);
        und.setOpaque(false);
        
        k = new Meives.labelM("Establecimiento 2:", new Color(102, 15, 130), 10, 80, 150, 20);
        n2 = new Meives.labelM("Precio:", new Color(102, 15, 130), 10, 100, 150, 20);
        pre2 = new Meives.textfieldM(0f, Color.black, 50, 100, 70, 20);
        o2 = new Meives.labelM("Cantidad:", new Color(102, 15, 130), 125, 100, 70, 20);
        cant2 = new Meives.textfieldM(0, Color.BLACK, 180, 100, 30, 20);
        p2 = new Meives.labelM("U Medida:", new Color(102, 15, 130), 10, 125, 70, 20);
        grm2 = new JRadioButton("Gramos");
        grm2.setBounds(55, 125, 70, 20);
        grm2.setOpaque(false);
        ltr2 = new JRadioButton("Litros");
        ltr2.setBounds(130, 125, 60, 20);
        ltr2.setOpaque(false);
        und2 = new JRadioButton("Uni");
        und2.setBounds(190, 125, 50, 20);
        und2.setOpaque(false);
        
        l = new Meives.labelM("Establecimiento 3:", new Color(102, 15, 130), 10, 150, 150, 20);
        n3 = new Meives.labelM("Precio:", new Color(102, 15, 130), 10, 170, 150, 20);
        pre3 = new Meives.textfieldM(0f, Color.black, 50, 170, 70, 20);
        o3 = new Meives.labelM("Cantidad:", new Color(102, 15, 130), 125, 170, 70, 20);
        cant3 = new Meives.textfieldM(0, Color.BLACK, 180, 170, 30, 20);
        p3 = new Meives.labelM("U Medida:", new Color(102, 15, 130), 10, 195, 70, 20);
        grm3 = new JRadioButton("Gramos");
        grm3.setBounds(55, 195, 70, 20);
        grm3.setOpaque(false);
        ltr3 = new JRadioButton("Litros");
        ltr3.setBounds(130, 195, 60, 20);
        ltr3.setOpaque(false);
        und3 = new JRadioButton("Uni");
        und3.setBounds(190, 195, 50, 20);
        und3.setOpaque(false);
        btn3 = new JButton("Terminar");
        btn3.setBounds(80, 220, 100, 20);

        //panel 3
        i = new Meives.PanelM(Color.white, 0.5f, 170, 300, 250, 250);
        i.setEnabled(false);
        text = new Meives.textareaM("", Color.red, 10, 10, 230, 100);
        clear = new JButton("Limpiar");
        clear.setBounds(10, 200, 100, 30);
        close = new JButton("Salir");
        close.setBounds(130, 200, 100, 30);
        close.addActionListener(this);
        
        Add();
    }
    
    public void Frm() {
        a = new Meives.frameM(new Dimension(600, 600), "Productos");
        a.add(b);
        a.add(h);
        a.add(i);
        a.InsertImg("/Complements/img2.jpg");
        a.InsertImgIcon("/Complements/bg.jpg");
        a.repaint();
    }
    
    public Productos() {
        Com();
        Frm();
    }
    String nombre, codigo;
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(btn)) {
            
            if (e.getText().isEmpty() || g.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Uno de sus campos en nulo");
            } else {
                if ((d.getText().length() < 3 || d.getText().length() > 20)) {
                    JOptionPane.showMessageDialog(null, "Nombre no cumle con la longitud requerida");
                } else {
                    nombre = d.getText();
                    codigo = g.getText();
                    h.setVisible(true);
                }
            }
            
        }
//        if (ae.getSource().equals(btn2)) {
//            System.out.println("2");
//        }
        if (ae.getSource().equals(btn3)) {
            if (pre.getText().isEmpty() || cant.getText().isEmpty() || pre2.getText().isEmpty() || cant2.getText().isEmpty() || pre3.getText().isEmpty() || cant3.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Uno de sus campos está nulo");
            }
        }
        if (ae.getSource().equals(close)) {
            System.exit(0);
        }
    }
}
