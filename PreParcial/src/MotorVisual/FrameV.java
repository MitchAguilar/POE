/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorVisual;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author estudiante
 */
public class FrameV implements ActionListener{
    JFrame a;
    JPasswordField b;
    JLabel c;
    JButton e;
    
    public void Components(){
        c= new JLabel("Digite su password.");
        c.setBounds(10, 30, 150, 30);
        c.setForeground(Color.white);
        
        b= new JPasswordField();
        b.setBounds(100, 70, 150, 30);
        
        e= new JButton("Ingresar");
        e.setBounds(90, 120, 100, 30);
        e.addActionListener(this);
    }
    public void Frame(){
        a=new JFrame("Validación");
        a.setSize(300, 200);
        a.setLayout(null);
        a.setBackground(Color.GRAY);
        
        a.add(c);
        a.add(b);
        a.add(e);
        
        Imagen ae= new Imagen("/Complement/descarga.jpg", 300, 200);
        a.add(ae);
        a.repaint();
        
        a.setVisible(true);
        a.setResizable(false);
        a.setLocationRelativeTo(null);
        a.setDefaultCloseOperation(a.EXIT_ON_CLOSE);
    }
    
   public FrameV(){
       Components();
       Frame();
   }

    @Override
    public void actionPerformed(ActionEvent ee) {
        if(ee.getSource()==e){
//            FrameP aa= new FrameP();
            if(b.getText() .equals("POE2017")){
                FrameP aa= new FrameP();
                a.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Error validación");
                b.setText(null);
            }
//           
        } 
    }
}
