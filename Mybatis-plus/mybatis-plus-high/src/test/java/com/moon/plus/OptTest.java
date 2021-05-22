package com.moon.plus;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.moon.plus.dao.UserMapper;
import com.moon.plus.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OptTest {

    @Autowired
    private UserMapper userMapper;


    /**
     * 逻辑删除配置下，乐观锁，更新测试。
     *
     * @author  moon  2020/08/26  23:30
     */
    @Test
    public void update() {

        int version = 2;

        User user = new User();
        user.setEmail("ly33@baomidou.com");
//        user.setId(1293581279953956865L);
        user.setVersion(version);
        QueryWrapper<User> query = Wrappers.<User>query();
        query.eq("name", "李玉");

        int rows = userMapper.update(user, query);  // 实际运行SQL为：UPDATE user SET email=?, update_time=?, version=? WHERE deleted=0 AND name = ? AND version = ?


        int version2 = 3;
        User user2 = new User();
        user2.setEmail("ly4@baomidou.com");
        user2.setVersion(version2);
        query.eq("age", 25);

        int rows2 = userMapper.update(user2, query);  // 运行失败，实际运行SQL为：UPDATE user SET email=?, update_time=?, version=? WHERE deleted=0 AND name = ? AND version = ? AND age = ? AND version = ?

        System.out.println("影响行数：" + rows2);
    }


    /**
     * 逻辑删除配置下，乐观锁，根据主键更新测试。
     *
     * @author  moon  2020/08/26  23:26
     */
    @Test
    public void updateById() {

        int version = 1;

        User user = new User();
        user.setAge(21);
        user.setEmail("lj2@baomidou.com");
        user.setId(1293581279953950001L);
        user.setVersion(version);

        int rows = userMapper.updateById(user);  // 实际运行的SQL语句： UPDATE user SET email=?, update_time=?, version=? WHERE id=? AND version=? AND deleted=0

        System.out.println("影响行数：" + rows);

    }


}
