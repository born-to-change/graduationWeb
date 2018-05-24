package com.lzq.service;

import com.lzq.common.Resullt;
import com.lzq.mapper.BookMapper;
import com.lzq.pojo.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;


    public Resullt.Result createBook(Book book) {
        Resullt.Result ret = Resullt.Result.builder().isFailed(true).build();
        try {
            bookMapper.createBook(book);

        } catch (Exception e) {
            log.warn("create book failed", e);
            ret.setFailed(false);
            ret.setErrorMessage(e.getMessage());
            return ret;
        }
        return ret;
    }

    public Resullt.Result updateBook(Book book) {
        Resullt.Result ret = Resullt.Result.builder().isFailed(true).build();
        try {
            bookMapper.updateBook(book);

        } catch (Exception e) {
            log.warn("update book failed", e);
            ret.setFailed(false);
            ret.setErrorMessage(e.getMessage());
            return ret;
        }
        return ret;
    }

    public Resullt.Result deleteBook(String bookId) {
        Resullt.Result ret = Resullt.Result.builder().isFailed(true).build();
        try {
            bookMapper.deleteBook(bookId);

        } catch (Exception e) {
            log.warn("delete book failed", e);
            ret.setFailed(false);
            ret.setErrorMessage(e.getMessage());
            return ret;
        }
        return ret;
    }

    public List<Book> getBooksByUserId(Integer userId){
        List<Book> bookList;
        try{
            bookList = bookMapper.getBooksByUserId(userId);
        }catch (Exception e){
            log.warn("query books by userId failed",e);
            return null;
        }
        return bookList;
    }

    public List<Book> getBooksBySearchKey(String key){
        List<Book> bookList;
        try{
            bookList = bookMapper.getBooksBySearchKey(key);
        }catch (Exception e){
            log.warn("query books by searchKey failed",e);
            return null;
        }
        return bookList;
    }

    public Book getBookByBookId(String bookId){
         Book book;
        try{
            book = bookMapper.getBookByBookId(bookId);
        }catch (Exception e){
            log.warn("query book by bookId failed",e);
            return null;
        }
        return book;
    }
}
