package org.library.pojo;
//plain ordinary java object，简单java对象；⼀般专指只有 setter/getter/toString 的简单类；pojo⽤于数据
//的临时传递，它只能装载数据， 作为数据存储的载体，⽽不具有业务逻辑处理的能⼒。pojo层命名为entity也可，
//表示实体层

import java.util.Optional;
/** 学生类 */
public class Admin {
    // 学号/工号
    private String aid;
    // 姓名
    private String aname;
    // 密码
    private String apassword;
    // 电话
    private String aphone;
    // 权限
    private int apermission;

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getApassword() {
        return apassword;
    }

    public void setApassword(String apassword) {
        this.apassword = apassword;
    }

    public String getAphone() {
        return aphone;
    }

    public void setAphone(String aphone) {
        this.aphone = aphone;
    }

    public int getApermission() { return apermission;}

    public void setApermission(int apermission) {
        this.apermission = apermission;
    }


    @Override
    //如 System.out.println(user)，这将自动调用 toString() 方法，
    public String toString() {

        String adminInfo=String.format("Admin:{aid=%s,aname=%s,apassword=%s,aphone=%s,apermission=%d}",
                Optional.ofNullable(aid).orElse(""),
                Optional.ofNullable(aname).orElse(""),
                Optional.ofNullable(apassword).orElse(""),
                Optional.ofNullable(aphone).orElse(""),
                Optional.ofNullable(apermission).orElse(2));
        return adminInfo;
    }
}
