package org.library.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.library.dao.userDao;
import org.library.pojo.Book;
import org.library.pojo.User;
import org.library.service.UserService;
import org.library.utils.MybatisUtils;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import static org.library.utils.ShaUtils.SHA256Encrypt;

//项⽬开发实践中，在进⾏业务处理时，⼀般不会直接调⽤DAO层的接⼝，⽽时将业务逻辑处理封装到service层
//service层：主要去负责⼀些业务逻辑处理。Service层的业务实现，具体要调⽤到已定义的DAO层的接⼝。封装
//Service层的业务逻辑有利于通⽤的业务逻辑的独⽴性和重复利⽤性。
public class UserServiceImpl implements UserService {
    //userServiceImpl 是一个 Java 类，实现了 userService 接口。接口提供了一些方法的定义，而 userServiceImpl 实现了这些方法的具体实现。
    private SqlSession sqlSession;
    private userDao mapper;

    public UserServiceImpl(){
        // 获取sqlSession
        sqlSession = MybatisUtils.getSqlSession();
        // 获取mapper接口
        mapper = sqlSession.getMapper(userDao.class);
    }


    @Override
    //返回所有的读者信息
    public List<User> findAllUser() {
        return mapper.findAllUser();
    }

    //根据输入的id查询读者对象
    @Override
    public User findUserByUid(String uid) {
        return mapper.findUserByUid(uid);
    }

    //根据对象的属性筛选符合条件的读者信息
    @Override
    public List<User> findUser(User user) {
        return mapper.findUser(user);
    }

    //根据读者对象添加一个读者
    @Override
    public  int addUser(User user) {
        return mapper.addUser(user);
    }

    //根据一个读者对象更新读者信息
    @Override
    public  int updateUser(User user) {
        return mapper.updateUser(user);
    }

    //根据读者id删除一个读者
    @Override
    public  int deleteUserByUid(String uid) {
        return mapper.deleteUserByUid(uid);
    }


    //根据输入的id和密码读者登录判断是否存在
    @Override
    public int userLogin(String id, String password) throws NoSuchAlgorithmException {
        User loginuser = findUserByUid(id);
        //如果不存在直接返回
        if(loginuser == null){
            return 0;
        }
        String userpassword = loginuser.getUpassword();
        int userpermission = 0;
//        System.out.println("原密码"+userpassword);
        String encryptpwd = SHA256Encrypt(password);
//        System.out.println("输入密码"+encryptpwd);

        // 用 equals() 比较两个字符串是否相等,则返回正确的权限
        if (encryptpwd.equals(userpassword)) {
            userpermission = loginuser.getUpermission();
        }
        return userpermission;
    }

    //根据读者的id查询所有借阅的图书,根据剩余时间升序
    @Override
    public  List<Book> getBooksByUserIdReturnASC(String uid){
        return mapper.getBooksByUserIdReturnASC(uid);
    }

    //根据读者的id查询所有借阅的图书,根据借书时间降序
    @Override
    public  List<Book> getBooksByUserIdBroDESC(String uid){
        return mapper.getBooksByUserIdBroDESC(uid);
    }




}
