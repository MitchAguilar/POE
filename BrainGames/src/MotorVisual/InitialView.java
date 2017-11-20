/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorVisual;

import MotorLogico.Meives;
import MotorLogico.Sound;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class InitialView {

    JFrame fr;
    JButton Init, Stadistics, Exit;

    public void Comp() {
        Init = new JButton("Start Game");
        Init.setOpaque(false);
        Init.setBounds(610, 50, 150, 30);
        Init.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fr.dispose();
                GameView gv = new GameView();
            }
        });

        Stadistics = new JButton("Stadistics");
        Stadistics.setOpaque(false);
        Stadistics.setBounds(610, 100, 150, 30);
        Stadistics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.err.println("Not Found");
            }
        });

        Exit = new JButton("Exit");
        Exit.setOpaque(false);
        Exit.setBounds(610, 150, 150, 30);
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Gracias Por Jugar", "Salir", JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }
        });
    }

    public void Frm() {
        fr = new JFrame();
        fr.setSize(800, 500);
        fr.setLayout(null);

        fr.add(Init);
        fr.add(Stadistics);
        fr.add(Exit);

        Meives.Imagen img = new Meives.Imagen("/Complements/Img/2.png", fr.getWidth(), fr.getHeight());
        fr.add(img);
        fr.repaint();
        
        Sound.Init.play();

        fr.setLocationRelativeTo(null);
        fr.setResizable(false);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(3);
    }

    public InitialView() {
        Comp();
        Frm();
    }
}
