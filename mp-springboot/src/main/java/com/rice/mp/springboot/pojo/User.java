package com.rice.mp.springboot.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author wgz
 * create date  2021/1/29 23:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_user")
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String userName;
    @TableField(select = false) // 查询的时候不返回
    private String password;
    @TableField(exist = false) // 标注数据库中不存在字段
    private String secret;
    @TableField(select = false) // 查询的时候不返回
    private String name;
    private Integer age;
    private Integer sex;
    private Date birthday;
    private String note;
    @TableField(value = "created") // 解决实体和字段名不一致
    private Timestamp createtime;
    private Timestamp updated;
}
