package org.library;
import org.library.pojo.Admin;
import org.library.service.AdminService;
import org.library.service.impl.AdminServiceImpl;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import org.library.utils.JDBCUtils;
import java.util.List;


public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // 测试驱动加载、数据库连接
        Connection connection= JDBCUtils.getConnection();

        // 测试service
        AdminService adminService =new AdminServiceImpl();






    }
}