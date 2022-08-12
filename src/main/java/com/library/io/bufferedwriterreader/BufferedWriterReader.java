package com.library.io.bufferedwriterreader;

import java.io.*;

public class BufferedWriterReader {
    String path;

    public BufferedWriterReader(String path){
        this.path = path;
    }

    public void BuffWriter(String st) {
        BufferedWriter buff = null;
        try {
            buff = new BufferedWriter(new FileWriter(path));
            buff.write(st);
        } catch (IOException e) {
            System.err.println("File is not found " + path);;
        } finally {
            try {
                assert buff != null;
                buff.close();
            } catch (IOException e) {
                System.err.println("File is not closed!");;
            }
        }
    }

    public void BuffReader() throws IOException {
        BufferedReader buffRead = null;
        try {
            buffRead = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            System.err.println("File is not found " + path);;
        }
        String c;
        while ((c=buffRead.readLine()) != null){
            System.out.println(c);
        }
        try {
            buffRead.close();
        } catch (IOException e) {
            System.err.println("File is not closed");
        }
    }
}
