package com.library.string;

public class StringBuilderPassword {
    public static void randomNumber(int size){
        StringBuilder password = new StringBuilder();
        int a = 0;
        int b = 9;

        for (int i = 0; i < size; i++) {
            int randomNumber = a + (int) (Math.random() * b);
            password.append(randomNumber);
        }
        System.out.println(password);
    }

    public static void main(String[] args) {
        randomNumber(9);
    }
}
