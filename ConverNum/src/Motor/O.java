package Motor;

import javax.swing.JOptionPane;

public class O {

    String bina = "";

    public boolean con(String g) {
        String a = "0123456789";
        boolean b = true;
        for (int i = 0; i < g.length(); i++) {
            int cm = 0;
            for (int j = 0; j < a.length(); j++) {
                if (g.charAt(i) != a.charAt(j)) {
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
    }//binario de un numero

    public void bin(int a) {//num binario
        if (a < 1) {
            return;
        } else {
            bin(a / 2);
            bina += (a % 2) + "";
        }
    }

    public long oct(int a) {
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

    public String hex(int a) {
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

    public int OCT(int a) {
        String b = "" + a;
        int base = 0;
        int len = b.length() - 1;
        for (int i = 0; i < b.length(); i++) {
            int n = Integer.parseInt("" + b.charAt(i));
            base += n * Math.pow(8, len);
            len--;
        }
        return base;
    }

    public String Res(String g, int bandera) {
        String dev = "";
        if (con(g) == false) {
            JOptionPane.showMessageDialog(null, "Ingrese Solo numeros, no puedes engañarnos");
        } else {
            int num = OCT(Integer.parseInt(g));
            bin(num);
            switch (bandera) {
                case 1:
                    dev = "Binario: " + bina;
                    break;
                case 2:
                    dev = "Decimal: " + num;
                    break;
                case 3:
                    dev = "Octal: " + g;
                    break;
                case 4:
                    dev = "Hexadec: " + hex(num);
                    break;
                default:
                    dev = "Error";
                    break;
            }
        }
        return dev;
    }
}
