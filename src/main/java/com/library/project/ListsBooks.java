package com.library.project;


import com.library.project.products.Book;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ListsBooks {
    public static void main(String[] args) {
        Book book1 = new Book(1, "aaa", "sdd", 32, 2425);
        Book book2 = new Book(1, "aaa", "sdd", 32, 2425);
        Book book3 = new Book(1, "aaa", "sdd", 32, 2425);

        List<Book> list = new ArrayList<>();
        list.add(book3);
        list.add(book3);
        list.add(book1);
        list.add(book1);
        list.add(book2);
        list.add(book2);
        for(Book o : list){
            System.out.println("list : " + o);
        }

        System.out.println();


        List<Book> list2 = new ArrayList<>(list);
        list2.sort((o1, o2) -> Integer.compare((o2.getId()), o1.getId()));

        for (Object o : list2){
            System.out.println("lis2 : " + o);
        }

        System.out.println();

        List <Book> list3 = new ArrayList<>(list);
        list3.sort((o1, o2) -> o2.getTitle().compareTo(o1.getTitle()));
        for (Object o :list3){
            System.out.println("list3 : " + o);
        }

        System.out.println();
        Set<Book> set = new LinkedHashSet<>(list);
        for (Object o : set){
            System.out.println("set : " + o);
        }
    }
}
