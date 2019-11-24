package com.moon.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.moon.mybatis.pojo.SysDict;

public interface SysDictMapper {
	
	
	/**
	 * 查询SysDict
	 * 
	 * @param sysDict     SysDict实体类
	 * @param rowBounds   分页参数
	 * @return
	 * 
	 * @author moon  2019/11/10  17:22
	 */
	List<SysDict> selectBySysDict(SysDict sysDict, RowBounds rowBounds);
	
	
	/**
	 * 新增 SysDict
	 * 
	 * @param sysDict
	 * @return
	 * 
	 * @author moon  2019/11/10  17:23
	 */
	Integer insertSysDict(SysDict sysDict);
	
	
	/**
	 * 根据主键更新 SysDict
	 * 
	 * @param sysDict  SysDict实体类
	 * @return
	 * 
	 * @author moon  2019/11/10  17:24
	 */
	Integer updateSysDictById(SysDict sysDict);
	
	
	/**
	 * 根据主键删除SysDict
	 * 
	 * @param id  主键Id
	 * @return
	 * 
	 * @author moon  2019/11/10  17:26
	 */
	Integer deleteSysDictById(Long id);
	
	
	/**
	 * 通过主键查询 SysDict 
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/11/09  23:28
	 */
	SysDict selectByPrimaryKey(Long id);
	
}
