/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molde;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mitch
 */
public class Frame {
    JFrame a;
    JPanel b,c,d;
    JButton f,g,h;
    
    public void Compoents(){
        
    }
    public void FrameV(){
        a= new JFrame("");
        a.setSize(0, 0);
        a.setLayout(null);
        
        
        a.setLocationRelativeTo(null);
        a.setResizable(false);
        a.setVisible(false);
        a.setDefaultCloseOperation(3);
    }
    public Frame(){
        Compoents();
        FrameV();
    }
}
