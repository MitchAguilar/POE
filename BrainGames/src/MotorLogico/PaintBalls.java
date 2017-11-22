/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;

/**
 *
 * @author Usuario
 */
public class PaintBalls extends Thread {

    int x, y, xInc, yInc;
    Graphics g;
    JFrame fr;
    private double radio = 7.5;
    private double diametro = radio * 2;
    public Color col = Color.BLACK;
    private Graphics2D circulo;

    public PaintBalls(Graphics g, JFrame frm) {
        fr = frm;
        x = (int) (Math.random() * 250 + 1);
        y = (int) (Math.random() * 250 + 1);
        diametro = 10;
        xInc = 5;
        yInc = 2;
        this.g = g;
    }

    @Override
    public void run() {
//        g.setColor(Color.BLUE);
        Color pelota;
        pelota = (new Color((int) (Math.random() * 256),
                (int) (Math.random() * 256),
                (int) (Math.random() * 256)));
        circulo = (Graphics2D) g;
        circulo.setStroke(new BasicStroke(10f));
        circulo.setPaint(col);
        circulo.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        circulo.drawOval(30, 50, (int)(diametro), (int)(diametro));
        
        for (;;) {
            g.setColor(pelota);
            if (x + xInc <= 0) {
                xInc = -xInc;
            }
            if (x + xInc >= 600) {
                xInc = -xInc;
            }
            if (y + yInc <= 0) {
                yInc = -yInc;
            }
            if (y + yInc >= 600) {
                yInc = -yInc;
            }
            x += xInc;
            y += yInc;

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Error de excepcion:" + e);
            }
            fr.repaint();
            circulo.fillOval(x, y, (int) (diametro), (int) (diametro));
        }
    }
}
