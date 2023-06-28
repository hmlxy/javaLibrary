package org.library.pojo;
//plain ordinary java object，简单java对象；⼀般专指只有 setter/getter/toString 的简单类；pojo⽤于数据
//的临时传递，它只能装载数据， 作为数据存储的载体，⽽不具有业务逻辑处理的能⼒。pojo层命名为entity也可，
//表示实体层

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

/** 学生类 */
public class Book {
    // 图书编号
    private String bid;
    // 图书名称
    private String bname;
    // 作者
    private String bauthor;
    // 类别
    private String bcategory;
    // 位置
    private String bplace;
    // 出版社
    private String bpublisher;
    // 出版日期
    private LocalDate byear;
    // 借阅状态
    private String bstatus;
    // 读者id
    private String uid;
    // 借书日期
    private LocalDate bbrodate;
    // 应还日期
    private LocalDate breturndate;


    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }
    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }
    public String getBauthor() {
        return bauthor;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }
    public String getBcategory() {
        return bcategory;
    }

    public void setBcategory(String bcategory) {
        this.bcategory = bcategory;
    }


    public String getBplace() {
        return bplace;
    }

    public void setBplace(String bplace) {
        this.bplace = bplace;
    }

    public String getBpublisher() {
        return bpublisher;
    }

    public void setBpublisher(String bpublisher) {
        this.bpublisher = bpublisher;
    }

    public LocalDate getByear() {
        return byear;
    }

    public void setByear(LocalDate byear) {
        this.byear = byear;
    }

    public String getBstatus() {
        return bstatus;
    }

    public void setBstatus(String bstatus) {
        this.bstatus = bstatus;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public LocalDate getBbrodate() {
        return bbrodate;
    }

    public void setBbrodate(LocalDate bbrodate) {
        this.bbrodate = bbrodate;
    }
    public LocalDate getBreturndate() {
        return breturndate;
    }

    public void setBreturndate(LocalDate breturndate) {
        this.breturndate = breturndate;
    }




    @Override
    //如 System.out.println(user)，这将自动调用 toString() 方法，
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //要注意到空值导致的转化为String错误NullPointerException
        String bookInfo = String.format("Book:{bid=%s,bname=%s,bauthor=%s,bcategory=%s,bplace=%s,bpublisher=%s,byear=%s,bstatus=%s,uid=%s,bbrodate=%s,breturndate=%s}",
                Optional.ofNullable(bid).orElse(""),
                Optional.ofNullable(bname).orElse(""),
                Optional.ofNullable(bauthor).orElse(""),
                Optional.ofNullable(bcategory).orElse(""),
                Optional.ofNullable(bplace).orElse(""),
                Optional.ofNullable(bpublisher).orElse(""),
                //要注意到空值导致的转化为String错误NullPointerException
                Optional.ofNullable(byear).map(formatter::format).orElse(""),
                Optional.ofNullable(bstatus).orElse(""),
                Optional.ofNullable(uid).orElse(""),
                //要注意到空值导致的转化为String错误NullPointerException
                Optional.ofNullable(bbrodate).map(formatter::format).orElse(""),
                Optional.ofNullable(breturndate).map(formatter::format).orElse(""));
        return bookInfo;
    }
}
