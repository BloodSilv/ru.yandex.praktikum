package ru.yandex.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

class Calculator {

    public int sum(int a, int b) {

        return a + b;
    }

    public int multi(int c, int d) {
        return c * d;
    }
}

@RunWith(Parameterized.class)
public class CalculatorTest { // создали тестовый класс

    private final int firstNumber;
    private final int secondNumber;
    private final int expected; // создали поля тестового класса

    public CalculatorTest(int firstNumber, int secondNumber, int expected) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.expected = expected; // создали конструктор тестового класса
    }

    @Parameterized.Parameters
//    public static Object[] getSumData() {
//        return new Object[][]{
//                {1, 9, 10},
//                {1, 0, 1}, // передали тестовые данные
//        };
//    }

    public static Object[] getMultiData() {
        return new Object[][] {
                {2, 8, 16},
                {10, 10, 100},
        };
    }

    @Test
    public void shouldBeSum() {
        Calculator calculator = new Calculator();
        int actual = calculator.sum(firstNumber, secondNumber); // обратились к полям тестового класса
        assertEquals(expected, actual); // сравнили ожидаемый и фактический результат
    }

    @Test
    public void shouldBeMulti() {
        Calculator calculator = new Calculator();
        int actual = calculator.multi(firstNumber, secondNumber);
        assertEquals(expected, actual);
    }
}