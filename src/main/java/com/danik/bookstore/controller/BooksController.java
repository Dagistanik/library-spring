package com.danik.bookstore.controller;

import com.danik.bookstore.dao.BookDAOImpl;
import com.danik.bookstore.model.Book;
import com.danik.bookstore.model.BookWithAuthor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.util.*;

@Controller
@RequestMapping("/sqlbook")
public class SqlBookController {
    BookDAOImpl bookDAO = new BookDAOImpl();

    @GetMapping
    public String list(HttpServletRequest req) {
        List<BookWithAuthor> books =bookDAO.getBooksWithAuthors();
        req.setAttribute("books", books);
        return "book/view-books";
    }

//    @PostMapping("/search")
//    public String authInfo(
//            @RequestParam(name = "title", required = true) String title,
//            HttpServletRequest req) {
//        List<Book> books = bookDAO.searchByTitle(title);
//        req.setAttribute("books", books);
//        return "book/search";
//    }

    @GetMapping("/add")
    public String addBookView() {
        return "book/add-book";
    }

    @PostMapping("/add")
    public String addBook(
            @RequestParam(name = "id", required = true) int id,
            @RequestParam(name = "title", required = true) String title,
            @RequestParam(name = "author_id", required = false) int author_id,
            @RequestParam(name = "year", required = false) int year,
            @RequestParam(name = "pages", required = false) int pages,
            HttpServletRequest req, HttpServletResponse resp) {

        bookDAO.create(new Book(id, title, author_id, year, pages));

        return "redirect:list";
    }
}

