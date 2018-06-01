package com.lzq.junit;

import com.lzq.mapper.BookMapper;
import com.lzq.mapper.UserMapper;
import com.lzq.pojo.Book;
import com.lzq.service.UserService;
import com.lzq.utils.IDUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;

public class JunitTestBook {


    @Test
    public void testCreateBook() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookMapper mapper = ac.getBean(BookMapper.class);
        Book book = new Book();
        book.setBookId(IDUtils.createID());
        book.setBookName("幻夜");
        book.setPrice(new BigDecimal(3));
        book.setBookPress("南海出版社");
        book.setUserId(12);
        book.setBookDescription("21221212122");
        book.setBookImage("../image/bookImg/s3960322.jpg");
        mapper.createBook(book);
    }

    @Test
    public void testGetBookByUserId() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookMapper mapper = ac.getBean(BookMapper.class);
        System.out.println(mapper.getBooksByUserId(7));
    }

    @Test
    public void testGetBooksBySearchKey() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookMapper mapper = ac.getBean(BookMapper.class);
        List<Book> books = mapper.getBooksBySearchKey("数学");
        books.forEach(x ->{
            System.out.println(x.toString());
        });

    }

    @Test
    public void testUpdateBook() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookMapper mapper = ac.getBean(BookMapper.class);
        Book book = mapper.getBookByBookId("152664692183565913551");
        book.setBookName("高等数学2");
        book.setPrice(new BigDecimal(2));
        book.setBookPress("高教");
        book.setUserId(7);
        book.setBookDescription("很多22wqq，2112版");
        book.setBookImage("/book/play");
        mapper.updateBook(book);
    }


    @Test
    public void testDeleteBook() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookMapper mapper = ac.getBean(BookMapper.class);
        mapper.deleteBook("152664517218317436989");
    }
   /* List<Book> getBooksByUserId(Integer userId);

    List<Book> getBooksBySearchKey(String key);

    void createBook(Book book);

    void updateBook(Book book);

    void deletdBook(String bookId);*/


}
