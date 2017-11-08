/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforos;

import MotorVisual.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Semaforos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        try {
            Frame fr = new Frame(2, 2);
//            FrameP a = new FrameP();
        } catch (StackOverflowError io) {
            JOptionPane.showMessageDialog(null, "Error por memoria", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

}
