    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario;

import MotorLogico.FormularioV2;
import MotorLogico.Formulariov1;
import MotorLogico.Meives;
import java.awt.Color;
import java.awt.Dimension;
import java.util.InputMismatchException;
import javax.swing.JFrame;

/**
 *
 * @author mitch
 */
public class Test{

    private JFrame frame;

    /**
     * Launch the application.
     *
     * @param args
     */
    public static void main(String[] args){
//         FormularioV2 v2= new  FormularioV2();
            
            Meives.frameM a = new Meives.frameM(new Dimension(500, 500),"Hola mundo");
            Meives.textfieldM b= new Meives.textfieldM();
            b.setBounds(20, 20, 100, 100);
            b.setText("h****1Sola");
            a.add(b);
            System.out.println(b.getText().matches("Solo.*"));
            a.repaint();
//        String str1 = "120";
//        String str2 = "3";
//        String respuesta;
//        int numerador, denominador, cociente;
//        try {
//            numerador = Integer.parseInt(str1);
//            denominador = Integer.parseInt(str2);
//            rango(numerador, denominador);
//            cociente = numerador / denominador;
//            respuesta = String.valueOf(cociente);
//        } catch (NumberFormatException ex) {
//            respuesta = "Se han introducido caracteres no numéricos";
//        } catch (ArithmeticException ex) {
//            respuesta = "División entre cero";
//        } catch (EI ex) {
//            respuesta = ex.getMessage();
//        }
//        System.out.println(respuesta);
//    }
//
//    static void rango(int num, int den) throws EI {
//        if ((num > 100) || (den < -5)) {
//            throw new EI("Números fuera de rango");
//        }
//    }
//        try {
//            Formulario f = new Formulario();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Scanner s = new Scanner(System.in);
//        int b = s.nextInt();
//        System.out.println("mitch");
//        throw new InputMismatchException();public class EI extends Exception {
//    public EI(String msg) {
//        super(msg);
//    }
//    public static class EI extends Exception {
//
//        public EI(String msg) {
//            super(msg);
//        }
//    }
    }

}
