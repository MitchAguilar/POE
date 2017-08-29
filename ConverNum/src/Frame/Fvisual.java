package Frame;

import Motor.B;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public class Fvisual extends MouseAdapter {//debemos hacerlo para poder capturarar el evento del clic

    Frame a;
    Panel b, c, d;
    Label f, g, h, i, j;//no colocar e como variable, los escuchadores la suelen tomar
    TextField k, l;
    ButtonGroup m;
    JCheckBox n, o, p, q;//cuatro sistemas numericos
    List r;

    public void PanelB() {
        //S Componets panel
        g = new Label("Digite el sistema númerico:");
        g.setBounds(5, 20, 170, 30);
        b.add(g);
        //system number
        o = new JCheckBox("Deceimal");
        o.setBounds(20, 50, 90, 30);

        n = new JCheckBox("Binario");
        n.setBounds(120, 50, 90, 30);

        p = new JCheckBox("Hexadecimal");
        p.setBounds(20, 90, 90, 30);//truquito

        q = new JCheckBox("Octal");
        q.setBounds(120, 90, 90, 30);

        //añade al grupo de botones
        m = new ButtonGroup();
        m.add(o);//vamos a hacer una pequeña trampita, saltandonos a la siguiente lib...y así podemos usar el button debido a que con awt el proceso es diferente
        m.add(n);
        m.add(p);
        m.add(q);

        //añade al panel
        b.add(o);
        b.add(n);
        b.add(p);
        b.add(q);
        //vamos a organizar mejor nuestro código, por paneles
        f = new Label("Digíte su numero: ");
        f.setBounds(5, 130, 150, 30);//recuerda que ya no es con respecto al frame=a, si no con respecto al panel
        b.add(f);//recordad el layout tambien aplica a los pnales.

        k = new TextField();
        k.setBounds(70, 160, 150, 30);
        b.add(k);
    }

    public void PanelC() {
        h = new Label("A qué sistema númerico desea convertirlo.");
        h.setBounds(5, 20, 235, 30);// a la medida, o podriamos usar Jlabel y configurarlo por html para qur se centace
        c.add(h);

        //ahora lo más interesante, eso es como vamos a permitir que el usuario elija el sistema al cual lo va a comvertir
        //una de esas formas es un choice, o una list, como mi preferencia para ésto es usar awt.
        //me voy por un choice
        r = new List();
        r.add("Decimal");
        r.add("Binario");
        r.add("Hexadecimal");
        r.add("Octal");
        r.setBounds((250 - 100) / 2, 70, 100, 70);
        r.addMouseListener(this);
        c.add(r);// de ser list, miren; ACABO DE CAMBIAR DE OPINION, ME VOY POR LA LIST

    }

    public void Complements() {
        //S paneles
        b = new Panel();
        b.setBounds(30, 50, 250, 200);
        b.setBackground(Color.YELLOW);
        b.setLayout(null);
        PanelB();

        c = new Panel();
        c.setBounds(330, 50, 250, 200);
        c.setBackground(Color.CYAN);
        c.setLayout(null);
        PanelC();

        d = new Panel();
        d.setBounds((600 - 300) / 2, 300, 300, 170);//centra lo que sea
        d.setBackground(Color.ORANGE);
        d.setLayout(null);

    }

    public void Frame() {
        a = new Frame("ConverNum");
        a.setSize(600, 500);
        a.setLayout(null);

        a.add(b);
        a.add(c);
        a.add(d);

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

    public Fvisual() {
        Complements();
        Frame();
    }
    public void Option(){
         B Bin = new B();
            switch (r.getSelectedItem()) {
                case "Binario":
                    System.out.println(Bin.Res(k.getText(), 1));
                    break;
                case "Decimal":
                    System.out.println(Bin.Res(k.getText(), 2));
                    break;
                case "Octal":
                    System.out.println(Bin.Res(k.getText(), 3));
                    break;
                case "Hexadecimal":
                    System.out.println(Bin.Res(k.getText(), 4));
                    break;
            }//el error se produce por la textf nula, ya arreglaé eso
    }
    public void mouseReleased(java.awt.event.MouseEvent e) {//ojo evento...debemo agregarlo al componente, vamos a ver si funciona
        if (e.getButton() == 3) {//voy  a probar algo a ver si funciona
            Option();
        } else if (e.getButton() == 1) {
           Option();
        }//soy el puto amo!!!!!!! ok, no :( ahora viene la magia
    }
}

//vamos a construir el motor, una vez lo tengamos, entonces, seguimos con la visual
//para no hacer largo el video, voy a usar el motor que creé hace un semestre, para éste tipo de conversiones
//yo os dejaré el link en la descropción del video.
