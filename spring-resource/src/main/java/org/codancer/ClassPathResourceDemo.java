package org.codancer;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

public class ClassPathResourceDemo {

    public static void main(String[] args) throws IOException {
        loadClassPathResource("a.txt");
    }
    public static void loadClassPathResource(String path) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource(path);
        try {
            InputStream inputStream = classPathResource.getInputStream();

            byte[] b = new byte[5];
            while (inputStream.read(b) != -1) {
                System.out.println(new String(b));
            }
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }
}
