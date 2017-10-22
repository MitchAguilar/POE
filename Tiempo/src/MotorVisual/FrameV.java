/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorVisual;

import MotorLogico.HiloContador;
import MotorLogico.PrCo;
import MotorLogico.Imagen;
import MotorLogico.panel;
import com.sun.javafx.scene.control.skin.CustomColorDialog;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Usuario
 */
public class FrameV {

    private JFrame fram;
    private panel Pan1, Pan2, Pan3;
    private PrCo c;

    public void Components() {
        Pan1 = new panel(Color.WHITE, 0.5f, "Contador");
        Pan1.setLayout(null);
        Pan1.setBounds(20, 20, 280, 430);
        
        c = new PrCo();
        c.setLayout(null);
        c.setBounds(15, 50, 250, 250);
        Pan1.add(c);

        Pan2 = new panel(Color.WHITE, 0.5f, "Reloj");
        Pan2.setLayout(null);
        Pan2.setBounds(355, 20, 280, 430);

        Pan3 = new panel(Color.WHITE, 0.5f, "Cronometro");
        Pan3.setLayout(null);
        Pan3.setBounds(690, 20, 280, 430);
    }

    public void running() {
        HiloContador hl= new HiloContador(c);
        hl.start();
    }

    public void Fram() {
        fram = new JFrame("Tiempo");
        fram.setSize(995, 500);
        fram.setLayout(null);

        fram.add(Pan1);
        fram.add(Pan2);
        fram.add(Pan3);

        Imagen img= new Imagen("/Complements/1.jpg", fram.getWidth(), fram.getHeight());
        fram.add(img);
        fram.repaint();
        fram.setResizable(false);
        fram.setLocationRelativeTo(null);
        fram.setVisible(true);
        fram.setDefaultCloseOperation(3);
    }

    public FrameV() {
        Components();
        Fram();
        running();
    }

}
