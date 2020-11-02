package ru.sbrf.cu.file;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("В файловой системе надо")
public class FileSystemScanDemo {

    @DisplayName("посчитать сколько раз в tmp встречается файл с именем newFile-r.txt")
    @Test
    public void sample1() {
        // TODO 1
        File file = new File("tmp");
        int count = calculateCount(file, "newFile-r.txt");
        assertEquals(2, count);
    }

    @DisplayName("посчитать сколько в tmp файлов с расширирением txt")
    @Test
    public void sample2() {
        // TODO 2
        File file = new File("tmp");
        int count = calculateExtentionCount(file);
        assertEquals(6, count);
    }

    @DisplayName("посчитать сколько раз в tmp встречается файл с именем newFile-r.txt без рекурсии")
    @Test
    public void sample2_() {
        // TODO 2
        int result = 0;
        File file = new File("tmp");
        Queue<File> files = new LinkedList<>();
        files.add(file);
        while (!files.isEmpty()) {
            file = files.poll();
            if (file.isDirectory()) {
                files.addAll(Arrays.asList(file.listFiles()));
            } else if (file.isFile() && file.getName().equals("newFile-r.txt")) {
                result++;
            }
        }
        assertEquals(2, result);
    }

    private int calculateCount(File file, String name) {
        int result = 0;
        if (file.exists()) {
            for (File subFile : file.listFiles()) {
                if (subFile.isDirectory()) {
                    result += calculateCount(subFile, name);
                } else if (subFile.isFile() && subFile.getName().equals(name)) {
                    result++;
                }
            }
        }
        return result;
    }

    private int calculateExtentionCount(File file) {
        int result = 0;
        if (file.exists()) {
            FileFilter fileFilter = pathname -> pathname.isDirectory() || pathname.getName().endsWith("txt");
            for (File subFile : file.listFiles(fileFilter)) {
                if (subFile.isDirectory()) {
                    result += calculateExtentionCount(subFile);
                } else if (subFile.isFile()) {
                    result++;
                }
            }
        }
        return result;
    }
}
