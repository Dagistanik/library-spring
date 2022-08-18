package com.danik.bookstore.controller;

import com.danik.bookstore.dao.AuthorDAO;
import com.danik.bookstore.dao.AuthorDAOImpl;
import com.danik.bookstore.dao.BookDAO;
import com.danik.bookstore.dao.BookDAOImpl;
import com.danik.bookstore.model.Author;
import com.danik.bookstore.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorsContrloler {
    AuthorDAO authorDAO = new AuthorDAOImpl();
    BookDAO bookDAO = new BookDAOImpl();

    @GetMapping("/{authorId}")
    public String authInfo(
            HttpServletRequest req,
            @PathVariable("authorId") int authorId)
    {
        Author author = authorDAO.getById(authorId);
        req.setAttribute("author", author);

        List<Book> books = bookDAO.getByAuthorId(authorId);
        req.setAttribute("books", books);

        return "author-info";
    }
}
