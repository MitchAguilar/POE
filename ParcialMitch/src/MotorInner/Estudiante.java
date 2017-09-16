/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorInner;

/**
 *
 * @author estudiante
 */
public class Estudiante {

    private String nombre, identificacion, programa;
    private double notadefinitiva;

    public Estudiante(String nombre, String identificacion, String programa, double notadefinitiva) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.programa = programa;
        this.notadefinitiva = notadefinitiva;
    }

    public Estudiante() {
        this.nombre = "Mitch";
        this.identificacion = "1117553160";
        this.programa = "Ing. Sistemas";
        this.notadefinitiva = 0.0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public double getNotadefinitiva() {
        return notadefinitiva;
    }

    public void setNotadefinitiva(double notadefinitiva) {
        this.notadefinitiva = notadefinitiva;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", identificacion=" + identificacion + ", programa=" + programa + ", notadefinitiva=" + notadefinitiva + '}';
    }
    
}
