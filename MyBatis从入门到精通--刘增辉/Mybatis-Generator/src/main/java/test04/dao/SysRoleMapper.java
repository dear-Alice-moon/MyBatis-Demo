package test04.dao;

import test04.model.SysRole;

public interface SysRoleMapper {
    SysRole selectByPrimaryKey(Long id);
}