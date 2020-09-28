//package ru.sbrf.cu.l02.animals;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@DisplayName("Новые классы должны")
//public class ObjectsTest {
//
//    @Test
//    @DisplayName("создаваться конструктором")
//    public void testNewClasses() {
//        // TODO Что будет корректно а что нет?
////        Animal animal = new Animal();
////        Mammal mammal = new Mammal();
////        Cat cat = new Cat();
////        Dog dog = new Dog();
////        Mammal catM = new Cat();
////        Animal dogA = new Dog();
//    }
//
//    @Test
//    @DisplayName("соответствовать родителям")
//    public void testClassHierarchy() {
//        Mammal dog = null; // TODO создать корректно собаку
//        assertTrue(dog instanceof Dog);
//        assertTrue(dog instanceof Mammal);
//        assertTrue(dog instanceof Animal);
//        assertTrue(dog instanceof Object);
//    }
//
//    @Test
//    @DisplayName("пользоваться методам родителя")
//    public void testClassMethods() {
//        Mammal mammal = new Cat();
////        mammal.eat();
////        mammal.getMilk();
////        mammal.murrr();
//
//        Mammal dog = new Dog();
////        mammal.equals(dog);
//    }
//
//    @Test
//    @DisplayName("исключения отрабатывают")
//    public void testExceptions() {
//        Cat cat = new Cat();
//        Dog dog = new Dog();
//
//        assertThrows(RuntimeException.class, () -> {
//                //TODO что сделать чтобы исключения?
//                }
//        );
//        dog.meet(cat);
//    }
//}
