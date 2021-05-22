package com.moon.plus;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.moon.plus.config.MybatisPlusConfiguration2;
import com.moon.plus.dao.UserMapper;
import com.moon.plus.dao.UserMapper2;
import com.moon.plus.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InjectorTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserMapper2 userMapper2;




    /**
     * 选装件 alwaysUpdateSomeColumnById()
     *
     * @author  moon 2020/09/14  22:44
     */
    @Test
    public void alwaysUpdateSomeColumnById() {

        User user = new User();
        user.setId(1088248166370832385L);
        user.setAge(33);
        user.setName("王天福2222333");

        int rows = userMapper2.alwaysUpdateSomeColumnById(user);
        System.out.println("影响行数： " + rows);

    }


    /**
     * 选装件 LogicDeleteByIdWithFill()
     *
     * @author  moon 2020/09/14  22:24
     */
    @Test
    public void deleteByIdWithFill() {

        User user = new User();
        user.setId(1305157804931170306L);
        user.setAge(39);

        int rows = userMapper2.deleteByIdWithFill(user);
        System.out.println("影响行数：" + rows);

    }


    /**
     * 8-2、选装件InsertBatchSomeColumn
     *
     * @author  moon 2020/09/13  22:39
     */
    @Test
    public void insertBatch() {
        User user1 = new User();
        user1.setName("李兴华222");
        user1.setAge(36);
        user1.setManagerId(1088248166370832385L);

        User user2 = new User();
        user2.setName("杨红222");
        user2.setAge(32);
        user2.setManagerId(1088248166370832385L);

        List<User> asList = Arrays.asList(user1, user2);
        userMapper2.insertBatchSomeColumn(asList);

    }


    /**
     * 8-1、SQL注入器简介及自定义方法实现
     *
     * @author  moon 2020/09/13  22:39
     */
    @Test
    public void deleteAll2() {

        int rows = userMapper2.deleteAll();
        System.out.println("row为：" + rows);
    }


    /**
     * 8-1、SQL注入器简介及自定义方法实现
     *
     * @author  moon 2020/09/13  16:15
     */
    @Test
    public void deleteAll() {

        int rows = userMapper.deleteAll();
        System.out.println("影响行数：" + rows);
    }

}
