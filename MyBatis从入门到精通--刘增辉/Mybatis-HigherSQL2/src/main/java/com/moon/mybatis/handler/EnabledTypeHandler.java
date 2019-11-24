package com.moon.mybatis.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.moon.mybatis.enums.Enabled2;

/**
 * 使用自定义的类型处理器
 * 
 * @author moon  2019/06/22 15:49  
 *
 */
public class EnabledTypeHandler implements TypeHandler<Enabled2> {
	
	private final Map<Integer, Enabled2> enabledMap = new HashMap<Integer, Enabled2>();
	
	
	public EnabledTypeHandler() {
		
		for (Enabled2 enabled : Enabled2.values()) {
			enabledMap.put(enabled.getValue(), enabled);
		}
		
	}
	
	
	@Override
	public void setParameter(PreparedStatement ps, int i, Enabled2 parameter, JdbcType jdbcType) throws SQLException {
		ps.setInt(i, parameter.getValue());
	}
	
	@Override
	public Enabled2 getResult(ResultSet rs, String columnName) throws SQLException {
		Integer value = rs.getInt(columnName);
		return enabledMap.get(value);
	}

	@Override
	public Enabled2 getResult(ResultSet rs, int columnIndex) throws SQLException {
		Integer value = rs.getInt(columnIndex);
		return enabledMap.get(value);
	}

	@Override
	public Enabled2 getResult(CallableStatement cs, int columnIndex) throws SQLException {
		Integer value = cs.getInt(columnIndex);
		return enabledMap.get(value);
	}
	
}
