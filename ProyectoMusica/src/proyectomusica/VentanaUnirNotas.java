package proyectomusica;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Daviid
 */
public class VentanaUnirNotas implements ActionListener {

    JFrame Ventana_Principal;
    JButton Aceptar, RetrocesoPagPrincipal;
    JLabel RedondaLabel, BlancaLabel, NegraLabel, CorcheaLabel, ClaveSolLabel, ClaveFaLabel, ClaveDoLabel;
    TextField RedondaCampo, BlancaCampo, NegraCampo, CorcheaCampo, ClaveSolCampo, ClaveFaCampo, ClaveDoCampo;
    JLabel Titulo1, Titulo2;
    Cursor c;
    Bloque xx = new Bloque(); // llamando desde bloquear
    Sonido son;

    public void Componentes() {

        Aceptar = new JButton("");
        Aceptar.setBounds(450, 330, 230, 80);
        Aceptar.setBackground(Color.BLUE);
        Aceptar.addActionListener(this);
        Font fondo2 = new Font("Serif", Font.ITALIC, 15);
        Aceptar.setFont(fondo2);
        Aceptar.setForeground(Color.WHITE);
//        URL IconodeAcetar = this.getClass().getResource("/Imagenes/IconoAcepar2_1.png");
//        Aceptar.setIcon(new ImageIcon(IconodeAcetar));
//        Aceptar.setOpaque(false);
//        Aceptar.setBorder(null);

        RetrocesoPagPrincipal = new JButton("");
        RetrocesoPagPrincipal.setBounds(10, 10, 50, 50);
        RetrocesoPagPrincipal.setBackground(Color.RED);
        RetrocesoPagPrincipal.addActionListener(this);
        RetrocesoPagPrincipal.setFont(fondo2);
        RetrocesoPagPrincipal.setForeground(Color.WHITE);
        URL IconoSalir = this.getClass().getResource("/Imagenes/Retroceso.png");
        RetrocesoPagPrincipal.setIcon(new ImageIcon(IconoSalir));
        RetrocesoPagPrincipal.setOpaque(false);
        RetrocesoPagPrincipal.setBorder(null);

        //Label
        RedondaLabel = new JLabel("");
        RedondaLabel.setBounds(100, 100, 120, 120);
        RedondaLabel.setForeground(Color.BLUE);
        RedondaLabel.setOpaque(false); // Quita el fondo
        URL Puesto11 = this.getClass().getResource("/Imagenes/Figuras/Redonda.jpg");
        RedondaLabel.setIcon(new ImageIcon(Puesto11));

        BlancaLabel = new JLabel("");
        BlancaLabel.setBounds(330, 100, 120, 120);
        BlancaLabel.setForeground(Color.BLUE);
        BlancaLabel.setOpaque(false); // Quita el fondo
        URL Puesto21 = this.getClass().getResource("/Imagenes/Figuras/Blanca.jpg");
        BlancaLabel.setIcon(new ImageIcon(Puesto21));

        NegraLabel = new JLabel("");
        NegraLabel.setBounds(570, 100, 120, 120);
        NegraLabel.setForeground(Color.BLUE);
        NegraLabel.setOpaque(false); // Quita el fondo
        URL Puesto31 = this.getClass().getResource("/Imagenes/Figuras/Negra.jpg");
        NegraLabel.setIcon(new ImageIcon(Puesto31));

        CorcheaLabel = new JLabel("");
        CorcheaLabel.setBounds(800, 100, 120, 120);
        CorcheaLabel.setForeground(Color.BLUE);
        CorcheaLabel.setOpaque(false); // Quita el fondo
        URL Puesto41 = this.getClass().getResource("/Imagenes/Figuras/Corchea.jpg");
        CorcheaLabel.setIcon(new ImageIcon(Puesto41));

        ClaveSolLabel = new JLabel("");
        ClaveSolLabel.setBounds(100, 400, 120, 120);
        ClaveSolLabel.setForeground(Color.BLUE);
        ClaveSolLabel.setOpaque(false); // Quita el fondo
        URL ClaveSolLabel1 = this.getClass().getResource("/Imagenes/Figuras/ClaveSol.jpg");
        ClaveSolLabel.setIcon(new ImageIcon(ClaveSolLabel1));

        ClaveFaLabel = new JLabel("");
        ClaveFaLabel.setBounds(330, 400, 120, 120);
        ClaveFaLabel.setForeground(Color.BLUE);
        ClaveFaLabel.setOpaque(false); // Quita el fondo
        URL ClaveFaLabel1 = this.getClass().getResource("/Imagenes/Figuras/ClaveFa.jpg");
        ClaveFaLabel.setIcon(new ImageIcon(ClaveFaLabel1));

        ClaveDoLabel = new JLabel("");
        ClaveDoLabel.setBounds(570, 400, 120, 120);
        ClaveDoLabel.setForeground(Color.BLUE);
        ClaveDoLabel.setOpaque(false); // Quita el fondo
        URL ClaveDoLabel1 = this.getClass().getResource("/Imagenes/Figuras/ClaveDo.jpg");
        ClaveDoLabel.setIcon(new ImageIcon(ClaveDoLabel1));

        Titulo1 = new JLabel("");
        Titulo1.setBounds((1000-400)/2, 10, 400, 80);
        Titulo1.setForeground(Color.BLUE);
        Titulo1.setOpaque(false); // Quita el fondo
        URL Titulo11 = this.getClass().getResource("/Imagenes/Titulos/Titulo2.png");
        Titulo1.setIcon(new ImageIcon(Titulo11));
        
        
        Titulo2 = new JLabel("");
        Titulo2.setBounds((1000-400)/2, 300, 206, 120);
        Titulo2.setForeground(Color.BLUE);
        Titulo2.setOpaque(false); // Quita el fondo
        URL Titulo21 = this.getClass().getResource("/Imagenes/Titulos/Titulo5.png");
        Titulo2.setIcon(new ImageIcon(Titulo21));
        
        

        // Textos
        Font TemaCampos = new Font("Serif", Font.ITALIC, 25);

        RedondaCampo = new TextField();
        RedondaCampo.setBounds(85, 240, 150, 35);
        RedondaCampo.setFont(TemaCampos);
        RedondaCampo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                xx.soloLetras(e);
            }
        });

        BlancaCampo = new TextField();
        BlancaCampo.setBounds(315, 240, 150, 35);
        BlancaCampo.setFont(TemaCampos);
        BlancaCampo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                xx.soloLetras(e);
            }
        });

        NegraCampo = new TextField();
        NegraCampo.setBounds(555, 240, 150, 35);
        NegraCampo.setFont(TemaCampos);
        NegraCampo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                xx.soloLetras(e);
            }
        });

        CorcheaCampo = new TextField();
        CorcheaCampo.setBounds(780, 240, 150, 35);
        CorcheaCampo.setFont(TemaCampos);
        CorcheaCampo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                xx.soloLetras(e);
            }
        });

        ClaveSolCampo = new TextField();
        ClaveSolCampo.setBounds(85, 550, 150, 35);
        ClaveSolCampo.setFont(TemaCampos);
        ClaveSolCampo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                xx.soloLetras(e);
            }
        });

        ClaveFaCampo = new TextField();
        ClaveFaCampo.setBounds(315, 550, 150, 35);
        ClaveFaCampo.setFont(TemaCampos);
        ClaveFaCampo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                xx.soloLetras(e);
            }
        });

        ClaveDoCampo = new TextField();
        ClaveDoCampo.setBounds(555, 550, 150, 35);
        ClaveDoCampo.setFont(TemaCampos);
        ClaveDoCampo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                xx.soloLetras(e);
            }
        });

    }

    public VentanaUnirNotas() {
        Componentes();
        Frame();
    }

    public void Frame() {
        Ventana_Principal = new JFrame("Configuracion");
        Ventana_Principal.setSize(1000, 650);
        Ventana_Principal.setLayout(null); // organizar sin dar posiciones
        Image icono = new ImageIcon(getClass().getResource("/Imagenes/Icono.png")).getImage(); //Icono
        Ventana_Principal.setIconImage(icono);//Agregando el icono y cambiando
        Ventana_Principal.setBackground(Color.WHITE);

        //--------------------------------------------------------Para el cursor
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image iconoMaus = new ImageIcon(getClass().getResource("/Imagenes/Punteros/Puntero7.png")).getImage(); //Icono
        c = tk.createCustomCursor(iconoMaus, new Point(1, 1), "String");
        Ventana_Principal.setCursor(c);

        Ventana_Principal.add(RetrocesoPagPrincipal);

        Ventana_Principal.add(RedondaLabel);
        Ventana_Principal.add(RedondaCampo);
        Ventana_Principal.add(BlancaLabel);
        Ventana_Principal.add(BlancaCampo);
        Ventana_Principal.add(NegraLabel);
        Ventana_Principal.add(NegraCampo);
        Ventana_Principal.add(CorcheaLabel);
        Ventana_Principal.add(CorcheaCampo);
        Ventana_Principal.add(ClaveSolLabel);
        Ventana_Principal.add(ClaveFaLabel);
        Ventana_Principal.add(ClaveDoLabel);
        Ventana_Principal.add(ClaveSolCampo);
        Ventana_Principal.add(ClaveFaCampo);
        Ventana_Principal.add(ClaveDoCampo);
        
        Ventana_Principal.add(Titulo1);
        Ventana_Principal.add(Titulo2);

        Ventana_Principal.setUndecorated(true);//Quitar el boton de cerrar y los otros

        Imagen img = new Imagen("/Imagenes/FondoFigurasMusicales.jpg", Ventana_Principal.getWidth(), Ventana_Principal.getHeight());
        Ventana_Principal.add(img);
        Ventana_Principal.repaint();
        Ventana_Principal.setResizable(false); // No maximizar
        Ventana_Principal.setVisible(true); // Para que lo muestre
        Ventana_Principal.setLocationRelativeTo(null); // aparesca en el centro
        Ventana_Principal.setDefaultCloseOperation(Ventana_Principal.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(RetrocesoPagPrincipal)) {
            
            try {
                son = new Sonido("/Sonido/Back.wav");
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
            Ventana_Principal.dispose(); // cierro la ventana
            Ventana xa = new Ventana();
        }

    }

}
