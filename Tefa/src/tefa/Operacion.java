/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tefa;

public class Operacion {

    private String cad;

    public Operacion(String str) {
        cad = str;
    }

    public String getCad() {
        return cad;
    }

    public void setCad(String cad) {
        this.cad = cad;
    }

    String dec_bin() {
        int dec = Integer.parseInt(cad);
        return Integer.toBinaryString(dec);

    }

    String dec_hex() {
        int dec = Integer.parseInt(cad);
        return Integer.toHexString(dec);

    }

    String dec_oct() {
        int dec = Integer.parseInt(cad);
        return Integer.toOctalString(dec);

    }

    String bin_dec() {
        int dec = Integer.parseInt(cad, 2);
        return "" + dec;
    }
}