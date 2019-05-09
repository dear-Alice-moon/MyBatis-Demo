
-- 创建"用户表"   2019/01/15  11:10  @moon                                
CREATE TABLE `sys_user` (
  `id` bigint(16) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(50) DEFAULT NULL COMMENT '密码',
  `user_email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `user_info` text COMMENT '简介',
  `head_img` blob COMMENT '头像',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';                   


-- 创建"角色表"   2019/01/15  11:10  @moon      
CREATE TABLE `sys_role` (
  `id` bigint(16) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名',
  `enabled` int(11) DEFAULT NULL COMMENT '有效标志',
  `create_by` bigint(16) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';


-- 创建"权限表"   2019/01/15  11:10  @moon     
CREATE TABLE `sys_privilege` (
  `id` bigint(16) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `privilege_name` varchar(50) DEFAULT NULL COMMENT '权限名称',
  `privilege_url` varchar(200) DEFAULT NULL COMMENT '权限URL',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';


-- 创建"用户角色关联表"   2019/01/15  11:10  @moon    
CREATE TABLE `sys_user_role` (
  `user_id` bigint(16) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(16) DEFAULT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';


-- 创建"角色权限关联表"   2019/01/15  11:10  @moon    
CREATE TABLE `sys_role_privilege` (
  `role_id` bigint(16) DEFAULT NULL COMMENT '角色ID',
  `privilege_id` bigint(16) DEFAULT NULL COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关联表';



INSERT INTO sys_user VALUES('1', 'admin', '123456', 'admin@mybatis.tk', '管理员', null, '2016-04-01 17:00:58');
INSERT INTO sys_user VALUES('1001', 'test', '123456', 'test@mybatis.tk', '测试用户', null, '2016-04-01 17:00:58');
INSERT INTO sys_role VALUES('1', '管理员', '1', '1', '2016-04-01 17:02:14');
INSERT INTO sys_role VALUES('2', '普通用户', '1', '1', '2016-04-01 17:02:34');


INSERT INTO sys_user_role VALUES('1', '1');
INSERT INTO sys_user_role VALUES('1', '2');
INSERT INTO sys_user_role VALUES('1001', '2');


INSERT INTO sys_privilege VALUES('1', '用户管理', '/users');
INSERT INTO sys_privilege VALUES('2', '角色管理', '/roles');
INSERT INTO sys_privilege VALUES('3', '系统日志', '/logs');
INSERT INTO sys_privilege VALUES('4', '人员维护', '/persons');
INSERT INTO sys_privilege VALUES('5', '单位维护', '/companiess');


INSERT INTO sys_role_privilege VALUES('1', '1');
INSERT INTO sys_role_privilege VALUES('1', '2');
INSERT INTO sys_role_privilege VALUES('1', '3');
INSERT INTO sys_role_privilege VALUES('2', '4');
INSERT INTO sys_role_privilege VALUES('2', '5');


