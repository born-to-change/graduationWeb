package com.lzq.controller;

import com.lzq.common.Resullt;
import com.lzq.pojo.Book;
import com.lzq.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;


    @RequestMapping("/getBooksByUserId")
    public List<Book> getBooksByUserId(Integer userId) {
        return bookService.getBooksByUserId(userId);
    }

    @RequestMapping("/getBookByBookId")
    public Book getBookByBookId(String bookId) {
        return bookService.getBookByBookId(bookId);
    }

    @RequestMapping("/getBooksBySearchKey")
    public List<Book> getBooksBySearchKey(String key) {
        return bookService.getBooksBySearchKey(key);
    }

    @RequestMapping("/createBook")
    public Resullt.Result createBook(Book book) {
        return bookService.createBook(book);
    }

    @RequestMapping("/updateBook")
    public Resullt.Result updateBook(Book book) {
        return bookService.updateBook(book);
    }

    @RequestMapping("/deleteBook")
    public Resullt.Result deleteBook(String bookId) {
        return bookService.deleteBook(bookId);
    }
}
