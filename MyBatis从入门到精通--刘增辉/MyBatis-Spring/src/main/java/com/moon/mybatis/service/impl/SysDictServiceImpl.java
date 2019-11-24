package com.moon.mybatis.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.mybatis.mapper.SysDictMapper;
import com.moon.mybatis.pojo.SysDict;
import com.moon.mybatis.service.SysDictService;
import com.sun.istack.internal.NotNull;

@Service
public class SysDictServiceImpl implements SysDictService {
	
	@Autowired
	private SysDictMapper sysDictMapper;
	
	
	/**
	 * 查询SysDict
	 * 
	 * @param sysDict     SysDict实体类
	 * @param rowBounds   分页参数
	 * @return
	 * 
	 * @author moon  2019/11/10  17:22
	 */
	@Override
	public List<SysDict> selectBySysDict(SysDict sysDict, Integer offset, Integer limit) {
		
		RowBounds rowBounds = RowBounds.DEFAULT;
		
		if (offset != null && limit != null) {
			rowBounds = new RowBounds(offset, limit);
		}
		
		
		return sysDictMapper.selectBySysDict(sysDict, rowBounds);
	}
	
	
	/**
	 * 新增或更新 SysDict
	 * 
	 * @param sysDict
	 * @return
	 * 
	 * @author moon  2019/11/10  17:23
	 */
	@Override
	public boolean saveOrUpdateSysDict(SysDict sysDict) {
		
		if (sysDict.getId() == null) {
			
			return sysDictMapper.insertSysDict(sysDict) == 1;
		} else {
			
			return sysDictMapper.updateSysDictById(sysDict) == 1;
		}
	}
	
	
	/**
	 * 根据主键删除SysDict
	 * 
	 * @param id  主键Id
	 * @return
	 * 
	 * @author moon  2019/11/10  17:26
	 */
	@Override
	public boolean deleteSysDictById(Long id) {
		
		return sysDictMapper.deleteSysDictById(id) == 1;
	}
	
	
	/**
	 * 通过主键查询 SysDict 
	 * 
	 * @param id
	 * @return
	 * 
	 * @author moon  2019/11/09  23:28
	 */
	@Override
	public SysDict selectByPrimaryKey(@NotNull Long id) {
		
		return sysDictMapper.selectByPrimaryKey(id);
	}

}
