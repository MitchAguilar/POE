/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tefa;

import java.awt.Button;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Checkbox;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;

public class Interfaz extends Frame implements ItemListener {

    Color Peach_Puff = new Color(255, 218, 185);
    Color Azure = new Color(66, 20, 95);
    Color Violet = new Color(169, 0, 97);

    Font f1 = new Font("Monospaced", Font.BOLD, 15);

    Panel panel1, panel2;
    Label l1, l2, l3, l4, l5;
    Button con, lim;
    TextField t1, t2, t3, t4, t5;
    CheckboxGroup ant;
    Checkbox bin, oct, dec, hex;
    Image icono;

    boolean b = false, d = false, o = false, h = false;

    Interfaz() {
        Lienzo();
        Componentes();
        add(panel1);
        add(panel2);
    }

    void Lienzo() {
        setTitle("Convertidor");
        setSize(600, 300);
        setLayout(null);
        setBackground(Peach_Puff);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    void Componentes() {
        panel1 = new Panel();
        panel1.setBounds(15, 40, 570, 80);
        panel1.setBackground(Azure);
        panel1.setLayout(null);

        l1 = new Label("Convertir de: ");
        l1.setFont(f1);
        l1.setForeground(Color.WHITE);
        l1.setBounds(10, 5, 120, 30);
        panel1.add(l1);

        t1 = new TextField();
        t1.setBounds(350, 15, 200, 20);
        t1.setEnabled(false);
        panel1.add(t1);

        con = new Button("Convertir");
        con.setBounds(350, 43, 90, 30);
        con.addActionListener(new MiAccion());
        panel1.add(con);

        lim = new Button("Limpiar");
        lim.setBounds(460, 43, 90, 30);
        lim.addActionListener(new MiAccion());
        panel1.add(lim);

        panel2 = new Panel();
        panel2.setBounds(15, 130, 570, 155);
        panel2.setBackground(Violet);
        panel2.setLayout(null);

        l2 = new Label("Binario");
        l2.setFont(f1);
        l2.setForeground(Color.WHITE);
        l2.setBounds(15, 20, 100, 20);
        panel2.add(l2);

        t2 = new TextField();
        t2.setBounds(15, 40, 200, 20);
        t2.setEnabled(false);
        panel2.add(t2);

        l3 = new Label("Octal");
        l3.setFont(f1);
        l3.setForeground(Color.WHITE);
        l3.setBounds(15, 85, 100, 20);
        panel2.add(l3);

        t3 = new TextField();
        t3.setBounds(15, 105, 200, 20);
        t3.setEnabled(false);
        panel2.add(t3);

        l4 = new Label("Decimal");
        l4.setFont(f1);
        l4.setForeground(Color.WHITE);
        l4.setBounds(340, 20, 100, 20);
        panel2.add(l4);

        t4 = new TextField();
        t4.setBounds(340, 40, 200, 20);
        t4.setEnabled(false);
        panel2.add(t4);

        l5 = new Label("Hexadecimal");
        l5.setFont(f1);
        l5.setForeground(Color.WHITE);
        l5.setBounds(340, 85, 100, 20);
        panel2.add(l5);

        t5 = new TextField();
        t5.setBounds(340, 105, 200, 20);
        t5.setEnabled(false);
        panel2.add(t5);

        ant = new CheckboxGroup();

        bin = new Checkbox("Binario", ant, false);
        bin.setBounds(10, 35, 60, 20);
        bin.setForeground(Color.WHITE);

        oct = new Checkbox("Octal", ant, false);
        oct.setBounds(85, 35, 60, 20);
        oct.setForeground(Color.WHITE);

        dec = new Checkbox("Decimal", ant, false);
        dec.setBounds(150, 35, 65, 20);
        dec.setForeground(Color.WHITE);

        hex = new Checkbox("Hexadecimal", ant, false);
        hex.setBounds(225, 35, 90, 20);
        hex.setForeground(Color.WHITE);

        bin.addItemListener(this);
        oct.addItemListener(this);
        dec.addItemListener(this);
        hex.addItemListener(this);
        panel1.add(bin);
        panel1.add(oct);
        panel1.add(dec);
        panel1.add(hex);

        //15*15px
//        icono = new ImageIcon(getClass().getResource("/_06_Imagenes/icono.jpg")).getImage();
//        setIconImage(icono);
    }

    public class MiAccion implements ActionListener {

        private Component Interfaz;

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource().equals(con)) {

                if (!t1.getText().isEmpty()) {// más optimo
                    //tu problema, son ésto booleanos 
                    Operacion op = new Operacion(t1.getText());
                    bin.setEnabled(false);
                    oct.setEnabled(false);
                    dec.setEnabled(false);
                    hex.setEnabled(false);

                    t1.setEnabled(false);

                    if (b) {
                        System.out.println("Primero");
//                        bloqbin(null);
                        t2.setText(op.getCad());

//                        t3.setText(op.bin_oct());

                        t4.setText(op.bin_dec());

//                        t5.setText(op.bin_hex());
                        

                    } else if (o) {
                        System.out.println("Segundo");
//                        t2.setText(op.oct_bin());

                        t3.setText(op.getCad());

////                        t4.setText(op.oct_dec());

//                        t5.setText(op.oct_hex());

                    } else if (d) {
                        System.out.println("tercero");
                        t2.setText(op.dec_bin());

                        t3.setText(op.dec_oct());

                        t4.setText(op.getCad());

                        t5.setText(op.dec_hex());

                    } else if (h) {
                        System.out.println("cuarto");
//                        t2.setText(op.hex_bin());
//
//                        t3.setText(op.hex_oct());
//
//                        t4.setText(op.hex_dec());

                        t5.setText(op.getCad());
                    }

                }
            }
            if (ae.getSource().equals(lim)) {//modifiqué aquí
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                
                ant.setSelectedCheckbox(null);
                bin.setEnabled(true);
                oct.setEnabled(true);
                dec.setEnabled(true);
                hex.setEnabled(true);

                

                t1.setEnabled(false);
                t2.setEnabled(false);
                t3.setEnabled(false);
                t4.setEnabled(false);
                t5.setEnabled(false);
            }
        }
    }

    public void bloqbin(KeyEvent e) {
        char caracter = e.getKeyChar();
        if ((caracter < '0' || caracter > '1')&& (caracter != KeyEvent.VK_BACK_SPACE)) {
            e.consume();
        }
        System.err.println("binarios bloqueados");
    }

    public void bloqoct(KeyEvent e) {
        char caracter = e.getKeyChar();
        if ((caracter < '0' || caracter > '7')&& (caracter != KeyEvent.VK_BACK_SPACE)) {
            e.consume();
        }
        System.err.println("octales bloqueados");
    }

    public void bloqdec(KeyEvent e) {
        char caracter = e.getKeyChar();
        if ((caracter < '0' || caracter > '9')&& (caracter != KeyEvent.VK_BACK_SPACE)) {
            e.consume();
        }
        System.err.println("decimales bloqueados");
    }

    public void bloqhex(KeyEvent e) {
        char caracter = e.getKeyChar();
        if ((caracter < '0' || caracter > 'f') && (caracter > 'a' || caracter < '9')&& (caracter != KeyEvent.VK_BACK_SPACE)) {
            e.consume();
        }
        System.err.println("hexadecimales bloqueados");
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getSource().equals(bin)) {
            b = true;
            t1.setEnabled(true);
            t1.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    bloqbin(e);
//                    if (t1.getText().length() > 25) {
//                        e.consume();
//                    }
                }
            });

        } 
        if (ie.getSource().equals(oct)) {
            o = true;
            t1.setEnabled(true);
            t1.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    bloqoct(e);
//                    if (t1.getText().length() > 9) {
//                        e.consume();
//                    }
                }
            });
        }
        if (ie.getSource().equals(dec)) {
            d = true;
            t1.setEnabled(true);
            t1.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    bloqdec(e);
//                    if (t1.getText().length() > 9) {
//                        e.consume();
//                    }
                }
            });
        } 
        if (ie.getSource().equals(hex)) {
            h = true;
            t1.setEnabled(true);
            t1.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    bloqhex(e);
//                    if (t1.getText().length() > 6) {
//                        e.consume();
//                    }
                }
            });
        }
    }
}
