package org.codancer;

import org.springframework.core.io.UrlResource;

public class UrlResourceDemo {

    public static void main(String[] args) {
        loadUrlResource("https://www.baidu.com");

        loadUrlResource("file");
    }
    public static void loadUrlResource(String path) {
        try {
            UrlResource urlResource = new UrlResource(path);
            System.out.println(urlResource.getFilename());
            System.out.println(urlResource.getURL());
            System.out.println(urlResource.getDescription());

        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }
}
