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

/**
 *
 * @author Mitch
 */
public class Frame implements ActionListener {

    Meives.frameM a;
    Meives.PanelM b, c, d;
    Meives.labelM e, f, g;
    Meives.buttonM btn;
    Hilos h;

    public void Pan1() throws InterruptedException {
        b.add(e);
        btn = new Meives.buttonM("/complements/go.png", 20, 250, 100, 100);
        btn.addActionListener(this);

    }

    public void Comp() throws InterruptedException {
        b = new Meives.PanelM(Color.WHITE, 0.1f, 10, 10, 350, 350);
        c = new Meives.PanelM(Color.WHITE, 0.1f, 380, 10, 350, 350);
        d = new Meives.PanelM(Color.WHITE, 0.1f, 750, 10, 350, 350);
        e = new Meives.labelM("0", Color.red, 100, 0, 250, 250);
        h = new Hilos("Tempo", e);
        Pan1();
    }

    public void Fram() {
        a = new Meives.frameM(new Dimension(1120, 400), "Hilos");
        a.add(e);
        a.add(btn);
        a.add(b);
        a.add(c);
        a.add(d);
        a.InsertImg("/Complements/bg.jpg");
        a.InsertImgIcon("/Complements/go.png");
        a.repaint();
    }

    public Frame() throws InterruptedException {
        Comp();
        Fram();
    }
    int coun = 0;

    @Override
    public void actionPerformed(ActionEvent eo) {//To change body of generated methods, choose Tools | Templates.
        if (eo.getSource().equals(btn)) {
            if (coun == 0) {
                h.start();
                System.out.println("bitch 1");
                coun++;
            } else if (coun == 1) {
                h.suspend();
                System.out.println("bitch 2");
                coun++;
            } else if (coun == 2) {
                h.resume();
                System.out.println("bitch 3");
                coun++;
            } else if (coun == 3) {
                h.stop();
                h = new Hilos("Tempo", e);
                System.out.println("bitch 4");
                coun = 0;
            }
        }
    }
}
