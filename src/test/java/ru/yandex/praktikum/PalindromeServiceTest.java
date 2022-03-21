package ru.yandex.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

class PalindromeService {
    public static boolean isPalindrome(String text, boolean expected) {
        String reversedText = new StringBuilder(text).reverse().toString();
        return text.equals(reversedText);
    }
}
@RunWith(Parameterized.class)// добавь аннотацию с раннером
public class PalindromeServiceTest {
    private final String checkedText;
    private final boolean expected;
    // добавь два поля класса: для проверяемой строки и ожидаемого результата

    public PalindromeServiceTest(String checkedText, boolean expected){
        this.checkedText = checkedText;
        this.expected = expected;
    }// напиши конструктор с двумя параметрами

    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][]{
                {"anna", true},
                {"anka", false},
                {"q", true},
        };
    }// напиши метод для получения тестовых данных
    @Test// напиши тест
    public void shouldCheckPalindrome(){
        PalindromeService palindromeService = new PalindromeService();
        boolean actual = PalindromeService.isPalindrome(checkedText, expected);
        assertEquals(expected, actual);
    }
}