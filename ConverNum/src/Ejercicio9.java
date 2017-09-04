
import java.util.Scanner;

/**
 * @author Diego
 */
public class Ejercicio9 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese numero: ");
        String hexa = "";
        String bin = "";
        String octal = "";
        int n = input.nextInt();
//Convertimos el numero ingresado a Hexadecimal
        hexa = Integer.toHexString(n);
//Convertimos el numero ingresado a Octal
        octal = Integer.toOctalString(n);
//Convertimos el numero ingresado a Binario
        bin = Integer.toBinaryString(n);
        System.out.println("------------------------------------------");
        System.out.println("Numero " + n + " en sistema decimal: " + n);
        System.out.println("Numero " + n + " en sistema hexadecimal: " + hexa);
        System.out.println("Numero " + n + " en sistema octal: " + octal);
        System.out.println("Numero " + n + " en sistema binario: " + bin);
    }
}
