package Code;

public class Divición extends Operaciones {

    public Divición() {
    }

    public Divición(int Num1, int Num2) {
        super(Num1, Num2);
    }

    public int Dividir() {
        return getNum1() / getNum2();
    }
}
