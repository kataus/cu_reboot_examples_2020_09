//package ru.sbrf.cu.l02;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@DisplayName("Проверяем базовые арифметические действия. Должно")
//public class ArithmeticTest {
//
//    int a = 15;
//    int b = 4;
//    int c = 32;
//    long d = -1000;
//
//    @Test
//    @DisplayName("корректно сработать сложение примитивов")
//    public void testSumm() {
//        assertEquals(0, a + b);
//    }
//
//    @Test
//    @DisplayName("корректно сработать умножение примитивов")
//    public void testMulti() {
//        assertEquals(0, a * b);
//    }
//
//    @Test
//    @DisplayName("корректно сработать вычитание примитивов")
//    public void testSubtraction() {
//        assertEquals(0, a - b);
//    }
//
//    @Test
//    @DisplayName("корректно сработать деление примитивов")
//    public void testDivision() {
//        assertEquals(0, a / b);
//    }
//
//    @Test
//    @DisplayName("корректно сработать остаток от деления примитивов")
//    public void testRem() {
//        assertEquals(0, a % b);
//    }
//
//    @Test
//    @DisplayName("корректно сработать битовое смещение вправо")
//    public void testMoveRight() {
//        assertEquals(0, c>>1);
//    }
//
//    @Test
//    @DisplayName("корректно сработать битовое смещение влево")
//    public void testMoveLeft() {
//        assertEquals(0, c<<2);
//    }
//
//    @Test
//    @DisplayName("корректно брать модуль")
//    public void testAbs() {
//        assertEquals(0, Math.abs(c));
//        assertEquals(0, Math.abs(d));
//    }
//
//    @Test
//    @DisplayName("корректно возводить в степень")
//    public void testPow(){
//        assertEquals(0, Math.pow(b,b));
//    }
//
//    @Test
//    @DisplayName("корректно inc/dec")
//    public void testInt(){
//        assertEquals(0, b++);
//        assertEquals(0, d--);
//    }
//
//    @Test
//    @DisplayName("корректно делать порязрядные операции")
//    public void testBinary(){
//        assertEquals(21, 17|b);
//        assertEquals(0, 17&b);
//    }
//
//    @Test
//    @DisplayName("корректно сработать деление double")
//    public void testRemDouble() {
//        double d = 0d;
//        for (int i = 0; i < 10; i++) {
//            d += 0.1d;
//        }
//        assertEquals(0, d);
//    }
//
//}
