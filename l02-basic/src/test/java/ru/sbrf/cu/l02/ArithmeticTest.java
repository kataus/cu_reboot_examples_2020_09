package ru.sbrf.cu.l02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName( "Проверяем базовые арифметические действия. Должно" )
public class ArithmeticTest {

    int a = 15;
    int b = 4;

    @Test
    @DisplayName( "корректно сработать сложение примитивов" )
    public void testSumm1(){
        assertEquals(0, a + b);
    }

}
