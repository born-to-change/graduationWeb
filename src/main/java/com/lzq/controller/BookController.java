package com.lzq.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.lzq.common.Resullt;
import com.lzq.pojo.Book;
import com.lzq.pojo.User;
import com.lzq.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getBooksByUserId/{userId}", method = RequestMethod.GET)
    public @ResponseBody
    List<Book> getBooksByUserId(@PathVariable Integer userId) {
        return bookService.getBooksByUserId(userId);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getBookByBookId/{bookId}", method = RequestMethod.GET)
    public @ResponseBody
    Book getBookByBookId(@PathVariable String bookId) {
        return bookService.getBookByBookId(bookId);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getBooksBySearchKey", method = RequestMethod.POST)
    @ResponseBody
    public List<Book> getBooksBySearchKey(@RequestBody String data) throws Exception{
        String jsonData = URLDecoder.decode(data,"UTF-8");
        Map<String,String> keyMap = JSON.parseObject(jsonData,Map.class);
        return bookService.getBooksBySearchKey(keyMap.get("data"));
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/createBook", method = RequestMethod.POST)
    @ResponseBody
    public Resullt.Result createBook(@RequestBody String data) {
        Book book = JSON.parseObject(data, Book.class);
        return bookService.createBook(book);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/updateBook", method = RequestMethod.POST)
    @ResponseBody
    public Resullt.Result updateBook(@RequestBody String data) {
        Book book = JSON.parseObject(data, Book.class);
        return bookService.updateBook(book);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/deleteBook/{bookId}", method = RequestMethod.GET)
    public @ResponseBody
    Resullt.Result deleteBook(@PathVariable String bookId) {
        return bookService.deleteBook(bookId);
    }
}
