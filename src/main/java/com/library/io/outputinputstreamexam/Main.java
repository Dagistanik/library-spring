package com.library.io.outputinputstreamexam;


public class Main {
    private static final String PATH = "E:/data.txt";

    public static void main(String[] args) {
        InputOutputStreamExam inputOutputStreamExam = new InputOutputStreamExam(PATH);
        inputOutputStreamExam.write("Hello World ");
        inputOutputStreamExam.read();
    }
}
