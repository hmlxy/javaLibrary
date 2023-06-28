package org.library.pojo;
//plain ordinary java object，简单java对象；⼀般专指只有 setter/getter/toString 的简单类；pojo⽤于数据
//的临时传递，它只能装载数据， 作为数据存储的载体，⽽不具有业务逻辑处理的能⼒。pojo层命名为entity也可，
//表示实体层

import java.util.List;
import java.util.Optional;

/** 学生类 */
public class User {
    // 学号/工号
    private String uid;
    // 姓名
    private String uname;
    // 性别
    private String usex;
    // 年龄
    private int uage;
    //院系
    private String udept;
    //密码
    private String upassword;
    // 权限
    private int upermission;
    //借阅的书籍


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public int getUage() {
        return uage;
    }

    public void setUage(int uage) {
        this.uage = uage;
    }

    public String getUdept() {
        return udept;
    }

    public void setUdept(String udept) {
        this.udept = udept;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }



    public int getUpermission() { return upermission;}

    public void setUpermission(int upermission) {
        this.upermission = upermission;
    }


    @Override
    //如 System.out.println(user)，这将自动调用 toString() 方法，
    public String toString() {
        String userInfo=String.format("User:{uid=%s,uname=%s,usex=%s,uage=%d,udept=%s,upassword=%s,upermission=%d}",
                Optional.ofNullable(uid).orElse(""),
                Optional.ofNullable(uname).orElse(""),
                Optional.ofNullable(usex).orElse(""),
                Optional.ofNullable(uage).orElse(20),
                Optional.ofNullable(udept).orElse(""),
                Optional.ofNullable(upassword).orElse(""),
                Optional.ofNullable(upermission).orElse(4));
        return userInfo;
    }
}
