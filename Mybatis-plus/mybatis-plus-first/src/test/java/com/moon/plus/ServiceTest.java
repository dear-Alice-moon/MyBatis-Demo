package com.moon.plus;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.moon.plus.pojo.User;
import com.moon.plus.pojo.User4;
import com.moon.plus.service.User4Service;
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
public class ServiceTest {

    @Autowired
    private User4Service user4Service;


    /**
     * 配置通用的 Service 层，链式删除。
     *
     * @author  moon  2020/08/09  12:15
     */
    @Test
    public void chain3() {

        boolean updateFlage = user4Service.lambdaUpdate().eq(User4::getAge, 33).remove();

        System.out.println("updateFlage为：" + updateFlage);
    }


    /**
     * 配置通用的 Service 层，链式更新。
     *
     * @author  moon  2020/08/09  12:11
     */
    @Test
    public void chain2() {

        boolean updateFlage = user4Service.lambdaUpdate().eq(User4::getAge, 30).set(User4::getAge, 33).update();

        System.out.println("updateFlage为：" + updateFlage);
    }


    /**
     * 配置通用的 Service 层，链式查询。
     *
     * @author  moon  2020/08/09  12:07
     */
    @Test
    public void chain() {

        List<User4> user4List = user4Service.lambdaQuery().gt(User4::getAge, 25).like(User4::getName, "雨").list();

        System.out.println("user4List：" + user4List);
    }


    /**
     * 配置通用的 Service 层，进行批量新增。
     *
     * @author  moon  2020/08/09  11:52
     */
    @Test
    public void batchAdd() {

        User4 user1 = new User4();
        user1.setName("徐丽3");
        user1.setAge(30);
        user1.setCreateTime(new Date());

        User4 user2 = new User4();
        user2.setId("e2179ad0ce2b4e087b88d05b12b2a0fc");
        user2.setName("许丽丽2");
        user2.setAge(18);
        user2.setCreateTime(new Date());

        List<User4> user4List = Arrays.asList(user1, user2);
        // boolean flage = user4Service.saveBatch(user4List);
        boolean flage = user4Service.saveOrUpdateBatch(user4List);

        System.out.println("flage为：" + flage);
    }


    /**
     * 配置通用的 Service 层，简单查询。
     *
     * @author  moon  2020/08/09  11:50
     */
    @Test
    public void getOne() {

        // User4 one = user4Service.getOne(Wrappers.<User4> lambdaQuery().eq(User4::getAge, 25));  // 当查询出来多条数据时，报错。
        User4 one = user4Service.getOne(Wrappers.<User4> lambdaQuery().gt(User4::getAge, 25), false);  // 当查询出来多条数据时，选取第1条数据。
        System.out.println("查询出来的User4为：" + one.toString());
    }


}
