package org.library.dao;

import org.library.pojo.Admin;
import java.util.List;
import java.util.Map;

//DAO层负责访问数据库进⾏数据的操作，取得结果集，之后将结果集中的数据取出封装到VO类对象之后返回
//给service层（service后⾯会出现）
//创建Mapper代理接⼝（这是是dao接⼝）
public interface adminDao {
    //查询所有管理员信息
    //List<Admin>则是一个列表对象，用来存储多个管理员对象
    List<Admin> findAllAdmin();

    // 按学号/工号查询管理员信息
    //返回一个Student对象
    Admin findAdminByAid(String aid);


    // 根据输入的管理员信息进行动态条件检索
    //也就是传入一个admin，如果有相符合的admin就返回
    List<Admin> findAdmin(Admin admin);


    //增加一个管理员
    int addAdmin(Admin admin);

    //更改管理员信息
    int updateAdmin(Admin admin);

    //删除管理员
    int deleteAdminByAid(String aid);




}
