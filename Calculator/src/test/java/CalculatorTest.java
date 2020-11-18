import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CalculatorTest {
    Calculator calculator;

    @Before
    public void setUp(){
        calculator = new Calculator();
    }


    @Test
    public void SumTest(){
        float testResult = 5;
    Assert.assertEquals(calculator.Sum(2,3), testResult, 0.1);
    }

    @Test
    public void SubstractTest(){
        float expectedResult = -1;
        Assert.assertEquals(calculator.Substract(2,3), expectedResult, 0.1);
    }

    @Test
    public void DivideTest(){
        double expectedResult = 0.5;
        Assert.assertEquals(calculator.Divide(1,2), expectedResult, 0.1);
    }

    @Test(expected = ArithmeticException.class)
    public void ArithmeticExceptionTest(){
        Assert.assertNotNull(calculator.Divide(6,2));
    }

    @Test
    public void MultiplyTest(){
        float expectedResult = 6;
        Assert.assertEquals(calculator.Multiply(2,3), expectedResult, 0.1);
    }

    @Test
    public void ExponentiateTest(){
        double expectedResult = 8.0;
        Assert.assertEquals(calculator.Exponentiate(2,3), expectedResult, 0.001);
    }

    @Test
    public void ExponentiateWithNegativePowerTest(){
        double expectedResult = 0.25;
        Assert.assertEquals(calculator.Exponentiate(2,-2), expectedResult, 0.001);
    }

    @Test
    public void MultyplyTwoNegativeValuesTest(){
        double expectedResult = 4;
        Assert.assertEquals(calculator.Multiply(-2,-2), expectedResult, 0.1);
    }

    @Test
    public void GetSinTest(){
        double expectedValue = -0.536;
        Assert.assertEquals(calculator.GetSin(12), expectedValue, 0.001);
    }

    @Test
    public void GetCosTest(){
        double expectedValue = 0.843;
        Assert.assertEquals(calculator.GetCos(12), expectedValue, 0.001);
    }

    @Test
    public void GetSinOfNegativeTest(){

        double expectedValue = -0.841;
        Assert.assertEquals(calculator.GetSin(-1), expectedValue, 0.001);
    }

    @Test
    public void GetCosOfNegativeTest(){
        double expectedValue = 0.540;
        Assert.assertEquals(calculator.GetCos(-1), expectedValue, 0.001);
    }
}
