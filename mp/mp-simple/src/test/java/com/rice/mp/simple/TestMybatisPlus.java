package com.rice.mp.simple;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.rice.mp.simple.mapper.UserMapper;
import com.rice.mp.simple.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.List;


/**
 * @author wgz
 * create date  2021/1/30 0:02
 */
public class TestMybatisPlus {

    @Test
    public void testFindAll() throws IOException {

//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
//        更换为MP中的MybatisSqlSessionFactoryBuilder进程构建
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder()
                .build(Resources.getResourceAsReader("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

//        List<User> all = mapper.findAll();
//        使用baseMapper中的方法
        List<User> all = mapper.selectList(null);
        all.forEach(System.out::println);
    }
}
