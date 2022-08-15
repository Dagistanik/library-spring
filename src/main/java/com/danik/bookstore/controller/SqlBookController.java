package com.danik.bookstore.controller;

import com.danik.bookstore.dao.BookDAOImpl;
import com.danik.bookstore.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.util.*;

@Controller
@RequestMapping("/sqlbook")
public class SqlBookController {
    BookDAOImpl bookDAO = new BookDAOImpl();

    @GetMapping("/list")
    public String books(HttpServletRequest req) {
        List<Book> books = bookDAO.getAll();
        req.setAttribute("books", books);
        return "view-sqlbook";
    }

    @GetMapping("/add")
    public String addBookView() {
        return "add-sqlbook";
    }

    @PostMapping("/add")
    public String addBook(
            @RequestParam(name="id",required = true) int id,
            @RequestParam(name="title",required = true) String title,
            @RequestParam(name="author",required = false) String author,
            @RequestParam(name="year",required = false) int year,
            @RequestParam(name="pages",required = false) int pages,
            HttpServletRequest req, HttpServletResponse resp){

        bookDAO.save(new Book(id, title, author, year, pages));

        return "redirect:list";
    }
}

