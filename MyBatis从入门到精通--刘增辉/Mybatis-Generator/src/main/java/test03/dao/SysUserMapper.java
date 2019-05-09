package test03.dao;

import test03.model.SysUser;

public interface SysUserMapper {
    SysUser selectByPrimaryKey(Long id);
}