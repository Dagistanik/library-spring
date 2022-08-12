package com.library.controller;

import com.library.project.Library;
import com.library.project.products.Book;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.*;

@Controller
@RequestMapping("/book")
public class BookController {
     Library library = Library.getInstance();

    @GetMapping("/list")
    public String books(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("books", library.getBooks());
        return "view-books";
    }

    @GetMapping("/add")
    public String addBookView(HttpServletRequest req, HttpServletResponse resp) {
        return "add-book";
    }

    @PostMapping("/add")
    public String addBook(
            @RequestParam(name="id",required = true) String id,
            @RequestParam(name="title",required = true) String title,
            @RequestParam(name="author",required = false) String author,
            @RequestParam(name="year",required = false) String year,
            @RequestParam(name="pages",required = false) String pages,
            HttpServletRequest req, HttpServletResponse resp) {

        Book book = new Book(
                NumberUtils.toInt(id),
                title,
                author,
                NumberUtils.toInt(year),
                NumberUtils.toInt(pages));
        library.add(book);

        return "redirect:list";
    }
}
