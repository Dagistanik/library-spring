package com.library.string;

public class StringBufferPassword {
    public static String randonMumber(int size){
        StringBuffer sb = new StringBuffer();
        int a = 0;
        int b = 9;

        for (int i = 0; i < size; i++) {
            int number = a + (int) (Math.random() * b);
            sb.append(number);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String result = randonMumber(9);
        System.out.println(result);
    }
}
