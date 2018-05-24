package com.lzq.mapper;

import com.lzq.pojo.Book;

import java.util.List;

public interface BookMapper {
    List<Book> getBooksByUserId(Integer userId);

    Book getBookByBookId(String bookId);

    List<Book> getBooksBySearchKey(String key);

    void createBook(Book book);

    void updateBook(Book book);

    void deleteBook(String bookId);

}
