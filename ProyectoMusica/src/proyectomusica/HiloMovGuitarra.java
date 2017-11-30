package proyectomusica;

import javax.swing.JLabel;

import static java.lang.Thread.sleep;

public class HiloMovGuitarra extends Thread {

    JLabel Guitarra;

    public HiloMovGuitarra(JLabel Flanders) {

        this.Guitarra = Flanders;
    }

    //GuitarraLabel.setBounds(100, 30, 100, 100)
    public void run() {

        for (int b = 30; b <= 500; b++) {
//            Guitarra.setVisible(true);
            Guitarra.setBounds(100, b, 100, 100);
            try {
                sleep(17);
            } catch (InterruptedException ex) {
            }
            
        }
        run();
    }
}
