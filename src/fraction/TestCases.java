package fraction;

import org.junit.Assert;
import org.junit.Test;
//import Fraction;

public class TestCases {
    @Test
    public void testFraction1(){
        //Test for reduction

        FractionImpl num = new FractionImpl(-9,15);
        String expected = "-3/5";
        String actual = num.toString();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testFraction2(){
        //Test for wholenumbers

        FractionImpl num = new FractionImpl(87);
        String expected = "87";
        String actual = num.toString();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testFraction3(){
        //Testing for string spacing

        FractionImpl num = new FractionImpl(" 5/4");
        String expected = "5/4";
        String actual = num.toString();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testAdd(){
        //Test add method for valid inputs

        FractionImpl num = new FractionImpl(3,4);
        FractionImpl num1 = new FractionImpl(3, 4);
        String expected = "3/2";
        String actual = num.add(num1).toString();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testSubtraction(){
        //Test subtraction for valid inputs

        FractionImpl num = new FractionImpl(5,4);
        FractionImpl num1 = new FractionImpl(3, 4);
        String expected = "1/2";
        String actual = num.subtract(num1).toString();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testMultiply(){
        //Test multiply method for valid inputs

        FractionImpl num = new FractionImpl(5,4);
        FractionImpl num1 = new FractionImpl(3, 4);
        String expected = "15/16";
        String actual = num.multiply(num1).toString();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testDivide(){
        //Test divide method for valid input

        FractionImpl num = new FractionImpl(5,4);
        FractionImpl num1 = new FractionImpl(3, 4);
        String expected = "5/3";
        String actual = num.divide(num1).toString();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testAbsolute(){
        //Test abs method on valid inputs

        FractionImpl num = new FractionImpl(5,-4);
        String expected = "5/4";
        String actual = num.abs().toString();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testNegation(){
        //Test negate method for valid inputs

        FractionImpl num = new FractionImpl(5,-4);
        String expected = "-5/4";
        String actual = num.negate().toString();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testEquals(){
        //Test equals method for both valid and invalid output

        FractionImpl num = new FractionImpl(5,4);
        FractionImpl num1 = new FractionImpl(3, 4);
        Assert.assertTrue(num.equals(num));
        Assert.assertTrue(num1.equals(num1));
        Assert.assertFalse(num1.equals(num));
    }
    @Test
    public void testInverse(){
        //Test inverse method on valid inputs

        FractionImpl num = new FractionImpl(5,4);
        FractionImpl num1 = new FractionImpl(3, 4);
        String expected = "4/5";
        String expected2 = "4/3";
        String actual = num.inverse().toString();
        String actual2 = num1.inverse().toString();
        Assert.assertEquals(expected,actual);
        Assert.assertEquals(expected2,actual2);

    }
    @Test
    public void testCompareTo(){
        //Test to check if this is 0
        FractionImpl num = new FractionImpl(0);
        FractionImpl num1 = new FractionImpl(3, 4);
        int expected = 0;
        int actual = num.compareTo(num1);
        Assert.assertEquals(expected,actual);

        //Test to check if this is greater than o
        FractionImpl num2 = new FractionImpl(5,4);
        FractionImpl num3 = new FractionImpl(3, 4);
        int expected1 = 1;
        int actual1 = num2.compareTo(num3);
        Assert.assertEquals(expected1,actual1);

        //Test to check if this is lesser than 0
        FractionImpl num4 = new FractionImpl(3, 4);
        FractionImpl num5 = new FractionImpl(5,4);
        int expected2 = -1;
        int actual2 = num4.compareTo(num5);
        Assert.assertEquals(expected2,actual2);

    }
    //Tests the exception for zero denominator
    @Test(expected = ArithmeticException.class)
    public void testException() throws ArithmeticException{
        FractionImpl a = new FractionImpl(6,0);
    }
    //Tests the exception from String constructor
    @Test(expected = ArithmeticException.class)
    public void testException1() throws ArithmeticException{
        FractionImpl b = new FractionImpl("8/0");
    }
    @Test
    public void testZeroNumerator() {
        //Tests zero numerator
        FractionImpl a = new FractionImpl(0, 5);
        String expected = "0/1";

        String actual = a.toString();
        Assert.assertEquals(expected, actual);
    }

}
