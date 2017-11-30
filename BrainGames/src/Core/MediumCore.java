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
public class MediumCore {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;

    public MediumCore(JLabel l1, JLabel l2, JLabel l3, JLabel l4, JLabel l5, JLabel l6, JLabel l7, JLabel l8, JLabel l9, JLabel l10) {
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
        l1.setText("83");
        l2.setText("-");
        l3.setText("76");
        l4.setText("=");
        l5.setText("");
        //second
        l6.setText("7");
        l7.setText("8");
        l8.setText("5");
        l9.setText("6");
        l10.setText("9");

        return 5 + "-" + 1;
        //primer numero es donde debe encajar
        //segundo numero es el donde está el ganador
    }

    public String Mov2() {
        l1.setText("26");
        l2.setText("*");
        l3.setText("3");
        l4.setText("");
        l5.setText("78");
        //second
        l6.setText("-");
        l7.setText("+");
        l8.setText("*");
        l9.setText("=");
        l10.setText("/");

        return 4 + "-" + 4;
        //primer numero es donde debe encajar
        //segundo numero es el donde está el ganador
    }

    public String Mov3() {
        l1.setText("+");
        l2.setText("*");
        l3.setText("-");
        l4.setText("=");
        l5.setText("");
        //second
        l6.setText("+");
        l7.setText("-");
        l8.setText("*");
        l9.setText("/");
        l10.setText("%");

        return 5 + "-" + 2;
        //primer numero es donde debe encajar
        //segundo numero es el donde está el ganador
    }

    public String Mov4() {
        l1.setText("67");
        l2.setText("+");
        l3.setText("32");
        l4.setText("=");
        l5.setText("");
        //second
        l6.setText("99");
        l7.setText("98");
        l8.setText("95");
        l9.setText("96");
        l10.setText("97");

        return 5 + "-" + 1;
        //primer numero es donde debe encajar
        //segundo numero es el donde está el ganador
    }

    public String Mov5() {
        l1.setText("2");
        l2.setText("^");
        l3.setText("");
        l4.setText("=");
        l5.setText("6");
        //second
        l6.setText("16");
        l7.setText("64");
        l8.setText("54");
        l9.setText("55");
        l10.setText("65");

        return 3 + "-" + 2;
        //primer numero es donde debe encajar
        //segundo numero es el donde está el ganador
    }

    public String Mov6() {
        l1.setText("1");
        l2.setText("");
        l3.setText("1");
        l4.setText("=");
        l5.setText("10");
        //second
        l6.setText("*");
        l7.setText("+");
        l8.setText("^");
        l9.setText("/");
        l10.setText("-");

        return 2 + "-" + 2;
        //primer numero es donde debe encajar
        //segundo numero es el donde está el ganador
    }

    public String Mov7() {
        l1.setText("2");
        l2.setText("");
        l3.setText("3");
        l4.setText("=");
        l5.setText("2");
        //second
        l6.setText("+");
        l7.setText("-");
        l8.setText("%");
        l9.setText("&");
        l10.setText("/");

        return 2 + "-" + 3;
        //primer numero es donde debe encajar
        //segundo numero es el donde está el ganador
    }

    public String Mov8() {
        l1.setText("23");
        l2.setText("%");
        l3.setText("3");
        l4.setText("=");
        l5.setText("");
        //second
        l6.setText("f");
        l7.setText("v");
        l8.setText("2");
        l9.setText("1");
        l10.setText("4");

        return 5 + "-" + 2;
        //primer numero es donde debe encajar
        //segundo numero es el donde está el ganador
    }

    public String Mov9() {
        l1.setText("12");
        l2.setText("");
        l3.setText("5");
        l4.setText("=");
        l5.setText("7");
        //second
        l6.setText("2");
        l7.setText("+");
        l8.setText("8");
        l9.setText("3");
        l10.setText("-");

        return 2 + "-" + 5;
        //primer numero es donde debe encajar
        //segundo numero es el donde está el ganador
    }

    public String Mov10() {
        l1.setText("x");
        l2.setText("+");
        l3.setText("p");
        l4.setText("=");
        l5.setText("");
        //second
        l6.setText("x");
        l7.setText("p");
        l8.setText("px");
        l9.setText("xp");
        l10.setText("2");

        return 5 + "-" + 4;
        //primer numero es donde debe encajar
        //segundo numero es el donde está el ganador
    }
}
