package org.library.service.impl;
import org.apache.ibatis.session.SqlSession;
import org.library.dao.adminDao;
import org.library.pojo.Admin;
import org.library.service.AdminService;
import org.library.utils.MybatisUtils;

import java.security.NoSuchAlgorithmException;
import java.util.List;


import static org.library.utils.ShaUtils.SHA256Encrypt;

//项⽬开发实践中，在进⾏业务处理时，⼀般不会直接调⽤DAO层的接⼝，⽽时将业务逻辑处理封装到service层
//service层：主要去负责⼀些业务逻辑处理。Service层的业务实现，具体要调⽤到已定义的DAO层的接⼝。封装
//Service层的业务逻辑有利于通⽤的业务逻辑的独⽴性和重复利⽤性。
public class AdminServiceImpl implements AdminService {
    //AdminServiceImpl 是一个 Java 类，实现了 AdminService 接口。接口提供了一些方法的定义，而 AdminServiceImpl 实现了这些方法的具体实现。
    private SqlSession sqlSession;
    private adminDao mapper;

    public AdminServiceImpl(){
        // 获取sqlSession
        sqlSession = MybatisUtils.getSqlSession();
        // 获取mapper接口
        mapper = sqlSession.getMapper(adminDao.class);
    }


    @Override
    //返回所有的管理员信息
    public List<Admin> findAllAdmin() {
        return mapper.findAllAdmin();
    }

    //根据输入的id查询管理员对象
    @Override
    public Admin findAdminByAid(String aid) {
        return mapper.findAdminByAid(aid);
    }

    //根据对象的属性筛选符合条件的管理员信息
    @Override
    public List<Admin> findAdmin(Admin admin) {
        return mapper.findAdmin(admin);
    }

    //根据管理员对象添加一个管理员
    @Override
    public int addAdmin(Admin admin) {
        return mapper.addAdmin(admin);
    }

    //根据一个管理员对象更新管理员信息
    @Override
    public int updateAdmin(Admin admin) {
        return mapper.updateAdmin(admin);
    }

    //根据管理员id删除一个管理员
    @Override
    public int deleteAdminByAid(String aid) {
        return mapper.deleteAdminByAid(aid);
    }


    //根据输入的id和密码管理员登录判断是否存在
    @Override
    public int adminLogin(String id, String password) throws NoSuchAlgorithmException {
        Admin loginadmin = findAdminByAid(id);
        //如果不存在直接返回
        if(loginadmin == null){
            return 0;
        }
        String adminpassword = loginadmin.getApassword();
        int adminpermission = 0;
//        System.out.println("原密码"+adminpassword);
        String encryptpwd = SHA256Encrypt(password);
//        System.out.println("输入密码"+encryptpwd);

        // 用 equals() 比较两个字符串是否相等,则返回正确的权限
        if (encryptpwd.equals(adminpassword)) {
            adminpermission = loginadmin.getApermission();
        }
        return adminpermission;
    }



}
