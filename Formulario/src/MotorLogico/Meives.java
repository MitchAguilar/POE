/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author estudiante
 */
public class Meives {

    /*Clase jlabel modificada de la por defecto*/
    public static class labelM extends JLabel {

        public int tam = 25;

        public labelM(String text, Color col) {
            Font fn = new Font("Agency FB", Font.BOLD, tam);
            setFont(fn);
            setText(text);
            setForeground(col);
        }
    }

    /*Clase panel modificada de la por defecto, para ser trasparente*/
    public static class PanelM extends JPanel {

        //modificar la opacidad
        public float dat = 0.5f;

        public PanelM(Color c) {
            setBackground(c);
            setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
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

    /*Jtextfiel modificados, y validados para diferentes tipos de campos*/
    public static class textfieldM extends JTextField {

        private void Num(KeyEvent e) {
            char c = e.getKeyChar();
            if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                e.consume();
            }
            if ((((c < '0') || (c > '9')) && c != '\b')) {
                JOptionPane.showMessageDialog(null, "Lo sentimos, ésto es un campo de numeros, por lo tanto no puede ingresar ningun otro caracter diferente de los numeros enteros ");
            }
        }

        private void dec(KeyEvent e) {
            char c = e.getKeyChar();
            if (((c < '0') || (c > '9')) && (c != '\b') && (c != '.') && (c != KeyEvent.VK_BACK_SPACE)) {
                e.consume();
            }
            if ((((c < '0') || (c > '9')) && (c != '\b') && (c != '.'))) {
                JOptionPane.showMessageDialog(null, "Lo sentimos, ésto es un campo de numeros decimales, por lo tanto no puede ingresar ningun otro caracter diferente de los numeros decimales ");
            }
            if (getText().contains(".")) {
                if (((c < '0') || (c > '9')) && (c != '\b') && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        }

        private void str(KeyEvent e) {
            char c = e.getKeyChar();
            if (((c < 'a') || (c > 'z')) && ((c < 'A') || (c > 'Z')) && (c != '\b') && (c != 'ñ') && (c != 'Ñ')) {
                e.consume();
            }
            if ((((c < 'a') || (c > 'z')) && ((c < 'A') || (c > 'Z')) && (c != '\b') && (c != 'ñ') && (c != 'Ñ'))) {
                JOptionPane.showMessageDialog(null, "Lo sentimos, ésto es un campo de solo letras, por lo tanto no puede ingresar ningun otro caracter diferente de letras");
            }
        }

        public textfieldM(int num, Color col) {
            setBorder(BorderFactory.createLineBorder(col, 1));
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    Num(e);
                }
            });
        }

        public textfieldM(float num, Color col) {
            setBorder(BorderFactory.createLineBorder(col, 1));
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    dec(e);
                }
            });
        }

        public textfieldM(String str, Color col) {
            setBorder(BorderFactory.createLineBorder(col, 1));
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    str(e);
                }
            });
        }
    }

    /*Panel Modificado para imagenes de todo tipo*/
    public static class Imagen extends JPanel {

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
    /*Text area modificada para uso especifico*/
    public static class textareaM{
        
    }
}
