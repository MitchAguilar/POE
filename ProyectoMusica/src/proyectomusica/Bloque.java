/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomusica;

import java.awt.TextField;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Daviid
 */
public class Bloque {

    TextField Campo;

    public void solonumeros(KeyEvent e) {// para solo numeros en el teclado

        char c = e.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            e.consume();
            JOptionPane.showMessageDialog(null, "Lo sentimos, ésto es un campo de numeros, por lo tanto no puede ingresar ningun otro caracter diferente de los numeros enteros ", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void soloLetras(KeyEvent e) {
        char c = e.getKeyChar();
        if (((c < 'a') || (c > 'z')) && ((c < 'A') || (c > 'Z')) && (c != '\b') && (c != 'ñ') && (c != 'Ñ')) {
            e.consume();
            JOptionPane.showMessageDialog(null, "Lo sentimos, ésto es un campo de solo letras, por lo tanto no puede ingresar ningun otro caracter diferente de letras", "Error", JOptionPane.WARNING_MESSAGE);

        }
//            if ((((c < 'a') || (c > 'z')) && ((c < 'A') || (c > 'Z')) && (c != '\b') && (c != 'ñ') && (c != 'Ñ'))) {
//               }
    }

    public void dec(KeyEvent e) {
        char c = e.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != '\b') && (c != '.') && (c != KeyEvent.VK_BACK_SPACE)) {
            e.consume();
            JOptionPane.showMessageDialog(null, "Lo sentimos, ésto es un campo de numeros decimales, por lo tanto no puede ingresar ningun otro caracter diferente de los numeros decimales", "Error", JOptionPane.WARNING_MESSAGE);
        }
//            if ((((c < '0') || (c > '9')) && (c != '\b') && (c != '.'))) {
//                }

// preguntar
        if (Campo.getText().contains(".")) {
            if (((c < '0') || (c > '9')) && (c != '\b') && (c != KeyEvent.VK_BACK_SPACE)) {
                e.consume();
                JOptionPane.showMessageDialog(null, "Lo sentimos, ésto es un campo de numeros decimales, por lo tanto no puede ingresar ningun otro caracter diferente de los numeros decimales", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public void solonumeros4numeros(KeyEvent e,TextField Campo) {// para solo numeros en el teclado

        char c = e.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            e.consume();
            JOptionPane.showMessageDialog(null, "Lo sentimos, ésto es un campo de numeros, por lo tanto no puede ingresar ningun otro caracter diferente de los numeros enteros ", "Error", JOptionPane.WARNING_MESSAGE);
        }
        if (Campo.getText().length() >= 4) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, ésto es un campo de solo 4 digitos ", "Error", JOptionPane.WARNING_MESSAGE);
            e.consume();
        }
    }

}
