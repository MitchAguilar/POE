package Code;

import java.util.*;

public class Principal {

    static Scanner a = new Scanner(System.in);
    static int b, c;

    public static void main(String[] arg) {
        while (true) {
            try {
                PedirDatos();
                System.out.println("***___________________***");
                System.out.println("Elija Su Opción");
                System.out.println("1.Sumar");
                System.out.println("2.Restar");
                System.out.println("3.Multiplicar");
                System.out.println("4.Dividir");
                int val = a.nextInt();
                switch (val) {
                    case 1:
                        Suma sum= new Suma(b,c);
                        System.out.println("El resultado es: " +sum.suma());
                        break;
                    case 2:
                        Resta res = new Resta(b,c);
                        System.out.println("El resultado es: " + res.resta());
                        break;
                    case 3:
                        Multiplicación mul = new Multiplicación(b,c);
                        System.out.println("El resultado es: " + mul.multiplicacion());
                        break;
                    case 4:
                        Divición div = new Divición(b,c);
                        System.out.println("El resultado es: " + div.divición());
                        break;
                    default:
                        System.err.println("Error digite una opción valida.");
                        break;
                }
            } catch (Exception io) {
                System.err.println("Lo sentimos, ocurrió un error");
            }
        }

    }

    public static void PedirDatos() {
        while (true) {
            try {
                System.out.println("Digite su primer numero");
                b = a.nextInt();
                System.out.println("Digite su segundo numero");
                c = a.nextInt();
                break;
            } catch (Exception io) {
                a = new Scanner(System.in);
            }
        }
    }
}
