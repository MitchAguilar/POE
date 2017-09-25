/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario;

import MotorLogico.Formulario;
import MotorLogico.Meives;
import java.awt.Color;
import java.awt.Dimension;
import java.util.InputMismatchException;
import javax.swing.JFrame;

/**
 *
 * @author mitch
 */
public class Test {

    private JFrame frame;

    /**
     * Launch the application.
     *
     * @param args
     */
    public static void main(String[] args) throws InputMismatchException {
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

        Meives.frameM m = new Meives.frameM(new Dimension(600, 600), "hola mundo");
//        m.add(new Meives.textfieldM(Color.red,10,10,100,150));

        Meives.PanelM pan = new Meives.PanelM(Color.cyan, 0.2f);
        pan.setBounds(100, 100, 400, 400);
        Meives.textfieldM lb= new Meives.textfieldM(0.1f, Color.red);
        lb.setBounds(10, 30, 100, 20);
        pan.add(lb);
        m.add(pan);
        m.InsertImg("/Complements/img2.jpg");
        m.repaint();
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
