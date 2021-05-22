package com.moon.plus.dao;

import com.moon.plus.pojo.User;

/**
 * MyMapper<T> 中实现了表数据全部删除功能。T 为泛型，若其他的PojoMapper想实现该功能，则需要继承 MyMapper<T> 即可。
 *
 * @author moon 2020/09/13  17:11
 */
public interface UserMapper2 extends MyMapper<User> {


}
