package com.library.io.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Exception {
    public static void main(String[] args) {
            try {
                InputStream inputStream = new FileInputStream("E:/data1.txt");
            } catch (FileNotFoundException e) {
                System.out.println("The file does not exist");;
            }

    }
}
