/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author estudiante
 */
public class Meives {

    /*Clase jlabel modificada de la por defecto*/
    public static class labelM extends JLabel {

        public int tam = 15;

        public labelM(String text, Color col, int width, int height, int largo, int ancho) {
            setBounds(width, height, largo, ancho);
            Font fn = new Font("Agency FB", Font.BOLD, tam);
            setFont(fn);
            setText(text);
            setForeground(col);
        }

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

        public PanelM(Color c, float opacidad, int x, int y, int wi, int he) {
            setBounds(x, y, wi, he);
            dat = opacidad;
            setBackground(c);
            setLayout(null);
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
                JOptionPane.showMessageDialog(null, "Lo sentimos, ésto es un campo de numeros, por lo tanto no puede ingresar ningun otro caracter diferente de los numeros enteros ", "Error", JOptionPane.WARNING_MESSAGE);
            }
            if (getText().length() >= 5) {
                e.consume();
                JOptionPane.showMessageDialog(null, "Lo sentimos, ése campo no puede recibir un valor tan grande ", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }

        private void dec(KeyEvent e) {
            char c = e.getKeyChar();
            if (((c < '0') || (c > '9')) && (c != '\b') && (c != '.') && (c != KeyEvent.VK_BACK_SPACE)) {
                e.consume();
                JOptionPane.showMessageDialog(null, "Lo sentimos, ésto es un campo de numeros decimales, por lo tanto no puede ingresar ningun otro caracter diferente de los numeros decimales", "Error", JOptionPane.WARNING_MESSAGE);
            }
            if (getText().contains(".")) {
                if (((c < '0') || (c > '9')) && (c != '\b') && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Lo sentimos, ésto es un campo de numeros decimales, por lo tanto no puede ingresar ningun otro caracter diferente de los numeros decimales", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        private void str(KeyEvent e) {
            char c = e.getKeyChar();
            if (((c < 'A') || (c > 'Z')) && (c != '\b') && (c != 'Ñ')) {
                e.consume();
                JOptionPane.showMessageDialog(null, "Lo sentimos, ésto es un campo de solo letras MAYUSCULAS, por lo tanto no puede ingresar ningun otro caracter diferente de letras MAYUSCULAS", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }

        private void str2(KeyEvent e) {
            char c = e.getKeyChar();
            if (getText().length() < 3) {
                if (((c < 'A') || (c > 'Z')) && (c != '\b') && (c != 'Ñ')) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Lo sentimos, ésto es un campo de solo letras MAYUSCULAS, por lo tanto no puede ingresar ningun otro caracter diferente de letras MAYUSCULAS", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
            if (getText().length() == 3) {
                if ((c != '-') && (c != '\b')) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Lo sentimos, este campo solo puede ser - ", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
            if (getText().length() == 4) {
                if ((c != 'A') && (c != 'E') && (c != 'I') && (c != 'O') && (c != 'U') && (c != '\b')) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Lo sentimos, este campo solo puede ser una VOCAL ", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
            if (getText().length() == 5) {
                if ((c != '-') && (c != '\b')) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Lo sentimos, este campo solo puede ser - ", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
            if (getText().length() == 6 || getText().length() == 7) {
                if ((c < '0') || (c > '9') && (c != '\b')) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Lo sentimos, este campo solo puede ser NUMEROS ", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
            if (getText().length() > 7) {
                e.consume();
                JOptionPane.showMessageDialog(null, "Lo sentimos, el tipo de campo no permite que sea más larga", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }

        public textfieldM(int num, Color col, int width, int height, int largo, int ancho) {
            setBounds(width, height, largo, ancho);
            setBorder(BorderFactory.createLineBorder(col, 1));
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    Num(e);
                }
            });
        }

        public textfieldM(float num, Color col, int a, int b, int c, int d) {
            setBounds(a, b, c, d);
            setBorder(BorderFactory.createLineBorder(col, 1));
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    dec(e);
                }
            });
        }

        public textfieldM(String str, Color col, int a, int b, int c, int d) {
            setBounds(a, b, c, d);
            setBorder(BorderFactory.createLineBorder(col, 1));
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    str(e);
                }
            });
        }

        public textfieldM(Color col) {
            setBorder(BorderFactory.createLineBorder(col, 1));
        }

        public textfieldM(Color col, int a, int b, int c, int d) {

            setBounds(a, b, c, d);
            setBorder(BorderFactory.createLineBorder(col, 1));
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    str2(e);
                }
            });
        }

        public textfieldM() {
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
    public static class textareaM extends JTextArea {

        private void Num(KeyEvent e) {
            char c = e.getKeyChar();
            if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                e.consume();
                JOptionPane.showMessageDialog(null, "Lo sentimos, ésto es un campo de numeros, por lo tanto no puede ingresar ningun otro caracter diferente de los numeros enteros ", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }

        private void dec(KeyEvent e) {
            char c = e.getKeyChar();
            if (((c < '0') || (c > '9')) && (c != '\b') && (c != '.') && (c != KeyEvent.VK_BACK_SPACE)) {
                e.consume();
                JOptionPane.showMessageDialog(null, "Lo sentimos, ésto es un campo de numeros decimales, por lo tanto no puede ingresar ningun otro caracter diferente de los numeros decimales", "Error", JOptionPane.WARNING_MESSAGE);

            }
            if (getText().contains(".")) {
                if (((c < '0') || (c > '9')) && (c != '\b') && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Lo sentimos, ésto es un campo de numeros decimales, por lo tanto no puede ingresar ningun otro caracter diferente de los numeros decimales", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        private void str(KeyEvent e) {
            char c = e.getKeyChar();
            if (((c < 'a') || (c > 'z')) && ((c < 'A') || (c > 'Z')) && (c != '\b') && (c != 'ñ') && (c != 'Ñ')) {
                e.consume();
                JOptionPane.showMessageDialog(null, "Lo sentimos, ésto es un campo de solo letras, por lo tanto no puede ingresar ningun otro caracter diferente de letras", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }

        public void scroll(int a, int b, int c, int d) {
            JScrollPane scroll = new JScrollPane(this);
            scroll.setBounds(new Rectangle(a, b, c, d));
//            frmprincipal.add(scroll);
//            frmprincipal.show(true);
        }

        public textareaM(int num, Color col) {
            setBorder(BorderFactory.createLineBorder(col, 1));
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    dec(e);
                }
            });
        }

        public textareaM(float num, Color col) {
            setBorder(BorderFactory.createLineBorder(col, 1));
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    dec(e);
                }
            });
        }

        public textareaM(String text, Color col, int width, int height, int largo, int ancho) {
            setBounds(width, height, largo, ancho);
            setEditable(false);
            setBorder(BorderFactory.createLineBorder(col, 1));
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    str(e);
                }
            });
        }
    }

    /*Implementación de errores personalizados*/
    public static class ErrorM extends Exception {

        public ErrorM() {
        }

        public ErrorM(String message) {
            super(message);
        }

        public ErrorM(String message, Throwable cause) {
            super(message, cause);
        }

        public ErrorM(Throwable cause) {
            super(cause);
        }

        public ErrorM(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }

    /*Frame modificado por parametros para recivir imagenes y personalizaciones*/
    public static class frameM extends JFrame {

        public frameM(Dimension sz, String title) {
            
            setUndecorated(true);
            setLayout(null);
            setSize(sz);
            setTitle(title);
            setVisible(true);
            setResizable(false);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(3);
        }

        public void InsertImg(String url) {
            Imagen img = new Imagen(url, getWidth(), getHeight());
            add(img);
        }

        public void InsertImgIcon(String url) {
            Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource(url));
            setIconImage(icon);
        }
    }
}
