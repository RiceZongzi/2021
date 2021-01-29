package com.rice.mp.springboot;

import com.rice.mp.springboot.mapper.UserMapper;
import com.rice.mp.springboot.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author wgz
 * create date  2021/1/30 1:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestMpSb {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
}
