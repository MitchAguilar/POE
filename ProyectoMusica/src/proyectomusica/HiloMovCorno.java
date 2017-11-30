package proyectomusica;

import javax.swing.JLabel;

import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;

public class HiloMovCorno extends Thread {

    JLabel Corno;

    public HiloMovCorno(JLabel Corno) {

        this.Corno = Corno;
    }

    //GuitarraLabel.setBounds(100, 30, 100, 100)
    public void run() {

        for (int b = 30; b <= 500; b++) {
//            Corno.setVisible(true);
            Corno.setBounds(470, b, 100, 100);
            try {
                sleep(10);
            } catch (InterruptedException ex) {
            }
            
        }
        run();
    }
}
