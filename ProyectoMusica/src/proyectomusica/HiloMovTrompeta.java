package proyectomusica;

import javax.swing.JLabel;

import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;

public class HiloMovTrompeta extends Thread {

    JLabel Trombon;

    public HiloMovTrompeta(JLabel Flanders) {

        this.Trombon = Flanders;
    }

    //GuitarraLabel.setBounds(100, 30, 100, 100)
    public void run() {

        for (int b = 30; b <= 500; b++) {
//            Trombon.setVisible(true);
            Trombon.setBounds(670, b, 100, 100);
            try {
                sleep(7);
            } catch (InterruptedException ex) {
            }
            
        }
        run();
    }
}
