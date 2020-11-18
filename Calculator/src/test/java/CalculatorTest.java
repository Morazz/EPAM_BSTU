import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void SumTest(){
        Calculator calculator = new Calculator();
        float testResult = 5;
    Assert.assertEquals(calculator.Sum(2,3), testResult, 0.1);
    }

    @Test
    public void SubstractTest(){
        Calculator calculator = new Calculator();
        float expectedResult = -1;
        Assert.assertEquals(calculator.Substract(2,3), expectedResult, 0.1);
    }

    @Test
    public void DivideTest(){
        Calculator calculator = new Calculator();
        double expectedResult = 0.5;
        Assert.assertEquals(calculator.Divide(1,2), expectedResult, 0.1);
    }

    @Test
    public void ArithmeticExceptionTest() throws  ArithmeticException{
        Calculator calculator = new Calculator();
        try {
            double expectedResult = calculator.Divide(2, 0);
            Assert.fail("Expected ArithmeticException");
        } catch (ArithmeticException thrown){
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }

    @Test
    public void MultiplyTest(){
        Calculator calculator = new Calculator();
        float expectedResult = 6;
        Assert.assertEquals(calculator.Multiply(2,3), expectedResult, 0.1);
    }

    @Test
    public void ExponentiateTest(){
        Calculator calculator = new Calculator();
        double expectedResult = 8.0;
        Assert.assertEquals(calculator.Exponentiate(2,3), expectedResult, 0.001);
    }

    @Test
    public void ExponentiateWithNegativePowerTest(){
        Calculator calculator = new Calculator();
        double expectedResult = 0.25;
        Assert.assertEquals(calculator.Exponentiate(2,-2), expectedResult, 0.001);
    }

    @Test
    public void MultyplyTwoNegativeValuesTest(){
        Calculator calculator = new Calculator();
        double expectedResult = 4;
        Assert.assertEquals(calculator.Multiply(-2,-2), expectedResult, 0.1);
    }

    @Test
    public void GetSinTest(){
        Calculator calculator = new Calculator();
        double expectedValue = -0.536573;
        Assert.assertEquals(calculator.GetSin(12), expectedValue, 0.001);
    }

    @Test
    public void GetCosTest(){
        Calculator calculator = new Calculator();
        double expectedValue = 0.843854;
        Assert.assertEquals(calculator.GetCos(12), expectedValue, 0.001);
    }

    @Test
    public void GetSinOfNegativeTest(){
        Calculator calculator = new Calculator();
        double expectedValue = -0.841471;
        Assert.assertEquals(calculator.GetSin(-1), expectedValue, 0.001);
    }

    @Test
    public void GetCosOfNegativeTest(){
        Calculator calculator = new Calculator();
        double expectedValue = 0.540302;
        Assert.assertEquals(calculator.GetCos(-1), expectedValue, 0.001);
    }
}
