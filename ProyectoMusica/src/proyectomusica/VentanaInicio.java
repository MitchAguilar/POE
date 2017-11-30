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
import static java.lang.Thread.sleep;

/**
 *
 * @author Daviid Ortiz
 */
public class VentanaInicio implements ActionListener {

    JFrame Ventana_Principal;
    JButton Comenzar, Salir;
    JLabel CargarGif;
    Cursor c;
    Sonido son;

    public void Componentes() {

        Comenzar = new JButton("Jugar");
        Comenzar.setBounds(410, 500, 150, 50);
        Comenzar.setBackground(Color.WHITE);
        Comenzar.addActionListener(this);
        Font fondo2 = new Font("Serif", Font.ITALIC, 30);
        Comenzar.setFont(fondo2);
        Comenzar.setForeground(Color.BLACK);
//        URL IconodeAcetar = this.getClass().getResource("/Imagenes/Icono.png");
//        Comenzar.setIcon(new ImageIcon(IconodeAcetar));
//        Comenzar.setOpaque(false);
//        Comenzar.setBorder(null);
        Comenzar.setVisible(false);

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

        //-----------------------------------------------------------------Label
        CargarGif = new JLabel("aa");
        CargarGif.setBounds(350, 440, 266, 148);
        CargarGif.setForeground(Color.BLUE);
        //        CargarGif.setBackground(Color.WHITE);    
        CargarGif.setOpaque(false); // Quita el fondo
        URL Puesto11 = this.getClass().getResource("/Imagenes/Cargando/Cargando11.gif");
        CargarGif.setIcon(new ImageIcon(Puesto11));

    }

    public VentanaInicio() {
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
        Ventana_Principal.add(Comenzar);

        Ventana_Principal.add(CargarGif);

        Ventana_Principal.setUndecorated(true);//Quitar el boton de cerrar y los otros

        Imagen img = new Imagen("/Imagenes/FondoEntrada.jpg", Ventana_Principal.getWidth(), Ventana_Principal.getHeight());
        Ventana_Principal.add(img);
        Ventana_Principal.repaint();
        Ventana_Principal.setResizable(false); // No maximizar
        Ventana_Principal.setVisible(true); // Para que lo muestre
        Ventana_Principal.setLocationRelativeTo(null); // aparesca en el centro
        Ventana_Principal.setDefaultCloseOperation(Ventana_Principal.EXIT_ON_CLOSE);

        for (int i = 1; i <= 10; i++) {
            try {
                sleep(800);
                System.out.println("" + i);
            } catch (InterruptedException ex) {
                Logger.getLogger(VentanaInicio.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (i == 10) {
                try {
                    son = new Sonido("/Sonido/Tilin.wav");
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
                CargarGif.setVisible(false);
                Comenzar.setVisible(true);
            }
        }
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

        if (e.getSource().equals(Comenzar)) {
            try {
                son = new Sonido("/Sonido/IntroMedio.wav");
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
            Ventana_Principal.dispose(); // cierro la ventana
            Ventana x2 = new Ventana();
        }
    }
}
