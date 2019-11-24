

#Mysql数据库，存储过程写法。   @moon  2019/06/16  11:26  
#Mysql存储过程中，输入、输出参数的位置顺序需要与 XML文件中输入、输出参数的位置顺序一致，否则会报错。


# 第一个存储过程.        
# 根据用户ID查询用户其他信息.   
# 方法看起来很奇怪，但是展示了多个输出参数.   
DROP PROCEDURE IF EXISTS `select_user_by_id`;
DELIMITER;; # 定界符 
CREATE PROCEDURE `select_user_by_id` (
	IN  userId BIGINT,
	OUT userName VARCHAR(50),
	OUT userPassword VARCHAR(50),
	OUT userEmail VARCHAR(50),
	OUT userInfo TEXT,
	OUT headImg BLOB,
	OUT createTime DATETIME
)

BEGIN
# 根据用户 id 查询其他数据
SELECT user_name, user_password, user_email, user_info, head_img, create_time
INTO userName, userPassword, userEmail, userInfo, headImg, createTime            
FROM sys_user         
WHERE id = userId;

END;;
DELIMITER; # 定界符




# 第二个存储过程.         
# 简单根据用户名和分页参数进行查询，返回总数和分页数据.      
DROP PROCEDURE IF EXISTS `select_user_page`;
DELIMITER;;  # 定界符
CREATE PROCEDURE `select_user_page` (
	IN userName VARCHAR(50),
	IN _offset BIGINT,
	IN _limit BIGINT,
	OUT total BIGINT
)
BEGIN
# 查询数据总数 
SELECT COUNT(*) INTO total
FROM sys_user
WHERE user_name LIKE CONCAT('%', userName, '%');

# 分页查询数据
SELECT *
FROM sys_user
WHERE user_name LIKE CONCAT('%', userName, '%')
LIMIT _offset, _limit;

END;; 
DELIMITER; # 定界符 




# 第三个存储过程  
# 保存用户信息和角色关联信息 
DROP PROCEDURE IF EXISTS `insert_user_and_roles`;
DELIMITER;;  # 定界符，测试是否可以只输入一个分号!
CREATE PROCEDURE `insert_user_and_roles` (
	OUT userId BIGINT,
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
SELECT LAST_INSERT_ID() INTO userId;

# 保存用户和角色关系数据 
SET roleIds = CONCAT(',', roleIds, ',');

INSERT INTO sys_user_role(user_id, role_id)
SELECT userId, id 
FROM sys_role
WHERE INSTR(roleIds, CONCAT(',', id, ',')) > 0;

END;;
DELIMITER; 




# 第四个存储过程
# 删除用户信息和角色关联信息 
DROP PROCEDURE IF EXISTS `delete_user_by_id`;
DELIMITER;; # 定界符 
CREATE PROCEDURE `delete_user_by_id` (
	IN userId BIGINT
)
BEGIN
DELETE FROM sys_user_role 	
WHERE user_id = userId;

DELETE FROM sys_user
WHERE id = userId;

END;; 
DELIMITER; 

