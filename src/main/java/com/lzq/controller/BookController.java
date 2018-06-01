package com.lzq.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.lzq.common.Resullt;
import com.lzq.pojo.Book;
import com.lzq.pojo.User;
import com.lzq.service.BookService;
import com.lzq.utils.IDUtils;
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
    @RequestMapping(value = "/getBooksByUserId", method = RequestMethod.POST)
    @ResponseBody
    public List<Book> getBooksByUserId(@RequestBody String data){
        Map<String,Integer> keyMap = JSON.parseObject(data,Map.class);
        if(keyMap.get("data").equals(7)) {
            return bookService.getBooksByUserId(UserController.getCurrentUserId());
        }else {
            return bookService.getBooksByUserId(Integer.valueOf(keyMap.get("data")));
        }
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
        Map<String,String> keyMap = JSON.parseObject(data,Map.class);
        Gson gson = new Gson();
        String bookInfo = gson.toJson(keyMap.get("data"));
        Book book= gson.fromJson(bookInfo, Book.class);
        book.setUserId(UserController.getCurrentUserId());
        book.setBookId(IDUtils.createID());
        String imagePath = book.getBookImage();
        String[] item = imagePath.split("\\\\");
        book.setBookImage("../image/bookImg/"+ item[item.length-1]);
        return bookService.createBook(book);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/updateBook", method = RequestMethod.POST)
    @ResponseBody
    public Resullt.Result updateBook(@RequestBody String data) {
        Map<String,String> keyMap = JSON.parseObject(data,Map.class);
        Gson gson = new Gson();
        String bookInfo = gson.toJson(keyMap.get("data"));
        Book book= gson.fromJson(bookInfo, Book.class);
        book.setUserId(UserController.getCurrentUserId());
        return bookService.updateBook(book);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/deleteBook", method = RequestMethod.POST)
    @ResponseBody
    public Resullt.Result deleteBook(@RequestBody String data) {
        Map<String,String> keyMap = JSON.parseObject(data,Map.class);
        return bookService.deleteBook(keyMap.get("data"));
    }
}
