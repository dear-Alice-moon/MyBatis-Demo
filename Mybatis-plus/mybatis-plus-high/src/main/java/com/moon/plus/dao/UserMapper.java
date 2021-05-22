package com.moon.plus.dao;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.moon.plus.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

//    @SqlParser(filter = true)
    @Select("SELECT * FROM user ${ew.customSqlSegment}")
    List<User> mySelectList(@Param(Constants.WRAPPER)Wrapper<User> wrapper);


    /**
     * 删除所有
     *
     * @return  影响行数
     */
    int deleteAll();

}
