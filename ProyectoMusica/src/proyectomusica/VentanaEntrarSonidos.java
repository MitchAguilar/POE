package proyectomusica;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
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
public class VentanaEntrarSonidos implements ActionListener, MouseMotionListener {

    Cursor c;
    JFrame Ventana_Principal;
    JButton Aceptar, RetrocesoPagPrincipal;
    JButton PlayBoton1, PlayBoton2, PlayBoton3, PlayBoton4;
    JLabel GuitarraLabel, PianoLabel, TrombonLabel, TrompetaLabel;
    JLabel Puesto1, Puesto2, Puesto3, Puesto4;
    JLabel Titulo1;
    Sonido son;

    public void Componentes() {

        //---------------------------------------------------------------Botones
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

        PlayBoton1 = new JButton("");
        PlayBoton1.setBounds(900, 130, 60, 60);
        PlayBoton1.setBackground(Color.RED);
        PlayBoton1.addActionListener(this);
        PlayBoton1.setFont(fondo2);
        PlayBoton1.setForeground(Color.WHITE);
        URL PlayBoton11 = this.getClass().getResource("/Imagenes/BotonPlay.png");
        PlayBoton1.setIcon(new ImageIcon(PlayBoton11));
        PlayBoton1.setOpaque(false);
        PlayBoton1.setBorder(null);

        PlayBoton2 = new JButton("");
        PlayBoton2.setBounds(900, 260, 60, 60);
        PlayBoton2.setBackground(Color.RED);
        PlayBoton2.addActionListener(this);
        PlayBoton2.setFont(fondo2);
        PlayBoton2.setForeground(Color.WHITE);
        URL PlayBoton21 = this.getClass().getResource("/Imagenes/BotonPlay.png");
        PlayBoton2.setIcon(new ImageIcon(PlayBoton21));
        PlayBoton2.setOpaque(false);
        PlayBoton2.setBorder(null);

        PlayBoton3 = new JButton("");
        PlayBoton3.setBounds(900, 400, 60, 60);
        PlayBoton3.setBackground(Color.RED);
        PlayBoton3.addActionListener(this);
        PlayBoton3.setFont(fondo2);
        PlayBoton3.setForeground(Color.WHITE);
        URL PlayBoton31 = this.getClass().getResource("/Imagenes/BotonPlay.png");
        PlayBoton3.setIcon(new ImageIcon(PlayBoton31));
        PlayBoton3.setOpaque(false);
        PlayBoton3.setBorder(null);

        PlayBoton4 = new JButton("");
        PlayBoton4.setBounds(900, 530, 60, 60);
        PlayBoton4.setBackground(Color.RED);
        PlayBoton4.addActionListener(this);
        PlayBoton4.setFont(fondo2);
        PlayBoton4.setForeground(Color.WHITE);
        URL PlayBoton41 = this.getClass().getResource("/Imagenes/BotonPlay.png");
        PlayBoton4.setIcon(new ImageIcon(PlayBoton41));
        PlayBoton4.setOpaque(false);
        PlayBoton4.setBorder(null);

        //-----------------------------------------------------------------Label
        GuitarraLabel = new JLabel("");
        GuitarraLabel.setBounds(100, 100, 120, 120);
        GuitarraLabel.setForeground(Color.BLUE);
        GuitarraLabel.setOpaque(false); // Quita el fondo
        URL carro1 = this.getClass().getResource("/Imagenes/Guitarra.gif");
        GuitarraLabel.setIcon(new ImageIcon(carro1));
        GuitarraLabel.addMouseMotionListener(this);
        GuitarraLabel.setDoubleBuffered(false);

        TrompetaLabel = new JLabel("");
        TrompetaLabel.setBounds(100, 230, 120, 120);
        TrompetaLabel.setForeground(Color.BLUE);
        TrompetaLabel.setOpaque(false); // Quita el fondo
        URL TrompetaLabel1 = this.getClass().getResource("/Imagenes/Trompeta.gif");
        TrompetaLabel.setIcon(new ImageIcon(TrompetaLabel1));
        TrompetaLabel.addMouseMotionListener(this);
        TrompetaLabel.setDoubleBuffered(false);

        PianoLabel = new JLabel("");
        PianoLabel.setBounds(100, 360, 120, 120);
        PianoLabel.setForeground(Color.BLUE);
        PianoLabel.setOpaque(false); // Quita el fondo
        URL PianoLabel1 = this.getClass().getResource("/Imagenes/Piano.gif");
        PianoLabel.setIcon(new ImageIcon(PianoLabel1));
        PianoLabel.addMouseMotionListener(this);
        PianoLabel.setDoubleBuffered(false);

        TrombonLabel = new JLabel("");
        TrombonLabel.setBounds(100, 490, 120, 120);
        TrombonLabel.setForeground(Color.BLUE);
        TrombonLabel.setOpaque(false); // Quita el fondo
        URL TrombonLabel1 = this.getClass().getResource("/Imagenes/Trombon.gif");
        TrombonLabel.setIcon(new ImageIcon(TrombonLabel1));
        TrombonLabel.addMouseMotionListener(this);
        TrombonLabel.setDoubleBuffered(false);

        //Puesto1,Puesto2,Puesto3,Puesto4;
        Puesto1 = new JLabel("");
        Puesto1.setBounds(750, 100, 120, 120);
        Puesto1.setForeground(Color.BLUE);
        Puesto1.setOpaque(false); // Quita el fondo
        URL Puesto11 = this.getClass().getResource("/Imagenes/Pregunta.gif");
        Puesto1.setIcon(new ImageIcon(Puesto11));

        Puesto2 = new JLabel("");
        Puesto2.setBounds(750, 230, 120, 120);
        Puesto2.setForeground(Color.BLUE);
        Puesto2.setOpaque(false); // Quita el fondo
        URL Puesto21 = this.getClass().getResource("/Imagenes/Pregunta.gif");
        Puesto2.setIcon(new ImageIcon(Puesto21));

        Puesto3 = new JLabel("");
        Puesto3.setBounds(750, 360, 120, 120);
        Puesto3.setForeground(Color.BLUE);
        Puesto3.setOpaque(false); // Quita el fondo
        URL Puesto31 = this.getClass().getResource("/Imagenes/Pregunta.gif");
        Puesto3.setIcon(new ImageIcon(Puesto31));

        Puesto4 = new JLabel("");
        Puesto4.setBounds(750, 490, 120, 120);
        Puesto4.setForeground(Color.BLUE);
        Puesto4.setOpaque(false); // Quita el fondo
        URL Puesto41 = this.getClass().getResource("/Imagenes/Pregunta.gif");
        Puesto4.setIcon(new ImageIcon(Puesto41));

        //Titulos
        Titulo1 = new JLabel("");
        Titulo1.setBounds((1000 - 600) / 2, 10, 600, 80);
        Titulo1.setForeground(Color.BLUE);
        Titulo1.setOpaque(false); // Quita el fondo
        URL Titulo11 = this.getClass().getResource("/Imagenes/Titulos/Titulo6.png");
        Titulo1.setIcon(new ImageIcon(Titulo11));

    }

    public VentanaEntrarSonidos() {
        Componentes();
        Frame();
    }

    public void Frame() {
        Ventana_Principal = new JFrame("Configuracion");
        Ventana_Principal.setSize(1000, 650);
        Ventana_Principal.setLayout(null); // organizar sin dar posiciones
        Image icono = new ImageIcon(getClass().getResource("/Imagenes/Icono.png")).getImage(); //Icono
        Ventana_Principal.setIconImage(icono);//Agregando el icono y cambiando

        //--------------------------------------------------------Para el cursor
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image iconoMaus = new ImageIcon(getClass().getResource("/Imagenes/Punteros/Puntero7.png")).getImage(); //Icono
        c = tk.createCustomCursor(iconoMaus, new Point(1, 1), "String");
        Ventana_Principal.setCursor(c);

        Ventana_Principal.setBackground(Color.WHITE);
        Ventana_Principal.add(RetrocesoPagPrincipal);
        Ventana_Principal.add(GuitarraLabel);
        Ventana_Principal.add(TrompetaLabel);
        Ventana_Principal.add(PianoLabel);
        Ventana_Principal.add(TrombonLabel);
        Ventana_Principal.add(Puesto1);
        Ventana_Principal.add(Puesto2);
        Ventana_Principal.add(Puesto3);
        Ventana_Principal.add(Puesto4);
        Ventana_Principal.add(PlayBoton1);
        Ventana_Principal.add(PlayBoton2);
        Ventana_Principal.add(PlayBoton3);
        Ventana_Principal.add(PlayBoton4);
        Ventana_Principal.add(Titulo1);

        Ventana_Principal.setUndecorated(true);//Quitar el boton de cerrar y los otros

        Imagen img = new Imagen("/Imagenes/FondoInSuenan3.jpg", Ventana_Principal.getWidth(), Ventana_Principal.getHeight());
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
        if (e.getSource().equals(PlayBoton1)) {
            try {
                son = new Sonido("/Sonido/Piano.wav");

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                Logger.getLogger(VentanaEntrarSonidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (e.getSource().equals(PlayBoton2)) {
            try {
                son = new Sonido("/Sonido/Trombon.wav");
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (e.getSource().equals(PlayBoton3)) {
            try {
                son = new Sonido("/Sonido/Guitarra.wav");
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (e.getSource().equals(PlayBoton4)) {
            try {
                son = new Sonido("/Sonido/Trompeta.wav");
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {

        if (e.getSource().equals(GuitarraLabel)) {

            if (GuitarraLabel.getX() > 0 && GuitarraLabel.getY() > 0) {
                GuitarraLabel.setLocation(GuitarraLabel.getX() + e.getX() - GuitarraLabel.getWidth() / 2, GuitarraLabel.getY() + e.getY() - GuitarraLabel.getHeight() / 2);
            } else {
                GuitarraLabel.setLocation(GuitarraLabel.getX() + 1, GuitarraLabel.getY() + 1);
            }
        }

        if (e.getSource().equals(PianoLabel)) {

            if (PianoLabel.getX() > 0 && PianoLabel.getY() > 0) {
                PianoLabel.setLocation(PianoLabel.getX() + e.getX() - PianoLabel.getWidth() / 2, PianoLabel.getY() + e.getY() - PianoLabel.getHeight() / 2);
            } else {
                PianoLabel.setLocation(PianoLabel.getX() + 1, PianoLabel.getY() + 1);
            }
        }

        if (e.getSource().equals(TrombonLabel)) {

            if (TrombonLabel.getX() > 0 && TrombonLabel.getY() > 0) {
                TrombonLabel.setLocation(TrombonLabel.getX() + e.getX() - TrombonLabel.getWidth() / 2, TrombonLabel.getY() + e.getY() - TrombonLabel.getHeight() / 2);
            } else {
                TrombonLabel.setLocation(TrombonLabel.getX() + 1, TrombonLabel.getY() + 1);
            }
        }
        if (e.getSource().equals(TrompetaLabel)) {

            if (TrompetaLabel.getX() > 0 && TrompetaLabel.getY() > 0) {
                TrompetaLabel.setLocation(TrompetaLabel.getX() + e.getX() - TrompetaLabel.getWidth() / 2, TrompetaLabel.getY() + e.getY() - TrompetaLabel.getHeight() / 2);
            } else {
                TrompetaLabel.setLocation(TrompetaLabel.getX() + 1, TrompetaLabel.getY() + 1);
            }
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
      
    }

}
