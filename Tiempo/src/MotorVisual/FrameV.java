/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorVisual;

import MotorLogico.HiloReloj;
import MotorLogico.PrCo;
import MotorLogico.Imagen;
import MotorLogico.panel;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Usuario
 */
public class FrameV {

    private JFrame fram;
    private panel Pan1, Pan2, Pan3,panConfig;
    private PrCo c, d, e;
    private JButton btn,btn2,btn3;

    public void Components() {
        panConfig= new panel(Color.white,0.5f,"Administración");
        panConfig.setLayout(null);
        panConfig.setBounds(10, 10, 120, 350);
        
        btn= new JButton();
        btn.setBounds(10, 20, 100, 100);
        URL url= this.getClass().getResource("/Complements/Reloj.png");
        btn.setIcon(new ImageIcon(url));
        
        btn2= new JButton();
        btn2.setBounds(10, 130, 100, 100);
        URL url2= this.getClass().getResource("/Complements/cronometro.png");
        btn2.setIcon(new ImageIcon(url2));
        
        btn3= new JButton();
        btn3.setBounds(10, 240, 100, 100);
        URL url3= this.getClass().getResource("/Complements/Temporizador.png");
        btn3.setIcon(new ImageIcon(url3));
        
        panConfig.add(btn);
        panConfig.add(btn2);
        panConfig.add(btn3);
        
        Pan1 = new panel(Color.WHITE, 0.5f, "Reloj");
        Pan1.setLayout(null);
        Pan1.setBounds((995-330)/2, 20, 330, 430);

        c = new PrCo();
        c.setLayout(null);
        c.setBounds(15, 60, 100, 100);

        d = new PrCo();
        d.setLayout(null);
        d.setBounds(115, 60, 100, 100);
        
        e = new PrCo();
        e.setLayout(null);
        e.setBounds(215, 60, 100, 100);
        Pan1.add(c);
        Pan1.add(d);
        Pan1.add(e);

        Pan2 = new panel(Color.WHITE, 0.5f, "Cronometro");
        Pan2.setLayout(null);
//        Pan2.setBounds(355, 20, 280, 430);

        Pan3 = new panel(Color.WHITE, 0.5f, "Temporizador");
        Pan3.setLayout(null);
//        Pan3.setBounds(690, 20, 280, 430);
    }

    public void running() throws InterruptedException {
        HiloReloj hl = new HiloReloj(c);
        hl.start();

        HiloReloj hl2 = new HiloReloj(d);
        hl2.start();

        HiloReloj hl3 = new HiloReloj(e);
        hl3.start();

    }

    public void Fram() {
        fram = new JFrame("Tiempo");
        fram.setSize(995, 500);
        fram.setLayout(null);

        fram.add(panConfig);
        fram.add(Pan1);
//        fram.add(Pan2);
//        fram.add(Pan3);
        
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Complements/icon.png"));
        Imagen img = new Imagen("/Complements/1.jpg", fram.getWidth(), fram.getHeight());
        fram.add(img);
        fram.setIconImage(icon);
        fram.repaint();
        fram.setResizable(false);
        fram.setLocationRelativeTo(null);
        fram.setVisible(true);
        fram.setDefaultCloseOperation(3);
    }

    public FrameV() throws InterruptedException {
        Components();
        Fram();
        running();
    }

}
