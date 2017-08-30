package Frame;

import Motor.B;
import Motor.D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Fvisual extends MouseAdapter implements ActionListener {//debemos hacerlo para poder capturarar el evento del clic

    public class Imagen extends javax.swing.JPanel {

        public Imagen() {
            this.setSize(a.getWidth(), a.getHeight()); //se selecciona el tamaño del panel
        }

        //Se crea un método cuyo parámetro debe ser un objeto Graphics
        public void paint(Graphics grafico) {
            Dimension height = getSize();
            //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
            ImageIcon Img = new ImageIcon(getClass().getResource("/Complements/bg.jpg"));

            //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
            grafico.drawImage(Img.getImage(), 0, 0, a.getWidth(), a.getHeight(), null);

            setOpaque(false);
            super.paintComponent(grafico);
        }
    }

    public class Imagen2 extends javax.swing.JPanel {

        public Imagen2() {
            this.setSize(b.getWidth(), b.getHeight()); //se selecciona el tamaño del panel
        }

        //Se crea un método cuyo parámetro debe ser un objeto Graphics
        public void paint(Graphics grafico) {
            Dimension height = getSize();
            //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
            ImageIcon Img = new ImageIcon(getClass().getResource("/Complements/bg2.jpg"));

            //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
            grafico.drawImage(Img.getImage(), 0, 0, b.getWidth(), b.getHeight(), null);

            setOpaque(false);
            super.paintComponent(grafico);
        }
    }

    public class Imagen3 extends javax.swing.JPanel {

        public Imagen3() {
            this.setSize(c.getWidth(), c.getHeight()); //se selecciona el tamaño del panel
        }

        //Se crea un método cuyo parámetro debe ser un objeto Graphics
        public void paint(Graphics grafico) {
            Dimension height = getSize();
            //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
            ImageIcon Img = new ImageIcon(getClass().getResource("/Complements/bg.jpg"));

            //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
            grafico.drawImage(Img.getImage(), 0, 0, c.getWidth(), c.getHeight(), null);

            setOpaque(false);
            super.paintComponent(grafico);
        }
    }

    public class Imagen4 extends javax.swing.JPanel {

        public Imagen4() {
            this.setSize(d.getWidth(), d.getHeight()); //se selecciona el tamaño del panel
        }

        //Se crea un método cuyo parámetro debe ser un objeto Graphics
        public void paint(Graphics grafico) {
            Dimension height = getSize();
            //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
            ImageIcon Img = new ImageIcon(getClass().getResource("/Complements/bg4.jpg"));

            //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
            grafico.drawImage(Img.getImage(), 0, 0, d.getWidth(), d.getHeight(), null);

            setOpaque(false);
            super.paintComponent(grafico);
        }
    }
    Frame a;
    Panel b, c, d;
    Label i, j;//no colocar e como variable, los escuchadores la suelen tomar
    JLabel f, h, g;
    TextField k, l;
    ButtonGroup m;
    JCheckBox n, o, p, q;//cuatro sistemas numericos
    List r;

    public void Enabl() {
        c.setEnabled(true);
        k.setEnabled(true);
        n.setEnabled(false);
        o.setEnabled(false);
        p.setEnabled(false);
        q.setEnabled(false);
    }

    private void binarios(KeyEvent e) {
        char c = e.getKeyChar();
        if (((c < '0') || (c > '1')) && (c != KeyEvent.VK_BACK_SPACE)) {
            e.consume();
        }
        if (!(c == '0' || c == '1' || c == '\b')) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, usted eligió binario, por lo tanto no puede ingresar ningun otro caracter diferente de 1 o 0");
        }
    }

    private void Decimales(KeyEvent e) {
        char c = e.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            e.consume();
        }
        if (!(!((c < '0') || (c > '9')) || c == '\b')) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, usted eligió decimal, por lo tanto no puede ingresar ningun otro caracter diferente de 1,2,3,4,5,6,7,8,9,0");
        }
    }

    private void Octales(KeyEvent e) {
        char ccc = e.getKeyChar();
        if (((ccc < '0') || (ccc > '7')) && (ccc != KeyEvent.VK_BACK_SPACE)) {
            e.consume();
        }
        if (!(!((ccc < '0') || (ccc > '7')) || ccc == '\b')) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, usted eligió octales, por lo tanto no puede ingresar ningun otro caracter diferente de 1,2,3,4,5,6,7,0");
        }
    }

    private void Hexa(KeyEvent e) {
        char c = e.getKeyChar();
        if (((c < '0') || (c > '9')) && ((c < 'A') || (c > 'F')) && ((c < 'a') || (c > 'f')) && (c != KeyEvent.VK_BACK_SPACE)) {
            e.consume();
        }
        if (!(!((c < '0') || (c > '9')) || c == '\b' || !((c < 'A') || (c > 'F')) || !((c < 'a') || (c > 'f')))) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, usted eligió Hexadecimal, por lo tanto no puede ingresar ningun otro caracter diferente de\n 1,2,3,4,5,6,7,8,9,0,a,b,c,d,e,f,A,B,C,D,E,F");
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(n)) {
            Enabl();
            k.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    binarios(e);
                }
            });
        }
        if (ae.getSource().equals(o)) {
            Enabl();
            k.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    Decimales(e);
                }
            });

        }
        if (ae.getSource().equals(p)) {
            Enabl();
            k.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    Hexa(e);
                }
            });
        }
        if (ae.getSource().equals(q)) {
            Enabl();
            k.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    Octales(e);
                }
            });
        }
    }

    public void PanelB() {
        //S Componets panel
        g = new JLabel("Digite el sistema númerico:");
        g.setBounds(5, 20, 170, 30);

        b.add(g);
        //system number
        o = new JCheckBox("Deceimal");
        o.setBounds(20, 50, 90, 30);
        o.addActionListener(this);
        o.setOpaque(false);

        n = new JCheckBox("Binario");
        n.setBounds(120, 50, 90, 30);
        n.addActionListener(this);
        n.setOpaque(false);

        p = new JCheckBox("Hexadecimal");
        p.setBounds(20, 90, 90, 30);//truquito
        p.setOpaque(false);
        p.addActionListener(this);

        q = new JCheckBox("Octal");
        q.setBounds(120, 90, 90, 30);
        q.setOpaque(false);
        q.addActionListener(this);

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
        f = new JLabel("Digíte su numero: ");
        f.setBounds(5, 130, 150, 30);//recuerda que ya no es con respecto al frame=a, si no con respecto al panel
        f.setOpaque(false);
        b.add(f);//recordad el layout tambien aplica a los pnales.

        k = new TextField();
        k.setBounds(70, 160, 150, 30);
        k.setEnabled(false);
        k.addMouseListener(this);
        b.add(k);
        Imagen2 aa = new Imagen2();
        b.add(aa);
        b.repaint();

    }

    public void PanelC() {
        h = new JLabel("¿A qué sistema númerico lo convertirá?");
        h.setBounds(5, 20, 235, 30);// a la medida, o podriamos usar Jlabel y configurarlo por html para qur se centace
        h.setOpaque(false);
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
        Imagen3 aa = new Imagen3();
        c.add(aa);
        c.repaint();
    }

    public void PaneD() {
        Imagen4 aa = new Imagen4();
        d.add(aa);
        d.repaint();
    }

    public void Complements() {
        //S paneles
        b = new Panel();
        b.setBounds(30, 50, 250, 200);
        b.setBackground(new Color(245, 245, 245));
        b.setLayout(null);
        PanelB();

        c = new Panel();
        c.setBounds(330, 50, 250, 200);
        c.setBackground(new Color(255, 223, 223));
        c.setLayout(null);
        PanelC();

        d = new Panel();
        d.setBounds((600 - 300) / 2, 300, 300, 170);//centra lo que sea
        d.setBackground(Color.ORANGE);
        d.setLayout(null);
        PaneD();

        c.setEnabled(false);
    }

    public void Frame() {
        a = new Frame("ConverNum");
        a.setSize(600, 500);
        a.setLayout(null);

        a.add(b);
        a.add(c);
        a.add(d);
        Imagen img = new Imagen();
        a.add(img);
        a.repaint();

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

    public void bin() {
        B Bin = new B();
        try {
            switch (r.getSelectedItem()) {
                case "Binario":
                    JOptionPane.showMessageDialog(null, Bin.Res(k.getText(), 1));
                    break;
                case "Decimal":
                    JOptionPane.showMessageDialog(null, Bin.Res(k.getText(), 2));
                    break;
                case "Octal":
                    JOptionPane.showMessageDialog(null, Bin.Res(k.getText(), 3));
                    break;
                case "Hexadecimal":
                    JOptionPane.showMessageDialog(null, Bin.Res(k.getText(), 4));
                    break;
                default:
                    System.out.println("Error");
                    break;
            }//el error se produce por la textf nula, ya arreglaé eso
        } catch (Exception io) {
            System.err.println("Error binarios");
        }
    }

    public void dec() {
        D dec = new D();
        try {
            switch (r.getSelectedItem()) {
                case "Binario":
                    JOptionPane.showMessageDialog(null, dec.Res(k.getText(), 1));
                    break;
                case "Decimal":
                    JOptionPane.showMessageDialog(null, dec.Res(k.getText(), 2));
                    break;
                case "Octal":
                    JOptionPane.showMessageDialog(null, dec.Res(k.getText(), 3));
                    break;
                case "Hexadecimal":
                    JOptionPane.showMessageDialog(null, dec.Res(k.getText(), 4));
                    break;
                default:
                    System.out.println("Error");
                    break;
            }//el error se produce por la textf nula, ya arreglaé eso
        } catch (Exception io) {
            System.err.println("Error decimales");
        }
    }

    public void Option(int a) {
        switch (a) {
            case 1:
                bin();
                break;
            case 2:
                dec();
                break;
        }
    }
//    int ban=1;
//    boolean numBan=true;

    public void mouseReleased(java.awt.event.MouseEvent e) {//ojo evento...debemo agregarlo al componente, vamos a ver si funciona
//        if (e.getButton() == 3) {//voy  a probar algo a ver si funciona
//            Option();
//        } else 
        if (e.getButton() == 1) {
            if (o.isSelected()) {
                Option(2);
            } else if (n.isSelected()) {
                Option(1);
            } else if (p.isSelected()) {

            } else if (q.isSelected()) {

            }
            System.out.println("seleccioné o");

        }
    }

}

//vamos a construir el motor, una vez lo tengamos, entonces, seguimos con la visual
//para no hacer largo el video, voy a usar el motor que creé hace un semestre, para éste tipo de conversiones
//yo os dejaré el link en la descropción del video.
