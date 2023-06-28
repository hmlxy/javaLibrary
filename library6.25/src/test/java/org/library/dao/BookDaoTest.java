package org.library.dao;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.library.pojo.Book;
import org.library.service.BookService;
import org.library.service.UserService;
import org.library.service.impl.BookServiceImpl;
import org.library.utils.MybatisUtils;

import javax.xml.crypto.Data;
import java.security.NoSuchAlgorithmException;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.time.LocalDate;


public class BookDaoTest {

    @Test
    public void testservice() throws NoSuchAlgorithmException {
        // 测试service
        BookService bookService =new BookServiceImpl();
        // 查询全部图书
        System.out.println("查询全部图书:");
        List<Book> BookList =bookService.findAllBook();
        for (Book Bookitem : BookList) {
            System.out.println(Bookitem);
        }


        if(bookService.updateReturnBook(bookService.findBookByBid("2023WX787"))>0){
            System.out.println("还书成功");
        }

        LocalDate nowdate = LocalDate.now();
        LocalDate returntime = nowdate.plusDays(30);
        Book bookitem = bookService.findBookByBid("2023WX0005");
        bookitem.setUid("202305");
        bookitem.setBstatus("已借出");
        bookitem.setBbrodate(nowdate);
        bookitem.setBreturndate(returntime);
        if(bookService.updateBook(bookitem)>0){
            System.out.println("借书成功");
        }

    }

//    //第一步：获得sqlSession对象
//    private SqlSession sqlSession;
//    @Test
//    public void test(){
//        try {
//
//            // 获取sqlSession
//            sqlSession = MybatisUtils.getSqlSession();
//            //获取BookMapper
//            bookDao BookMapper = sqlSession.getMapper(bookDao.class);
//
//            /*进行图书接口测试*/
//
//
//            // 查询全部图书
//            System.out.println("查询全部图书:");
//            List<Book> BookList = BookMapper.findAllBook();
//            for (Book Bookitem : BookList) {
//                System.out.println(Bookitem);
//            }
//
//            //分别根据图书名称，作者，分类统计数量
//            System.out.println("统计数量:");
//            int countByName = BookMapper.getCountByName("雪国");
//            int countByAuthor = BookMapper.getCountByAuthor("莫言");
//            int countByCategory = BookMapper.getCountByCategory("日本文学");
//            String output = String.format("Count by 雪国: %d, count by 莫言: %d, count by 日本文学: %d",
//                    countByName, countByAuthor, countByCategory);
//            System.out.println(output);
//
//
//            // 根据学号/工号查询图书
//            System.out.println("根据学号/工号查询图书:");
//            Book Book=BookMapper.findBookByBid("2023WX0012");
//            System.out.println(Book);
//            System.out.println("\n");
//
//            //根据输入的图书信息进行动态条件检索
//            System.out.println("根据传入的管图书对象进行筛选");
//            Book Booknew = new Book();
//            Booknew.setBcategory("中国");
//            Booknew.setBauthor("莫言");
//            List<Book> BookList1=BookMapper.findBook(Booknew);
//            for (Book Bookitem : BookList1) {
//                System.out.println(Bookitem);
//            }
//
//
//            //新增一个图书
//            System.out.println("随机新增一个图书:");
//            Random randomid = new Random();
//            int randomNum = randomid.nextInt(1000) + 100;
//            String randomString = "2023WX" +String.valueOf(randomNum);
//            String[] firstNameList = {"奥丽雅", "伊甸", "吉榭尔", "卡伊", "莱瑞娜", "麦丝玛拉", "皮皮", "蕾雅", "塞拉芬娜", "泰丝拉", "维纳斯", "伊甸", "艾米莉亚", "布列塔尼", "帕尔默", "萨布里娜", "乔伊", "哈珀", "艾薇儿", "瑞秋", "蒂芙尼", "梅根", "斯蒂芬妮"};
//            String[] lastNameList = {"剑圣", "魔法师", "巨人", "巫妖", "狼王", "精灵王", "泰坦", "天使", "妖精", "海怪", "克苏鲁", "恶魔", "矮人", "龙族", "凤凰", "黑龙", "火龙", "冰龙", "夜魔", "猛犸", "狮鹫", "恐鹤", "鸟人"};
//
//
//            Random randomname = new Random();
//            //
//            String firstName = firstNameList[randomname.nextInt(firstNameList.length)];
//            String ranbookname = firstNameList[randomname.nextInt(firstNameList.length)];
//            String cbname = firstNameList[randomname.nextInt(firstNameList.length)];
//            //
//            String lastName = lastNameList[randomname.nextInt(lastNameList.length)];
//            String wxname = lastNameList[randomname.nextInt(lastNameList.length)];
//            String editname = lastNameList[randomname.nextInt(lastNameList.length)];
//            String bookname = firstName + lastName;
//
//
//
//            // 获取一个随机日期
//            // 获取2023年的第一天和今天
//            LocalDate startDate = LocalDate.of(2023, Month.JANUARY, 1);
//            LocalDate endDate = LocalDate.now();
//            // 计算天数
//            long days = ChronoUnit.DAYS.between(startDate, endDate);
//            // 生成一个随机天数，小于天数
//            int randomDays = randomid.nextInt((int) days);
//            // 构造随机日期
//            LocalDate brotime = startDate.plusDays(randomDays);
//
//            LocalDate returntime = brotime.plusDays(30);
//            Book Bookadd= new Book();
//            Bookadd.setBid(randomString);
//            Bookadd.setBname(bookname);
//            Bookadd.setBauthor(ranbookname);
//            Bookadd.setBcategory(wxname+"文学");
//            Bookadd.setBplace("3楼西区2排B面4列1层");
//            Bookadd.setBpublisher(cbname+"出版社");
//            Bookadd.setBstatus("已借出");
//            Bookadd.setUid("202305");
//            Bookadd.setByear(brotime);
//            Bookadd.setBbrodate(brotime);
//            Bookadd.setBreturndate(returntime);
//            BookMapper.addBook(Bookadd);
//            System.out.println(Bookadd);
//            System.out.println("\n");
//
//            // 修改图书信息
//            System.out.println("将新增图书更名:");
//            Bookadd.setBname(editname+bookname);
//            BookMapper.updateBook(Bookadd);
//            System.out.println(Bookadd);
//
//
//            // 删除图书
////            System.out.println("\n");
////            String Bookdel = Bookadd.getBid();
////            BookMapper.deleteBookByBid(Bookdel);
////            System.out.println("删除成功:"+Bookdel);
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

