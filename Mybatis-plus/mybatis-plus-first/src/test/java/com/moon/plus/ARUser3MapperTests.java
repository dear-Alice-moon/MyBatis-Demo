package com.moon.plus;

import com.alibaba.fastjson.JSON;
import com.moon.plus.dao.User3Mapper;
import com.moon.plus.dao.UserMapper;
import com.moon.plus.pojo.User;
import com.moon.plus.pojo.User3;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ARUser3MapperTests {

	@Autowired
	private User3Mapper user3Mapper;


	/**
	 * AR模式下，简单新增/更新测试.
	 *
	 * @author RenKuo  2020/08/03  11:17
	 */
	@Test
	public void insertOrUpdate() {

		User3 user3 = new User3();
		user3.setId(1088248166370830017L);
		user3.setName("测试数据002");
		user3.setAge(30);
		user3.setCreateTime(new Date());

		boolean result = user3.insertOrUpdate();  // 这里有2条SQL语句，第一条是 SELECT 语句，根据 id 查询表中是否存在对应的数据。若存在则更新，若不存在则新增。
		System.out.println("返回boolean值为：" + result);  // 返回值为：true
	}


	/**
	 * AR模式下，简单删除测试.
	 *
	 * @author RenKuo  2020/08/03  11:17
	 */
	@Test
	public void deleteById() {

		User3 user3 = new User3();
		user3.setId(1088248166370830017L);

		boolean result = user3.deleteById();  // DELETE FROM user WHERE id=?
		System.out.println("返回boolean值为：" + result);  // 返回值为：true
	}


	/**
	 * AR模式下，简单更新测试.
	 *
	 * @author RenKuo  2020/08/03  10:33
	 */
	@Test
	public void updateById() {

		User3 user3 = new User3();
		user3.setId(1088248166370830010L);
		user3.setName("向前看");

		boolean result = user3.updateById();  // UPDATE user SET name=? WHERE id=?
		System.out.println("返回boolean值为：" + result);
	}


	/**
	 * AR模式下，简单查询测试2.
	 *
	 * @author RenKuo  2020/08/03  10:33
	 */
	@Test
	public void selectById2() {

		User3 user3 = new User3();
		user3.setId(1088248166370830010L);

		User3 selectUser = user3.selectById();  // SELECT id,name,age,email,manager_id,create_time FROM user WHERE id=?

		System.out.println(selectUser == user3);  // 返回值为：false
		System.out.println("selectUser为：" + JSON.toJSONString(selectUser));
	}


	/**
	 * AR模式下，简单查询测试.
	 *
	 * @author RenKuo  2020/08/03  10:33
	 */
	@Test
	public void selectById() {

		User3 user3 = new User3();
		User3 selectUser = user3.selectById(1290114518067081217L);  // SELECT id,name,age,email,manager_id,create_time FROM user WHERE id=?

		System.out.println(selectUser == user3);  // 返回值为：false
		System.out.println("selectUser为：" + JSON.toJSONString(selectUser));
	}


	/**
	 * AR模式下，简单新增测试.
	 *
	 * @author RenKuo  2020/08/03  10:33
	 */
	@Test
	public void insert() {

		User3 user3 = new User3();
		user3.setName("李丽华");
		user3.setAge(29);
		user3.setEmail("llh@baomidou.com");
		user3.setManagerId(1087982257332887553L);
		user3.setCreateTime(new Date());

		boolean insert = user3.insert();
		System.out.println("返回的boolean类型值为：" + insert);
	}


}
