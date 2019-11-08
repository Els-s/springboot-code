package org.javaboy.jpa;

import org.javaboy.jpa.dao.BookDao;
import org.javaboy.jpa.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaApplicationTests {

    @Autowired
    BookDao bookDao;
    @Test
    void contextLoads() {
        Book book = new Book();
        book.setName("三国演义");
        book.setAuthor("罗贯中");
        bookDao.save(book);
    }
    @Test
    void test1() {
        List<Book> list = bookDao.findAll();
        System.out.println(list);
        Optional<Book> book = bookDao.findById(2);
        Book b = book.get();
        System.out.println(b);
        b.setAuthor("曹雪芹2222");
        bookDao.saveAndFlush(b);
        bookDao.deleteById(2);
    }

    @Test
    void test2() {
        Pageable pageable = PageRequest.of(1, 3);
        Page<Book> page = bookDao.findAll(pageable);
        System.out.println("是否首页："+page.isFirst());
        System.out.println("是否尾页："+page.isLast());
        System.out.println("当前页的数据量："+page.getNumberOfElements());
        System.out.println("页码："+page.getNumber());
        System.out.println("查到的数据："+page.getContent());
        System.out.println("总页数："+page.getTotalPages());
        System.out.println("每页数据量："+page.getSize());
        System.out.println("总记录数："+page.getTotalElements());
    }
}
