package org.library.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

// sqlSessionFactory -->sqlSession
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    //SqlSessionFactory是MyBatis的关键对象,它是个单个数据库映射关系经过编译后的内存镜像
    // 使用mybatis第一步，获取sqlSessionFactory对象
    //每⼀个MyBatis的应⽤程序都以⼀个SqlSessionFactory对象的实例为核⼼
    static {
        try {
            String resource = "mybatis-config.xml";
            // Resources类：从类路径中加载资源
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 既然有了sqlSessionFactory,顾名思义，我们就可以从中获得sqlSession的实例了
    // sqlSession 完全包含了面向数据库执行SQL命令所需的所有方法
    //SqlSession是MyBatis的关键对象,是执⾏持久化操作的独享,类似于JDBC中的Connection。
    //SqlSession对象完全包含以数据库为背景的所有执⾏SQL操作的⽅法,它的底层封装了JDBC连接,可以⽤
    //SqlSession实例来直接执⾏被映射的SQL语句
    public static SqlSession getSqlSession(){
        // openSession()方法的参数值设置成true时，可以开启事务自动提交功能。
        return sqlSessionFactory.openSession(true);
    }
}

