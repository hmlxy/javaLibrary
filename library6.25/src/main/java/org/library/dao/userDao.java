package org.library.dao;

import org.library.pojo.User;
import org.library.pojo.Book;

import java.util.List;
import java.util.Map;

//DAO层负责访问数据库进⾏数据的操作，取得结果集，之后将结果集中的数据取出封装到VO类对象之后返回
//给service层（service后⾯会出现）
//创建Mapper代理接⼝（这是是dao接⼝）
public interface userDao {
    //查询所有读者信息
    //List<User>则是一个列表对象，用来存储多个读者对象
    List<User> findAllUser();

    // 按学号/工号查询读者信息
    //返回一个Student对象
    User findUserByUid(String uid);


    // 根据输入的读者信息进行动态条件检索
    //也就是传入一个User的属性，如果有相符合的User就返回
    //比如输入名字，院系，
    List<User> findUser(User user);


    //增加一个读者
    int addUser(User user);

    //更改读者信息
    int updateUser(User user);

    //删除读者
    int deleteUserByUid(String uid);


    //根据读者的id查询所有借阅的图书,根据剩余时间升序
    List<Book> getBooksByUserIdReturnASC(String uid);

    //根据读者的id查询所有借阅的图书,根据借书时间降序
    List<Book> getBooksByUserIdBroDESC(String uid);





}
