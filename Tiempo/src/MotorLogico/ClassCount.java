package MotorLogico;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class ClassCount extends JPanel {

    private int progress = 0,rotate=0;

    public void UpdateProgres(int progress) {
        this.progress = progress;
    }

    public ClassCount(int rotate) {
        this.rotate=rotate;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.translate(this.getWidth() / 2, this.getHeight() / 2);
        g2.rotate(Math.toRadians(270));
        Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
        Ellipse2D circle = new Ellipse2D.Float(0, 0, 30, 30);
        arc.setFrameFromCenter(new Point(0, 0), new Point(40, 40));
        circle.setFrameFromCenter(new Point(0, 0), new Point(30, 30));
        arc.setAngleStart(1);
        arc.setAngleExtent(-progress * rotate);//360/100=3.6
        g2.setColor(Color.DARK_GRAY);
        g2.draw(arc);
        g2.fill(arc);
        g2.setColor(Color.white);
        g2.draw(circle);
        g2.fill(circle);
        g2.setColor(Color.DARK_GRAY);
        g2.rotate(Math.toRadians(90));
        g2.setFont(new Font("Verdana", Font.PLAIN, 40));
        FontMetrics fn = g2.getFontMetrics();
        Rectangle2D r = fn.getStringBounds(progress + "", g);
        int x = (0 - (int) r.getWidth()) / 2;
        int y = (0 - (int) r.getHeight()) / 2 + fn.getAscent();
        g2.drawString(progress + "", x, y);
    }
}
