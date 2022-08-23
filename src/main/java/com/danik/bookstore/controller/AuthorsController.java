package com.danik.bookstore.controller;

import com.danik.bookstore.dao.*;
import com.danik.bookstore.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorsController {
    @Resource
    AuthorDAO authorDAO;
    @Resource
    BookDAO bookDAO;

    @GetMapping("/{authorId}")
    public String authInfo(
            HttpServletRequest req,
            @PathVariable("authorId") int authorId)
    {
        Author author = authorDAO.getById(authorId);
        req.setAttribute("author", author);

        List<Book> books = bookDAO.getByAuthorId(authorId);
        req.setAttribute("books", books);

        return "author/details";
    }
}
