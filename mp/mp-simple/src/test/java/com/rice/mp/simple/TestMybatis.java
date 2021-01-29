package com.rice.mp.simple;

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
public class TestMybatis {

    @Test
    public void testFindAll() throws IOException {

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsReader("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> all = mapper.findAll();
        all.forEach(System.out::println);
    }
}
