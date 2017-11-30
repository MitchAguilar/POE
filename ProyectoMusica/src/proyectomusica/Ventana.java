package proyectomusica;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import static java.lang.Thread.sleep;
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
public class Ventana implements ActionListener {

    JFrame Ventana_Principal;
    JButton Aceptar, Salir, BotonTiempoFiguras, BotonSonidosInstrumento, BotonInstrumentosCaen;
    JLabel MusicosGif;
    Cursor c;
    Sonido son;

    public void Componentes() {

        Aceptar = new JButton("");
        Aceptar.setBounds(450, 330, 230, 80);
        Aceptar.setBackground(Color.WHITE);
        Aceptar.addActionListener(this);
        Font fondo2 = new Font("Serif", Font.ITALIC, 15);
        Aceptar.setFont(fondo2);
        Aceptar.setForeground(Color.WHITE);
        URL IconodeAcetar = this.getClass().getResource("/Imagenes/Icono.png");
        Aceptar.setIcon(new ImageIcon(IconodeAcetar));
        Aceptar.setOpaque(false);
        Aceptar.setBorder(null);

        Salir = new JButton("");
        Salir.setBounds(940, 10, 50, 50);
        Salir.setBackground(Color.RED);
        Salir.addActionListener(this);
        Salir.setFont(fondo2);
        Salir.setForeground(Color.WHITE);
        URL IconoSalir = this.getClass().getResource("/Imagenes/IconoSalir.png");
        Salir.setIcon(new ImageIcon(IconoSalir));
        Salir.setOpaque(false);
        Salir.setBorder(null);

        BotonTiempoFiguras = new JButton("Figuras Musicales");
        BotonTiempoFiguras.setBounds(50, 400, 200, 40);
        BotonTiempoFiguras.setBackground(Color.WHITE);
        BotonTiempoFiguras.addActionListener(this);
        BotonTiempoFiguras.setFont(fondo2);
        BotonTiempoFiguras.setForeground(Color.BLACK);
//        URL BotonTiempoFigurass = this.getClass().getResource("/Imagenes/IconoSalir.png");
//        BotonTiempoFiguras.setIcon(new ImageIcon(BotonTiempoFigurass));
//        BotonTiempoFiguras.setOpaque(false);
//        BotonTiempoFiguras.setBorder(null);

        BotonSonidosInstrumento = new JButton("Adivina el Instrumento");
        BotonSonidosInstrumento.setBounds(50, 300, 200, 40);
        BotonSonidosInstrumento.setBackground(Color.WHITE);
        BotonSonidosInstrumento.addActionListener(this);
        BotonSonidosInstrumento.setFont(fondo2);
        BotonSonidosInstrumento.setForeground(Color.BLACK);
//        URL BotonSonidosInstrumentow = this.getClass().getResource("/Imagenes/IconoSalir.png");
//        BotonSonidosInstrumento.setIcon(new ImageIcon(BotonSonidosInstrumentow));
//        BotonSonidosInstrumento.setOpaque(false);
//        BotonSonidosInstrumento.setBorder(null);

        BotonInstrumentosCaen = new JButton("Instumentos al aire");
        BotonInstrumentosCaen.setBounds(50, 500, 200, 40);
        BotonInstrumentosCaen.setBackground(Color.WHITE);
        BotonInstrumentosCaen.addActionListener(this);
        BotonInstrumentosCaen.setFont(fondo2);
        BotonInstrumentosCaen.setForeground(Color.BLACK);
//        URL BotonInstrumentosCaena = this.getClass().getResource("/Imagenes/IconoSalir.png");
//        BotonInstrumentosCaen.setIcon(new ImageIcon(BotonInstrumentosCaena));
//        BotonInstrumentosCaen.setOpaque(false);
//        BotonInstrumentosCaen.setBorder(null);

        //-----------------------------------------------------------------Label
        MusicosGif = new JLabel("aa");
        MusicosGif.setBounds(330, 520, 250, 120);
        MusicosGif.setForeground(Color.BLUE);
        //        MusicosGif.setBackground(Color.WHITE);    
        MusicosGif.setOpaque(false); // Quita el fondo
        URL Puesto11 = this.getClass().getResource("/Imagenes/Musicos3.gif");
        MusicosGif.setIcon(new ImageIcon(Puesto11));

    }

    public Ventana() {
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
        Ventana_Principal.add(Salir);
        Ventana_Principal.add(BotonTiempoFiguras);
        Ventana_Principal.add(BotonSonidosInstrumento);
        Ventana_Principal.add(BotonInstrumentosCaen);
//        Ventana_Principal.add(MusicosGif);

        Ventana_Principal.setUndecorated(true);//Quitar el boton de cerrar y los otros

        Imagen img = new Imagen("/Imagenes/FondoN2.jpg", Ventana_Principal.getWidth(), Ventana_Principal.getHeight());
        Ventana_Principal.add(img);
        Ventana_Principal.repaint();
        Ventana_Principal.setResizable(false); // No maximizar
        Ventana_Principal.setVisible(true); // Para que lo muestre
        Ventana_Principal.setLocationRelativeTo(null); // aparesca en el centro
        Ventana_Principal.setDefaultCloseOperation(Ventana_Principal.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(Salir)) {
            try {
                son = new Sonido("/Sonido/Final.wav");
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (int i = 1; i <= 10; i++) {
                try {
                    sleep(250);
                    System.out.println("" + i);
                } catch (InterruptedException ex) {
                    Logger.getLogger(VentanaInicio.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (i == 10) {
                    System.exit(0);
                }

            }
        }
        if (e.getSource().equals(BotonTiempoFiguras)) {

            try {
                son = new Sonido("/Sonido/Entrada.wav");
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
//            
            Ventana_Principal.dispose(); // cierro la ventana
            VentanaUnirNotas x = new VentanaUnirNotas();
        }
        if (e.getSource().equals(BotonSonidosInstrumento)) {

            try {
                son = new Sonido("/Sonido/Entrada.wav");
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }

            Ventana_Principal.dispose(); // cierro la ventana
            VentanaEntrarSonidos x1 = new VentanaEntrarSonidos();
        }

        if (e.getSource().equals(BotonInstrumentosCaen)) {

            try {
                son = new Sonido("/Sonido/Entrada.wav");
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
            Ventana_Principal.dispose(); // cierro la ventana
            VentanaInstrumentosCaen x2 = new VentanaInstrumentosCaen();
        }

    }

}
