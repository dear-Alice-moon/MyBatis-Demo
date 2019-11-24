package com.moon.mybatis.service;

import java.util.List;

import com.moon.mybatis.pojo.SysDict;

public interface SysDictService {
	
	/**
	 * 查询SysDict
	 * 
	 * @param sysDict     SysDict实体类
	 * @param rowBounds   分页参数
	 * @return
	 * 
	 * @author moon  2019/11/10  17:22
	 */
	List<SysDict> selectBySysDict(SysDict sysDict, Integer offset, Integer limit);
	
	
	/**
	 * 新增或更新 SysDict
	 * 
	 * @param sysDict
	 * @return
	 * 
	 * @author moon  2019/11/10  17:23
	 */
	boolean saveOrUpdateSysDict(SysDict sysDict);
	
	
	/**
	 * 根据主键删除SysDict
	 * 
	 * @param id  主键Id
	 * @return
	 * 
	 * @author moon  2019/11/10  17:26
	 */
	boolean deleteSysDictById(Long id);
	
	
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
