package com.lzq.service;

import com.lzq.common.ResultInfo;
import com.lzq.pojo.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookService {
    List<Book> getBooksByUserId(Integer userId);

    Book getBookByBookId(String bookId);

    List<Book> getBooksBySearchKey(String key);

    ResultInfo.Result createBook(Book book);

    ResultInfo.Result updateBook(Book book);

    ResultInfo.Result deleteBook(String bookId);
}
