package ru.sbrf.cu.json.gson;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class GsonDemo {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        BagOfPrimitives obj = new BagOfPrimitives(22, "test", 10);
        System.out.println(obj);

        String json = gson.toJson(obj);
        System.out.println(json);

        BagOfPrimitives obj2 = gson.fromJson(json, BagOfPrimitives.class);
        System.out.println(obj.equals(obj2));
        System.out.println(obj2);

        InputStream inputStream = new InputStream() {
            @Override
            public int read() throws IOException {
                return 1;
            }
        };

        OutputStream outputStream = new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }
        };

        byte[] buf = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buf)) > 0) {
            outputStream.write(buf, 0, bytesRead);
        }
    }
}
