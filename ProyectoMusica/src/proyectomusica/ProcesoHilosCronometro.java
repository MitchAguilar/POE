package proyectomusica;

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;

/**
 *
 * @author Daviid
 */
public class ProcesoHilosCronometro extends Thread {

    int Hora, Minutos, Segundos;
    String HoraS = "", MinutosS = "", SegundosS = "";
    JLabel HoraLabel, MinutosLabel, SegundosLabel;
    int Tiempo = 500;
    Sonido son;
    int Llevar;

    public ProcesoHilosCronometro(JLabel HoraLabel, JLabel MinutosLabel, JLabel SegundosLabel) {
        this.HoraLabel = HoraLabel;
        this.MinutosLabel = MinutosLabel;
        this.SegundosLabel = SegundosLabel;
        
    }

//    public void ProcesoH(int Llevar) {        
//        this.Llevar = Llevar;
//    }
//    
    public void run() {
        Llevar = 10;
        int i, j, k;

        for (i = Hora; i < Llevar; i++) {
            if (i < 10) {
                HoraS = "0";
            } else {
                HoraS = "";
            }
            for (j = Minutos; j < 60; j++) {
                if (j < 10) {
                    MinutosS = "0";
                } else {
                    MinutosS = "";
                }

                for (k = Segundos; k < 60; k++) {
                    if (k < 10) {
                        SegundosS = "0";
                    } else {
                        SegundosS = "";
                    }

                    HoraLabel.setText(HoraS + i + "");
                    MinutosLabel.setText(MinutosS + j + "");
                    SegundosLabel.setText(SegundosS + k + "");
                    try {
                        sleep(1);
                    } catch (InterruptedException ex) {
                    }

                }
                Segundos = 0; //Inicializando

            }
            Minutos = 0;
            
        }
        Hora = 0;
    }
}
