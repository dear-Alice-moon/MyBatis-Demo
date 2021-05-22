package com.moon.plus;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.moon.plus.dao.UserMapper;
import com.moon.plus.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FillTests {

    @Autowired
    private UserMapper userMapper;


    /**
     * 逻辑删除配置下，自动填充，插入测试。
     *
     * @author  moon  2020/08/12  23:45
     */
    @Test
    public void insert() {

        User user = new User();
        user.setName("李玉儿");
        user.setAge(16);
        user.setEmail("ly@baomidou.com");
        user.setManagerId(1088248166370832385L);
        int rows = userMapper.insert(user);

        System.out.println("影响行数：" + rows);
    }


    /**
     * 逻辑删除配置下，根据主键更新测试。
     *
     * @author  moon  2020/08/11  23:29
     */
    @Test
    public void updateById() {

        User user = new User();
        user.setAge(28);
        user.setId(1088248166370832385L);
        user.setUpdateTime(new Date());
        int rows = userMapper.updateById(user);  // 实际运行的SQL语句： UPDATE user SET age=? WHERE id=? AND deleted=0

        System.out.println("影响行数：" + rows);

    }


}
