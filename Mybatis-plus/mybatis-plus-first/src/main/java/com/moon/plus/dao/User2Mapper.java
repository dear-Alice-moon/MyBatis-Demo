package com.moon.plus.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.moon.plus.pojo.User2;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface User2Mapper extends BaseMapper<User2> {


    /**
     * 在 User2Mapper.xml 中自定义SQL查询语句，可进行多表关联分页查询。
     *
     * @param page
     * @param wrapper
     * @return
     *
     * @author  moon  2020/08/02  19:00
     */
    IPage<User2> selectUser2Page(Page<User2> page, @Param(Constants.WRAPPER)Wrapper<User2> wrapper);


    /**
     * 在 User2Mapper.xml 中自定义SQL查询语句
     *
     * @param wrapper
     * @return
     *
     * @author  moon  2020/08/02  17:25
     */
    List<User2> selectAll2(@Param(Constants.WRAPPER)Wrapper<User2> wrapper);


    @Select("SELECT * FROM user ${ew.customSqlSegment}")
    List<User2> selectAll(@Param(Constants.WRAPPER)Wrapper<User2> wrapper);

}
