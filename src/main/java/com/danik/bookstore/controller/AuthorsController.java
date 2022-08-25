package com.danik.bookstore.controller;

import com.danik.bookstore.dao.*;
import com.danik.bookstore.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/authors")
public class AuthorsController {
    @Resource
    AuthorDAO authorDAO;
    @Resource
    BookDAO bookDAO;

    @GetMapping("/{authorId}")
    public String authorInfo(
            HttpServletRequest req,
            @PathVariable("authorId") int authorId) {
        Author author = authorDAO.getById(authorId);
        if(author == null) {
            throw new NoSuchElementException("Author not found " + authorId);
        }
        req.setAttribute("author", author);

        List<Book> books = bookDAO.getByAuthorId(authorId);
        req.setAttribute("books", books);

        return "author/details";
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String onNotFoundException(NoSuchElementException ex){
        System.out.println(ex.getMessage());
        return "error";
    }
}
