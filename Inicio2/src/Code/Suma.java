package Code;

public class Suma extends Operaciones {

    public Suma() {
    }

    public Suma(int Num1, int Num2) {
        super(Num1, Num2);
    }
    
    public int Sumar() {
        return getNum1() + getNum2();
    }
}
