package com.library.string;

public class MirrorCopy {
    public static String mirror(String word){
        StringBuilder newWord = new StringBuilder();

        for (int i = word.length() - 1; i >= 0 ; i--) {
            newWord.append(word.charAt(i));
        }
//        System.out.println(newWord);
        return String.valueOf(newWord);
    }

    public static void main(String[] args) {
        System.out.println(mirror("headphones"));
    }
}
