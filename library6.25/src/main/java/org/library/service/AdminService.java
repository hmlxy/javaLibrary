package org.library.service;
import org.library.pojo.Admin;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface AdminService {
    //查询所有管理员信息
    List<Admin> findAllAdmin();

    // 按学号查询管理员信息
    Admin findAdminByAid(String aid);

    // 根据输入的管理员信息进行动态条件检索
    List<Admin> findAdmin(Admin admin);

    //增加一个管理员信息
    int addAdmin(Admin admin);

    //更改管理员信息
    int updateAdmin(Admin admin);

    //删除管理员信息
    int deleteAdminByAid(String aid);

    //判断管理员登录
    int adminLogin(String id, String password) throws NoSuchAlgorithmException;

}
