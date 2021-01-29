package com.rice.mp.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rice.mp.springboot.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wgz
 * create date  2021/1/29 23:53
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
