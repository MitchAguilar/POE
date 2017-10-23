/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClassRel extends JPanel {

    static int aumento = 0;
    static int aps = 0;
    static int fps = 0;
    static int contador1 = 1, contador2 = 1, contador3 = 1;

    public static void main(String[] args) throws InterruptedException {

        int hora, minutos, segundos, anchoReloj;
        Calendar calendario = Calendar.getInstance();
        hora = (calendario.get(Calendar.HOUR_OF_DAY));
        minutos = (calendario.get(Calendar.MINUTE));
        segundos = (calendario.get(Calendar.SECOND));
//        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("/Recurso/Mitch.png"));
        JFrame lienzo = new JFrame("Hola Mundo");
//        lienzo.setIconImage(retValue);
        Dimension dimension = new Dimension();
        dimension.setSize(700, 700);
        lienzo.setSize(dimension);
        lienzo.setLocationRelativeTo(null);
        lienzo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ClassRel dibujos = new ClassRel();
        lienzo.add(dibujos);
        lienzo.setVisible(true);

        while (true) {
            dibujos.repaint();
            Thread.sleep(1000);
        }
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Color color;
        fps++;
        Calendar calendario = Calendar.getInstance();
        int hora, minutos, segundos, anchoSegundo, anchoMinuto, anchoHora, anchoTexto;
        hora = (calendario.get(Calendar.HOUR_OF_DAY));
        minutos = (calendario.get(Calendar.MINUTE));
        segundos = (calendario.get(Calendar.SECOND));
        anchoSegundo = 550;
        anchoMinuto = 450;
        anchoHora = 350;
        anchoTexto = 250;

        if (segundos == 0) {
            contador1 = contador1 == 2 ? 1 : 2;
            Sonido.MIN.play();
        }
        if (minutos == 0) {
            if (segundos == 0) {
                contador2 = contador2 == 2 ? 1 : 2;
                Sonido.MIN.play();
            }
        }
        if (hora == 0) {
            if (minutos == 0) {
                if (segundos == 0) {
                    contador3 = contador3 == 2 ? 1 : 2;
                    Sonido.HOR.play();
                }
            }
        }
        //Fondo        
        g2d.setPaint(new GradientPaint(150, 10, Color.BLACK, 35, 100, new Color(0f, 0f, 0.3f), true));
        g2d.fill(new Rectangle2D.Double(0, 0, this.getWidth(), this.getHeight()));
        //Fondosegundo

        g2d.setPaint(Color.WHITE);
        g2d.setStroke(new BasicStroke(6.0f));
        g2d.draw(new Arc2D.Double(((this.getWidth() - anchoSegundo) / 2) - 3, ((this.getHeight() - anchoSegundo) / 2) - 3, anchoSegundo + 6, anchoSegundo + 6, 90, 360, Arc2D.PIE));

        color = contador1 == 1 ? new Color(0f, 0f, 0f) : new Color(0.2f, 0f, 1f);
        g2d.setColor(color);
        g2d.fillOval((this.getWidth() - anchoSegundo) / 2, (this.getHeight() - anchoSegundo) / 2, anchoSegundo, anchoSegundo);

        color = contador1 == 1 ? new Color(0.2f, 0f, 1f) : new Color(0f, 0f, 0f);
        g2d.setColor(color);
        g2d.fillArc((this.getWidth() - anchoSegundo) / 2, (this.getHeight() - anchoSegundo) / 2, anchoSegundo, anchoSegundo, 90, (int) (segundos * -6));

        g2d.setPaint(Color.WHITE);
        g2d.setStroke(new BasicStroke(6.0f));
        g2d.draw(new Arc2D.Double(((this.getWidth() - anchoMinuto) / 2) - 3, ((this.getHeight() - anchoMinuto) / 2) - 3, anchoMinuto + 6, anchoMinuto + 6, 90, 360, Arc2D.PIE));

        color = contador2 == 1 ? new Color(0f, 0f, 0f) : new Color(1f, 0.2f, 0f);
        g2d.setColor(color);
        g2d.fillOval((this.getWidth() - anchoMinuto) / 2, (this.getHeight() - anchoMinuto) / 2, anchoMinuto, anchoMinuto);

        color = contador2 == 1 ? new Color(1f, 0.2f, 0f) : new Color(0f, 0f, 0f);
        g2d.setColor(color);
        g2d.fillArc((this.getWidth() - anchoMinuto) / 2, (this.getHeight() - anchoMinuto) / 2, anchoMinuto, anchoMinuto, 90, (int) (minutos * -6));

        g2d.setPaint(Color.WHITE);
        g2d.setStroke(new BasicStroke(6.0f));
        g2d.draw(new Arc2D.Double(((this.getWidth() - anchoHora) / 2) - 3, ((this.getHeight() - anchoHora) / 2) - 3, anchoHora + 6, anchoHora + 6, 90, 360, Arc2D.PIE));

        color = contador3 == 1 ? new Color(0f, 0f, 0f) : new Color(0.5f, 1f, 0f);
        g2d.setColor(color);
        g2d.fillOval((this.getWidth() - anchoHora) / 2, (this.getHeight() - anchoHora) / 2, anchoHora, anchoHora);

        color = contador3 == 1 ? new Color(0.5f, 1f, 0f) : new Color(0f, 0f, 0f);
        g2d.setColor(color);
        g2d.fillArc((this.getWidth() - anchoHora) / 2, (this.getHeight() - anchoHora) / 2, anchoHora, anchoHora, 90, hora >= 12 ? (int) ((hora - 12) * -30) + 1 : (int) ((hora) * -30) + 1);

        g2d.setPaint(Color.WHITE);
        g2d.setStroke(new BasicStroke(6.0f));
        g2d.draw(new Arc2D.Double(((this.getWidth() - anchoTexto) / 2) - 3, ((this.getHeight() - anchoTexto) / 2) - 3, anchoTexto + 6, anchoTexto + 6, 90, 360, Arc2D.PIE));

        color = new Color(0f, 0f, 0f);
        g2d.setColor(color);
        g2d.fillOval((this.getWidth() - anchoTexto) / 2, (this.getHeight() - anchoTexto) / 2, anchoTexto, anchoTexto);

        color = new Color(1f, 1f, 1f);
        g2d.setColor(color);
        int Tam;
        String S, M, H;
        S = segundos < 10 ? String.valueOf("0" + segundos) : String.valueOf(segundos);
        M = minutos < 10 ? String.valueOf("0" + minutos) : String.valueOf(minutos);
        H = hora > 12 ? hora - 12 < 10 ? String.valueOf("0" + (hora - 12)) : String.valueOf(hora - 12) : hora < 10 ? String.valueOf("0" + (hora)) : String.valueOf(hora);
        Tam = 50;
        g2d.setFont(new Font("SansSerif", Font.PLAIN, Tam));
        g2d.drawString(H + ":" + M + ":" + S, (int) ((this.getWidth() - (Tam * 4)) / 2), (int) ((this.getHeight() + Tam) / 2));
    }

}
