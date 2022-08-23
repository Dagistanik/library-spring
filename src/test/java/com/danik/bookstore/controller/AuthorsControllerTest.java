package com.danik.bookstore.controller;

import com.danik.bookstore.dao.AuthorDAO;
import com.danik.bookstore.dao.BookDAO;
import com.danik.bookstore.model.Author;
import com.danik.bookstore.model.Book;
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
import java.util.*;

@SpringBootTest(classes = {AuthorsController.class})
@AutoConfigureMockMvc
class AuthorsControllerTest {
        @MockBean
        AuthorDAO authorDAO;

        @MockBean
        BookDAO bookDAO;

        @Resource
        private MockMvc mvc;

        @Test
        public void testSomething() throws Exception {
                //create test request
                MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/authors/1/");

                //execute request in virtual browser
                MvcResult result = mvc.perform(req).andReturn();

                //check result
                assert result.getResponse().getStatus() == HttpServletResponse.SC_OK;

                assert result.getModelAndView().getViewName() == "author/details";
        }

        @Test
        public  void searchById() throws Exception{
                //create test data
                Author author = new Author(1, "Лев Толстой", new Date(1800, Calendar.FEBRUARY, 1), "RU");
                List<Author> testAuthor = new ArrayList<>();
                testAuthor.add(author);

                Mockito.when(authorDAO.getById(1)).thenReturn(author);

                MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/authors/1/");

                //execute request in virtual browser
                MvcResult result = mvc.perform(req).andReturn();


                Author authors = (Author) result.getRequest().getAttribute("author");
                assert authors == author;
        }
        @Test
        public void searchByAuthorId() throws Exception{
                Book book1 = new Book(1, "asd1", 1, 1840, 1000);
                Book book2 = new Book(2, "asd2", 1, 2017, 300);
                List<Book> testBooks = Arrays.asList(book1, book2);

                Mockito.when(bookDAO.getByAuthorId(1)).thenReturn(testBooks);

                MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/authors/1/");

                MvcResult result = mvc.perform(req).andReturn();

                List<Book> books = (List<Book>) result.getRequest().getAttribute("books");
                assert books.size() == 2;
        }
}