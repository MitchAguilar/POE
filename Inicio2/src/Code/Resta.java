package Code;

public class Resta extends Operaciones {

    public Resta() {
    }

    public Resta(int Num1, int Num2) {
        super(Num1, Num2);
    }
    
    public int Restar() {
        return getNum1() - getNum2();
    }
}
