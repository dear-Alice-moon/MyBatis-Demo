package test04.dao;

import test04.model.SysUser;

public interface SysUserMapper {
    SysUser selectByPrimaryKey(Long id);
}