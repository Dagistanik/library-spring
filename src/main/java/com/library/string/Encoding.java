package com.library.string;

import java.util.Arrays;

public class Encoding {
    public static void main(String[] args) {
        /*
         конвертировать String в массив byte - byte[]
         */
        String string = "new line";
        byte[] bytes = string.getBytes();
        System.out.println(Arrays.toString(bytes));

    }
}
