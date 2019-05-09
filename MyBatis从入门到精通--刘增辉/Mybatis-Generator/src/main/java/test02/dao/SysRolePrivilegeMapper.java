package test02.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import test02.model.SysRolePrivilege;
import test02.model.SysRolePrivilegeExample;

public interface SysRolePrivilegeMapper {
    long countByExample(SysRolePrivilegeExample example);

    int deleteByExample(SysRolePrivilegeExample example);

    int insert(SysRolePrivilege record);

    int insertSelective(SysRolePrivilege record);

    List<SysRolePrivilege> selectByExample(SysRolePrivilegeExample example);

    int updateByExampleSelective(@Param("record") SysRolePrivilege record, @Param("example") SysRolePrivilegeExample example);

    int updateByExample(@Param("record") SysRolePrivilege record, @Param("example") SysRolePrivilegeExample example);
}