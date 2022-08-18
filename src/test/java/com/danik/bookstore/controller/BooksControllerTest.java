package com.danik.bookstore.controller;

import com.danik.bookstore.dao.BookDAO;
import com.danik.bookstore.model.Author;
import com.danik.bookstore.model.Book;
import com.danik.bookstore.model.BookWithAuthor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@SpringBootTest(
        classes = {
                BooksController.class
        }
)
@AutoConfigureMockMvc
class BooksControllerTest {

    @MockBean
    BookDAO bookDAO;

    @Resource
    private BooksController controller;

    @Resource
    private MockMvc mvc;


    @Test
    public void testSomething() throws Exception {
        //create test data
        Book book1 = new Book(1, "Война и мир", 1, 1840, 1000);
        Book book2 = new Book(2, "Bobiverse", 2, 2017, 300);
        Author author1 = new Author(1, "Лев Толстой", new Date(1800, 1, 1), "RU");
        Author author2 = new Author(2, "Dennis Taylor", new Date(1970, 2, 2), "US");
        BookWithAuthor bwa1 = new BookWithAuthor(book1, author1);
        BookWithAuthor bwa2 = new BookWithAuthor(book2, author2);
        List<BookWithAuthor> testData = Arrays.asList(bwa1, bwa2);

        //emulate mock behavior
        Mockito.when(bookDAO.getBooksWithAuthors()).thenReturn(testData);


        //create test request
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/books");


        //execute request in virtual browser
        MvcResult result = mvc.perform(req).andReturn();

        //check results
        assert result.getResponse().getStatus() == HttpServletResponse.SC_OK;

        assert result.getModelAndView().getViewName() == "book/view-books";
        List<BookWithAuthor> books = (List<BookWithAuthor>) result.getRequest().getAttribute("books");

        assert books != null && books.size() > 0;

        System.out.println("Tested!!!");
    }


    @Test
    public void testSearchByTitle() throws Exception {
        //create test data
        Book book1 = new Book(1, "asd1", 1, 1840, 1000);
        Book book2 = new Book(2, "asd2", 2, 2017, 300);
        Author author1 = new Author(1, "Лев Толстой", new Date(1800, 1, 1), "RU");
        Author author2 = new Author(2, "Dennis Taylor", new Date(1970, 2, 2), "US");
        BookWithAuthor bwa1 = new BookWithAuthor(book1, author1);
        BookWithAuthor bwa2 = new BookWithAuthor(book2, author2);
        List<BookWithAuthor> testData = Arrays.asList(bwa1, bwa2);

        //emulate mock behavior
        Mockito.when(bookDAO.getBooksWithAuthors("asd")).thenReturn(testData);


        //create test request
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders
                .get("/books?title=asd");


        //execute request in virtual browser
        MvcResult result = mvc.perform(req).andReturn();

        //check results
        assert result.getResponse().getStatus() == HttpServletResponse.SC_OK;

        assert result.getModelAndView().getViewName() == "book/view-books";
        List<BookWithAuthor> books = (List<BookWithAuthor>) result.getRequest().getAttribute("books");

        assert books.size() == 2;

        System.out.println("Tested!!!");
    }


    @Test
    public void testRedirectToBooksListPage() throws Exception {
        //create test request
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders
                .get("/books?title=");


        //execute request in virtual browser
        MvcResult result = mvc.perform(req).andReturn();

        //check results
        assert result.getResponse().getRedirectedUrl().equals("/books");
    }


}