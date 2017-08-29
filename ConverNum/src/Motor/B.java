package Motor;

import javax.swing.JOptionPane;

public class B {

    //éste metodo es el que se encarga de recibir y comprobar si lo que hay es un decimal
    //en mi proyecto anterior ésto era una interfaz frafica; ahora va  a se ruan clase de procesos
    //hay que modificar algunas cosas.
    public boolean con(String c) {//maldita pericia la de las letras
        String a = "01";
        boolean b = true;
        for (int i = 0; i < c.length(); i++) {
            int cm = 0;
            for (int j = 0; j < a.length(); j++) {
                if (c.charAt(i) != a.charAt(j)) {
                    cm++;
                }
            }
            if (cm == a.length()) {
                b = false;
                break;
            }
        }
        return b;
    }

    public static void C(long a) {
        if (a < 1) {
            return;
        } else {
            C(a / 2);
            System.out.print(a % 2);
        }
    }//binario de un numero, para convertirlo a bianrio, es decir que de aqui va a salir, binario, octal, hex...

    public int Dec(long a) {//decimal
        int dec = 0;
        int Arr[] = new int[100];
        for (int i = 0; i < Arr.length; i++) {
            Arr[i] = (int) Math.pow(2, i);
        }
        String b = a + "";
        System.out.println(b);
        int le = b.length() - 1;
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) != '0') {
                dec += Arr[le];
            }
            le--;
        }
        return dec;
    }
    String bina = "";

    public void bin(int a) {//num binario
        if (a < 1) {
            return;
        } else {
            bin(a / 2);
            bina += (a % 2) + "";
        }
    }

    public long oct(int a) {//el metodo octal es el más bonito que he hecho
        int pow = 1;
        int[] reg = new int[100];
        int i = 0;
        String num = "";
        int cou = 0;
        while (pow < a) {
            reg[i] = pow;
            pow = (int) Math.pow(8, i);
            i++;
            cou++;
        }
        int base = 0;
        for (int j = cou - 1; j > 0; j--) {
            base = (a / reg[j]);
            a = Math.abs((base * reg[j] - a));
            num += "" + base;
        }

        return Long.parseLong(num);
    }

    public String hex(int a) {//ese y el hexa, son hermosos, verdaderamente
        int pow = 1;
        int[] reg = new int[100];
        int i = 0;
        String num = "";
        int cou = 0;
        while (pow < a) {
            reg[i] = pow;
            pow = (int) Math.pow(16, i);
            i++;
            cou++;
        }
        int base = 0;
        String he = "0123456789ABCDEF";
        for (int j = cou - 1; j > 0; j--) {
            base = (a / reg[j]);
            a = Math.abs(((base * reg[j]) - a));
            num += he.charAt(base);
        }
        return num;
    }
//ésta parte no nos importa

    public B() {
        //estupido ya que lo pienso
    }

    public String Res(String a, int bandera) {//ahora que lo pienso, ésto es mejor
        String dev = "";
        if (con(a) == false) {//si ese metodo dice false, significa que uno de los valores no es numerico
            JOptionPane.showMessageDialog(null, "Ingrese Solo numeros binarios, no puedes engañarnos");
        } else {
            switch (bandera) {
                case 1:
                    dev = "Binario: " + a;//ojo, ahora que lo pienso necesitamos una bandera, porque no sabemos a que no los van a pedir convertir
                    break;
                case 2:
                    dev = "Decimal: " + Dec(Long.parseLong(a));//Error, ya recordé, recibo un binario jejej
                    break;
                case 3:
                    dev = "Octal: " + oct(Dec(Long.parseLong(a)));//recordé que los convertí a decimal primero
                    break;
                case 4:
                    dev = "Hexadec: " + hex(Dec(Long.parseLong(a)));
                    break;
                default:
                    dev = "ERROR GENERAL";
                    break;
            }
        }
        return dev;
    }
}

//Cabe anotar que yo nombro las clases con una sola letra porque eso me ayuda a escribir más rapido
//es decir que b=binario, D,desimal, Hhexadesimal, O=octal, B=binario
//Ahora empezemos
//ya que hay que modificiar algunas cosas



//CREO QUE TERMINAMOS ÉSTE, OS PIDO DISCULPAS POR LOS PIENSO, ÉSTE ES UN RETO PARA MI...
//NO TENGO LIBRETO NI NADA ENSAYADO, ES SOLO LO QUE TENGO EN MI MENTE Y SÉ...
//POR ESO EN OCACIONES ME DENTENGO A PENSAR