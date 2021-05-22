package com.moon.plus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.moon.plus.dao.User2Mapper;
import com.moon.plus.dao.UserMapper;
import com.moon.plus.pojo.User;
import com.moon.plus.pojo.User2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DeleteUser2MapperTests {

	@Autowired
	private User2Mapper user2Mapper;


	/**
	 * 以 LambdaQueryWrapper 为条件构造器，进行删除。
	 *
	 * @author RenKuo  2020/08/03  09:39
	 */
	@Test
	public void deleteByQueryWrapper() {

		QueryWrapper<User2> queryWrapper = new QueryWrapper<User2>();
		queryWrapper.like("name", "右").le("age", 22);  // DELETE FROM user WHERE name LIKE ? AND age <= ?

		int rows = user2Mapper.delete(queryWrapper);
		System.out.println("删除条数为：" + rows);  // rows = 1
	}


	/**
	 * 以 LambdaQueryWrapper 为条件构造器，进行删除。
	 *
	 * @author RenKuo  2020/08/03  09:39
	 */
	@Test
	public void deleteByLambdaQueryWrapper() {

		LambdaQueryWrapper<User2> lambdaQuery = Wrappers.<User2>lambdaQuery();
		lambdaQuery.eq(User2::getAge,21).eq(User2::getName, "向北").or().gt(User2::getAge, 41);  // DELETE FROM user WHERE age = ? AND name = ? OR age > ?

		int rows = user2Mapper.delete(lambdaQuery);
		System.out.println("删除条数为：" + rows);  // rows = 1
	}


	/**
	 * 批量删除
	 *
	 * @author RenKuo  2020/08/03  09:30
	 */
	@Test
	public void deleteBatchIds() {

		int rows = user2Mapper.deleteBatchIds(Arrays.asList(1088248166370830014L, 1088248166370830015L, 1088248166370830016L));
		System.out.println("删除条数为：" + rows);  // rows = 3
	}


	/**
	 * 普通删除方法，以Map<K, V>为参数，进行删除。
	 *
	 * @author RenKuo  2020/08/03  09:24
	 */
	@Test
	public void deleteByMap() {

		Map<String, Object> columnMap = new HashMap<String, Object>();
		columnMap.put("name", "向后");
		columnMap.put("age", 25);

		int rows = user2Mapper.deleteByMap(columnMap);
		System.out.println("删除条数为：" + rows);
	}


	/**
	 * 根据id删除
	 *
	 * @author RenKuo  2020/08/03  09:22
	 */
	@Test
	public void deleteById() {

		int rows = user2Mapper.deleteById(1088248166370830017L);
		System.out.println("删除条数为：" + rows);
	}


}
