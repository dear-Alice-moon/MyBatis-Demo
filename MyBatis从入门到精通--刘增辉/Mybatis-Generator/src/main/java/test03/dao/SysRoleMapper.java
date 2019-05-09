package test03.dao;

import test03.model.SysRole;

public interface SysRoleMapper {
    SysRole selectByPrimaryKey(Long id);
}