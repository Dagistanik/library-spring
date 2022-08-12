package com.library.io.bufferedwriterreader;

import java.io.IOException;

public class Main {
    private final static String PATH = "E:/data.txt";

    public static void main(String[] args) throws IOException {
        BufferedWriterReader bufferedWriterReader = new BufferedWriterReader(PATH);
        bufferedWriterReader.BuffWriter("HELLO java");
        bufferedWriterReader.BuffReader();
    }
}
