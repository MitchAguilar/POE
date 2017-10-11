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
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.event.AncestorListener;

/**
 *
 * @author Mitch
 */
public class Frame implements ActionListener{
    Meives.frameM a;
    Meives.labelM b;
    Meives.buttonM btn;
    public void Comp(){
        b=new Meives.labelM("0", Color.red, 200, 10, 150, 100);
        btn= new Meives.buttonM("/complements/go.png",200, 200, 100, 100);
        btn.addActionListener(this);
    }
    public void Fram(){
        a= new Meives.frameM(new Dimension(500, 400), "Contador");
        a.add(b);
        a.add(btn);
        a.repaint();
    }
    public Frame() throws InterruptedException{
        Comp();
        Fram();
        Hilos h= new Hilos("hola");
        h.run(b);
    }

    @Override
    public void actionPerformed(ActionEvent e) {//To change body of generated methods, choose Tools | Templates.
        if(e.getSource().equals(btn)){
            System.out.println("dlmñlkdfdnlfkd");
        }
    }
}
