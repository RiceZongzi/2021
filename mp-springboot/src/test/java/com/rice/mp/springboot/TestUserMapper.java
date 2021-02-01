package com.rice.mp.springboot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rice.mp.springboot.mapper.UserMapper;
import com.rice.mp.springboot.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wgz
 * create date  2021/1/30 1:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestUserMapper {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        User u = new User();
        u.setUserName("Viper");
        u.setAge(90);
        u.setCreatetime(new Timestamp(System.currentTimeMillis()));
        // 受影响的行数
        System.out.println("rows => " + userMapper.insert(u));
        // 自增涨id的值会回填到对象中
        // id =>1356116051636535298
        // 在实体类中定义策略(IdType)
        System.out.println("id => " + u.getId());
    }

    @Test
    public void testUpdateById() {
        User u = new User();
        u.setId(17L);
        u.setPassword("123");
        System.out.println("rows => " + userMapper.updateById(u));
    }

    @Test
    public void testUpdateQueryWrapper() {
        User u = new User();
        u.setPassword("123456");

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 匹配 user_name = "Viper"
        queryWrapper.eq("user_name", "Viper");
        System.out.println("rows => " + userMapper.update(u, queryWrapper));
    }

    @Test
    public void testUpdateUpdateWrapper() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();

        updateWrapper
                // 待更新字段赋值
                .set("password", "123")
                .set("name", "vip")
                // 匹配 user_name = "Viper"
                .eq("user_name", "Viper");
        System.out.println("rows => " + userMapper.update(null, updateWrapper));
    }

    @Test
    public void testDeleteById() {
        System.out.println("rows => " + userMapper.deleteById(17L));
    }

    @Test
    public void testDeleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("user_name", "Viper");
        map.put("age", 90);
        System.out.println("rows => " + userMapper.deleteByMap(map));
    }

    @Test
    public void testDeleteQueryWrapper() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 匹配 user_name = "Viper"
        queryWrapper.eq("user_name", "Viper");
        System.out.println("rows => " + userMapper.delete(queryWrapper));
    }

    @Test
    public void testDeleteQueryWrapper2() {
        User u = new User();
        u.setUserName("Viper");
        // 传递实体对象
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(u);
        System.out.println("rows => " + userMapper.delete(queryWrapper));
    }

    @Test
    public void testDeleteBatchIds() {
        System.out.println("rows => " + userMapper.deleteBatchIds(Arrays.asList(20L, 21L)));
    }

    @Test
    public void testSelectById() {
        System.out.println(userMapper.selectById(1L));
    }

    @Test
    public void testSelectBatchIds() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(12L, 13L, 19L));
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectOne() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", "axe");
        System.out.println(userMapper.selectOne(queryWrapper));
    }

    @Test
    public void testSelectList() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("password", "123");
        System.out.println(userMapper.selectList(queryWrapper));
    }

    @Test
    public void testSelectPage() {
        Page<User> userPage = new Page<>(1, 1);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("password", "123");
        IPage<User> userIPage = userMapper.selectPage(userPage, queryWrapper);
        System.out.println("总条数 => " + userIPage.getTotal());
        System.out.println("总页数 => " + userIPage.getPages());
        System.out.println("当前页数 => " + userIPage.getCurrent());
        // 遍历当前页
        userIPage.getRecords().forEach(System.out::println);
    }

    @Test
    public void testSelectCount() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age", 20);
        System.out.println(userMapper.selectCount(queryWrapper));
    }
}
