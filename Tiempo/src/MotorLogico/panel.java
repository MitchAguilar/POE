/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico;

/**
 *
 * @author mitch
 */
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class panel extends JPanel {

    public float dat = 0.5f;

    public panel(Color c, float dat, String title) {
        setBackground(c);
        this.dat = dat;
        TitledBorder bord;
        bord = BorderFactory.createTitledBorder(title);
        bord.setTitleColor(Color.ORANGE);
        setBorder(bord);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        AlphaComposite old = (AlphaComposite) g2.getComposite();
        g2.setComposite(AlphaComposite.SrcOver.derive(dat));
        super.paintComponent(g);
        g2.setComposite(old);
    }

}
