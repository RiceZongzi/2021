package com.rice.mp.simple.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rice.mp.simple.pojo.User;

import java.util.List;

/**
 * @author wgz
 * create date  2021/1/29 23:53
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> findAll();
}
