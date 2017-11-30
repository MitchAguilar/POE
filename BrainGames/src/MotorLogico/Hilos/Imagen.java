package MotorLogico.Hilos;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Imagen extends javax.swing.JPanel {

    int wit, hei;
    String ruta;

    public Imagen(int wit, int hei, String ruta) {
        this.wit = wit;
        this.hei = hei;
        this.ruta = ruta;
        this.setSize(wit, hei);
    }

    @Override
    public void paint(Graphics grafico) {
        ImageIcon img = new ImageIcon(getClass().getResource(ruta));
        grafico.drawImage(img.getImage(), 0, 0, wit, hei, null);
        setOpaque(false);
        super.paintComponent(grafico);
    }
}
