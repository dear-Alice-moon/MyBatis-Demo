package com.moon.plus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyMapper<T> extends BaseMapper<T> {

    /**
     * 删除所有
     *
     * @return  影响行数
     */
    int deleteAll();

    /**
     * 选装件InsertBatchSomeColumn
     *
     * @param list
     * @return
     *
     * @author  moon  2020/09/13  22:47
     */
    int insertBatchSomeColumn(List<T> list);


    /**
     * 选装件 LogicDeleteByIdWithFill
     *
     * @param entity
     * @return
     *
     * @author  moon  2020/09/14  22:20
     */
    int deleteByIdWithFill(T entity);


    /**
     * 选装件 alwaysUpdateSomeColumnById
     *
     * @param entity
     * @return
     */
    int alwaysUpdateSomeColumnById(@Param(Constants.ENTITY) T entity);

}
