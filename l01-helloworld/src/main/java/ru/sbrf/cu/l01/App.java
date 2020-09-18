package ru.sbrf.cu.l01;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args){
        List<String> items = new ArrayList<>();
        items.add("Hello");
        items.add(" ");
        items.add("World");
        items.add("!");
        StringBuilder sb = new StringBuilder();
        items.forEach(s -> sb.append(s));
        System.out.println(sb.toString());
    }
}
