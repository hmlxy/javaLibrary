package org.library.dao;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.library.pojo.Admin;
import org.library.service.AdminService;
import org.library.service.impl.AdminServiceImpl;
import org.library.utils.MybatisUtils;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.library.utils.ShaUtils.SHA256Encrypt;


public class AdminDaoTest {

    @Test
    public void testservice() throws NoSuchAlgorithmException {
        // 测试service
        AdminService adminService =new AdminServiceImpl();

        //管理员登录
        String aid = "2023479";
        String apassword="123456";
        if (adminService.adminLogin(aid,apassword)>0){
            System.out.println("登录成功");
        }
        else {
            System.out.println("账号或密码错误" );
        }


        //新增一个管理员
        System.out.println("随机新增一个管理员:");
        Random randomtest = new Random();
        int randomNum = randomtest.nextInt(900) + 100;
        String randomid = "2023" +String.valueOf(randomNum);
        String[] firstNameList = {"王", "李", "张", "刘", "陈", "杨", "赵", "黄", "周", "吴", "郑", "孙", "朱", "高", "林", "何", "郭", "马", "罗", "梁", "宋", "郭"};
        String[] lastNameList = {"明", "红", "芳", "建国", "建华", "少华", "强", "鹤", "生", "芬", "东", "碧华", "明华", "芝华", "丽华", "洋", "琴", "玉", "平", "文"};
        Random randomname = new Random();
        // 随机选择一个姓
        String firstName = firstNameList[randomname.nextInt(firstNameList.length)];
        // 随机选择一个名
        String lastName = lastNameList[randomname.nextInt(lastNameList.length)];
        String adminname = firstName + lastName;
        Admin admin1= new Admin();
        admin1.setAid(randomid);
        admin1.setAname(adminname);
        admin1.setApassword(SHA256Encrypt("123456"));
        admin1.setAphone("256922335");
        admin1.setApermission(2);
        adminService.addAdmin(admin1);
        System.out.println(admin1);
        System.out.println("\n");




    }




    //第一步：获得sqlSession对象
//    private SqlSession sqlSession;


//    @Test
//    public void testsha() {
//        String plainText = "hello world";
//        String encryptedText = null;
//
//        try {
//            encryptedText = SHA256Encrypt(plainText);
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Plain text: " + plainText);
//        System.out.println("Encrypted text: " + encryptedText);
//    }


//    @Test
//    public void test(){
//        try {
//
//            // 获取sqlSession
//            sqlSession = MybatisUtils.getSqlSession();
//            // 获取adminMapper接口
//            adminDao adminMapper = sqlSession.getMapper(adminDao.class);

//            /*首先进行管理员接口的测试*/

//            //新增一个管理员
//            System.out.println("随机新增一个管理员:");
//            Random randomtest = new Random();
//            int randomNum = randomtest.nextInt(900) + 100;
//            String randomid = "2023" +String.valueOf(randomNum);
//            String[] firstNameList = {"王", "李", "张", "刘", "陈", "杨", "赵", "黄", "周", "吴", "郑", "孙", "朱", "高", "林", "何", "郭", "马", "罗", "梁", "宋", "郭"};
//            String[] lastNameList = {"明", "红", "芳", "建国", "建华", "少华", "强", "鹤", "生", "芬", "东", "碧华", "明华", "芝华", "丽华", "洋", "琴", "玉", "平", "文"};
//            Random randomname = new Random();
//            // 随机选择一个姓
//            String firstName = firstNameList[randomname.nextInt(firstNameList.length)];
//            // 随机选择一个名
//            String lastName = lastNameList[randomname.nextInt(lastNameList.length)];
//            String adminname = firstName + lastName;
//            Admin admin1= new Admin();
//            admin1.setAid(randomid);
//            admin1.setAname(adminname);
//            admin1.setApassword(SHA256Encrypt("123456"));
//            admin1.setAphone("256922335");
//            admin1.setApermission(2);
//            adminMapper.addAdmin(admin1);
//            System.out.println(admin1);
//            System.out.println("\n");
//
//
//
//
//
//
//            // 修改管理员信息
//            System.out.println("将新增的管理员改名:");
//            admin1.setAname("伊露席尔的"+adminname);
//            adminMapper.updateAdmin(admin1);
//            System.out.println(admin1);
//
//
//
//            // 根据学号/工号查询管理员
//            System.out.println("根据学号/工号查询管理员:");
//            Admin admin=adminMapper.findAdminByAid("2023572");
//            System.out.println(admin);
//            System.out.println("\n");
//
//
//
//            //根据输入的管理员信息进行动态条件检索
//            //可以说极为强大，可以通过所有属性进行筛选
//            System.out.println("根据传入的管理员对象查询是否存在");
//            Admin adminnew = new Admin();
//            adminnew.setAid("2023708");
//            List<Admin> adminList1=adminMapper.findAdmin(adminnew);
//            for (Admin adminlist : adminList1) {
//                System.out.println(adminlist);
//            }
//            System.out.println("\n");
//
//            // 查询全部管理员信息
//            System.out.println("查询全部的管理员:");
//            List<Admin> adminList = adminMapper.findAllAdmin();
//            for (Admin admin2 : adminList) {
//                System.out.println(admin2);
//            }
//            System.out.println("\n");
//
//
//
//            // 删除管理员
////            System.out.println("\n");
////            String aid1 = admin1.getAid();
////            adminMapper.deleteAdminByAid(aid1);
////            System.out.println("删除管理员成功:"+aid1);
////            System.out.println("\n");
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

