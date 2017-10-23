/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiempo;

import MotorVisual.FrameV;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Tiempo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        
        try {
            FrameV a = new FrameV();
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, "Lo siento, reventaste el proceso de pila de la JVM,\n por tanto no es posible recuperar tu aplicación."
                    + " \n te recomendamos reiniciar." + io.getCause(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

}
