/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import MotorLogico.Meives;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;

/**
 *
 * @author Usuario
 */
public class Ventana {
    Meives.frameM a;
    JButton btn;
    Meives.labelM c;
    
    public void Complem(){
        c= new Meives.labelM("jjj", Color.LIGHT_GRAY, 30, 20, 100, 30);
        btn= new JButton("Start");
        btn.setBounds(60, 100, 80, 20);
        
    }
    public void Fram(){
        a= new Meives.frameM(new Dimension(200, 200), "Count");
        a.add(c);
        a.add(btn);
        
        a.repaint();
    }
    public Ventana(){
        Complem();
        Fram();
    }
}
