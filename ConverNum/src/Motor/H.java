package Motor;

import javax.swing.JOptionPane;

public class H {

    String bina = "";

    public boolean con(String g) {
        String a = "0123456789ABCDEFabcdef";
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

    public int oct(int a) {
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
        System.out.println(num);
        int dev=Integer.parseInt(num);
        return dev;
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

    public int Dec(long a) {
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

    public String Res(String g,int bandera) {
        String dev = "";
        if (con(g) == false) {
            JOptionPane.showMessageDialog(null, "Ingrese Solo los caracteres especiales permitidos,"
                    + " no puedes engañarnos");
        } else {
            String bin = "";
            String cad = hex_bin(g);

            for (int i = 0; i < cad.length(); i++) {
                if (cad.charAt(i) == '1') {
                    bin = cad.substring(i, cad.length());
                    break;
                }
            }
            int n = Dec(Long.parseLong(bin));
            
            switch (bandera){
                case 1:
                    dev="Binario: " + bin;
                    break;
                case 2:
                    dev="Decimal: " + n;
                    break;
                case 3:
                    dev="Octal: " + oct(n);
                    break;
                case 4:
                    dev="Hexadec: " + g;
                    break;
                default:
                    dev="Error General de la app";
                    break;
            }
        }
        return dev;
    }

    public String hex_bin(String a) {
        String c[] = new String[16];
        c[0] = "0000";
        c[1] = "0001";
        c[2] = "0010";
        c[3] = "0011";
        c[4] = "0100";
        c[5] = "0101";
        c[6] = "0110";
        c[7] = "0111";
        c[8] = "1000";
        c[9] = "1001";
        c[10] = "1010";
        c[11] = "1011";
        c[12] = "1100";
        c[13] = "1101";
        c[14] = "1110";
        c[15] = "1111";
        String b = "";
        String d = "0123456789abcdef";
        String base = "";
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < d.length(); j++) {
                if (a.charAt(i) == d.charAt(j)) {
                    try {
                        base += c[Integer.parseInt(d.charAt(j) + "")];
                    } catch (Exception e) {
                        base += c[j];
                    }
                }
            }
        }
        return base;
    }
}
