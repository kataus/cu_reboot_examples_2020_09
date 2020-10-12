package ru.sbrf.cu.j8.functional;

@FunctionalInterface
public interface OneAbsMethodClass {
    int m1();
    default int m2() {
        return m1();
    }
}
