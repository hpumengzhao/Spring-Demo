package org.codancer;

import java.util.Locale;
import java.util.ResourceBundle;

public class Resourcei18n {
    public static void main(String[] args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", new Locale("zh", "CN"));
        String value1 = resourceBundle.getString("test");
        System.out.println(value1);


        ResourceBundle resourceBundle1 = ResourceBundle.getBundle("message", new Locale("en", "GB"));
        String value2 = resourceBundle1.getString("test");
        System.out.println(value2);
    }
}
