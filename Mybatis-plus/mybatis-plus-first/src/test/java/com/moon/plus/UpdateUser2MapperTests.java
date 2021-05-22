package com.moon.plus;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.LambdaUpdateChainWrapper;
import com.moon.plus.dao.User2Mapper;
import com.moon.plus.pojo.User;
import com.moon.plus.pojo.User2;
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
public class UpdateUser2MapperTests {

	@Autowired
	private User2Mapper user2Mapper;


	/**
	 * 根据 LambdaUpdateChainWrapper ，以条件构造器中set方法进行更新测试
	 *
	 * @author  RenKuo  2020/08/02  23:34
	 */
	@Test
	public void updateByWrapper5() {

		boolean update = new LambdaUpdateChainWrapper<User2>(user2Mapper)
							.eq(User2::getName, "李艺伟").eq(User2::getAge, 28)
							.set(User2::getAge, 34)
							.update();  // UPDATE user SET age=? WHERE name = ? AND age = ?

		System.out.println("影响记录数：" + update);
	}


	/**
	 * 根据 LambdaUpdateWrapper ，以条件构造器中set方法进行更新测试
	 *
	 * @author  RenKuo  2020/08/02  23:29
	 */
	@Test
	public void updateByWrapper4() {

		LambdaUpdateWrapper<User2> lambdaUpdateWrapper = Wrappers.<User2>lambdaUpdate();
		lambdaUpdateWrapper.eq(User2::getName, "李艺伟").eq(User2::getAge, 31)
				           .set(User2::getAge, 32);

		int rows = user2Mapper.update(null, lambdaUpdateWrapper);  // 运行正确，更新成功则返回1； 运行正确，没有更新则返回0；
		System.out.println("影响记录数：" + rows);
	}


	/**
	 * 根据 UpdateWrapper ，以条件构造器中set方法进行更新测试
	 *
	 * @author  RenKuo  2020/08/02  23:10
	 */
	@Test
	public void updateByWrapper3() {

		UpdateWrapper<User2> updateWrapper = new UpdateWrapper<User2>();
		updateWrapper.eq("name", "李艺伟").eq("age", 30)
					.set("age", 31);  //  UPDATE user SET age=? WHERE name = ? AND age = ?

		int rows = user2Mapper.update(null, updateWrapper);

		System.out.println("影响记录数：" + rows);
	}


	/**
	 * 根据 UpdateWrapper ，以条件构造器作为参数进行更新测试。
	 *
	 * @author  RenKuo  2020/08/02  23:10
	 */
	@Test
	public void updateByWrapper2() {

		User2 whereUser = new User2();
		whereUser.setName("李艺伟");

		UpdateWrapper<User2> updateWrapper = new UpdateWrapper<User2>(whereUser);
		// updateWrapper.eq("name", "李艺伟").eq("age", 28);  // whereUser中已经包含name值，这里就不要再重复使用。
		updateWrapper.eq("age", 29);  // UPDATE user SET age=?, email=? WHERE name = ? AND age = ?

		User2 user2 = new User2();
		user2.setEmail("lyw-2020@baomidou.com");
		user2.setAge(30);

		int rows = user2Mapper.update(user2, updateWrapper);

		System.out.println("影响记录数：" + rows);
	}


	/**
	 * 根据 UpdateWrapper ，以条件构造器作为参数进行更新测试。
	 *
	 * @author  RenKuo  2020/08/02  23:10
	 */
	@Test
	public void updateByWrapper() {

		UpdateWrapper<User2> updateWrapper = new UpdateWrapper<User2>();
		updateWrapper.eq("name", "李艺伟").eq("age", 28);  // UPDATE user SET age=?, email=? WHERE name = ? AND age = ?

		User2 user2 = new User2();
		user2.setEmail("lyw2020@baomidou.com");
		user2.setAge(29);

		int rows = user2Mapper.update(user2, updateWrapper);

		System.out.println("影响记录数：" + rows);
	}


	/**
	 * 通过 Id 进行更新测试
	 *
	 * @author  RenKuo  2020/08/02  22:58
	 */
	@Test
	public void updateTest() {
		User2 user2 = new User2();
		user2.setId(1088248166370830001L);
		user2.setAge(21);
		user2.setEmail("zs2020@baomidou.com");

		int rows = user2Mapper.updateById(user2);  // UPDATE user SET age=?, email=? WHERE Id=?
		System.out.println("影响记录数：" + rows);
	}


}
