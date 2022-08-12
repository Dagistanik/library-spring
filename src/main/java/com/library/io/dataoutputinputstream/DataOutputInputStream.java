package com.library.io.dataoutputinputstream;

import java.io.*;

public class DataOutputInputStream {

    private final String path;

    public DataOutputInputStream(String path){
        this.path = path;
    }

    public void write() throws IOException {
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(new FileOutputStream(path));
            out.writeUTF("Hello UTF");

        } catch (FileNotFoundException e) {
            System.err.println("file is not found " + path);;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        out.flush(); // what it does?
    }

    public void read() {
        DataInputStream in = null;
        try {
            in = new DataInputStream(new FileInputStream(path));
        } catch (FileNotFoundException e) {
            System.out.println("File is not found "+ path);;
        }
        String data = null;
        try {
            assert in != null;
            data = in.readUTF();
        } catch (IOException e) {
            System.err.println("Empty file");;
        }
        System.out.println(data);
    }
}
