package Vent;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;

public final class Clases implements ActionListener {

    Frame a;
    Label b, c, i;
    TextField j, g;
    Button h;

    public void Compooent() {
        b = new Label("Sumando 1");
        b.setBounds(10, 50, 100, 20);

        c = new Label("Sumando 2");
        c.setBounds(10, 100, 100, 20);
        Font myFont = new Font("Serif", Font.ITALIC, 15);
        c.setFont(myFont);
        c.setForeground(Color.CYAN);

        j = new TextField();
        j.setBounds(150, 50, 100, 20);

        g = new TextField();
        g.setBounds(150, 100, 100, 20);

        i = new Label();
        i.setBounds((300 - 100) / 2, 200, 200, 30);

        h = new Button("Sumar");
        h.setBounds((300 - 100) / 2, 160, 100, 30);
        h.addActionListener(this);

    }

    public void FrameCre(String title) {
        a = new Frame(title);
        a.setSize(300, 400);
        a.setBackground(Color.PINK);
        a.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        }
        );

        a.setLayout(null);
        a.add(b);
        a.add(c);
        a.add(j);
        a.add(g);
        a.add(h);
        a.add(i);

        a.setLocationRelativeTo(null);
        a.setResizable(false);
        a.setVisible(true);
    }

    public Clases(String title) {
        Compooent();
        FrameCre(title);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(h)) {
            i.setText("la suma es " + (Integer.parseInt(g.getText()) + Integer.parseInt(j.getText())));
        }
    }

}
