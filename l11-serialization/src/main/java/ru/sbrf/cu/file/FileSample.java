package ru.sbrf.cu.file;

import java.io.File;

public class FileSample {
    public static void main(String[] args){
        File file = new File("l11-serialization/src/main");

        System.out.println(file.exists());

    }
}
