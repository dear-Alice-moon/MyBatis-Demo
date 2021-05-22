package com.moon.plus;

import com.moon.plus.dao.UserMapper;
import com.moon.plus.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertUserMapperTests {

	@Autowired
	private UserMapper userMapper;


	/**
	 * 简单插入测试2
	 *
	 * @author  RenKuo  2020/07/30  09:53
	 */
	@Test
	public void insertTest2() {

		User user = new User(null, "王五4", new Integer(20), "1234578@qq.com", 1088248166370832385L, new Date());
		user.setRemark("这是一个测试数据......");
		int row = userMapper.insert(user);
		System.out.println("影响记录行数为：" + row);

	}


	/**
	 * 简单插入测试
	 *
	 * @author  RenKuo  2020/07/30  09:51
	 */
	@Test
	public void insertTest() {

		User user = new User(1094592041087729601L, "张三", new Integer(20), "1234578@qq.com", 1088248166370832385L, new Date());
		int row = userMapper.insert(user);
		System.out.println("影响记录行数为：" + row);

		System.out.println("----------------------- 插入第2条数据 -----------------------");

		User user2 = new User(1094592041087729602L, "李四", new Integer(21), null, 1088248166370832385L, new Date());
		int row2 = userMapper.insert(user2);
		System.out.println("影响记录行数为：" + row2);
	}


	/**
	 * 简单查询测试，查询出了所有数据。
	 *
	 * @author RenKuo  2020/07/30  09:51
	 */
	@Test
	public void select() {

		List<User> listUser = userMapper.selectList(null);

//		Assert.assertEquals(5, listUser.size());
		for(User u : listUser) {
			System.out.println(u);
		}

	}


}
