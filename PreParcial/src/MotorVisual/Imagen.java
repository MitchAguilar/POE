/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorVisual;

/**
 *
 * @author estudiante
 */
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Imagen extends javax.swing.JPanel {

    int wei, hei;
    String url;

    public Imagen(String url, int wei, int hei) {
        this.url = url;
        this.wei = wei;
        this.hei = hei;
        this.setSize(wei, hei);
    }

    public void paint(Graphics grafico) {
        ImageIcon Img = new ImageIcon(getClass().getResource(url));
        grafico.drawImage(Img.getImage(), 0, 0, wei, hei, null);
        setOpaque(false);
        super.paintComponent(grafico);
    }
}


