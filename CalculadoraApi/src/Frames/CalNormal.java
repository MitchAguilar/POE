package Frames;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CalNormal implements ActionListener{

    Frame a;
    Panel b, c;
    Label d, f, g;
    Button h;
    Choice i;
    TextField j,k;

    public void Componets() {
        b= new  Panel();
        b.setBounds(40,50,245,300);
        b.setLayout(null);
        b.setBackground(Color.white);
        
        c= new Panel();
        c.setBounds(325,50,245,300);
        c.setLayout(null);
        c.setBackground(Color.lightGray);
        
        d= new Label("DÍGITO 1:");
        d.setBackground(Color.white);
        d.setBounds(10,50,100,30);
        b.add(d);
        
        f= new Label("DÍGITO 2:");
        f.setBackground(Color.white);
        f.setBounds(10,100,100,30);
        b.add(f);
        
        g= new Label("Escoja La Operación A Realizar");
        g.setBackground(Color.lightGray);
        g.setBounds(10,50,200,30);
        c.add(g);
        
        h= new Button("CALCULAR");
        h.setBounds(120,100,100,30);
        h.addActionListener(this);
        c.add(h);
        
        
        i= new Choice();
        i.add("Sumar");
        i.add("Restar");
        i.add("Multiplicar");
        i.add("Dividir");
        i.setBounds(10, 100, 100, 30);
        c.add(i);
        
        j= new TextField();
        j.setBounds(100,50,125,30);
        b.add(j);
        
        k= new TextField();
        k.setBounds(100,100,125,30);
        b.add(k);
    }

    public void FrameCom() {
        a= new Frame("CALCULADORA");
        a.setSize(600,500);
        a.setBackground(Color.CYAN);
        a.setLayout(null);
        
        a.add(b);
        a.add(c);
        
        a.setVisible(true);
        a.setResizable(false);
        a.setLocationRelativeTo(null);
        a.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        }
        );
    }

    public CalNormal() {
        Componets();
        FrameCom();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(h)){
            System.out.println(i.getSelectedItem());
        }
    }
}
