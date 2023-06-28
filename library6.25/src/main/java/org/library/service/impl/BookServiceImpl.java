package org.library.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.library.dao.bookDao;
import org.library.dao.userDao;
import org.library.pojo.Book;
import org.library.pojo.User;
import org.library.service.BookService;
import org.library.utils.MybatisUtils;

import javax.xml.crypto.Data;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.List;

import static org.library.utils.ShaUtils.SHA256Encrypt;

//项⽬开发实践中，在进⾏业务处理时，⼀般不会直接调⽤DAO层的接⼝，⽽时将业务逻辑处理封装到service层
//service层：主要去负责⼀些业务逻辑处理。Service层的业务实现，具体要调⽤到已定义的DAO层的接⼝。封装
//Service层的业务逻辑有利于通⽤的业务逻辑的独⽴性和重复利⽤性。
public class BookServiceImpl implements   BookService {
    //bookServiceImpl 是一个 Java 类，实现了 bookService 接口。接口提供了一些方法的定义，而 bookServiceImpl 实现了这些方法的具体实现。
    private SqlSession sqlSession;
    private bookDao mapper;

    public BookServiceImpl(){
        // 获取sqlSession
        sqlSession = MybatisUtils.getSqlSession();
        // 获取mapper接口
        mapper = sqlSession.getMapper(bookDao.class);
        userDao usermapper = sqlSession.getMapper(userDao.class);
    }


    @Override
    //返回所有的图书信息
    public List<Book> findAllBook() {
        return mapper.findAllBook();
    }

    //根据输入的id查询图书对象
    @Override
    public Book findBookByBid(String Bid) {
        return mapper.findBookByBid(Bid);
    }

    //根据对象的属性筛选符合条件的图书信息
    @Override
    public List<Book> findBook(Book book) {
        return mapper.findBook(book);
    }

    //根据图书对象添加一个图书
    @Override
    public int addBook(Book book) {
        return mapper.addBook(book);
    }

    //根据一个图书对象更新图书信息
    @Override
    public  int updateBook(Book book)
    {
        return mapper.updateBook(book);
    }

    //根据图书id删除一个图书
    @Override
    public  int deleteBookByBid(String Bid) {
        return mapper.deleteBookByBid(Bid);
    }



    //根据书名统计数量
    @Override
    public int getCountByName(String Bname){
        return mapper.getCountByName(Bname);
    }

    //根据作者统计数量
    @Override
    public int getCountByAuthor(String Bauthor){
        return mapper.getCountByAuthor(Bauthor);
    }
    @Override
    //根据分类统计数量
    public int getCountByCategory(String Bcategory){return mapper.getCountByCategory(Bcategory);}

    @Override
    //还书，根据图书id将图书的借阅信息为“可借”，然后消除日期
    public int updateReturnBook(Book book){
        return mapper.updateReturnBook(book);
    }






}
