package com.library.string;

public class Password {
    public static void randomNumber(int size){
        String password = "";
        int a = 0;
        int b = 9;

        for (int i = 0; i < size; i++){
            int randomNumber = a + (int) (Math.random() * b);
            password += randomNumber;
        }
        System.out.println(password);
    }

    public static void main(String[] args) {
        randomNumber(10);
    }
}
