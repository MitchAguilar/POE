package calculadoraNormal;

public class Operaciones {

    private int a, b;

    public Operaciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Operaciones() {
        a = 10;
        b = 15;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int Sumar() {
        return a + b;
    }

    public int Restar() {
        return a - b;
    }

    public int Multiplicar() {
        return a * b;
    }

    public int Dividir() {
        return a + b;
    }
}
