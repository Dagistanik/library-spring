package com.library.string;

public class Compare {
    public static boolean worldCompare(String firstWord, String secondWord){
        if (firstWord.length() == secondWord.length()){
            for (int i = 0; i <= firstWord.length()-1 ; i++) {
                while (firstWord.charAt(i) != secondWord.charAt(i)){
                    System.out.println("The lines are not the equal");
                }
            }
        }
        System.out.println("The strings equals");
        return false;
    }
    public static void main(String[] args) {
        worldCompare("abcd", "aecd");
    }
}
