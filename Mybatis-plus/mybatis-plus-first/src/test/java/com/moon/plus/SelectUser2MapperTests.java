package com.moon.plus;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.moon.plus.dao.User2Mapper;
import com.moon.plus.pojo.User;
import com.moon.plus.pojo.User2;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectUser2MapperTests {

    @Autowired
    private User2Mapper user2Mapper;



    /**
     * 测试案例24： Mybatis-plus自定义SQL语句，进行多表关联分页查询，返回JavaBean类型数据。需求：年龄大于等于26岁
     *              age > 26
     *
     * @author moon  2020/08/02  19:02
     */
    @Test
    public void selectPageManyTables() {

        QueryWrapper<User2> queryWrapper = new QueryWrapper<User2>();
        queryWrapper.ge("age", 26);

        // Page<User2> page = new Page<User2>(1, 2);  // 打印2条SQL，一条查询总记录数，一条分页(LIMIT)查询.
        Page<User2> page = new Page<User2>(1, 2, false);  // 打印1条SQL，进行分页(LIMIT)查询.
        page.setDesc("create_time");  // 根据时间进行降序排序

        IPage<User2> user2IPage = user2Mapper.selectUser2Page(page, queryWrapper);
        System.out.println("user2IPage为：" + JSON.toJSONString(user2IPage));
        System.out.println("总页数为：" + user2IPage.getPages());
        System.out.println("总记录数为：" + user2IPage.getTotal());
        List<User2> user2MapList = user2IPage.getRecords();
        user2MapList.forEach(System.out::println);

    }


    /**
     * 测试案例23： Mybatis-plus进行分页查询，返回Map<K, V>类型数据。需求：年龄大于等于26岁
     *              age > 26
     *
     * @author moon  2020/08/02  18:39
     */
    @Test
    public void selectPageResultMap() {

        QueryWrapper<User2> queryWrapper = new QueryWrapper<User2>();
        queryWrapper.ge("age", 26);

        // Page<User2> page = new Page<User2>(1, 2);  // 打印2条SQL，一条查询总记录数，一条分页(LIMIT)查询.
        Page<User2> page = new Page<User2>(1, 2, false);  // 打印1条SQL，进行分页(LIMIT)查询.
        page.setDesc("create_time");  // 根据时间进行降序排序

        IPage<Map<String, Object>> user2IPage = user2Mapper.selectMapsPage(page, queryWrapper);  // SELECT Id,name,age,email,manager_id,create_time FROM user WHERE age >= ? LIMIT ?,?
        System.out.println("user2IPage为：" + JSON.toJSONString(user2IPage));
        System.out.println("总页数为：" + user2IPage.getPages());
        System.out.println("总记录数为：" + user2IPage.getTotal());
        List<Map<String, Object>> user2MapList = user2IPage.getRecords();
        user2MapList.forEach(System.out::println);

    }


    /**
     * 测试案例23： Mybatis-plus进行分页查询，返回JavaBean类型数据。需求：年龄大于等于26岁
     *              age > 26
     *
     * @author moon  2020/08/02  17:11
     */
    @Test
    public void selectPageResultEntity() {

        QueryWrapper<User2> queryWrapper = new QueryWrapper<User2>();
        queryWrapper.ge("age", 26);

        // Page<User2> page = new Page<User2>(1, 2);  // 打印2条SQL，一条查询总记录数，一条分页(LIMIT)查询.
        Page<User2> page = new Page<User2>(1, 2, false);  // 打印1条SQL，进行分页(LIMIT)查询.
        page.setDesc("create_time");  // 根据时间进行降序排序

        IPage<User2> user2IPage = user2Mapper.selectPage(page, queryWrapper);  // SELECT Id,name,age,email,manager_id,create_time FROM user WHERE age >= ? LIMIT ?,?
        System.out.println("user2IPage为：" + JSON.toJSONString(user2IPage));
        System.out.println("总页数为：" + user2IPage.getPages());
        System.out.println("总记录数为：" + user2IPage.getTotal());
        List<User2> user2List = user2IPage.getRecords();
        user2List.forEach(System.out::println);

    }


    /**
     * 测试案例23： 使用xml文件中自定义SQL方式查询，名字为王姓并且（年龄小于40或邮箱不为空）
     *              name LIKE '王%' AND (age < 40 OR email IS NOT NULL)
     *
     * @author moon  2020/08/02  17:11
     */
    @Test
    public void selectByMySql2() {

        LambdaQueryWrapper<User2> lambdaQuery = Wrappers.<User2>lambdaQuery();
        lambdaQuery.likeRight(User2::getName, "王")
                .and(lqw -> lqw.lt(User2::getAge, 40).or().isNotNull(User2::getEmail));  // SELECT * FROM user WHERE name LIKE ? AND ( age < ? OR email IS NOT NULL )

        List<User2> user2List = user2Mapper.selectAll2(lambdaQuery);
        user2List.forEach(System.out::println);
    }


    /**
     * 测试案例23： 使用java文件中自定义SQL方式查询，名字为王姓并且（年龄小于40或邮箱不为空）
     *              name LIKE '王%' AND (age < 40 OR email IS NOT NULL)
     *
     * @author moon  2020/08/02  10:13
     */
    @Test
    public void selectByMySql() {

        LambdaQueryWrapper<User2> lambdaQuery = Wrappers.<User2>lambdaQuery();
        lambdaQuery.likeRight(User2::getName, "王")
                    .and(lqw -> lqw.lt(User2::getAge, 40).or().isNotNull(User2::getEmail));  // SELECT * FROM user WHERE name LIKE ? AND ( age < ? OR email IS NOT NULL )

        List<User2> user2List = user2Mapper.selectAll(lambdaQuery);
        user2List.forEach(System.out::println);
    }


    /**
     * 测试案例22： 使用 LambdaQueryChainWrapper 方式查询，姓名中含‘雨’并且年龄大于等于20
     *              WHERE name LIKE '%雨%' AND age >= 20
     *
     * @author moon  2020/08/02  10:13
     */
    @Test
    public void selectLambda3() {
        List<User2> user2List = new LambdaQueryChainWrapper<User2>(user2Mapper).like(User2::getName, "雨").ge(User2::getAge, 20).list();  // SELECT Id,name,age,email,manager_id,create_time FROM user WHERE name LIKE ? AND age >= ?

        user2List.forEach(System.out::println);
    }


    /**
     * 测试案例21： 使用 Lambda 方式查询，名字为王姓并且（年龄小于40或邮箱不为空）
     *              name LIKE '王%' AND (age < 40 OR email IS NOT NULL)
     *
     * @author moon  2020/08/02  10:13
     */
    @Test
    public void selectLambda2() {
        LambdaQueryWrapper<User2> user2LamQuery = Wrappers.<User2>lambdaQuery();
        user2LamQuery.likeRight(User2::getName, "王").and(lqw -> lqw.lt(User2::getAge, 40).or().isNotNull(User2::getEmail));  // SELECT Id,name,age,email,manager_id,create_time FROM user WHERE name LIKE ? AND ( age < ? OR email IS NOT NULL )

        List<User2> user2List = user2Mapper.selectList(user2LamQuery);
        user2List.forEach(System.out::println);
    }


    /**
     * 测试案例20： 3种 Lambda 查询
     *
     * @author moon  2020/08/02  10:13
     */
    @Test
    public void selectLambda() {

//        LambdaQueryWrapper<User2> lambda = new QueryWrapper<User2>().lambda();
//        LambdaQueryWrapper<User2> user2LamQueryWrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<User2> user2LamQueryWrapper2 = Wrappers.<User2>lambdaQuery();
        user2LamQueryWrapper2.like(User2::getName, "雨").lt(User2::getAge, 40);  //  WHERE name LIKE ? AND age < ?

        List<User2> user2List = user2Mapper.selectList(user2LamQueryWrapper2);
        user2List.forEach(System.out::println);
    }


    /**
     * 测试案例19： selectOne 测试， 若返回的数据行大于1则报错。
     *
     * @author moon  2020/08/02  09:52
     */
    @Test
    public void selectByWrapperOne() {

        QueryWrapper<User2> queryWrapper = new QueryWrapper<User2>();
        // queryWrapper.like("name", "雨").lt("age", 40);  // 返回的数据行大于1，报错!
        queryWrapper.like("name", "刘红雨").lt("age", 40);  // SELECT Id,name,age,email,manager_id,create_time FROM user WHERE name LIKE ? AND age < ?

        User2 user2 = user2Mapper.selectOne(queryWrapper);
        System.out.println("返回值为：" + user2);  //  User2{Id=1094592041087729666, name='刘红雨', age=32, email='lhm@baomidou.com', managerId=1088248166370832385, createTime=Mon Jan 14 09:48:16 CST 2019}

    }


    /**
     * 测试案例18： 返回符合要求的总记录数值 测试
     *
     * @author moon  2020/08/02  09:50
     */
    @Test
    public void selectByWrapperCount() {

        QueryWrapper<User2> queryWrapper = new QueryWrapper<User2>();
        queryWrapper.like("name", "雨").lt("age", 40);  // SELECT COUNT( 1 ) FROM user WHERE name LIKE ? AND age < ?

        Integer count = user2Mapper.selectCount(queryWrapper);
        System.out.println("总记录数为：" + count);  // 总记录数为：2

    }


    /**
     * 测试案例17： 返回Objs类型值 测试
     *              注意：返回为object类型时，只取 "SELECT id, name" 中的第一列值 id .
     *
     * @author moon  2020/08/02  09:40
     */
    @Test
    public void selectByWrapperObjs() {

        QueryWrapper<User2> queryWrapper = new QueryWrapper<User2>();
        queryWrapper.select("id", "name").like("name", "雨").lt("age", 40);  // SELECT id,name FROM user WHERE name LIKE ? AND age < ?

        List<Object> objList = user2Mapper.selectObjs(queryWrapper);
        for (Object b : objList) {

            System.out.println("b为：" + b);  // b为：1094590409767661570
        }

    }


    /**
     * 测试案例16： 返回Map类型值 测试
     *              按照直属上级分组，查询每组的平均年龄、最大年龄、最小年龄。并且只取年龄总和小于500的组。
     *
     * @author moon  2020/08/01  18:49
     */
    @Test
    public void selectByWrapperMaps2() {

        QueryWrapper<User2> queryWrapper = new QueryWrapper<User2>();
        queryWrapper.select("AVG(age) avg_age", "MIN(age) min_age", "MAX(age) max_age")
                .groupBy("manager_id").having("SUM(age) < {0}", 500);  // SELECT AVG(age) avg_age,MIN(age) min_age,MAX(age) max_age FROM user GROUP BY manager_id HAVING SUM(age) < ?

        List<Map<String, Object>> user2List = user2Mapper.selectMaps(queryWrapper);
        for (Map m : user2List) {

            System.out.println("m为：" + m);
        }

    }


    /**
     * 测试案例15： 返回Map类型值 测试
     *
     * @author moon  2020/08/01  18:49
     */
    @Test
    public void selectByWrapperMaps() {

        QueryWrapper<User2> queryWrapper = new QueryWrapper<User2>();
        // queryWrapper.like("name", "雨").lt("age", 40);  // SELECT Id,name,age,email,manager_id,create_time FROM user WHERE name LIKE ? AND age < ?
        queryWrapper.select("id", "name").like("name", "雨").lt("age", 40);  // SELECT id,name FROM user WHERE name LIKE ? AND age < ?

        List<Map<String, Object>> user2List = user2Mapper.selectMaps(queryWrapper);
        for (Map m : user2List) {

            System.out.println("m为：" + m);
        }

    }


    /**
     * 测试案例14： QueryWrapper.allEq(Map<K, V>) 测试
     *
     * @author moon  2020/08/01  18:49
     */
    @Test
    public void selectByWrapperAllEq() {

        QueryWrapper<User2> queryWrapper = new QueryWrapper<User2>();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", "王天风");
        // params.put("age", 25);
        // queryWrapper.allEq(params);  // SELECT Id,name,age,email,manager_id,create_time FROM user WHERE name = ? AND age = ?

        params.put("age", null);
        // queryWrapper.allEq(params, false);  // SELECT Id,name,age,email,manager_id,create_time FROM user WHERE name = ?

        queryWrapper.allEq((k, v) -> !k.equals("name"), params);  // SELECT Id,name,age,email,manager_id,create_time FROM user WHERE age IS NULL

        List<User2> user2List = user2Mapper.selectList(queryWrapper);
        for (User2 u : user2List) {

            System.out.println("u为：" + u.toString());
        }

    }


    /**
     * 测试案例13：QueryWrapper<T> 测试
     *
     * @author moon  2020/08/01  18:32
     */
    @Test
    public void selectByWrapperEntity() {
        User2 whereUser = new User2();
        whereUser.setName("刘红雨");
        whereUser.setAge(32);

        QueryWrapper<User2> queryWrapper = new QueryWrapper<User2>(whereUser);
        // queryWrapper.like("name", "雨").lt("age", 40);  // 该行最好不要与 “QueryWrapper<T> 测试” 联用

        // 对User2.java 中 name、age 的添加注解，来达到 like、lt 的操作.

        List<User2> user2List = user2Mapper.selectList(queryWrapper);
        for (User2 u : user2List) {

            System.out.println("u为：" + u.toString());
        }

    }


    /**
     * 测试案例12：使用 condition 关键字排除非空字符串
     *
     */
    @Test
    public void  testCondition() {

        // String name = "王";
        String name = "张";
        String email = "z";

        condition(name, email);
    }

    private void condition(String name, String email) {

        QueryWrapper<User2> queryWrapper = new QueryWrapper<User2>();
//        if (StringUtils.isNotEmpty(name)) {
//            queryWrapper.like("name", name);
//        }
//        if (StringUtils.isNotEmpty(email)) {
//            queryWrapper.like("email", email);
//        }

        // 下行代码等同于上面的2个if判断
        queryWrapper.like(StringUtils.isNotEmpty(name), "name", name)
                    .like(StringUtils.isNotEmpty(email), "email", email);

        List<User2> user2List = user2Mapper.selectList(queryWrapper);
        for (User2 u : user2List) {
            System.out.println("u为：" + u.toString());
        }

    }


    /**
     * 测试案例11：名字中包含雨并且年龄小于40(需求1加强版)，查询出的字段不包含create_time、email
     *             第二种情况：select id,name,age,email
     * 	                       from user
     * 	                       where name like '%雨%' and age<40
     *
     */
    @Test
    public void selectByWrapperSupper2() {

        QueryWrapper<User2> queryWrapper = new QueryWrapper<User2>();
        queryWrapper.like("name", "雨").lt("age", 40)
                    .select(User2.class, info -> !info.getColumn().equals("create_time") &&
                                                 !info.getColumn().equals("email"));

        List<User2> user2List = user2Mapper.selectList(queryWrapper);
        for (User2 u : user2List) {
            System.out.println("u为：" + u.toString());
        }
    }


    /**
     * 测试案例10：名字中包含雨并且年龄小于40(需求1加强版),查询出的字段仅有id，name
     *             第一种情况：select id,name
     * 	                       from user
     * 	                       where name like '%雨%' and age<40
     *
     */
    @Test
    public void selectByWrapperSupper1() {

        QueryWrapper<User2> queryWrapper = new QueryWrapper<User2>();
        queryWrapper.select("id", "name").like("name", "雨").lt("age", 40);

        List<User2> user2List = user2Mapper.selectList(queryWrapper);
        for (User2 u : user2List) {
            System.out.println("u为：" + u.toString());
        }
    }


    /**
     * 测试案例9：在案例8的基础上，只返回满足条件的其中一条语句即可。
     *
     */
    @Test
    public void selectByWrapper9() {

        QueryWrapper<User2> queryWrapper = new QueryWrapper<User2>();
        queryWrapper.in("age", Arrays.asList(30, 31, 32, 33, 34, 35)).last("LIMIT 1");

        List<User2> user2List = user2Mapper.selectList(queryWrapper);
        for (User2 u : user2List) {
            System.out.println("u为：" + u.toString());
        }
    }


    /**
     * 测试案例8：年龄为30、31、34、35
     *            age in (30、31、34、35)
     */
    @Test
    public void selectByWrapper8() {

        QueryWrapper<User2> queryWrapper = new QueryWrapper<User2>();
        queryWrapper.in("age", Arrays.asList(30, 31, 32, 33, 34, 35));

        List<User2> user2List = user2Mapper.selectList(queryWrapper);
        for (User2 u : user2List) {
            System.out.println("u为：" + u.toString());
        }
    }


    /**
     * 测试案例7：（年龄小于40或邮箱不为空）并且名字为王姓
     *             (age<40 or email is not null) and name like '王%'
     */
    @Test
    public void selectByWrapper7() {

        QueryWrapper<User2> queryWrapper = new QueryWrapper<User2>();
        queryWrapper.nested(wq -> wq.lt("age", 40).or().isNotNull("email"))
                                    .likeRight("name", "王");

        List<User2> user2List = user2Mapper.selectList(queryWrapper);
        for (User2 u : user2List) {
            System.out.println("u为：" + u.toString());
        }
    }


    /**
     * 测试案例6：名字为王姓或者（年龄小于40并且年龄大于20并且邮箱不为空）
     *            name like '王%' or (age<40 and age>20 and email is not null)
     */
    @Test
    public void selectByWrapper6() {

        QueryWrapper<User2> queryWrapper = new QueryWrapper<User2>();
        queryWrapper.likeRight("name", "王").or(wq -> wq.lt("age", 40)
                                                                    .gt("age", 20)
                                                                    .isNotNull("email"));

        List<User2> user2List = user2Mapper.selectList(queryWrapper);
        for (User2 u : user2List) {
            System.out.println("u为：" + u.toString());
        }
    }


    /**
     * 测试案例5：名字为王姓并且（年龄小于40或邮箱不为空）
     *            name like '王%' and (age<40 or email is not null)
     */
    @Test
    public void selectByWrapper5() {

        QueryWrapper<User2> queryWrapper = new QueryWrapper<User2>();
        queryWrapper.likeRight("name", "王").and(wq -> wq.lt("age", 40).or().isNotNull("email"));

        List<User2> user2List = user2Mapper.selectList(queryWrapper);
        for (User2 u : user2List) {
            System.out.println("u为：" + u.toString());
        }
    }


    /**
     * 测试案例4：创建日期为2019年2月14日并且直属上级为名字为王姓
     *            date_format(create_time,'%Y-%m-%d')='2019-02-14'
     *            and manager_id in (select id from user where name like '王%')
     */
    @Test
    public void selectByWrapper4() {

        QueryWrapper<User2> queryWrapper = new QueryWrapper<User2>();
        queryWrapper.apply("DATE_FORMAT(create_time, '%Y-%m-%d') ={0}", "2019-02-14")
                    .inSql("manager_id", "SELECT id FROM user WHERE name LIKE '王%'");

        List<User2> user2List = user2Mapper.selectList(queryWrapper);
        for (User2 u : user2List) {
            System.out.println("u为：" + u.toString());
        }
    }


    /**
     * 测试案例3：名字为王姓或者年龄大于等于25，按照年龄降序排列，年龄相同按照id升序排列
     *            name like '王%' or age>=25 order by age desc,id asc
     */
    @Test
    public void selectByWrapper3() {

        QueryWrapper<User2> queryWrapper = new QueryWrapper<User2>();
        queryWrapper.likeRight("name", "王").or().ge("age", 25)
                    .orderByDesc("age").orderByAsc("id");

        List<User2> user2List = user2Mapper.selectList(queryWrapper);
        for (User2 u : user2List) {
            System.out.println("u为：" + u.toString());
        }
    }


    /**
     * 测试案例2：名字中包含雨年并且龄大于等于20且小于等于40并且email不为空
     *            name like '%雨%' and age between 20 and 40 and email is not null
     */
    @Test
    public void selectByWrapper2() {

        QueryWrapper<User2> queryWrapper = new QueryWrapper<User2>();
        queryWrapper.like("name", "雨").between("age", 20, 40).isNotNull("email");

        List<User2> user2List = user2Mapper.selectList(queryWrapper);
        for (User2 u : user2List) {
            System.out.println("u为：" + u.toString());
        }
    }


    /**
     * 测试案例1：字中包含雨并且年龄小于40
     *            name like '%雨%' and age<40
     */
    @Test
    public void selectByWrapper() {

        QueryWrapper<User2> queryWrapper = new QueryWrapper<User2>();
        // queryWrapper.like("name", "雨").le("age", 40); // le表示 <= 操作
        queryWrapper.like("name", "雨").lt("age", 40); // lt表示 < 操作

        List<User2> user2List = user2Mapper.selectList(queryWrapper);
        for (User2 u : user2List) {

            System.out.println("u为：" + u.toString());
        }
    }


    /**
     * 使用Map类型参数，查询 User 信息
     *
     * @author  RenKuo  2020/07/30  16:00
     */
    @Test
    public void selectByMap() {

        Map<String, Object> columnMap = new HashMap<String, Object>();
        columnMap.put("age", 20);
        // columnMap.put("manager_id", 1088248166370830001L);
        List<User2> user2List = user2Mapper.selectByMap(columnMap);
        for (User2 u : user2List) {
            System.out.println("u为：" + u.toString());
        }

    }


    /**
     * 根据主键批量查询 User 信息
     *
     * @author  RenKuo  2020/07/30  15:48
     */
    @Test
    public void selectByIds() {

        List<Long> idList = Arrays.asList(1088248166370830004L, 1088250446457389058L, 1094592041087729666L);
        List<User2> userList = user2Mapper.selectBatchIds(idList);
        for (User2 u : userList) {

            System.out.println("u为：" + u.toString());
        }

    }


    /**
     * 根据主键查询 User 信息
     *
     * @author  RenKuo  2020/07/30  15:48
     */
    @Test
    public void selectById() {

        User2 user = user2Mapper.selectById(1094590409767661570L);
        System.out.println("user为：" + user.toString());
    }

}
