package com.lzq.service;

import com.lzq.common.Resullt;
import com.lzq.pojo.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookService {
    List<Book> getBooksByUserId(Integer userId);

    Book getBookByBookId(String bookId);

    List<Book> getBooksBySearchKey(String key);

    Resullt.Result createBook(Book book);

    Resullt.Result updateBook(Book book);

    Resullt.Result deleteBook(String bookId);
}
