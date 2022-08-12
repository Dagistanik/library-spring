package com.library.io.outputinputstreamexam;

import java.io.*;

public class InputOutputStreamExam {
    private final String path;

    public InputOutputStreamExam(String path){
        this.path = path;
    }

    public void write(String st) {
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(path);
            outputStream.write(st.getBytes());
        } catch (FileNotFoundException e) {
            System.err.println("File is not found " + path);
        } catch (IOException e){
            System.err.println("Error Writing to file");
        } finally {
                try {
                    assert outputStream != null;
                    outputStream.close();
                } catch (IOException e) {
                    System.err.println("Не получилось закрыть файл.");
                }
        }
    }

    public void read() {
        FileInputStream inputStream = null;
        int data = 0;
        try {
            inputStream = new FileInputStream(path);
            data = inputStream.read();
        } catch (FileNotFoundException e) {
            System.err.println("File is not found " + path);
        } catch (IOException e) {
            System.err.println("Empty file " + path);;
        }
        char content;
        while (data != -1) {
            content = (char) data;
            System.out.println(content);
            try {
                assert inputStream != null;
                data = inputStream.read();
            } catch (IOException e) {
                System.err.println("Empty file " + path);;
            }  finally {
                if(inputStream == null){
                    try {
                        assert false;
                        inputStream.close();
                    } catch (IOException e) {
                        System.err.println("File is not closed!");;
                    }
                }
            }
        }
    }
}
