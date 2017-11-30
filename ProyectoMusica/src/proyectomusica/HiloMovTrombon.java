package proyectomusica;

import javax.swing.JLabel;

import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;

public class HiloMovTrombon extends Thread {

    JLabel Trombon;

    public HiloMovTrombon(JLabel Flanders) {

        this.Trombon = Flanders;
    }

    //GuitarraLabel.setBounds(100, 30, 100, 100)
    public void run() {

        for (int b = 30; b <= 500; b++) {
//            Trombon.setVisible(true);
            Trombon.setBounds(320, b, 100, 100);
            try {
                sleep(13);
            } catch (InterruptedException ex) {
            }
            
        }
        run();
    }
}
