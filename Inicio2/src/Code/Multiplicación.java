package Code;

public class Multiplicación extends Operaciones {

    public Multiplicación() {
    }

    public Multiplicación(int Num1, int Num2) {
        super(Num1, Num2);
    }

    public int Multiplicar() {
        return getNum1() * getNum2();
    }
}
