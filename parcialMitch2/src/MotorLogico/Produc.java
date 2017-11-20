/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico;

/**
 *
 * @author estudiante
 */
public class Produc {

    private String Nombre, Url, codigo;
    private String[][] establecimeintos;

    public Produc(String Nombre, String Url, String codigo, String[][] establecimeintos) {
        this.Nombre = Nombre;
        this.Url = Url;
        this.codigo = codigo;
        this.establecimeintos = establecimeintos;
    }

    public Produc() {
        this.Nombre = "";
        this.Url = "";
        this.codigo = "";
        this.establecimeintos = null;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String[][] getEstablecimeintos() {
        return establecimeintos;
    }

    public void setEstablecimeintos(String[][] establecimeintos) {
        this.establecimeintos = establecimeintos;
    }
}
