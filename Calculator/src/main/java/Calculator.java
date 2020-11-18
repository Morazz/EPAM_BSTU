public class Calculator {
    public float Sum(float firstValue, float secondValue) {
        return firstValue + secondValue;
    }

    public float Substract(float firstValue, float secondValue) {
        return firstValue - secondValue;
    }

    public double Divide(double firstValue, double secondValue) {
        return firstValue / secondValue;
    }

    public float Multiply(float firstValue, float secondValue) {
        return firstValue * secondValue;
    }

    public double Exponentiate(double firstValue, double secondValue) { return Math.pow(firstValue, secondValue);}

    public double GetSin(double value){return Math.sin(value);}

    public double GetCos(double value){return  Math.cos(value);}
}
