package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenSubFourMinusOneThenThree() {
        Calculator calc = new Calculator();
        calc.subtraction(4D, 1D);
        double result = calc.getResult();
        double expected = 3D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenMulFourMultiplyTwoThenEight() {
        Calculator calc = new Calculator();
        calc.multiplication(4D, 2D);
        double result = calc.getResult();
        double expected = 8D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenDivFourDivideTwoThenTwo() {
        Calculator calc = new Calculator();
        calc.division(4D, 2D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
}
