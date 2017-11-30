package proyectomusica;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class ProcesoHilosTiempo extends Thread {

    int Hora, Minutos, Segundos;
    String HoraS = "", MinutosS = "", SegundosS = "";
    Calendar TraerHora = new GregorianCalendar();

    JLabel HoraLabel, MinutosLabel, SegundosLabel;
    int Tiempo = 500;

    public ProcesoHilosTiempo(JLabel HoraLabel, JLabel MinutosLabel, JLabel SegundosLabel) {
        this.HoraLabel = HoraLabel;
        this.MinutosLabel = MinutosLabel;
        this.SegundosLabel = SegundosLabel;

        Hora = TraerHora.get(Calendar.HOUR);
        Minutos = TraerHora.get(Calendar.MINUTE);
        Segundos = TraerHora.get(Calendar.SECOND);
    }

    public void run() {
        int i, j, k;
        while (true) { //Para que sea infinito
            for (i = Hora; i < 24; i++) {
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
                            sleep(1000);
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
}
