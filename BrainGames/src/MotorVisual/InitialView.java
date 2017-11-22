/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorVisual;

import MotorLogico.Meives;
import MotorLogico.Sound;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

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
        Init.setBounds(580, 50, 210, 90);
        Init.setBorder(null);
        Color c = UIManager.getLookAndFeel().getDefaults().getColor("Panel.background");
        Init.setBackground(new Color(c.getRed(), c.getGreen(), c.getBlue()));
        ImageIcon a2 = new ImageIcon(getClass().getResource("/Complements/Img/3.gif"));
        Icon fnd = new ImageIcon(a2.getImage().getScaledInstance(Init.getWidth(), Init.getHeight(), Image.SCALE_DEFAULT));
        Init.setIcon(fnd);
        Init.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fr.dispose();
                GameView gv = new GameView();
            }
        });

        Stadistics = new JButton("Stadistics");
        Stadistics.setOpaque(false);
        Stadistics.setBounds(560, 130, 253, 80);
        Stadistics.setBorder(null);
        Color c2 = UIManager.getLookAndFeel().getDefaults().getColor("Panel.background");
        Stadistics.setBackground(new Color(c2.getRed(), c2.getGreen(), c2.getBlue()));
        ImageIcon a3 = new ImageIcon(getClass().getResource("/Complements/Img/4.gif"));
        Icon fnd2 = new ImageIcon(a3.getImage().getScaledInstance(Stadistics.getWidth(), Stadistics.getHeight(), Image.SCALE_DEFAULT));
        Stadistics.setIcon(fnd2);
        Stadistics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.err.println("Not Found");
            }
        });

        Exit = new JButton("Exit");
        Exit.setOpaque(false);
        Exit.setBounds(620, 200, 130, 80);
        Exit.setBorder(null);
        Color c3 = UIManager.getLookAndFeel().getDefaults().getColor("Panel.background");
        Exit.setBackground(new Color(c3.getRed(), c3.getGreen(), c3.getBlue()));
        ImageIcon a4 = new ImageIcon(getClass().getResource("/Complements/Img/5.gif"));
        Icon fnd3 = new ImageIcon(a4.getImage().getScaledInstance(Exit.getWidth(), Exit.getHeight(), Image.SCALE_DEFAULT));
        Exit.setIcon(fnd3);
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
        fr.setUndecorated(true);

        fr.add(Init);
        fr.add(Stadistics);
        fr.add(Exit);

        Meives.Imagen img = new Meives.Imagen("/Complements/Img/2.jpg", fr.getWidth(), fr.getHeight());
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
