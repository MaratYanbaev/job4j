package ru.job4j.calculator;

public class Calculator {
    public double result;

    public void add(double first, double second) {
        this.result = first + second;
    }

    public void subtraction(double first, double second) {
        this.result = first - second;
    }

    public void multiplication(double first, double second) {
        this.result = first * second;
    }

    public void division(double first, double second) {
        this.result = first / second;
    }

    public double getResult() {
        return this.result;
    }

}
