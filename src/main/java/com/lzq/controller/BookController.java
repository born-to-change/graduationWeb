package com.lzq.controller;

import com.alibaba.fastjson.JSON;
import com.lzq.common.Resullt;
import com.lzq.pojo.Book;
import com.lzq.pojo.User;
import com.lzq.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/getBooksByUserId/{userId}", method = RequestMethod.GET)
    public @ResponseBody
    List<Book> getBooksByUserId(@PathVariable Integer userId) {
        return bookService.getBooksByUserId(userId);
    }

    @RequestMapping(value = "/getBookByBookId/{bookId}", method = RequestMethod.GET)
    public @ResponseBody
    Book getBookByBookId(@PathVariable String bookId) {
        return bookService.getBookByBookId(bookId);
    }

    @RequestMapping(value = "/getBooksBySearchKey/{key}", method = RequestMethod.GET)
    public @ResponseBody
    List<Book> getBooksBySearchKey(@PathVariable String key) {
        return bookService.getBooksBySearchKey(key);
    }

    @RequestMapping(value = "/createBook", method = RequestMethod.POST)
    @ResponseBody
    public Resullt.Result createBook(@RequestBody String data) {
        Book book = JSON.parseObject(data, Book.class);
        return bookService.createBook(book);
    }

    @RequestMapping(value = "/updateBook", method = RequestMethod.POST)
    @ResponseBody
    public Resullt.Result updateBook(@RequestBody String data) {
        Book book = JSON.parseObject(data, Book.class);
        return bookService.updateBook(book);
    }

    @RequestMapping(value = "/deleteBook/{bookId}", method = RequestMethod.GET)
    public @ResponseBody
    Resullt.Result deleteBook(@PathVariable String bookId) {
        return bookService.deleteBook(bookId);
    }
}
