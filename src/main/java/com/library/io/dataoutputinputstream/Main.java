package com.library.io.dataoutputinputstream;

import java.io.IOException;

public class Main {
    private static final String PATH = "E:/data.txt";

    public static void main(String[] args) throws IOException {
        DataOutputInputStream dataOutputInputStream = new DataOutputInputStream(PATH);
        dataOutputInputStream.write();
        dataOutputInputStream.read();
    }
}
