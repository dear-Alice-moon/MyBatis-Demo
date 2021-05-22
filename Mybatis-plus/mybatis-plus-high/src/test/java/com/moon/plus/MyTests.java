package com.moon.plus;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.moon.plus.config.MybatisPlusConfiguration2;
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
public class MyTests {

    @Autowired
    private UserMapper userMapper;


    /**
     * 逻辑删除配置下，测试动态表名实现。
     *
     * @author  moon 2020/09/06  21:49
     */
    @Test
    public void dynamicTableName() {

        MybatisPlusConfiguration2.myTableName.set("user_2020");

        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }


    /**
     * 逻辑删除配置下，自定义SQL语句查询，查询语句中去除 deleted=0
     *
     */
    @Test
    public void mySelect() {

        // List<User> userList = userMapper.mySelectList(Wrappers.<User>lambdaQuery().gt(User::getAge, 25));  // 实际运行SQL语句为：SELECT * FROM user WHERE age > ?
        List<User> userList = userMapper.mySelectList(Wrappers.<User>lambdaQuery()
                                                        .gt(User::getAge, 25)
                                                        .eq(User::getDeleted, 0));  // 实际运行SQL语句为：SELECT * FROM user WHERE age > ? AND deleted = ?

        userList.forEach(System.out::println);
    }


    /**
     * 逻辑删除配置下，根据主键更新测试。
     *
     * @author  moon  2020/08/11  23:29
     */
    @Test
    public void updateById() {

//        MybatisPlusConfiguration2.myTableName.set("user_2020");

        User user = new User();
        user.setAge(38);
        user.setUpdateTime(new Date());
        user.setId(1088248166370832385L);
        int rows = userMapper.updateById(user);  // 实际运行的SQL语句： UPDATE user SET age=? WHERE id=? AND deleted=0

        System.out.println("影响行数：" + rows);

    }


    /**
     * 逻辑删除配置下，根据主键删除测试。
     *
     * @author  moon  2020/08/11  23:22
     */
    @Test
    public void deleteById() {

        int rows = userMapper.deleteById(1094590409767661570L);  // 实际运行的SQL语句：UPDATE user SET deleted=1 WHERE id=? AND deleted=0
        System.out.println("影响行数为：" + rows);
    }


    /**
     * 逻辑删除配置下，根据主键进行查询。
     *
     * @author  RenKuo  2020/08/11  23:19
     */
    @Test
    public void selectById() {

        User user = userMapper.selectById(1094592041087729001L);  // 实际运行的SQL语句：SELECT id,name,age,email,manager_id,create_time,update_time,version,deleted FROM user WHERE id=? AND deleted=0
        System.out.println("user为：" + user.toString());
        System.out.println("user为：" + JSON.toJSONString(user));
    }

}
