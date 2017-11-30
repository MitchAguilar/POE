/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import javax.swing.JLabel;

/**
 *
 * @author mitch
 */
public class EasyCore {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;

    public EasyCore(JLabel l1, JLabel l2, JLabel l3, JLabel l4, JLabel l5, JLabel l6, JLabel l7, JLabel l8, JLabel l9, JLabel l10) {
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
        this.l4 = l4;
        this.l5 = l5;
        this.l6 = l6;
        this.l7 = l7;
        this.l8 = l8;
        this.l9 = l9;
        this.l10 = l10;
    }

    public String Mov1() {
        l1.setText("1");
        l2.setText("*");
        l3.setText("");
        l4.setText("=");
        l5.setText("12");
        //second
        l6.setText("20");
        l7.setText("10");
        l8.setText("1");
        l9.setText("2");
        l10.setText("12");

        return 3 + "-" + 5;
        //primer numero es donde debe encajar
        //segundo numero es el donde está el ganador
    }

    public String Mov2() {
        l1.setText("0");
        l2.setText("*");
        l3.setText("0");
        l4.setText("=");
        l5.setText("");
        //second
        l6.setText("21");
        l7.setText("3");
        l8.setText("0");
        l9.setText("23");
        l10.setText("1");

        return 5 + "-" + 3;
        //primer numero es donde debe encajar
        //segundo numero es el donde está el ganador
    }

    public String Mov3() {
        l1.setText("19");
        l2.setText("*");
        l3.setText("");
        l4.setText("=");
        l5.setText("38");
        //second
        l6.setText("22");
        l7.setText("10");
        l8.setText("11");
        l9.setText("2");
        l10.setText("12");

        return 3 + "-" + 4;
        //primer numero es donde debe encajar
        //segundo numero es el donde está el ganador
    }

    public String Mov4() {
        l1.setText("4");
        l2.setText("+");
        l3.setText("");
        l4.setText("=");
        l5.setText("2");
        //second
        l6.setText("-1");
        l7.setText("10");
        l8.setText("-2");
        l9.setText("2");
        l10.setText("13");

        return 3 + "-" + 3;
        //primer numero es donde debe encajar
        //segundo numero es el donde está el ganador
    }

    public String Mov5() {
        l1.setText("8");
        l2.setText("/");
        l3.setText("2");
        l4.setText("=");
        l5.setText("");
        //second
        l6.setText("21");
        l7.setText("4");
        l8.setText("12");
        l9.setText("2");
        l10.setText("11");

        return 5 + "-" + 2;
        //primer numero es donde debe encajar
        //segundo numero es el donde está el ganador
    }

    public String Mov6() {
        l1.setText("30");
        l2.setText("-");
        l3.setText("10");
        l4.setText("=");
        l5.setText("");
        //second
        l6.setText("20");
        l7.setText("10");
        l8.setText("1");
        l9.setText("2");
        l10.setText("12");

        return 5 + "-" + 1;
        //primer numero es donde debe encajar
        //segundo numero es el donde está el ganador
    }

    public String Mov7() {
        l1.setText("99");
        l2.setText("-");
        l3.setText("");
        l4.setText("=");
        l5.setText("17");
        //second
        l6.setText("20");
        l7.setText("88");
        l8.setText("83");
        l9.setText("26");
        l10.setText("82");

        return 3 + "-" + 5;
        //primer numero es donde debe encajar
        //segundo numero es el donde está el ganador
    }

    public String Mov8() {
        l1.setText("2");
        l2.setText("+");
        l3.setText("");
        l4.setText("=");
        l5.setText("12");
        //second
        l6.setText("20");
        l7.setText("10");
        l8.setText("1");
        l9.setText("2");
        l10.setText("12");

        return 3 + "-" + 2;
        //primer numero es donde debe encajar
        //segundo numero es el donde está el ganador
    }

    public String Mov9() {
        l1.setText("12");
        l2.setText("*");
        l3.setText("5");
        l4.setText("=");
        l5.setText("");
        //second
        l6.setText("20");
        l7.setText("60");
        l8.setText("1");
        l9.setText("23");
        l10.setText("62");

        return 5 + "-" + 2;
        //primer numero es donde debe encajar
        //segundo numero es el donde está el ganador
    }
    public String Mov10() {
        l1.setText("p");
        l2.setText("-");
        l3.setText("p");
        l4.setText("=");
        l5.setText("");
        //second
        l6.setText("0");
        l7.setText("1");
        l8.setText("1");
        l9.setText("2");
        l10.setText("12");

        return 5 + "-" + 1;
        //primer numero es donde debe encajar
        //segundo numero es el donde está el ganador
    }
}
