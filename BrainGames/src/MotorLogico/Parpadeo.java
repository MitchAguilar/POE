/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author Usuario
 */
public class Parpadeo extends Canvas {

    public int WIDTH;
    public int HEIGHT;
    private BufferedImage imagenBuffer;
    private Graphics g_imagenBuffer;
    private JFrame jf;

    public Parpadeo(int qid, int hei, JFrame fr) {
        WIDTH = qid;
        HEIGHT = hei;
        jf = fr;
        this.setSize(WIDTH, HEIGHT);
        //creamos la imagen en memoria
        imagenBuffer = new BufferedImage(WIDTH,
                HEIGHT,
                BufferedImage.TYPE_INT_RGB
        );
        //obtenemos los graficos
        g_imagenBuffer = imagenBuffer.getGraphics();
    }

    @Override
    public void update(Graphics g) {
        g.drawImage(imagenBuffer, 0, 0, jf);
    }
}
