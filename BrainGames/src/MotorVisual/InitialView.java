/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorVisual;

import MotorLogico.Meives;
import MotorLogico.Parpadeo;
import MotorLogico.Sound;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Usuario
 */
public class InitialView {

    JFrame fr;
    JButton Init, Stadistics, Exit;
    Cursor c;

    public void Comp() {
        Init = new JButton("Start Game");
        Init.setOpaque(false);
        Init.setBounds(560, 50, 210, 90);
        Init.setBorder(null);
        Color c = UIManager.getLookAndFeel().getDefaults().getColor("Panel.background");
        Init.setBackground(new Color(c.getRed(), c.getGreen(), c.getBlue()));
        ImageIcon a2 = new ImageIcon(getClass().getResource("/Complements/Img/3.gif"));
        Icon fnd = new ImageIcon(a2.getImage().getScaledInstance(Init.getWidth(), Init.getHeight(), Image.SCALE_DEFAULT));
        Init.setIcon(fnd);
        Init.setDoubleBuffered(true);
        Init.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fr.dispose();
                Sound.Init.stop();
                GameViewOneLevel gv = new GameViewOneLevel();
            }
        });

        Stadistics = new JButton("Stadistics");
        Stadistics.setOpaque(false);
        Stadistics.setBounds(540, 130, 253, 80);
        Stadistics.setBorder(null);
        Color c2 = UIManager.getLookAndFeel().getDefaults().getColor("Panel.background");
        Stadistics.setBackground(new Color(c2.getRed(), c2.getGreen(), c2.getBlue()));
        ImageIcon a3 = new ImageIcon(getClass().getResource("/Complements/Img/4.gif"));
        Icon fnd2 = new ImageIcon(a3.getImage().getScaledInstance(Stadistics.getWidth(), Stadistics.getHeight(), Image.SCALE_DEFAULT));
        Stadistics.setIcon(fnd2);
        Stadistics.setDoubleBuffered(true);
        Stadistics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.err.println("Not Found");
            }
        });

        Exit = new JButton("Exit");
        Exit.setOpaque(false);
        Exit.setBounds(600, 200, 130, 80);
        Exit.setBorder(null);
        Color c3 = UIManager.getLookAndFeel().getDefaults().getColor("Panel.background");
        Exit.setBackground(new Color(c3.getRed(), c3.getGreen(), c3.getBlue()));
        ImageIcon a4 = new ImageIcon(getClass().getResource("/Complements/Img/5.gif"));
        Icon fnd3 = new ImageIcon(a4.getImage().getScaledInstance(Exit.getWidth(), Exit.getHeight(), Image.SCALE_DEFAULT));
        Exit.setIcon(fnd3);
        Exit.setDoubleBuffered(true);
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Gracias Por Jugar", "Salir", JOptionPane.INFORMATION_MESSAGE);
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

        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Complements/Img/icon.png"));
        fr.setIconImage(icon);
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image iconoMaus = new ImageIcon(getClass().getResource("/Complements/Img/7.png")).getImage(); //Icono
        c = tk.createCustomCursor(iconoMaus, new Point(1, 1), "String");
        fr.setCursor(c);

        fr.setLocationRelativeTo(null);
        fr.setResizable(false);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(3);

        Meives.PanelM pn = new Meives.PanelM(Color.white, 0, 0, 0, 600, 500);
        fr.add(pn);
    }

    public InitialView() {
        Comp();
        Frm();
        Parpadeo md = new Parpadeo(fr.getWidth(), fr.getHeight(), fr);
//        Balls();
    }
}
