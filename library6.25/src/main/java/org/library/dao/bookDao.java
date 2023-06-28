package org.library.dao;

import org.library.pojo.Book;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

//DAO层负责访问数据库进⾏数据的操作，取得结果集，之后将结果集中的数据取出封装到VO类对象之后返回
//给service层（service后⾯会出现）
//创建Mapper代理接⼝（这是是dao接⼝）
public interface bookDao {
    //查询所有图书信息
    //List<Book>则是一个列表对象，用来存储多个图书对象
    List<Book> findAllBook();

    // 按图书编号查询图书信息
    Book findBookByBid(String Bid);


    // 根据输入的图书信息进行动态条件检索
    //也就是传入一个Book的属性，如果有相符合的Book就返回
    //比如作者，书名
    List<Book> findBook(Book book);


    //增加一个图书
    int addBook(Book book);

    //更改图书信息
    int updateBook(Book book);

    //删除图书
    int deleteBookByBid(String Bid);

    //根据书名统计数量
    int getCountByName(String Bname);

    //根据作者统计数量
    int getCountByAuthor(String Bauthor);

    //根据分类统计数量
    int getCountByCategory(String Bcategory);

    //还书，根据图书id将图书的借阅信息为“可借”，然后消除id，日期
    int updateReturnBook(Book book);









}
