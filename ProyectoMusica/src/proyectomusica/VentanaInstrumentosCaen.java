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
import javax.swing.JOptionPane;

/**
 *
 * @author Daviid
 */
public class VentanaInstrumentosCaen implements ActionListener, MouseMotionListener {

    Cursor c;
    JFrame Ventana_Principal;
    JButton Jugar, RetrocesoPagPrincipal;
    JLabel TrompetaLabel, TrombonLabel, CornoLabel, GuitarraLabel;
    JLabel ClaveSolLabel, ClaveFaLabel, ClaveDoLabel;
    JLabel HoraTiempo, MinutosTiempo, SegundosTiempo, TiempoTitulo, PuntoHoraTiempo, PuntoMinutosTiempo;
    JLabel HoraCronometro, MinutosCronometro, SegundosCronometro, CronometroTitulo, PuntoHoraCronometro, PuntoMinutosCronometro;
    HiloMovGuitarra HiloGuitarra;
    HiloMovCorno HiloCorno;
    HiloMovTrompeta HiloTrompeta;
    HiloMovTrombon HiloTrombon;
    Sonido son;
    ProcesoHilosTiempo ProcesoTiempo;
    ProcesoHilosCronometro ProcesoCronometro;

    public void Componentes() {

        Jugar = new JButton("");
        Jugar.setBounds(900, 10, 60, 60);
        Jugar.setBackground(Color.BLUE);
        Jugar.addActionListener(this);
        Font fondo2 = new Font("Serif", Font.ITALIC, 15);
        Jugar.setFont(fondo2);
        Jugar.setForeground(Color.WHITE);
        URL IconodeAcetar = this.getClass().getResource("/Imagenes/BotonPlay.png");
        Jugar.setIcon(new ImageIcon(IconodeAcetar));
        Jugar.setOpaque(false);
        Jugar.setBorder(null);

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

        //-----------------------------------------------------------------Label
        GuitarraLabel = new JLabel("aa");
        GuitarraLabel.setBounds(100, 30, 100, 100);//(470, 30, 100, 100);
        GuitarraLabel.setForeground(Color.BLUE);
        GuitarraLabel.setBackground(Color.WHITE);
        GuitarraLabel.setOpaque(false); // Quita el fondo
        URL GuitarraLabel1 = this.getClass().getResource("/Imagenes/Guitarra.png");
        GuitarraLabel.setIcon(new ImageIcon(GuitarraLabel1));

        TrombonLabel = new JLabel("aa");
        TrombonLabel.setBounds(320, 30, 100, 100);
        TrombonLabel.setForeground(Color.BLUE);
        TrombonLabel.setBackground(Color.WHITE);
        TrombonLabel.setOpaque(false); // Quita el fondo
        URL TrombonLabel1 = this.getClass().getResource("/Imagenes/Trombon.png");
        TrombonLabel.setIcon(new ImageIcon(TrombonLabel1));

        CornoLabel = new JLabel("aa");
        CornoLabel.setBounds(450, 30, 100, 100);
        CornoLabel.setForeground(Color.BLUE);
        CornoLabel.setBackground(Color.WHITE);
        CornoLabel.setOpaque(false); // Quita el fondo
        URL CornoLabel1 = this.getClass().getResource("/Imagenes/Corno.png");
        CornoLabel.setIcon(new ImageIcon(CornoLabel1));

        TrompetaLabel = new JLabel("aa");
        TrompetaLabel.setBounds(670, 30, 100, 100);
        TrompetaLabel.setForeground(Color.BLUE);
        TrompetaLabel.setBackground(Color.WHITE);
        TrompetaLabel.setOpaque(false); // Quita el fondo
        URL Puesto11 = this.getClass().getResource("/Imagenes/Trompeta.png");
        TrompetaLabel.setIcon(new ImageIcon(Puesto11));

        // ClaveSolLabel, ClaveFaLabel, ClaveDoLabel;
        ClaveSolLabel = new JLabel("aa");
        ClaveSolLabel.setBounds(250, 500, 100, 100);
        ClaveSolLabel.setForeground(Color.BLUE);
        ClaveSolLabel.setBackground(Color.WHITE);
        ClaveSolLabel.setOpaque(false); // Quita el fondo
        URL ClaveSolLabel1 = this.getClass().getResource("/Imagenes/ClaveSol.png");
        ClaveSolLabel.setIcon(new ImageIcon(ClaveSolLabel1));
        ClaveSolLabel.addMouseMotionListener(this);
        ClaveSolLabel.setDoubleBuffered(false);

        ClaveFaLabel = new JLabel("aa");
        ClaveFaLabel.setBounds(500, 500, 100, 100);
        ClaveFaLabel.setForeground(Color.BLUE);
        ClaveFaLabel.setBackground(Color.WHITE);
        ClaveFaLabel.setOpaque(false); // Quita el fondo
        URL ClaveFaLabel1 = this.getClass().getResource("/Imagenes/ClaveFa.png");
        ClaveFaLabel.setIcon(new ImageIcon(ClaveFaLabel1));
        ClaveFaLabel.addMouseMotionListener(this);
        ClaveFaLabel.setDoubleBuffered(false);

        ClaveDoLabel = new JLabel("aa");
        ClaveDoLabel.setBounds(750, 500, 100, 100);
        ClaveDoLabel.setForeground(Color.BLUE);
        ClaveDoLabel.setBackground(Color.WHITE);
        ClaveDoLabel.setOpaque(false); // Quita el fondo
        URL ClaveDoLabel1 = this.getClass().getResource("/Imagenes/ClaveDo.png");
        ClaveDoLabel.setIcon(new ImageIcon(ClaveDoLabel1));
        ClaveDoLabel.addMouseMotionListener(this);
        ClaveDoLabel.setDoubleBuffered(false);

        //tiempo
        Font TemaNumeros = new Font("Serif", Font.ITALIC, 40);
        Font Titulos = new Font("Serif", Font.ITALIC, 60);

        TiempoTitulo = new JLabel("Tiempo");
        TiempoTitulo.setBounds((350 - 180) / 2, 10, 180, 100);
        TiempoTitulo.setFont(Titulos);
        TiempoTitulo.setForeground(Color.WHITE);
        TiempoTitulo.setOpaque(false); // Quita el fondo

        HoraTiempo = new JLabel("00");
        HoraTiempo.setBounds(20, 100, 70, 70);
        HoraTiempo.setFont(TemaNumeros);
        HoraTiempo.setForeground(Color.WHITE);
        HoraTiempo.setOpaque(false); // Quita el fondo

        MinutosTiempo = new JLabel("00");
        MinutosTiempo.setBounds(130, 140, 70, 70);
        MinutosTiempo.setFont(TemaNumeros);
        MinutosTiempo.setForeground(Color.WHITE);
        MinutosTiempo.setOpaque(false); // Quita el fondo

        SegundosTiempo = new JLabel("00");
        SegundosTiempo.setBounds(240, 140, 70, 70);
        SegundosTiempo.setFont(TemaNumeros);
        SegundosTiempo.setForeground(Color.WHITE);
        SegundosTiempo.setOpaque(false); // Quita el fondo

        PuntoHoraTiempo = new JLabel(":");
        PuntoHoraTiempo.setBounds(100, 140, 70, 70);
        PuntoHoraTiempo.setFont(TemaNumeros);
        PuntoHoraTiempo.setForeground(Color.WHITE);
        PuntoHoraTiempo.setOpaque(false); // Quita el fondo

        PuntoMinutosTiempo = new JLabel(":");
        PuntoMinutosTiempo.setBounds(210, 140, 70, 70);
        PuntoMinutosTiempo.setFont(TemaNumeros);
        PuntoMinutosTiempo.setForeground(Color.WHITE);
        PuntoMinutosTiempo.setOpaque(false); // Quita el fondo

        HoraCronometro = new JLabel("00");
        HoraCronometro.setBounds(670 + 160, 60, 70, 70);
        HoraCronometro.setFont(TemaNumeros);
        HoraCronometro.setForeground(Color.WHITE);
        HoraCronometro.setOpaque(false); // Quita el fondo

        MinutosCronometro = new JLabel("00");
        MinutosCronometro.setBounds(810 + 80, 60, 70, 70);
        MinutosCronometro.setFont(TemaNumeros);
        MinutosCronometro.setForeground(Color.WHITE);
        MinutosCronometro.setOpaque(false); // Quita el fondo

        SegundosCronometro = new JLabel("00");
        SegundosCronometro.setBounds(950, 60, 70, 70);
        SegundosCronometro.setFont(TemaNumeros);
        SegundosCronometro.setForeground(Color.WHITE);
        SegundosCronometro.setOpaque(false); // Quita el fondo

        PuntoHoraCronometro = new JLabel(":");
        PuntoHoraCronometro.setBounds(740 + 140, 60, 70, 70);
        PuntoHoraCronometro.setFont(TemaNumeros);
        PuntoHoraCronometro.setForeground(Color.WHITE);
        PuntoHoraCronometro.setOpaque(false); // Quita el fondo

        PuntoMinutosCronometro = new JLabel(":");
        PuntoMinutosCronometro.setBounds(880 + 50, 60, 70, 70);
        PuntoMinutosCronometro.setFont(TemaNumeros);
        PuntoMinutosCronometro.setForeground(Color.WHITE);
        PuntoMinutosCronometro.setOpaque(false); // Quita el fondo

    }

    public VentanaInstrumentosCaen() {
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
        Ventana_Principal.add(Jugar);
        Ventana_Principal.add(TrompetaLabel);
        Ventana_Principal.add(TrombonLabel);
        Ventana_Principal.add(CornoLabel);
        Ventana_Principal.add(GuitarraLabel);

        Ventana_Principal.add(ClaveSolLabel);
        Ventana_Principal.add(ClaveFaLabel);
        Ventana_Principal.add(ClaveDoLabel);

//        Ventana_Principal.add(HoraTiempo);
//        Ventana_Principal.add(PuntoHoraTiempo);
//        Ventana_Principal.add(MinutosTiempo);
//        Ventana_Principal.add(PuntoMinutosTiempo);
//        Ventana_Principal.add(SegundosTiempo);
        Ventana_Principal.add(HoraCronometro);
        Ventana_Principal.add(PuntoHoraCronometro);
        Ventana_Principal.add(MinutosCronometro);
        Ventana_Principal.add(PuntoMinutosCronometro);
        Ventana_Principal.add(SegundosCronometro);

        Ventana_Principal.setUndecorated(true);//Quitar el boton de cerrar y los otros

        Imagen img = new Imagen("/Imagenes/FondoInCaen1.jpg", Ventana_Principal.getWidth(), Ventana_Principal.getHeight());
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
        if (e.getSource().equals(Jugar)) {

            try {
                son = new Sonido("/Sonido/InicioMario.wav");
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }

            HiloGuitarra = new HiloMovGuitarra(GuitarraLabel);
            HiloGuitarra.start();

            HiloCorno = new HiloMovCorno(CornoLabel);
            HiloCorno.start();

            HiloTrompeta = new HiloMovTrompeta(TrompetaLabel);
            HiloTrompeta.start();

            HiloTrombon = new HiloMovTrombon(TrombonLabel);
            HiloTrombon.start();

//            ProcesoTiempo = new ProcesoHilosTiempo(HoraTiempo, MinutosTiempo, SegundosTiempo);
//            ProcesoTiempo.start();
            ProcesoCronometro = new ProcesoHilosCronometro(HoraCronometro, MinutosCronometro, SegundosCronometro);
            ProcesoCronometro.start();

        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        if (e.getSource().equals(ClaveSolLabel)) {

            //            ClaveSolLabel.setLocation(ClaveSolLabel.getX() + e.getX() - ClaveSolLabel.getWidth() / 2, 1000);
            //            if ((ClaveSolLabel.getX() + e.getX()) > 0 && (ClaveSolLabel.getX() + e.getX()+ClaveSolLabel.getY()) < (Ventana_Principal.getWidth() - ClaveSolLabel.getWidth())) {
            //            }
            if (ClaveSolLabel.getX() > 0 && ClaveSolLabel.getY() > 0) {
                ClaveSolLabel.setLocation(ClaveSolLabel.getX() + e.getX() - ClaveSolLabel.getWidth() / 2, ClaveSolLabel.getY() + e.getY() - ClaveSolLabel.getHeight() / 2);
            } else {
                ClaveSolLabel.setLocation(ClaveSolLabel.getX() + 1, ClaveSolLabel.getY() + 1);
            }
            //            if (ClaveSolLabel.getX() > 900) {
            //                ClaveSolLabel.setLocation(ClaveSolLabel.getX() - 10, ClaveSolLabel.getY());
            //            } else {
            //                ClaveSolLabel.setLocation(ClaveSolLabel.getX() + e.getX() - ClaveSolLabel.getWidth() / 2, ClaveSolLabel.getY() + e.getY() - ClaveSolLabel.getHeight() / 2);
            //            }
            //            if (ClaveSolLabel.getY() > 500) {
            //                ClaveSolLabel.setLocation(ClaveSolLabel.getX(), ClaveSolLabel.getY() - 10);
            //            } else {
            //                ClaveSolLabel.setLocation(ClaveSolLabel.getX() + e.getX() - ClaveSolLabel.getWidth() / 2, ClaveSolLabel.getY() + e.getY() - ClaveSolLabel.getHeight() / 2);
            //            }
            //            if (ClaveSolLabel.getX() < 0) {
            //                ClaveSolLabel.setLocation(ClaveSolLabel.getX() + 10, ClaveSolLabel.getY());
            //            } else {
            //                ClaveSolLabel.setLocation(ClaveSolLabel.getX() + e.getX() - ClaveSolLabel.getWidth() / 2, ClaveSolLabel.getY() + e.getY() - ClaveSolLabel.getHeight() / 2);
            //            }
            //            if (ClaveSolLabel.getY() < 0) {
            //                ClaveSolLabel.setLocation(ClaveSolLabel.getX(), ClaveSolLabel.getY() + 10);
            //            } else {
            //                ClaveSolLabel.setLocation(ClaveSolLabel.getX() + e.getX() - ClaveSolLabel.getWidth() / 2, ClaveSolLabel.getY() + e.getY() - ClaveSolLabel.getHeight() / 2);
            //            }

        }
        //            ClaveSolLabel.setLocation(ClaveSolLabel.getX() + e.getX() - ClaveSolLabel.getWidth() / 2, ClaveSolLabel.getY() + e.getY() - ClaveSolLabel.getHeight() / 2);

        if (e.getSource().equals(ClaveFaLabel)) {

            if (ClaveFaLabel.getX() > 0 && ClaveFaLabel.getY() > 0) {
                ClaveFaLabel.setLocation(ClaveFaLabel.getX() + e.getX() - ClaveFaLabel.getWidth() / 2, ClaveFaLabel.getY() + e.getY() - ClaveFaLabel.getHeight() / 2);
            } else {
                ClaveFaLabel.setLocation(ClaveFaLabel.getX() + 1, ClaveFaLabel.getY() + 1);
            }
        }

        if (e.getSource().equals(ClaveDoLabel)) {

            if (ClaveDoLabel.getX() > 0 && ClaveDoLabel.getY() > 0) {
                ClaveDoLabel.setLocation(ClaveDoLabel.getX() + e.getX() - ClaveDoLabel.getWidth() / 2, ClaveDoLabel.getY() + e.getY() - ClaveDoLabel.getHeight() / 2);
            } else {
                ClaveDoLabel.setLocation(ClaveDoLabel.getX() + 1, ClaveDoLabel.getY() + 1);
            }
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) { // dejar vacio sino error
    }
}
