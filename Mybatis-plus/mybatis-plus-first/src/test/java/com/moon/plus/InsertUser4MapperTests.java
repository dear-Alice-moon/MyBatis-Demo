package com.moon.plus;

import com.moon.plus.dao.User4Mapper;
import com.moon.plus.dao.UserMapper;
import com.moon.plus.pojo.User;
import com.moon.plus.pojo.User4;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;


/**
 * Mybatis-plus 支持的主键策略，局部策略优于全局策略。
 *
 * @author moon  2020/08/04  09:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertUser4MapperTests {

	@Autowired
	private User4Mapper user4Mapper;


	/**
	 * 简单插入测试
	 *
	 * @author  RenKuo  2020/07/30  09:51
	 */
	@Test
	public void insertTest() {

		User4 user4 = new User4();
		user4.setName("赵大锤");
		user4.setAge(22);
		user4.setEmail("zdc@baomidou.com");
		user4.setManagerId(1087982257332887553L);
		user4.setCreateTime(new Date());

		int rows = user4Mapper.insert(user4);
		System.out.println("影响记录数为：" + rows);
		System.out.println("主键为：" + user4.getId());
	}


	/**
	 * 简单查询测试，查询出了所有数据。
	 *
	 * @author RenKuo  2020/08/04  09:30
	 */
	@Test
	public void select() {

		List<User4> listUser = user4Mapper.selectList(null);

//		Assert.assertEquals(5, listUser.size());
		for(User4 u : listUser) {
			System.out.println(u);
		}

	}


}
