package chvirov.com.example.work11;

public class Calculations {
    protected double value1;
    protected double value2;
    protected double calculationResult;


    public Calculations() {
        value1 = 0;
        value2 = 0;
    }

    public double Plus() {
        return calculationResult = value1 + value2;
    }

    public double Minus() {
        return calculationResult = value1 - value2;
    }

    public double Multi() {
        return calculationResult = value1 * value2;
    }

    public double Divide() {
        return calculationResult = value1 / value2;
    }

    public double Percent() {
        return calculationResult = value2 * 100 / value1;
    }



    public double getValue1() {
        return value1;
    }

    public void setValue1(double value1) {
        this.value1 = value1;
    }

    public double getValue2() {
        return value2;
    }

    public void setValue2(double value2) {
        this.value2 = value2;
    }

    public double getCalculationResult() {
        return calculationResult;
    }
}
