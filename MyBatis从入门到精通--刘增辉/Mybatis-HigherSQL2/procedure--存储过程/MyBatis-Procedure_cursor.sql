

#Oracle数据库，存储过程写法，涉及到Oracle中的游标。   @moon  2019/06/16  11:29  


CREATE OR REPLACE PROCEDURE SELECT_COUNTRIES(
	ref_cur1 out sys_refcursor,
	ref_urr2 out sys_refcursor
) IS
BEGIN 
	OPEN ref_cur1 FOR SELECT 
		id,
		country_name,
		country_code 
	FROM country WHERE id < 3;
	
	
	OPEN ref_cur2 FOR SELECT 
		id,
		country_name,
		country_code  
	FROM country WHERE id >= 3;
	
END SELECT_COUNTRIES;


