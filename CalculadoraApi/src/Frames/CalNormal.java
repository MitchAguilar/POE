package Frames;

import calculadoraNormal.Operaciones;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import org.w3c.dom.events.MouseEvent;

public class CalNormal extends MouseAdapter implements ActionListener {

    Frame a;
    Panel b, c;
    Label d, f, g, l;
    Button h, m;
    Choice i;
    TextField j, k;

    public void Componets() {
        b = new Panel();
        b.setBounds(40, 50, 245, 200);
        b.setLayout(null);
        b.addMouseListener(this);
        b.setBackground(Color.white);

        c = new Panel();
        c.setBounds(325, 50, 245, 200);
        c.setLayout(null);
        c.addMouseListener(this);
        c.setBackground(Color.lightGray);

        d = new Label("DÍGITO 1:");
        d.setBackground(Color.white);
        d.setBounds(10, 50, 100, 30);
        b.add(d);

        f = new Label("DÍGITO 2:");
        f.setBackground(Color.white);
        f.setBounds(10, 100, 100, 30);
        b.add(f);

        g = new Label("Escoja La Operación A Realizar");
        g.setBackground(Color.lightGray);
        g.setBounds(10, 50, 200, 30);
        c.add(g);

        h = new Button("CALCULAR");
        h.setBounds(120, 100, 100, 30);
        h.addActionListener(this);
        c.add(h);

        i = new Choice();
        i.add("Seleccione");
        i.select("Seleccione");
        i.add("Sumar");
        i.add("Restar");
        i.add("Multiplicar");
        i.add("Dividir");
        i.setBounds(10, 100, 100, 30);
        c.add(i);

        j = new TextField();
        j.setBounds(100, 50, 125, 30);
        j.setBackground(Color.PINK);
        b.add(j);

        k = new TextField();
        k.setBounds(100, 100, 125, 30);
        k.setBackground(Color.pink);
        b.add(k);

        l = new Label();
//        l.setBackground(Color.green);
        l.setBounds(250, 300, 300, 30);

        m = new Button("Reset");
        m.setBounds(120, 150, 100, 30);
        m.addActionListener(this);
        c.add(m);
    }

    public void FrameCom() {
        a = new Frame("CALCULADORA");
        a.setSize(600, 400);
        a.setBackground(Color.CYAN);
        a.setLayout(null);

        a.add(b);
        a.add(c);
        a.add(l);
        a.addMouseListener(this);
        a.setVisible(true);
        a.setResizable(false);
        a.setLocationRelativeTo(null);
        a.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        }
        );
    }

    public CalNormal() {
        Componets();
        FrameCom();
    }

    public void mouseReleased(java.awt.event.MouseEvent e) {
        if (e.getButton() == 3) {
            JOptionPane.showMessageDialog(null, "clic derecho");
        } else if (e.getButton() == 1) {
            JOptionPane.showMessageDialog(null, "clic izquierdo");
        }
    }
    int bandera = 0;

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(h)) {
            if (j.getText().isEmpty() || k.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Faltan uno o más números.");
            } else {
                try {
                    Operaciones Aa = new Operaciones(Integer.parseInt(j.getText()), Integer.parseInt(k.getText()));
                    switch (i.getSelectedItem()) {
                        case "Sumar":
                            l.setText("Suma Es   Igual: " + Aa.Sumar());
                            break;
                        case "Restar":
                            l.setText("Resta Es Igual: " + Aa.Restar());
                            break;
                        case "Multiplicar":
                            l.setText("Multiplicación Es Igual: " + Aa.Multiplicar());
                            break;
                        case "Dividir":
                            l.setText("Dividir Es Igual: " + Aa.Dividir());
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Por favor seleccione una operación");
                            break;
                    }
                    j.setEnabled(false);
                    k.setEnabled(false);
                    d.setEnabled(false);
                    f.setEnabled(false);
                    i.setEnabled(false);
                    bandera = 0;
                    b.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent e) {
                            if (e.getClickCount() != 0 && bandera == 0) {
                                JOptionPane.showMessageDialog(null, "Debe Resetear los campos");
                            }

                        }
                    });
                } catch (Exception io) {
                    JOptionPane.showMessageDialog(null, "Error en las operaciones, en la mayoria de los casos ocurre por divición entre cero");
                }
            }
        }
        if (ae.getSource().equals(m)) {
            j.setEnabled(true);
            j.setText(null);
            k.setEnabled(true);
            k.setText(null);
            d.setEnabled(true);
            f.setEnabled(true);
            l.setText(null);
            i.setEnabled(true);
            bandera = 1;
        }
    }

    public void this_mousePressed(MouseEvent e) {
        System.out.println("fghjfnjkfgnlif");
    }
}
