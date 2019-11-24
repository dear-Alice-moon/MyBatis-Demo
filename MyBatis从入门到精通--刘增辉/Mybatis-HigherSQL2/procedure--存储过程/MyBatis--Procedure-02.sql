

#Mysql数据库，存储过程写法。   @moon  2019/06/16  11:26  
#Mysql存储过程中，输入、输出参数的位置顺序需要与 XML文件中输入、输出参数的位置顺序一致，否则会报错。


# 第三个存储过程  
# 保存用户信息和角色关联信息 
DROP PROCEDURE IF EXISTS `insert_user_and_roles`;
DELIMITER;;  # 定界符，测试是否可以只输入一个分号!
CREATE PROCEDURE `insert_user_and_roles` (
	OUT id BIGINT,
	IN userName VARCHAR(50),
	IN userPassword VARCHAR(50),
	IN userEmail VARCHAR(50),
	IN userInfo TEXT,
	IN headImg BLOB,
	OUT createTime DATETIME,
	IN roleIds VARCHAR(200)
)

BEGIN

# 设置当前时间 
SET createTime = NOW();         

# 插入数据   
INSERT INTO sys_user(user_name, user_password, user_email, user_info, head_img, create_time)
VALUES(userName, userPassword, userEmail, userInfo, headImg, createTime);

# 获取自增主键 
SELECT LAST_INSERT_ID() INTO id;

# 保存用户和角色关系数据 
SET roleIds = CONCAT(',', roleIds, ',');

INSERT INTO sys_user_role(user_id, role_id)
SELECT id, r.id 
FROM sys_role r
WHERE INSTR(roleIds, CONCAT(',', id, ',')) > 0;

END;;
DELIMITER; 









