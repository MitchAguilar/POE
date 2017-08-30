package Frames;

import calculadoraNormal.Operaciones;
import calculadoraapi.CalculadoraApi;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CalApi implements ActionListener {

    Frame a;
    Panel b, c;
    Label d, f, g, l;
    Button h;
    Choice i;
    TextField j, k;

    public void Componets() {
        b = new Panel();
        b.setBounds(40, 50, 245, 200);
        b.setLayout(null);
        b.setBackground(Color.white);

        c = new Panel();
        c.setBounds(325, 50, 245, 200);
        c.setLayout(null);
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
        l.setBounds(250, 300, 200, 30);
    }

    public void FrameCom() {
        a = new Frame("CALCULADORA API");
        a.setSize(600, 400);
        a.setBackground(Color.CYAN);
        a.setLayout(null);

        a.add(b);
        a.add(c);
        a.add(l);

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

    public CalApi() {
        Componets();
        FrameCom();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(h)) {
            try {
                CalculadoraApi Aa = new CalculadoraApi();
                switch (i.getSelectedItem()) {
                    case "Sumar":
                        l.setText("Suma Es Igual: " + Aa.Operaciones("Sumar?N1="+j.getText()+"&N2="+k.getText()));
                        break;
                    case "Restar":
                        l.setText("Resta Es Igual: " + Aa.Operaciones("Restar?N1="+j.getText()+"&N2="+k.getText()));
                        break;
                    case "Multiplicar":
                        l.setText("Multiplicación Es Igual: " +Aa.Operaciones("Multiplicar?N1="+j.getText()+"&N2="+k.getText()));
                        break;
                    case "Dividir":
                        l.setText("Dividir Es Igual: " +Aa.Operaciones("Dividir?N1="+j.getText()+"&N2="+k.getText()));
                        break;
                    default:
                        l.setText("Not Found");
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(CalApi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
