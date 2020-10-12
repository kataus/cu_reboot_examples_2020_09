package ru.sbrf.cu.j8.functional;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
    private final int x = 0;

    public static void main(String[] args) {
        List<String> list = List.of("AA", "BBB", "C");

        List list1 = List.of(1, 2, 3, 4, 3, 2, 6);

        // создание инстанса
        Collections.sort(list, new MyComparator());

        // анонимный класс
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        Collections.sort(list, (s1, s2) -> {
            return s1.length() - s2.length();
        });

        Collections.sort(list, Comparator.comparingInt(String::length));


        // Типы можно вывести
        Collections.sort(list, (s1, s2) -> {
            return s1.length() - s2.length();
        });

        Collections.sort(list, Comparator.comparingInt(s -> s.length()));

        Collections.sort(list, Comparator.comparingInt(String::length));
    }

    public void checkId() {

        List<String> list = List.of("AA", "BBB", "C");
        Collections.sort(list, (s1, s2) -> {
            return s1.length() - s2.length();

        });

//    return 0;
    }

    // Описание в отдельном классе
    static class MyComparator implements Comparator<String> {
        @Override
        public int compare(@NotNull String o1, @NotNull String o2) {

            return o1.length() - o2.length();
        }
    }
}
