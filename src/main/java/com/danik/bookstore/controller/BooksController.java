package com.danik.bookstore.controller;

import com.danik.bookstore.dao.BookDAO;
import com.danik.bookstore.model.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.*;
import java.util.*;

@Controller
@RequestMapping("/books")
public class BooksController {

    @Resource
    BookDAO bookDAO;

    @GetMapping
    public String list(HttpServletRequest req) {
        List<BookWithAuthor> books =bookDAO.getBooksWithAuthors();
        req.setAttribute("books", books);
        return "book/view-books";
    }

    @GetMapping(params = "title")
    public String list(
            @RequestParam(name = "title", required = true) String title,
            HttpServletRequest req)
    {
        if (StringUtils.isBlank(title)){
            return "redirect:/books";}
        req.setAttribute("title", title);
        List<BookWithAuthor> books = bookDAO.getBooksWithAuthors(title);
        req.setAttribute("books", books);

        return "book/view-books";
    }

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

        return "redirect:";
    }
}

