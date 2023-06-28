package org.library.dao;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.library.pojo.Book;
import org.library.pojo.User;
import org.library.service.AdminService;
import org.library.service.UserService;
import org.library.service.impl.AdminServiceImpl;
import org.library.service.impl.UserServiceImpl;
import org.library.utils.MybatisUtils;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

import static org.library.utils.ShaUtils.SHA256Encrypt;

public class UserDaoTest {

    @Test
    public void testservice() throws NoSuchAlgorithmException {
        // 测试service
        UserService userService =new UserServiceImpl();

        //读者登录
        String uid = "202305";
        String upassword="123456";
        if (userService.userLogin(uid,upassword)>0){
            System.out.println("登录成功");
        }
        else {
            System.out.println("账号或密码错误" );
        }

        //新增一个读者
        System.out.println("随机新增一个读者:");
        Random randomid = new Random();
        int randomNum = randomid.nextInt(5000) + 100;
        String randomString = "2023" +String.valueOf(randomNum);

        String[] firstNameList = {"王", "李", "张", "刘", "陈", "杨", "赵", "黄", "周", "吴", "郑", "孙", "朱", "高", "林", "何", "郭", "马", "罗", "梁", "宋", "郭"};
        String[] lastNameList = {"明", "红", "芳", "建国", "建华", "少华", "强", "鹤", "生", "芬", "东", "碧华", "明华", "芝华", "丽华", "洋", "琴", "玉", "平", "文"};

        Random randomname = new Random();
        // 随机选择一个姓
        String firstName = firstNameList[randomname.nextInt(firstNameList.length)];
        String editname = firstNameList[randomname.nextInt(firstNameList.length)];
        // 随机选择一个名
        String lastName = lastNameList[randomname.nextInt(lastNameList.length)];
        String adminname = firstName + lastName;
        User useradd= new User();
        useradd.setUid(randomString);
        useradd.setUname(adminname);
        useradd.setUsex("女");
        useradd.setUage(21);
        useradd.setUdept("计算机");
        useradd.setUpassword(SHA256Encrypt("123456"));
        useradd.setUpermission(4);
        userService.addUser(useradd);
        System.out.println(useradd);
        System.out.println("\n");


    }
    //第一步：获得sqlSession对象
//    private SqlSession sqlSession;
//    @Test
//    public void test(){
//        try {
//
//
//            // 获取sqlSession
//            sqlSession = MybatisUtils.getSqlSession();
//            //获取userMapper
//            userDao userMapper = sqlSession.getMapper(userDao.class);
//
//
//            /*测试查询读者的所有借阅图书*/
//            System.out.println("查询读者的全部借阅图书剩余时间升序:");
//            List<Book> bookListASC = userMapper.getBooksByUserIdReturnASC("202305");
//            for (Book bookitemASC : bookListASC) {
//                System.out.println(bookitemASC);
//            }
//
//            System.out.println("查询读者的全部借阅图书剩余时间降序:");
//            List<Book> bookListDESC = userMapper.getBooksByUserIdBroDESC("202305");
//            for (Book bookitemDESC : bookListDESC) {
//                System.out.println(bookitemDESC);
//            }
//
//
//
//            /*进行读者接口测试*/
//
//            //新增一个读者
//            System.out.println("随机新增一个读者:");
//            Random randomid = new Random();
//            int randomNum = randomid.nextInt(5000) + 100;
//            String randomString = "2023" +String.valueOf(randomNum);
//
//            String[] firstNameList = {"王", "李", "张", "刘", "陈", "杨", "赵", "黄", "周", "吴", "郑", "孙", "朱", "高", "林", "何", "郭", "马", "罗", "梁", "宋", "郭"};
//            String[] lastNameList = {"明", "红", "芳", "建国", "建华", "少华", "强", "鹤", "生", "芬", "东", "碧华", "明华", "芝华", "丽华", "洋", "琴", "玉", "平", "文"};
//
//            Random randomname = new Random();
//            // 随机选择一个姓
//            String firstName = firstNameList[randomname.nextInt(firstNameList.length)];
//            String editname = firstNameList[randomname.nextInt(firstNameList.length)];
//            // 随机选择一个名
//            String lastName = lastNameList[randomname.nextInt(lastNameList.length)];
//            String adminname = firstName + lastName;
//            User useradd= new User();
//            useradd.setUid(randomString);
//            useradd.setUname(adminname);
//            useradd.setUsex("女");
//            useradd.setUage(21);
//            useradd.setUdept("计算机");
//            useradd.setUpassword(SHA256Encrypt("123456"));
//            useradd.setUpermission(4);
//            userMapper.addUser(useradd);
//            System.out.println(useradd);
//            System.out.println("\n");
//
//            //读者登录
//            System.out.println("读者登录:");
//            String userid="202305";
//            String password="123456";
//
//            User loginuser =userMapper.findUserByUid(userid);
//            String userpassword=loginuser.getUpassword();
//            System.out.println("原密码："+userpassword);
//            String uid="";
//            String upassword="";
//            //如果输入的密码加密后和原密文相同，则密码正确
//            String encryptpwd = SHA256Encrypt(password);
//            System.out.println("输入的密码："+encryptpwd);
//            //两个字符串判断相等要用equals
//            if(encryptpwd.equals(userpassword)) {
//                uid = userid;
//                upassword = encryptpwd;
//            }
//
//            Map<String, Object> userparams = new HashMap<String, Object>();
//            userparams.put("uid", uid);
//            userparams.put("upassword", upassword);
//            User userlogin = userMapper.findUserByIdAndPassword(userparams);
//            System.out.println("登录成功：" + userlogin);
//            System.out.println("\n");
//            // 查询全部读者
//            System.out.println("查询全部读者:");
//            List<User> userList = userMapper.findAllUser();
//            for (User useritem : userList) {
//                System.out.println(useritem);
//            }
//
//            // 根据学号/工号查询读者
//            System.out.println("根据学号/工号查询读者:");
//            User user=userMapper.findUserByUid("202307");
//            System.out.println(user);
//            System.out.println("\n");
//
//
//
//            //根据输入的读者信息进行动态条件检索
//            System.out.println("根据传入的管读者对象查询是否存在");
//            User usernew = new User();
//            usernew.setUid("202307");
//            List<User> userList1=userMapper.findUser(usernew);
//            for (User useritem : userList1) {
//                System.out.println(useritem);
//            }
//
//
//
//
//            // 修改读者信息
//            System.out.println("将新增的管理员更名:");
//            useradd.setUname(editname+ adminname);
//            userMapper.updateUser(useradd);
//            System.out.println(useradd);
//
//
//            // 删除读者
////            System.out.println("\n");
////            String userdel = useradd.getUid();
////            userMapper.deleteUserByUid(userdel);
////            System.out.println("删除读者成功:"+userdel);
////            System.out.println("\n");
//
//
//
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            //关闭sqlSession
//            sqlSession.close();
//        }
//    }
}

