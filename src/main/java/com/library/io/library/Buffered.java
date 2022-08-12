package com.library.io.library;

import com.library.project.products.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Buffered {
    public static void main(String[] args) throws IOException {
        Book book1 = new Book(1, "Приключения Незнайки", "qwe", 2010, 567);
        Book book2 = new Book(2, "Приключения Электроника", "df", 2022, 467);

        BufferedWriter bw = new BufferedWriter(new FileWriter("E:/java/libraryBuff.bin"));

        bw.write(String.valueOf(book1));
        bw.write(String.valueOf(book2));
        bw.close();

        BufferedReader br = new BufferedReader(new FileReader("E:/java/library.bin"));

        List<String> loadedBooks = new ArrayList<>();

        loadedBooks.add(br.readLine());
        loadedBooks.add(br.readLine());

        for (String book : loadedBooks) {
            System.out.println(book);
        }
        br.close();
    }
}
