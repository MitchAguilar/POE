/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorVisual;

import MotorLogico.Imagen;
import MotorLogico.Meives;
import MotorLogico.panel;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class FrameP {

    JFrame Fram;
    panel Lona;
    JLabel TiempoVer, TiempoAma, Aleator;
    Meives.textfieldM Tv, Ta;
    JButton enviar;
    JCheckBox A1,A2;

    public void Components() {
        Lona = new panel(Color.WHITE, 0.5f, "Parametros");
        Lona.setBounds(10, 10, 375, 250);
        Lona.setLayout(null);

        TiempoVer = new JLabel("Tiempo Verde:");
        TiempoVer.setBounds(10, 30, 120, 30);

        TiempoAma = new JLabel("Tiempo Amarillo:");
        TiempoAma.setBounds(10, 80, 120, 30);
        
        Aleator= new JLabel("Semaforos Aleatorios:");
        Aleator.setBounds(10, 120, 150, 30);
        
        A1= new JCheckBox("Si");//Para el aleatorio
        A1.setBounds(150, 120, 50, 30);
        A1.setOpaque(false);
        A1.setEnabled(false);
        
        A2= new JCheckBox("No");//Para el aleatorio
        A2.setBounds(230, 120, 50, 30);
        A2.setOpaque(false);
        A2.setEnabled(false);

        Tv = new Meives.textfieldM(0, Color.ORANGE, 150, 30, 200, 30);
        Ta = new Meives.textfieldM(0, Color.ORANGE, 150, 80, 200, 30);

        enviar = new JButton("Ingresar");
        enviar.setBounds(250, 200, 100, 30);
        enviar.setForeground(Color.ORANGE);
        enviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(Tv.getText().isEmpty() || Ta.getText().isEmpty())) {
                    Fram.dispose();
                    try {
                        Frame a = new Frame(Integer.parseInt(Tv.getText()), Integer.parseInt(Ta.getText()));
                    } catch (InterruptedException ex) {
                        Logger.getLogger(FrameP.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Lo sentimos, no se han completado todos los campos", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        Lona.add(TiempoVer);
        Lona.add(Tv);
        Lona.add(Ta);
        Lona.add(A1);
        Lona.add(A2);
        Lona.add(enviar);
        Lona.add(TiempoAma);
        Lona.add(Aleator);
    }

    public void Fram() {
        Fram = new JFrame("Parametros");
        Fram.setSize(400, 300);
        Fram.setLayout(null);

        Fram.add(Lona);

        Imagen img = new Imagen("/Complements/SrM.jpg", Fram.getWidth(), Fram.getHeight());
        Fram.add(img);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Complements/Icon.png"));
        Fram.setIconImage(icon);

        Fram.repaint();
        Fram.setVisible(true);
        Fram.setResizable(false);
        Fram.setLocationRelativeTo(null);
        Fram.setDefaultCloseOperation(3);
    }

    public FrameP() {
        Components();
        Fram();
    }

}
