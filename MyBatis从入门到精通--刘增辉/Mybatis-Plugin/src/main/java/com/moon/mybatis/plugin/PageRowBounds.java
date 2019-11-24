package com.moon.mybatis.plugin;

import org.apache.ibatis.session.RowBounds;

/**
 * 可以记录 total 的分页参数
 * 
 * @author moon  2019/09/21  18:45
 *
 */
public class PageRowBounds extends RowBounds {
	
	private long total;  // 总条数
	
	
	public PageRowBounds() {
		super();
	}

	public PageRowBounds(int offset, int limit) {
		super(offset, limit);
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
	
}
